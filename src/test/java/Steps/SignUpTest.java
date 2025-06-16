package Steps;

import CommonFile.BasePage;
import Pages.SignUpPage;
import Utils.TimestampDataGenerator;
import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.SignupData;

import static hooks.Hooks.test;

public class SignUpTest {
    SignupData timestampData = TimestampDataGenerator.generateValidSignupData();
    SignUpPage signUpPage = new SignUpPage(BasePage.driver);


    @Given("Navigate to the Sign Up page")
    public void navigateToTheSignUpPage() {
        test.info("Navigating to Signup page");
        signUpPage.clickOnSignUpButton();
        test.pass("Navigation to Signup page successfully");

    }

    @When("User fill the Sign Up form with valid details")
    public void userFillTheSignUpFormWithValidDetails() {
        SignupData data = Hooks.signupDataWrapper.getSignupWithValidData();
        test.info("Enter valid details for Signup");
        signUpPage.enterEmailAddress(timestampData.getEmail());
        signUpPage.enterUsername(timestampData.getUsername());
        signUpPage.fillSignUpFormWithValidData(data);
        test.pass("Details filled successful for Signup page");
    }

    @And("agree to the terms and conditions")
    public void agreeToTheTermsAndConditions() {
         test.info("Accept terms and conditions for successful signup");
         signUpPage.clickOnConfirmTermAndCondition();
         test.pass("Successfully accept the terms and conditions for signup");
    }

    @And("user submit the SignUp form")
    public void userSubmitTheSignUpForm() {
        test.info("Submit the details for successful signup");
        signUpPage.clickOnCreateAnAccountButton();
        test.pass("Successfully submitted all the details for signup");

    }

    @Then("account should be created successfully")
    public void accountShouldBeCreatedSuccessfully() {
        test.info("Signup message should display");
        signUpPage.verifySignupSuccessfulMessage();
        test.pass("Signup successful with valid details");
    }

    @When("User fills only email and username fields")
    public void userFillsOnlyEmailAndUsernameFields() {
        test.info("Enter username and password: ");
        signUpPage.enterEmailAddress(timestampData.getEmail());
        signUpPage.enterUsername(timestampData.getUsername());
        test.pass("Data Filled successfully");
    }

    @Then("appropriate error message should be displayed for required fields")
    public void appropriateErrorMessageShouldBeDisplayedForRequiredFields() {
        test.info("Verify appropriate error message: ");
        signUpPage.verifyErrorMessage();
        test.pass("Error displayed successful");
    }

    @When("User fills the form with invalid email format")
    public void userFillsTheFormWithInvalidEmailFormat() {
        SignupData invalidData = Hooks.signupDataWrapper.getSignupWithInvalidData();
        SignupData validData = Hooks.signupDataWrapper.getSignupWithValidData();
        test.info("Enter Invalid email id for Signup");
        signUpPage.enterEmailAddress(invalidData.getEmail());
        signUpPage.enterUsername(timestampData.getUsername());
        signUpPage.fillSignUpFormWithValidData(validData);
        test.pass("Details filled successful for Signup page");
    }

    @Then("error message for invalid email should be shown")
    public void errorMessageForInvalidEmailShouldBeShown() {
        test.info("Verify appropriate error message for Invalid email id: ");
        signUpPage.verifyInvalidEmailIdErrorMessage();
        test.pass("Error displayed successful");
    }

    @When("User fills the form with mismatched password and confirm password")
    public void userFillsTheFormWithMismatchedPasswordAndConfirmPassword() {
        SignupData data = Hooks.signupDataWrapper.getSignupWithValidData();
        test.info("Enter valid details for Signup");
        signUpPage.enterEmailAddress(timestampData.getEmail());
        signUpPage.enterUsername(timestampData.getUsername());
        signUpPage.fillSignUpFormWithValidData(data);
        signUpPage.enterConfirmPassword(timestampData.getConfirmPassword());
        test.pass("Details filled successful for Signup page");
    }

    @Then("error message for password mismatch should be shown")
    public void errorMessageForPasswordMismatchShouldBeShown() {
        test.info("Verify appropriate error message for password mismatch ");
        signUpPage.verifyMismatchedPasswordErrorMessage();
        test.pass("Error displayed successful");
    }

    @When("User fills the form with weak password")
    public void userFillsTheFormWithWeakPassword() {
        SignupData validData = Hooks.signupDataWrapper.getSignupWithValidData();
        test.info("Enter valid details for Signup");
        signUpPage.enterEmailAddress(timestampData.getEmail());
        signUpPage.enterUsername(timestampData.getUsername());
        signUpPage.enterInvalidPassword();
        test.pass("Details filled successful for Signup page");
    }

    @Then("error message for weak password should be shown")
    public void errorMessageForWeakPasswordShouldBeShown() {
        test.info("Verify appropriate error message for weak password ");
        signUpPage.verifyWeakPasswordErrorMessage();
        test.pass("Error displayed successful");
    }

    @When("User fills the form with already registered email")
    public void userFillsTheFormWithAlreadyRegisteredEmail() {
        SignupData data = Hooks.signupDataWrapper.getSignupWithValidData();
        test.info("Enter valid details for Signup");
        signUpPage.enterEmailAddress(data.getEmail());
        signUpPage.enterUsername(timestampData.getUsername());
        signUpPage.fillSignUpFormWithValidData(data);
        test.pass("Details filled successful for Signup page");
    }

    @Then("error message for duplicate email should be shown")
    public void errorMessageForDuplicateEmailShouldBeShown() {
        test.info("Verify appropriate error message for duplicate email ");
        signUpPage.verifyEmailIsAlreadyRegisteredErrorMessage();
        test.pass("Error displayed successful");
    }

    @Then("user should be prompted to accept terms and conditions")
    public void userShouldBePromptedToAcceptTermsAndConditions() {
        test.info("Verify appropriate error message for accept terms and conditions ");
        signUpPage.verifyTermAndConditionErrorMessage();
        test.pass("Error displayed successful");
    }

    @Then("appropriate error message should be displayed for all required fields")
    public void appropriateErrorMessageShouldBeDisplayedForAllRequiredFields() {
        test.info("Verify appropriate error messages for all required field: ");
        signUpPage.verifyEmailAndUsernameErrorMessage();
        signUpPage.verifyErrorMessage();
        test.pass("Error displayed successful");
    }
}
