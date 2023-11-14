package stepDefinition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;
import pageObjectModel.LoginModel;

public class Login {

    public LoginModel loginModel = new LoginModel(Hook.driver);

    @Test
    @Given("Kullanıcı {string} adresine gider")
    public void userNavigatesTo(String url) {
        loginModel.getWebSite();
    }

    @When("Kullanıcı kullanıcı adı  ve şifre ile giriş yapar")
    public void userLogsIn() throws InterruptedException {
        loginModel.loginPage();
    }

    @Then("Kullanıcı başarıyla giriş yapmış olmalıdır")
    public void userSuccessfullyLoggedIn() {
        loginModel.isShowBalanceVisible();
    }
}

