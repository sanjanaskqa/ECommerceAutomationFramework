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
<<<<<<< HEAD
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
=======

    private static final Logger logger = LogManager.getLogger(TestListener.class);

    private static ExtentReports extent = ExtentReport.getReportInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
>>>>>>> da8faee (Updated Selenium TestNG automation framework with parallel execution and ThreadLocal driver)

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test started: {}", result.getMethod().getMethodName());
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test passed: {}", result.getMethod().getMethodName());
<<<<<<< HEAD
        test.get().log(Status.PASS,"Test Passed");
=======
        test.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        logger.error("Test failed: {}", result.getMethod().getMethodName());
        logger.error("Failure reason: ", result.getThrowable());

        // Mark failure in Extent
        test.get().fail(result.getThrowable());

        Object testClass = result.getInstance();
        WebDriver driver = null;

        if (testClass instanceof BaseTest) {
            driver = ((BaseTest) testClass).getDriver();
        }

        if (driver == null) {
            logger.warn("WebDriver is null. Screenshot will not be captured.");
            return;
        }

        String screenshotPath = ScreenshotUtils.captureScreenshot(
                driver,
                result.getMethod().getMethodName()
        );

        // Attach screenshot to Extent Report
        if (screenshotPath != null && test.get() != null) {
            try {
                test.get().addScreenCaptureFromPath(screenshotPath);
            } catch (Exception e) {
                logger.error("Failed to attach screenshot to Extent report", e);
            }
        }
>>>>>>> da8faee (Updated Selenium TestNG automation framework with parallel execution and ThreadLocal driver)
    }

    @Override
    public void onTestSkipped(ITestResult result) {
<<<<<<< HEAD
        logger.warn("Test skipped: {}", result.getMethod().getMethodName());        test.get().log(Status.SKIP, "Test Skipped");

=======
        logger.warn("Test skipped: {}", result.getMethod().getMethodName());
        test.get().log(Status.SKIP, "Test Skipped");
>>>>>>> da8faee (Updated Selenium TestNG automation framework with parallel execution and ThreadLocal driver)
    }

    @Override
    public void onFinish(ITestContext context) {
<<<<<<< HEAD
        logger.info("Test execution finished. Flushing report.");
        extent.flush();

=======
        logger.info("Test execution finished. Flushing Extent Report.");
        extent.flush();
>>>>>>> da8faee (Updated Selenium TestNG automation framework with parallel execution and ThreadLocal driver)
    }
}
