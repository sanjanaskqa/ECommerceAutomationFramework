package utils;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviderUtil {
    @DataProvider(name= "addToCartData")
    public static Object[][] getAddToCartData() throws IOException {

        return ExcelUtils.getTestData("AddToCartData");
    }
}
