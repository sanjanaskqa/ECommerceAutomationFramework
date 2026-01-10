package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    // WebDriverWait instance used for explicit waits
    private final WebDriverWait wait;

    // Constructor initializes wait with driver and timeout value
    // Timeout is usually read from config to keep it configurable
    public WaitUtils(WebDriver driver, int timeout) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    // Waits until the element is visible on the page
    public void waitForElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Waits until the element is clickable (visible and enabled)
    public void waitForElementClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Waits until the current URL contains the expected value
    public void waitForUrlContains(String value) {
        wait.until(ExpectedConditions.urlContains(value));
    }
}
