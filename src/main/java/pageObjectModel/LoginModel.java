package pageObjectModel;
import config.AppConfig;
import error.ErrorCode;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;

/**
 * LoginModel class representing the page object model for the login functionality.
 * This class includes methods for navigating to the login page, performing login, and validating successful login.
 * This class is developed by Cem AÇAR.
 * Last updated on 13.11.23
 */
public class LoginModel extends BaseTest{

    WebDriver driver;

    @FindBy(name = "header-username-input")
    WebElement userName;

    @FindBy(name = "header-password-input")
    WebElement password;

    @FindBy(css = "[data-test-id='header-login-btn']")
    WebElement loginButton;

    @FindBy(id = "hideShowBalance")
    WebElement showBalance;


    /**
     * Constructs a LoginModel object with the specified WebDriver instance.
     *
     * @param driver The WebDriver instance.
     */
    public LoginModel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Navigates to the login page.
     * If an exception occurs, it captures a screenshot and attaches an error message to the Allure report.
     *
     * @throws Exception If an error occurs during navigation.
     */
    public void getWebSite() {
        try {
            driver.get(AppConfig.getProperty("login.url"));
        } catch (Exception e) {
            attachText("Hata", ErrorCode.WEB_SITE_ACCESS_ERROR + e.getMessage());
            attachScreenshot(driver, "Ekran Görüntüsü");
            throw e;
        }
    }

    /**
     * Performs login by entering username and password, and clicking the login button.
     * If an exception occurs, it captures a screenshot and attaches an error message to the Allure report.
     * @throws Exception If an error occurs during login.
     */
    public void loginPage(){
        try {
            validateElementVisibility(driver, userName, Duration.ofSeconds(10));
            userName.sendKeys(AppConfig.getProperty("login.username"));
            password.sendKeys(AppConfig.getProperty("login.password"));
            loginButton.click();
        } catch (Exception e) {
            attachText("Hata", ErrorCode.LOGIN_ERROR + e.getMessage());
            attachScreenshot(driver, "Ekran Görüntüsü");
            throw e;
        }
    }

    /**
     * Validates whether the "Show Balance" element is visible after a successful login.
     * If not visible or an assertion error occurs, it captures a screenshot and attaches an error message to the Allure report.
     *
     * @throws Exception,AssertionError If an error occurs during validation.
     */
    public void isShowBalanceVisible() {
        try {
            validateElementVisibility(driver, showBalance, Duration.ofSeconds(5));
            Assert.assertTrue(ErrorCode.LOGIN_SUCESS_ERROR_2, showBalance.isDisplayed());
        } catch (Exception e) {
            attachText("Hata", ErrorCode.LOGIN_SUCESS_ERROR + e.getMessage());
            attachScreenshot(driver, "Ekran Görüntüsü");
            throw e;
        } catch (AssertionError e){
            attachText("Hata", ErrorCode.LOGIN_SUCESS_ERROR + e.getMessage());
            attachScreenshot(driver, "Ekran Görüntüsü");
            throw e;
        }
    }

}
