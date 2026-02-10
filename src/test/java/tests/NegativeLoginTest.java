package tests;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.loginPage;

public class NegativeLoginTest extends BaseTest {

    @Test(groups = "regression")
    public void loginwithinvalidcredentails(){
        int timeout = Integer.parseInt(prop.getProperty("timeout"));
        loginPage lp = new loginPage(getDriver(),timeout);
        lp.enterusername("invalidUser");
        lp.enterpassword("invalidPass");
        lp.clicklogin();
    }
    @Test(groups = "security" )
    public void loginwithVeryLongUsername(){
        int timeout = Integer.parseInt(prop.getProperty("timeout"));
        loginPage lp = new loginPage(getDriver(),timeout);
        String longUsername = "a".repeat(20);
        lp.enterusername(longUsername);
        lp.enterpassword("secret_sauce");
        lp.clicklogin();
        Assert.fail("Forcing failure to test screenshot");


    }

    @Test(groups = "boundary")
    public void loginwithsqlInjection(){
        int timeout = Integer.parseInt(prop.getProperty("timeout"));
        loginPage lp = new loginPage(getDriver(),timeout);
        lp.enterusername(" 'OR '1' ='1");
        lp.enterpassword("'OR '1' ='1 ");
        lp.clicklogin();
        Assert.assertTrue(lp.isErrorMessageDisplayed());
    }
}
