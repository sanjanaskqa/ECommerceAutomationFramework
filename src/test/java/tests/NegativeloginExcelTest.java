package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.loginPage;
import utils.DataProviderUtil;

public class NegativeloginExcelTest extends BaseTest {
    @Test(

            dataProvider = "negativeLoginData",
            dataProviderClass = DataProviderUtil.class,
            groups = {"smoke","security","boundary"}

    )
    public void negativelogintests(String username, String password, String expectedError, String scenario){
        int timeout = Integer.parseInt(prop.getProperty("timeout"));
        loginPage lp = new loginPage(getDriver(),timeout);
        lp.enterusername(username);
        lp.enterpassword(password);
        lp.clicklogin();
        // boolean actualError= lp.isErrorMessageDisplayed();
        // Assert.assertEquals(actualError,expectedError,"Failed Scenario:" + scenario);


    }
}
