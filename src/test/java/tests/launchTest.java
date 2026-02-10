package tests;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
<<<<<<< HEAD
=======
import utils.DataProviderUtil;
>>>>>>> da8faee (Updated Selenium TestNG automation framework with parallel execution and ThreadLocal driver)

public class launchTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(launchTest.class);

<<<<<<< HEAD
    // Simple smoke test to verify the application launches correctly
    @Test
=======
    // Test to verify that a valid user can log in successfully
    @Test(
            groups = {"regression"},
            retryAnalyzer = utils.RetryAnalyzer.class)

    // Simple smoke test to verify the application launches correctly

>>>>>>> da8faee (Updated Selenium TestNG automation framework with parallel execution and ThreadLocal driver)
    public void VerifyApp(){

        logger.info("Getting the title of the page");

        // Fetch the current page title after application launch
        String title = getDriver().getTitle();

        // Validate that the title contains expected text
        // This confirms the correct page is loaded
        Assert.assertTrue(title.contains("Swag Labs"));
    }

}