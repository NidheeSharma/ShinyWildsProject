package Steps;

import CommonFile.BasePage;
import Pages.LoginPage;
import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.LoginData;

import static hooks.Hooks.test;

public class LoginTest {

    LoginPage loginPage = new LoginPage(BasePage.driver);

    @Given("Navigate to login page")
    public void goToLoginPage() {
         test.info("Navigating to login page");
         loginPage.clickOnLoginButtonOnHomePage();
         test.pass("Navigation to login page successful");
    }

    @When("User enters valid Username and password")
    public void userEntersValidUsernameAndPassword() {
         LoginData data = Hooks.loginDataWrapper.getValidLogin();
         test.info("Entering valid username and password");
         loginPage.enterUsernameAndPassword(data.getEmail(), data.getPassword());
         loginPage.clickOnLoginButton();
         loginPage.clickOnAccept();
         test.pass("Login successful");
    }

    @Then("User should redirect on home page")
    public void userShouldRedirectOnHomePage() {
         test.info("Verifying user is redirected to home page");
         loginPage.verifyLoginIsSuccessful();
         test.pass("User is on home page");
    }

    @When("User enters invalid Username and password")
    public void userEntersInvalidUsernameAndPassword() {
         LoginData data = Hooks.loginDataWrapper.getInvalidLogin();
         test.info("Entering invalid username and password");
         loginPage.enterUsernameAndPassword(data.getEmail(), data.getPassword());
         loginPage.clickOnLoginButton();
         test.pass("Invalid credentials submitted");
    }

    @Then("User should see login error message")
    public void userShouldSeeLoginErrorMessage() {
         test.info("Verifying error message for invalid login");
         loginPage.verifyInvalidUsernameAndPasswordErrorMassage();
         test.pass("Login error message verified");
    }

    @When("User enters empty Username and password")
    public void userEntersEmptyUsernameAndPassword() {
         LoginData data = Hooks.loginDataWrapper.getEmptyFields();
         test.info("Entering empty username and password");
         loginPage.enterUsernameAndPassword(data.getEmail(), data.getPassword());
         loginPage.clickOnLoginButton();
         test.pass("Submitted empty credentials");
    }

    @Then("User should see required field validation messages")
    public void userShouldSeeRequiredFieldValidationMessages() {
         test.info("Verifying validation for empty fields");
         loginPage.verifyRequiredUsernameError();
         loginPage.verifyPasswordUsernameError();
         test.pass("Validation messages verified");
    }

    @When("User enters valid Username and empty password")
    public void userEntersValidUsernameAndEmptyPassword() {
         LoginData data = Hooks.loginDataWrapper.getValidUsernameEmptyPassword();
         test.info("Entering valid username and empty password");
         loginPage.enterUsernameAndPassword(data.getEmail(), data.getPassword());
         loginPage.clickOnLoginButton();
         test.pass("Submitted valid username with empty password");
    }

    @Then("User should see required password field validation messages")
    public void userShouldSeeRequiredPasswordFieldValidationMessages() {
         test.info("Verifying password field required validation");
         loginPage.verifyPasswordUsernameError();
         test.pass("Password field validation verified");
    }

    @When("User enters empty Username and valid password")
    public void userEntersEmptyUsernameAndValidPassword() {
         loginPage.clickOnLoginButton();
         test.pass("Submitted empty username with valid password");
    }

    @Then("User should see required username field validation messages")
    public void userShouldSeeRequiredUsernameFieldValidationMessages() {
        test.info("Verifying username field required validation");
        loginPage.verifyRequiredUsernameError();
        test.pass("Username field validation verified");
    }

    @When("User clicks on Sign Up button")
    public void userClicksOnSignUpButton() {
         test.info("Clicking on Sign Up button");
         loginPage.clickOnSignUp();
         test.pass("Clicked on Sign Up button");
    }

    @Then("User should be redirected to the registration page")
    public void userShouldBeRedirectedToTheRegistrationPage() {
         test.info("Verifying Sign Up page redirection");
         loginPage.verifySignUpPage();
         test.pass("Redirection to Sign Up page verified");
    }

    @When("User enters password")
    public void userEntersPassword() {
         LoginData data = Hooks.loginDataWrapper.getValidLogin();
         test.info("Entering password");
         loginPage.enterUsernameAndPassword(data.getEmail(), data.getPassword());
         test.pass("Password entered");
    }

    @Then("Password field should mask the entered characters")
    public void passwordFieldShouldMaskTheEnteredCharacters() {
         test.info("Verifying password masking");
         loginPage.verifyPasswordIsMasked();
         test.pass("Password masking verified");
    }

    @When("User clicks on Show Password icon")
    public void userClicksOnShowPasswordIcon() {
         userEntersPassword(); // logging included inside it
         test.info("Clicking on Show Password icon");
         loginPage.clickOnShowPasswordIcon();
         test.pass("Clicked Show Password icon");
    }

    @Then("Password should be visible in plain text")
    public void passwordShouldBeVisibleInPlainText() {
         test.info("Verifying plain text password visibility");
         loginPage.verifyPasswordIsVisible();
         test.pass("Password visibility verified");
    }

    @When("User clicks on Forgot Password link")
    public void userClicksOnForgotPasswordLink() {
         test.info("Clicking Forgot Password link");
         loginPage.clickOnForgotPassword();
         test.pass("Forgot Password link clicked");
    }

    @Then("User should be redirected to forgot password page")
    public void userShouldBeRedirectedToForgotPasswordPage() {
         test.info("Verifying Forgot Password page");
         loginPage.verifyForgotPassword();
         test.pass("Forgot Password page verified");
    }

    @When("User selects a different language from dropdown")
    public void userSelectsADifferentLanguageFromDropdown() {
         test.info("Selecting different language");
         loginPage.clickOnLanguageDropdown();
         test.pass("Language selected");
    }

    @Then("UI text should be displayed in selected language")
    public void uiTextShouldBeDisplayedInSelectedLanguage() {
         test.info("Verifying language change in UI");
         loginPage.verifyLanguageDropdown();
         test.pass("Language UI verified");
    }

    @When("User clicks on Logout button")
    public void userClicksOnLogoutButton() {
         test.info("Click on Logout button in Menu dropdown");
         loginPage.clickOnLogoutButton();
         test.pass("Successfully click on Logout button");
    }

    @Then("Then user should be logout successfully")
    public void thenUserShouldBeLogoutSuccessfully() {
         test.info("Verifying Logout is Successful");
         loginPage.verifyLogoutSuccessMessage();
         test.pass("Logout is Successful");
    }
}
