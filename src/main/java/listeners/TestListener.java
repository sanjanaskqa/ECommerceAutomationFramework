package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;
import utils.ExtentReport;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener {
    ExtentReports extent = ExtentReport.getReportInstance();
     ThreadLocal<ExtentTest> test = new ThreadLocal<>();
     private static final Logger logger = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Test failed: {}", result.getMethod().getMethodName());

        logger.error("Failure reason: ",
                result.getThrowable());

        // Get the test class instance
        Object testClass = result.getInstance();

        // Get WebDriver from BaseTest
        WebDriver driver = ((BaseTest) testClass).getDriver();

        // Capture screenshot with test method name
        ScreenshotUtils.captureScreenshot(
                driver,
                result.getMethod().getMethodName()
        );
    }

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test started: {}", result.getMethod().getMethodName());
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test passed: {}", result.getMethod().getMethodName());
        test.get().log(Status.PASS,"Test Passed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("Test skipped: {}", result.getMethod().getMethodName());        test.get().log(Status.SKIP, "Test Skipped");

    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test execution finished. Flushing report.");
        extent.flush();

    }
}
