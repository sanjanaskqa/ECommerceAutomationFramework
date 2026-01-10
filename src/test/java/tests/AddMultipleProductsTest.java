package tests;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;
import pages.loginPage;
import utils.DataProviderUtil;



public class AddMultipleProductsTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(AddMultipleProductsTest.class);

    @Test(
            groups = {"regression"},
            dataProvider = "addToCartData",
            dataProviderClass = DataProviderUtil.class,
              retryAnalyzer = utils.RetryAnalyzer.class )
    public void addMultipleProductsToCartTest(String username, String password, String productcount ){


        int timeout = Integer.parseInt(prop.getProperty("timeout"));
        int count = Integer.parseInt(productcount);

        //Login
        // Create login page object using the initialized WebDriver
        logger.info("Performing login with valid credentials");
        loginPage lp = new loginPage(getDriver(), timeout);
        // Perform login with valid credentials
        lp.login(username, password);


        //Productpage
        logger.info("Adding the multiple product to the cart");
        ProductsPage prdpage = new ProductsPage(getDriver(),timeout);
       // prdpage.setFirstaddtocart();
        prdpage.addmultipleproducttocar(count);

        // ---------- GO TO CART ----------
        prdpage.goTocart();
        // ---------- CLICK CHECKOUT ----------
        prdpage.checkout();
        // ---------- VERIFY CHECKOUT PAGE ----------
        Assert.assertTrue(getDriver().getCurrentUrl().contains("checkout"),"checkout page not opened");

        //Assert.assertEquals(1, 2);


    }

}
