package tests;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;
import pages.loginPage;

public class AddToCartTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(AddToCartTest.class);

    @Test
    public void addsingleproducttocart(){
        int timeout =Integer.parseInt(prop.getProperty("timeout"));
        // Create login page object using the initialized WebDriver
        loginPage lp = new loginPage(getDriver(), timeout);

        // Perform login with valid credentials
        logger.info("Validating with valid cred");
        lp.login("standard_user", "secret_sauce");

        //Productpage
        logger.info("Adding the first product to cart");
        ProductsPage prdpage = new ProductsPage(getDriver(),timeout);
        prdpage.setFirstaddtocart();
    }
}
