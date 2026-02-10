package tests;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
<<<<<<< HEAD
=======
import pages.CheckoutPage;
>>>>>>> da8faee (Updated Selenium TestNG automation framework with parallel execution and ThreadLocal driver)
import pages.ProductsPage;
import pages.loginPage;
import utils.DataProviderUtil;

<<<<<<< HEAD


public class AddMultipleProductsTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(AddMultipleProductsTest.class);
=======
public class AddMultipleProductsTest extends BaseTest {

    private static final Logger logger =
            LogManager.getLogger(AddMultipleProductsTest.class);
>>>>>>> da8faee (Updated Selenium TestNG automation framework with parallel execution and ThreadLocal driver)

    @Test(
            groups = {"regression"},
            dataProvider = "addToCartData",
            dataProviderClass = DataProviderUtil.class,
<<<<<<< HEAD
              retryAnalyzer = utils.RetryAnalyzer.class )
    public void addMultipleProductsToCartTest(String username, String password, String productcount ){

=======
            retryAnalyzer = utils.RetryAnalyzer.class
    )
    public void addMultipleProductsToCartTest(
            String username,
            String password,
            String productcount,
            String firstname,
            String lastname,
            String pincode
    ) {
>>>>>>> da8faee (Updated Selenium TestNG automation framework with parallel execution and ThreadLocal driver)

        int timeout = Integer.parseInt(prop.getProperty("timeout"));
        int count = Integer.parseInt(productcount);

<<<<<<< HEAD
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
=======
        loginPage lp = new loginPage(getDriver(), timeout);
        lp.login(username, password);

        ProductsPage productsPage = new ProductsPage(getDriver(), timeout);
        productsPage.addmultipleproducttocar(count);
        productsPage.goTocart();
        productsPage.checkout();

        CheckoutPage checkoutPage = new CheckoutPage(getDriver(), timeout);
        checkoutPage.enterCheckoutDetails(firstname, lastname, pincode);
        checkoutPage.clickContinue();
        checkoutPage.clickFinish();

        // ✅ Assert based on actual behavior
        Assert.assertTrue(
                checkoutPage.isOrderSuccessful(),
                "Checkout failed for user: " + username
        );
    }
}
>>>>>>> da8faee (Updated Selenium TestNG automation framework with parallel execution and ThreadLocal driver)
