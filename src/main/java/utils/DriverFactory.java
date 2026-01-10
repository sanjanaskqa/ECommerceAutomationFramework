package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    // Holds a single WebDriver instance for the entire test run
    private static WebDriver driver;

    // Creates and initializes the WebDriver based on the browser name
    public static WebDriver initializeDriver(String browser){

        // Initialize Chrome browser when chrome is specified
        if(browser.equalsIgnoreCase("chrome")){
            // Launch Chrome browser
           driver = new ChromeDriver();

        }

        // Ensure consistent browser size across all tests
        driver.manage().window().maximize();
        return driver;
    }

    // Returns the already initialized WebDriver instance
    public static WebDriver getDriver(){
        return driver;
    }

    // Closes the browser and releases resources
    public static void quitDriver(){
        if(driver != null){
            driver.quit();
        }
    }
}
