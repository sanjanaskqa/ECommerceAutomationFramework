package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class loginPage {

    // WebDriver instance used to interact with the login page
    private WebDriver driver;
    private WaitUtils wait;
    private static final  Logger logger = LogManager.getLogger(loginPage.class);


    // Locators for login page elements
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("h3[data-test='error']");

    // Constructor receives driver from test or base class
    // This keeps driver management outside the page class
    public loginPage(WebDriver driver,int timeout){
        this.driver = driver;
        this.wait = new WaitUtils(driver, timeout);
        logger.info("LoginPage initialized");
    }


    // Enters username into the username input field
    public void enterusername(String username){
        wait.waitForElementClickable(usernameField);
        logger.info("Entering username");
        driver.findElement(usernameField).sendKeys(username);
    }

    // Enters password into the password input field
    public void enterpassword(String password){
        logger.info("Entering password");
        wait.waitForElementClickable(passwordField);
        driver.findElement(passwordField).sendKeys(password);
    }

    // Clicks the login button
    public void clicklogin(){
        logger.info("clicking login button");
        wait.waitForElementClickable(loginButton);
        driver.findElement(loginButton).click();
    }

    // Performs complete login action using username and password
    // Combines multiple steps into a single reusable method
    public void login(String username, String password){
        logger.info("Performing login action");
        enterusername(username);
        enterpassword(password);
        clicklogin();
    }
    public boolean isErrorMessageDisplayed(){
        logger.info("Checking if error message is displayed");
        return driver.findElement(errorMessage).isDisplayed();
    }
}
