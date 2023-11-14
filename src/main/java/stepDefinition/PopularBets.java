package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectModel.PopulerBetModel;

public class PopularBets {
    public PopulerBetModel populerBetModel = new PopulerBetModel(Hook.driver);

    @And("Kullanıcı popüler bahis adresine tıklar")
    public void userClicksOnPopularBets() {
        populerBetModel.getPopulerBetPage();
    }

    @When("Kullanıcı {string} sekmesine tıkladığında")
    public void userClicksOnTab(String tabName) {
        populerBetModel.getBetPopulerTypeFutbol();
    }

    @Then("Popüler bahis listesindeki değerle servisteki değerlerin eşit olması beklenir")
    public void comparisonBetweenValuesIsExpectedToBeEqual() throws InterruptedException {
        populerBetModel.compareDynamicAndActualData();
    }
}
