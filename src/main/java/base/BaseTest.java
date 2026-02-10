package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
<<<<<<< HEAD
import org.testng.annotations.Parameters;
=======
>>>>>>> da8faee (Updated Selenium TestNG automation framework with parallel execution and ThreadLocal driver)
import utils.DriverFactory;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {

<<<<<<< HEAD
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
=======
    // Thread-safe WebDriver for parallel execution
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    protected Properties prop;
    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    // Access driver safely anywhere
    public static WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod(alwaysRun = true)
    public void setup() throws IOException {

        String env = System.getProperty("env", "qa");
        logger.info("Loading configuration properties");

        prop = new Properties();
        prop.load(
                getClass()
                        .getClassLoader()
                        .getResourceAsStream("config_" + env + ".properties")
        );

        String browser = prop.getProperty("browser");
        String url = prop.getProperty("url");

        WebDriver localDriver = DriverFactory.initializeDriver(browser);
        driver.set(localDriver);

        getDriver().manage().window().maximize();
        getDriver().get(url);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        logger.info("Closing browser");
        WebDriver localDriver = driver.get();
        if (localDriver != null) {
            localDriver.quit();
            driver.remove();
        }
>>>>>>> da8faee (Updated Selenium TestNG automation framework with parallel execution and ThreadLocal driver)
    }
}
