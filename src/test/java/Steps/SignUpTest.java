package Steps;

import CommonFile.BasePage;
import Pages.LoginPage;
import Pages.SignUpPage;
import Utils.FakerDataGenerator;
import Utils.JsonReader;
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
    LoginPage loginPage = new LoginPage(BasePage.driver);


    @Given("Navigate to the Sign Up page")
    public void navigateToTheSignUpPage() {
        try {
            loginPage.clickOnAccept();
            test.info("Navigating to Signup page");
            signUpPage.clickOnSignUpButton();
            test.pass("Navigation to Signup page successfully");
        } catch (Exception e){
            test.fail("Failed to Navigate to Signup page" + e.getMessage());
            test.fail(e);
        }
    }

    @When("User fill the Sign Up form with valid details")
    public void userFillTheSignUpFormWithValidDetails() {
        try {
            //SignupData fakeData = FakerDataGenerator.generateValidSignupData();
            //SignupData data = JsonReader.getObjectFromJson("src/test/resource/signupData.json", SignupData.class);
            SignupData data = Hooks.signupDataWrapper.getSignupWithValidData();
            test.info("Enter valid details for Signup");
            signUpPage.enterEmailAddress(timestampData.getEmail());
            signUpPage.enterUsername(timestampData.getUsername());
            signUpPage.fillSignUpFormWithValidData(data);
            test.pass("Details filled successful for Signup page");
        }catch (Exception e){
            test.fail("Failed to fill valid data for Signup" + e.getMessage());
            test.fail(e);
        }

    }

    @And("agree to the terms and conditions")
    public void agreeToTheTermsAndConditions() {
        try {
            test.info("Accept terms and conditions for successful signup");
            signUpPage.clickOnConfirmTermAndCondition();
            test.pass("Successfully accept the terms and conditions for signup");
        }catch (Exception e){
            test.fail("Failed to accept the terms and conditions for Signup" + e.getMessage());
            test.fail(e);
        }
    }

    @And("user submit the SignUp form")
    public void userSubmitTheSignUpForm() {
        try {
            test.info("Submit the details for successful signup");
            signUpPage.clickOnCreateAnAccountButton();
            test.pass("Successfully submitted all the details for signup");
        }catch (Exception e){
            test.fail("Failed to submit all the details for signup" + e.getMessage());
            test.fail(e);
        }
    }

    @Then("account should be created successfully")
    public void accountShouldBeCreatedSuccessfully() {
        try {
            test.info("Signup message should display");
            signUpPage.verifySignupSuccessfulMessage();
            test.pass("Signup successful with valid details");
        }catch (Exception e){
            test.fail("Failed Signup with valid data");
            test.fail(e);
        }
    }


    @When("User fills only email and username fields")
    public void userFillsOnlyEmailAndUsernameFields() {
        try {
            test.info("Enter username and password: ");
            signUpPage.fillSignUpWithUsernameAndPassword(timestampData);
            test.pass("Data Filled successfully");
        }catch (Exception e){
            test.fail("Failed to fill username and email");
            test.fail(e);
        }
    }

    @Then("appropriate error message should be displayed for required fields")
    public void appropriateErrorMessageShouldBeDisplayedForRequiredFields() {
        try {
            test.info("Verify appropriate error message: ");
            signUpPage.verifyErrorMessage();
            test.pass("Error displayed successful");
        }catch (Exception e){
            test.fail("Failed to display error message");
            test.fail(e);
        }
    }

    @When("User fills the form with invalid email format")
    public void userFillsTheFormWithInvalidEmailFormat() {
        
    }

    @Then("error message for invalid email should be shown")
    public void errorMessageForInvalidEmailShouldBeShown() {

    }

    @When("User fills the form with mismatched password and confirm password")
    public void userFillsTheFormWithMismatchedPasswordAndConfirmPassword() {
        
    }

    @Then("error message for password mismatch should be shown")
    public void errorMessageForPasswordMismatchShouldBeShown() {
        
    }

    @When("User fills the form with weak password")
    public void userFillsTheFormWithWeakPassword() {
        
    }

    @Then("error message for weak password should be shown")
    public void errorMessageForWeakPasswordShouldBeShown() {
        
    }

    @When("User fills the form with already registered email")
    public void userFillsTheFormWithAlreadyRegisteredEmail() {
        
    }

    @Then("error message for duplicate email should be shown")
    public void errorMessageForDuplicateEmailShouldBeShown() {
        
    }

    @When("User fills the form with invalid phone number")
    public void userFillsTheFormWithInvalidPhoneNumber() {
        
    }

    @Then("error message for invalid phone number should be shown")
    public void errorMessageForInvalidPhoneNumberShouldBeShown() {

    }

    @When("User fills the form with invalid postal code")
    public void userFillsTheFormWithInvalidPostalCode() {
        
    }

    @Then("error message for invalid postal code should be shown")
    public void errorMessageForInvalidPostalCodeShouldBeShown() {
        
    }

    @Then("user should be prompted to accept terms and conditions")
    public void userShouldBePromptedToAcceptTermsAndConditions() {
        
    }

    @Then("appropriate error message should be displayed for all required fields")
    public void appropriateErrorMessageShouldBeDisplayedForAllRequiredFields() {
    }
}
