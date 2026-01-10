package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReport {
    private static ExtentReports extent;
    public static ExtentReports getReportInstance(){
        if(extent == null){
            String timeStamp= new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String reportPath = System.getProperty("user.dir")+"/reports/TestReport_" + timeStamp + ".html";

            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            sparkReporter.config().setReportName("E-Commerce Automation Repor");
            sparkReporter.config().setDocumentTitle("Test Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

        }
        return extent;
    }
}
