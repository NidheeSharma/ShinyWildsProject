package Steps;

import CommonFile.BasePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.LoginData;

import static hooks.Hooks.test;

public class MyAccountTest {
    LoginPage loginPage = new LoginPage(BasePage.driver);
    MyAccountPage myAccountPage = new MyAccountPage(BasePage.driver);

    @Given("User is logged into the application")
    public void userIsLoggedIntoTheApplication() {
        test.info("Navigating to login page");
        loginPage.clickOnLoginButtonOnHomePage();
        test.pass("Navigation to login page successful");

        LoginData data = Hooks.loginDataWrapper.getUsernamePasswordForChangePassword();
        test.info("Entering valid username and password");
        loginPage.enterUsernameAndPassword(data.getEmail(), data.getPassword());
        loginPage.clickOnLoginButton();
        loginPage.clickOnAccept();
        test.pass("Login successful");
    }

    @And("User navigates to the My Account page")
    public void userNavigatesToTheMyAccountPage(){
        myAccountPage.clickOnDropdownMenuButton();
        myAccountPage.clickOnMyAccountLabel();
    }

    @Then("Verify the Email ID and Username data fields should be visible")
    public void verifyTheEmailIDAndUsernameDataFieldsShouldBeVisible() {
        myAccountPage.verifyEmailAndUsername();
    }

    @When("User opens the Private Data tab")
    public void userOpensThePrivateDataTab() {
        myAccountPage.openPrivateDataSection();
    }

    @Then("Verify the private data fields should be visible")
    public void verifyThePrivateDataFieldsShouldBeVisible() {
        myAccountPage.verifyPrivateData();
    }

    @When("User opens the Address tab")
    public void userOpensTheAddressTab() {
        myAccountPage.clickOnAddressSection();
    }

    @Then("Verify the address data fields should be visible")
    public void verifyTheAddressDataFieldsShouldBeVisible() {
        myAccountPage.verifyAddressData();
    }

    @When("User opens the Change Password tab")
    public void userOpensTheChangePasswordTab() {
        myAccountPage.clickOnChangePasswordSection();
    }

    @And("User enters a valid new password")
    public void userEntersAValidNewPassword() {
        myAccountPage.enterPassword();
    }

    @And("User confirms the password")
    public void userConfirmsThePassword() {
        myAccountPage.enterConfirmPassword();
    }

    @And("User clicks on Save Changes")
    public void userClicksOnSaveChanges() {
        myAccountPage.clickOnSaveChanges();
    }

    @Then("A success message Password updated successfully should be displayed")
    public void aSuccessMessagePasswordUpdatedSuccessfullyShouldBeDisplayed() {
        myAccountPage.verifyPasswordUpdateSuccessfully();

        LoginData data = Hooks.loginDataWrapper.getReLoginViaChangePassword();
        test.info("Re-enter the username and changed password");
        loginPage.enterUsernameAndPassword(data.getEmail(), data.getPassword());
        loginPage.clickOnLoginButton();
        loginPage.clickOnAccept();
        test.pass("Login successful");
        loginPage.clickOnCrossButton();

        myAccountPage.clickOnDropdownMenuButton();
        myAccountPage.clickOnMyAccountLabel();

        myAccountPage.clickOnChangePasswordSection();
        myAccountPage.reEnterPassword();
        myAccountPage.reEnterConfirmPassword();
        myAccountPage.clickOnSaveChanges();
        myAccountPage.verifyPasswordUpdateSuccessfully();

    }

    @And("User try to enters a same password")
    public void userTryToEntersASamePassword() {
        myAccountPage.reEnterPassword();
    }

    @And("User confirms with the same password")
    public void userConfirmsWithTheSamePassword() {
        myAccountPage.reEnterConfirmPassword();
    }

    @Then("A error message should be displayed")
    public void aErrorMessageShouldBeDisplayed() {
        myAccountPage.verifyErrorMsgWithSamePassword();
    }
}
