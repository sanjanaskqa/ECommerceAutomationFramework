package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // ---------- LOCATORS ----------
    private By firstNameInput  = By.id("first-name");
    private By lastNameInput   = By.id("last-name");
    private By postalCodeInput = By.id("postal-code");
    private By continueButton  = By.id("continue");
    private By finishButton    = By.id("finish");
    private By successMessage  = By.className("complete-header");

    public CheckoutPage(WebDriver driver, int timeout) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    public void enterCheckoutDetails(String first, String last, String zip) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInput)).sendKeys(first);
        driver.findElement(lastNameInput).sendKeys(last);
        driver.findElement(postalCodeInput).sendKeys(zip);
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    public void clickFinish() {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                wait.until(ExpectedConditions.elementToBeClickable(finishButton))
        );
    }

    // ✅ SAFE verification (no URL dependency)
    public boolean isOrderSuccessful() {
        try {
            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(successMessage)
            ).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
