package Steps;

import CommonFile.BasePage;
import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginTest {

    LoginPage loginPage;
    @Given("Go to login page")
    public void goToLoginPage() {
        //luanchURL("https://www.shinywilds.com/en/login");
        loginPage = new LoginPage(BasePage.driver);
        loginPage.clickOnLoginButtonOnHomePage();
    }

    @When("user enters {string} and {string}")
    public void userEntersAnd(String username, String password) {
        loginPage.login(username,password);
        loginPage.clickOnLoginButton();
        loginPage.clickOnAccept();
    }

    @Then("user should redirect on home page")
    public void userShouldRedirectOnHomePage() {
        loginPage.verifyLoginIsSuccessfull();
    }
}
