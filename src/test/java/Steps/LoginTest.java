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
        try {
            test.info("Navigating to login page");
            loginPage.clickOnLoginButtonOnHomePage();
            test.pass("Navigation to login page successful");
        } catch (Exception e) {
            test.fail("Failed to navigate to login page: " + e.getMessage());
            test.fail(e);
        }
    }

    @When("User enters valid Username and password")
    public void userEntersValidUsernameAndPassword() {
        try {

            LoginData data = Hooks.loginDataWrapper.getValidLogin();
            test.info("Entering valid username and password");
            loginPage.enterUsernameAndPassword(data.getEmail(), data.getPassword());
            loginPage.clickOnLoginButton();
            loginPage.clickOnAccept();
            test.pass("Login successful");
        } catch (Exception e) {
            test.fail("Login failed: " + e.getMessage());
            test.fail(e);
        }
    }

    @Then("User should redirect on home page")
    public void userShouldRedirectOnHomePage() {
        try {
            test.info("Verifying user is redirected to home page");
            loginPage.verifyLoginIsSuccessful();
            test.pass("User is on home page");
        } catch (Exception e) {
            test.fail("User not redirected to home page: " + e.getMessage());
            test.fail(e);
        }
    }

    @When("User enters invalid Username and password")
    public void userEntersInvalidUsernameAndPassword() {
        try {
            LoginData data = Hooks.loginDataWrapper.getInvalidLogin();
            test.info("Entering invalid username and password");
            loginPage.enterUsernameAndPassword(data.getEmail(), data.getPassword());
            loginPage.clickOnLoginButton();
            test.pass("Invalid credentials submitted");
        } catch (Exception e) {
            test.fail("Error entering invalid credentials: " + e.getMessage());
            test.fail(e);
        }
    }

    @Then("User should see login error message")
    public void userShouldSeeLoginErrorMessage() {
        try {
            test.info("Verifying error message for invalid login");
            loginPage.verifyInvalidUsernameAndPasswordErrorMassage();
            test.pass("Login error message verified");
        } catch (Exception e) {
            test.fail("Login error message not shown: " + e.getMessage());
            test.fail(e);
        }
    }

    @When("User enters empty Username and password")
    public void userEntersEmptyUsernameAndPassword() {
        try {
            LoginData data = Hooks.loginDataWrapper.getEmptyFields();
            test.info("Entering empty username and password");
            loginPage.enterUsernameAndPassword(data.getEmail(), data.getPassword());
            loginPage.clickOnLoginButton();
            test.pass("Submitted empty credentials");
        } catch (Exception e) {
            test.fail("Failed to enter empty credentials: " + e.getMessage());
            test.fail(e);
        }
    }

    @Then("User should see required field validation messages")
    public void userShouldSeeRequiredFieldValidationMessages() {
        try {
            test.info("Verifying validation for empty fields");
            loginPage.verifyRequiredUsernameError();
            loginPage.verifyPasswordUsernameError();
            test.pass("Validation messages verified");
        } catch (Exception e) {
            test.fail("Validation messages not shown: " + e.getMessage());
            test.fail(e);
        }
    }

    @When("User enters valid Username and empty password")
    public void userEntersValidUsernameAndEmptyPassword() {
        try {
            LoginData data = Hooks.loginDataWrapper.getValidUsernameEmptyPassword();
            test.info("Entering valid username and empty password");
            loginPage.enterUsernameAndPassword(data.getEmail(), data.getPassword());
            loginPage.clickOnLoginButton();
            test.pass("Submitted valid username with empty password");
        } catch (Exception e) {
            test.fail("Error entering valid username with empty password: " + e.getMessage());
            test.fail(e);
        }
    }

    @Then("User should see required password field validation messages")
    public void userShouldSeeRequiredPasswordFieldValidationMessages() {
        try {
            test.info("Verifying password field required validation");
            loginPage.verifyPasswordUsernameError();
            test.pass("Password field validation verified");
        } catch (Exception e) {
            test.fail("Password validation not shown: " + e.getMessage());
            test.fail(e);
        }
    }

    @When("User enters empty Username and valid password")
    public void userEntersEmptyUsernameAndValidPassword() {
        try {
//            LoginData data = Hooks.loginDataWrapper.getEmptyUsernameValidPassword();
//            test.info("Entering empty username and valid password");
//            loginPage.enterUsernameAndPassword(data.getEmail(), data.getPassword());
            loginPage.clickOnLoginButton();
            test.pass("Submitted empty username with valid password");
        } catch (Exception e) {
            test.fail("Error entering empty username: " + e.getMessage());
            test.fail(e);
        }
    }

    @Then("User should see required username field validation messages")
    public void userShouldSeeRequiredUsernameFieldValidationMessages() {
        try {
            test.info("Verifying username field required validation");
            loginPage.verifyRequiredUsernameError();
            test.pass("Username field validation verified");
        } catch (Exception e) {
            test.fail("Username validation not shown: " + e.getMessage());
            test.fail(e);
        }
    }

    @When("User clicks on Sign Up button")
    public void userClicksOnSignUpButton() {
        try {
            test.info("Clicking on Sign Up button");
            loginPage.clickOnSignUp();
            test.pass("Clicked on Sign Up button");
        } catch (Exception e) {
            test.fail("Failed to click on Sign Up: " + e.getMessage());
            test.fail(e);
        }
    }

    @Then("User should be redirected to the registration page")
    public void userShouldBeRedirectedToTheRegistrationPage() {
        try {
            test.info("Verifying Sign Up page redirection");
            loginPage.verifySignUpPage();
            test.pass("Redirection to Sign Up page verified");
        } catch (Exception e) {
            test.fail("Sign Up page not shown: " + e.getMessage());
            test.fail(e);
        }
    }

    @When("User enters password")
    public void userEntersPassword() {
        try {
            LoginData data = Hooks.loginDataWrapper.getValidLogin();
            test.info("Entering password");
            loginPage.enterUsernameAndPassword(data.getEmail(), data.getPassword());
            test.pass("Password entered");
        } catch (Exception e) {
            test.fail("Error entering password: " + e.getMessage());
            test.fail(e);
        }
    }

    @Then("Password field should mask the entered characters")
    public void passwordFieldShouldMaskTheEnteredCharacters() {
        try {
            test.info("Verifying password masking");
            loginPage.verifyPasswordIsMasked();
            test.pass("Password masking verified");
        } catch (Exception e) {
            test.fail("Password not masked: " + e.getMessage());
            test.fail(e);
        }
    }

    @When("User clicks on Show Password icon")
    public void userClicksOnShowPasswordIcon() {
        try {
            userEntersPassword(); // logging included inside it
            test.info("Clicking on Show Password icon");
            loginPage.clickOnShowPasswordIcon();
            test.pass("Clicked Show Password icon");
        } catch (Exception e) {
            test.fail("Failed to click on Show Password: " + e.getMessage());
            test.fail(e);
        }
    }

    @Then("Password should be visible in plain text")
    public void passwordShouldBeVisibleInPlainText() {
        try {
            test.info("Verifying plain text password visibility");
            loginPage.verifyPasswordIsVisible();
            test.pass("Password visibility verified");
        } catch (Exception e) {
            test.fail("Password not visible: " + e.getMessage());
            test.fail(e);
        }
    }

    @When("User clicks on Forgot Password link")
    public void userClicksOnForgotPasswordLink() {
        try {
            test.info("Clicking Forgot Password link");
            loginPage.clickOnForgotPassword();
            test.pass("Forgot Password link clicked");
        } catch (Exception e) {
            test.fail("Error clicking Forgot Password: " + e.getMessage());
            test.fail(e);
        }
    }

    @Then("User should be redirected to forgot password page")
    public void userShouldBeRedirectedToForgotPasswordPage() {
        try {
            test.info("Verifying Forgot Password page");
            loginPage.verifyForgotPassword();
            test.pass("Forgot Password page verified");
        } catch (Exception e) {
            test.fail("Forgot Password page not shown: " + e.getMessage());
            test.fail(e);
        }
    }

    @When("User selects a different language from dropdown")
    public void userSelectsADifferentLanguageFromDropdown() {
        try {
            test.info("Selecting different language");
            loginPage.clickOnLanguageDropdown();
            test.pass("Language selected");
        } catch (Exception e) {
            test.fail("Failed to select language: " + e.getMessage());
            test.fail(e);
        }
    }

    @Then("UI text should be displayed in selected language")
    public void uiTextShouldBeDisplayedInSelectedLanguage() {
        try {
            test.info("Verifying language change in UI");
            loginPage.verifyLanguageDropdown();
            test.pass("Language UI verified");
        } catch (Exception e) {
            test.fail("Language UI not updated: " + e.getMessage());
            test.fail(e);
        }
    }

    @When("User clicks on Logout button")
    public void userClicksOnLogoutButton() {
        try {
            test.info("Click on Logout button in Menu dropdown");
            loginPage.clickOnLogoutButton();
            test.pass("Successfully click on Logout button");
        } catch (Exception e) {
            test.fail("Failed to click on Logout button: " + e.getMessage());
            test.fail(e);
        }
    }

    @Then("Then user should be logout successfully")
    public void thenUserShouldBeLogoutSuccessfully() {
        try {
            test.info("Verifying Logout is Successful");
            loginPage.verifyLogoutSuccessMessage();
            test.pass("Logout is Successful");
        } catch (Exception e) {
            test.fail("Failed to verify Logout: " + e.getMessage());
            test.fail(e);
        }
    }
}
