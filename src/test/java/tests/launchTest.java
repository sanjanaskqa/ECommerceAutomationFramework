package tests;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class launchTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(launchTest.class);

    // Simple smoke test to verify the application launches correctly
    @Test
    public void VerifyApp(){

        logger.info("Getting the title of the page");

        // Fetch the current page title after application launch
        String title = getDriver().getTitle();

        // Validate that the title contains expected text
        // This confirms the correct page is loaded
        Assert.assertTrue(title.contains("Swag Labs"));
    }

}