package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utils.DriverFactory;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    //parallel execution:
    public WebDriver getDriver(){
        return  driver.get();
    }

    // WebDriver instance used by all test classes that extend this base
   // public WebDriver driver;

    //parallel execution we are using this below
    protected static ThreadLocal<WebDriver> driver= new ThreadLocal<>();

    // Holds values from config.properties (browser, url, timeout, etc.)
    protected Properties prop;
    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    // Runs before every test method
    @Parameters("browser")
    @BeforeMethod
    public void setup() throws IOException {
        logger.info("Loading configuration properties");

        // Create Properties object to read data from config file
        prop = new Properties();

        // Load config.properties file from resources folder
      //  prop = new Properties();
        prop.load(
                getClass()
                        .getClassLoader()
                        .getResourceAsStream("config.properties")
        );




        // Get browser name and application URL from config
        String browser = prop.getProperty("browser");
        String url = prop.getProperty("url");

        // Initialize WebDriver based on browser value
       WebDriver localDriver = DriverFactory.initializeDriver(browser);
       driver.set(localDriver);

        // Navigate to the application URL
        driver.get().get(prop.getProperty("url"));
    }

    // Runs after all tests are executed
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        logger.info("Closing browser");
        driver.get().quit();
        driver.remove();
    }
}
