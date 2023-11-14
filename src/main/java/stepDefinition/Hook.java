package stepDefinition;
import config.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

/**
 * Hook class for setting up and tearing down the WebDriver before and after scenarios.
 * This class is developed by Cem AÇAR.
 * Last updated on 13.11.23
 */
public class Hook {
    public static WebDriver driver;
    /**
     * Sets up the WebDriver before the scenario.
     */
    @Before
    public void setUp() {
       this.driver = WebDriverFactory.createDriver("firefox");
    }

    /**
     * Tears down the WebDriver after the scenario.
     */
    @After
    public void tearDown() {
        driver.quit();
    }
}
