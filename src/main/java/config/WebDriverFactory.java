package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


/**
 * WebDriverFactory class for creating WebDriver instances based on the specified browser type.
 * This class supports Chrome, Firefox, Edge, and Internet Explorer browsers.
 * This class is developed by Cem AÇAR.
 * Last updated on 13.11.23
 */
public class WebDriverFactory {
    private static final int WAIT_TIMEOUT_SECONDS = 10;

    /**
     * Creates a WebDriver instance based on the specified browser type.
     * @param browserType The type of the browser to create (e.g., "chrome", "firefox", "edge", "ie").
     * @return A WebDriver instance.
     * @throws IllegalArgumentException If an invalid browser type is provided.
     */
    public static WebDriver createDriver(String browserType) {
        switch (browserType.toLowerCase()) {
            case "chrome":
                return createChromeDriver();
            case "firefox":
                return createFirefoxDriver();
            case "edge":
                return createEdgeDriver();
            case "ie":
                return createInternetExplorerDriver();
            default:
                throw new IllegalArgumentException("Invalid browser type: " + browserType);
        }
    }

    /**
     * Creates a ChromeDriver instance with specific configurations.
     * @return A ChromeDriver instance.
     */
    private static WebDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    /**
     * Creates a FirefoxDriver instance with specific configurations.
     * @return A FirefoxDriver instance.
     */
    private static WebDriver createFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        FirefoxDriver driver = new FirefoxDriver();
        setDriverConfig(driver);
        return driver;
    }

    /**
     * Creates an EdgeDriver instance with specific configurations.
     * @return An EdgeDriver instance.
     */
    private static WebDriver createEdgeDriver() {
        System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver");
        EdgeDriver driver = new EdgeDriver();
        setDriverConfig(driver);
        return driver;
    }

    /**
     * Creates an InternetExplorerDriver instance with specific configurations.
     * @return An InternetExplorerDriver instance.
     */
    private static WebDriver createInternetExplorerDriver() {
        System.setProperty("webdriver.ie.driver", "src/main/resources/IEDriverServer");
        InternetExplorerDriver driver = new InternetExplorerDriver();
        setDriverConfig(driver);
        return driver;
    }

    /**
     * Sets common configurations for the WebDriver instance.
     * @param driver The WebDriver instance to configure.
     */
    private static void setDriverConfig(WebDriver driver) {
        driver.manage().window().maximize();
     }
}
