package pageObjectModel;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * BaseTest class providing common functionalities and utilities for test classes.
 * This class includes methods for validating element visibility, attaching screenshots, and attaching text content to Allure reports.
 * This class is developed by Cem AÇAR.
 * Last updated on 14.11.23
 */
public abstract class BaseTest {

    /**
     * Validates the visibility of a WebElement within the specified timeout.
     * @param driver  The WebDriver instance.
     * @param element The WebElement to validate visibility.
     * @param timeout The duration to wait for the element to become visible.
     */
    protected void validateElementVisibility(WebDriver driver, WebElement element, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Attaches a screenshot to the Allure report with the specified attachment name.
     * @param driver          The WebDriver instance to capture the screenshot from.
     * @param attachmentName  The name of the attachment.
     */
    protected void attachScreenshot(WebDriver driver, String attachmentName) {
        try {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.getLifecycle().addAttachment(attachmentName, "image/png", "png", screenshot);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Attaches text content to the Allure report with the specified attachment name.
     * @param attachmentName The name of the attachment.
     * @param content        The text content to attach.
     */
    protected void attachText(String attachmentName, String content) {
        try {
            Allure.addAttachment(attachmentName, content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
