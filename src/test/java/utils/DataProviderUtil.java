package utils;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviderUtil {
    @DataProvider(name= "addToCartData")
    public static Object[][] getAddToCartData() throws IOException {

        return ExcelUtils.getTestData("AddToCartData");
    }
<<<<<<< HEAD
=======

    @DataProvider(name ="negativeLoginData")
    public static Object[][] getNegativeLoginData() throws Exception{
        return ExcelUtils.getTestData("Login_NegativeData");
    }
>>>>>>> da8faee (Updated Selenium TestNG automation framework with parallel execution and ThreadLocal driver)
}
