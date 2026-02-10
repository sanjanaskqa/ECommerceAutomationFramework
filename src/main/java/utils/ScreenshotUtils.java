package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

<<<<<<< HEAD
    // Takes screenshot and saves it with test name + time
    public static void captureScreenshot(WebDriver driver, String testName)  {

        // Create a timestamp to avoid overwriting screenshots
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        // Create screenshot file name
        String fileName = testName + "_" + timeStamp + ".png";

        // Define where screenshot will be saved
        String filePath = System.getProperty("user.dir") + "/screenshots/" + fileName;

        // Take screenshot and store it as a file
=======
    // Takes screenshot and returns the file path
    public static String captureScreenshot(WebDriver driver, String testName) {

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = testName + "_" + timeStamp + ".png";
        String filePath = System.getProperty("user.dir") + "/screenshots/" + fileName;

>>>>>>> da8faee (Updated Selenium TestNG automation framework with parallel execution and ThreadLocal driver)
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshot, new File(filePath));
<<<<<<< HEAD
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


=======
            return filePath; // ✅ IMPORTANT
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
>>>>>>> da8faee (Updated Selenium TestNG automation framework with parallel execution and ThreadLocal driver)
}
