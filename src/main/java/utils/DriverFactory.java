package utils;

<<<<<<< HEAD
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
=======
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    public static WebDriver initializeDriver(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {

            System.setProperty(
                    "webdriver.chrome.driver",
                    System.getProperty("user.dir") + "\\drivers\\chromedriver.exe"
            );

            ChromeOptions options = new ChromeOptions();

            // ✅ IMPORTANT: use fresh automation profile (no Google sync)
            options.addArguments("--incognito");

            // ✅ Disable Chrome password manager & breach popups
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            prefs.put("profile.default_content_setting_values.notifications", 2);
            prefs.put("safebrowsing.enabled", false);

            options.setExperimentalOption("prefs", prefs);

            // ✅ Disable Chrome UI distractions
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-save-password-bubble");
            options.addArguments("--disable-features=PasswordLeakDetection");
            options.addArguments("--disable-features=AutofillServerCommunication");

            // Required for latest Chrome
            options.addArguments("--remote-allow-origins=*");

            return new ChromeDriver(options);
        }

        throw new RuntimeException("Browser not supported: " + browser);
>>>>>>> da8faee (Updated Selenium TestNG automation framework with parallel execution and ThreadLocal driver)
    }
}
