package tests;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.loginPage;
import utils.DataProviderUtil;

public class loginTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(loginTest.class);

    // Test to verify that a valid user can log in successfully
    @Test(
<<<<<<< HEAD
            groups = {"regression","smoke"},
=======
            groups = {"regression"},
>>>>>>> da8faee (Updated Selenium TestNG automation framework with parallel execution and ThreadLocal driver)
            dataProvider = "addToCartData",
            dataProviderClass = DataProviderUtil.class,
            retryAnalyzer = utils.RetryAnalyzer.class)

    public void validlogintest(String username, String password, String productcount) {
        logger.info("Starting valid login test");

        int timeout = Integer.parseInt(prop.getProperty("timeout"));
        loginPage lp = new loginPage(getDriver(), timeout);

        // Perform login with valid credentials
        //step1: Attempt login
        logger.info("Attempting login");
        lp.login(username, password);

        //step2:check login result
        boolean loginsuccessful = getDriver().getCurrentUrl().contains("inventory");

        if (loginsuccessful) {
            logger.info("Login successfull , validating navigation");
            Assert.assertTrue(getDriver().getCurrentUrl().contains("inventory"), "user should be navigated to inventory page");
        } else {
            logger.info("Login failed, validating error message");
            Assert.assertTrue(lp.isErrorMessageDisplayed(), "Error message should be displayed for invalid login");

        }

        logger.info("Login test completed for user" + username);
    }
}



