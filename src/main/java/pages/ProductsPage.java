package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ProductsPage {
    private WebDriver driver;
    private WaitUtils wait;
    private static final Logger logger = LogManager.getLogger(ProductsPage.class);

    private By firstaddtocart = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    private  By addToCartButtons = By.xpath("//button[contains(text(),'Add to cart')]");

    private By CartIcon = By.className("shopping_cart_link");
    private By Checkout = By.id("checkout");

    public ProductsPage(WebDriver driver, int timeout){
        this.driver=driver;
        this.wait= new WaitUtils(driver,timeout);
        logger.info("Product Page Initialized");
    }

    public void setFirstaddtocart(){
        driver.findElement(firstaddtocart).click();
    }

    public  void addmultipleproducttocar(int count){
        logger.info("Items are adding to cart");
        wait.waitForElementVisible(addToCartButtons);
       List<WebElement> buttons = driver.findElements(addToCartButtons);
       for(int i=0; i<count && i < buttons.size(); i++){
           buttons.get(i).click();
       }
    }


    public void goTocart(){
        logger.info("Products are added to cart");
        wait.waitForElementClickable(CartIcon);
        driver.findElement(CartIcon).click();
    }

    public void checkout(){
        logger.info("Checkout page opened");
        wait.waitForElementClickable(Checkout);
        driver.findElement(Checkout).click();
    }

}
