package pageObjectModel;

import dto.PopulerBet;
import error.ErrorCode;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import service.RestClient;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * PopulerBetModel class representing the page object model for the Populer Bet functionality.
 * This class includes methods for navigating to the Populer Bet page, selecting the Futbol type, and comparing dynamic and actual data.
 * This class is developed by Cem AÇAR.
 * Last updated on 13.11.23
 */
public class PopulerBetModel extends BaseTest{

    WebDriver driver;

    RestClient restClient = new RestClient();

    @FindBy(css = "[tracking-label='Header-PopulerBahisler']")
    WebElement populerBetButton;

    @FindBy(css = "[bettypeid='1']")
    WebElement populerBetTypeFutbol;

    @FindAll(@FindBy(css = "[data-test-id='MatchLine']"))
    List<WebElement> pagePopulerBets;

    /**
     * Constructs a PopulerBetModel object with the specified WebDriver instance.
     * @param driver The WebDriver instance.
     */
    public PopulerBetModel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Navigates to the Populer Bet page.
     * If an exception occurs, it captures a screenshot and attaches an error message to the Allure report.
     *
     * @throws Exception If an error occurs during navigation.
     */
    public void getPopulerBetPage() {
        try {
            validateElementVisibility(driver, populerBetButton, Duration.ofSeconds(5));
            populerBetButton.click();
        } catch (Exception e) {
            attachText("Hata", ErrorCode.POPULERBET_PAGE_ERROR + e.getMessage());
            attachScreenshot(driver, "Ekran Görüntüsü");
            throw e;
        }
    }

    /**
     * Selects the "Futbol" type on the Populer Bet page.
     * If an exception occurs, it captures a screenshot and attaches an error message to the Allure report.
     *
     * @throws Exception If an error occurs during type selection.
     */
    public void getBetPopulerTypeFutbol() {
        try {
            validateElementVisibility(driver, populerBetTypeFutbol, Duration.ofSeconds(5));
            populerBetTypeFutbol.click();
        } catch (Exception e) {
            attachText("Hata", ErrorCode.POPULERBET_FUTBOL_PAGE_ERROR + e.getMessage());
            attachScreenshot(driver, "Ekran Görüntüsü");
            throw e;
        }
    }

    /**
     * Compares dynamic and actual data on the Populer Bet page.
     * If an exception occurs during the comparison or an assertion error is thrown, it captures a screenshot and attaches an error message to the Allure report.
     *
     * @throws Exception,AssertionError If an error occurs during data comparison.
     */
    public void compareDynamicAndActualData(){
        try {
            List<PopulerBet> actualData = getPopulerBet();
            List<PopulerBet> dynamicData = restClient.getPopularBet();
            System.out.println("actual Data" + actualData.size() + "Dynamic Data Size" + dynamicData.size());
            Assert.assertEquals("Listeler aynı uzunluktan değil", actualData.size(), dynamicData.size());

            for (int i = 0; i < actualData.size(); i++) {
                Integer actualMarketNo = actualData.get(i).getMarketNo();
                Integer actualPlayedCount = actualData.get(i).getPlayedCount();

                Integer dynamicMarketNo = dynamicData.get(i).getMarketNo();
                Integer dynamicPlayedCount = dynamicData.get(i).getPlayedCount();
                Assert.assertEquals("MarketNo değerleri eşleşmiyor", actualMarketNo, dynamicMarketNo);
                Assert.assertEquals("PlayedCount değerleri eşleşmiyor", actualPlayedCount, dynamicPlayedCount);
            }
        } catch (Exception e) {
            attachText("Hata", ErrorCode.POPULERBET_COMPARE + e.getMessage());
            attachScreenshot(driver, "Ekran Görüntüsü");
            throw e;
        } catch (AssertionError e){
            attachText("Hata",e.getMessage());
            throw e;
        }

    }

    /**
     * Retrieves the Populer Bet data from the web page.
     * If an exception occurs, it captures a screenshot and attaches an error message to the Allure report.
     *
     * @return <List><PopulerBet objects representing the retrieved data.
     * @throws Exception If an error occurs during data retrieval.
     */
    private List<PopulerBet> getPopulerBet(){
        try {
            List<PopulerBet> betInfoList = new ArrayList<>();
            for (int i = 0; i < pagePopulerBets.size(); i++) {
                WebElement element = pagePopulerBets.get(i);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                Integer marketNo = Integer.valueOf(element.findElement(By.className("matchCode"))
                                    .findElement(By.tagName("button"))
                                    .findElement(By.tagName("span"))
                                    .getText());
                String playedCount = element.findElement(By.className("playedCount")).getText().replace(".", "");
                PopulerBet populerBet = new PopulerBet(Integer.parseInt(playedCount), marketNo);
                betInfoList.add(populerBet);
            }
            return betInfoList;
        } catch (Exception e) {
            attachText("Hata", ErrorCode.POPULERBET_FUTBOL_PAGE_ERROR + e.getMessage());
            attachScreenshot(driver, "Ekran Görüntüsü");
            throw e;
        }
    }
}
