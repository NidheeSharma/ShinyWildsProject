package Pages;

import Utils.ConfigManager;
import Utils.TimestampDataGenerator;
import hooks.Hooks;
import model.SignupData;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class SignUpPage {


    WebDriver driver;
    WebDriverWait wait;
    String site;

    SignupData timestampData = TimestampDataGenerator.generateValidSignupData();


    @FindBy(css = "a[class='signup-btn btn-hover-effect']")
    WebElement signUpButton;

    @FindBy(css = "span[class='signup-title']")
    WebElement signUpTitle;

    @FindBy(css = "button[class='close-button-login-signup']")
    WebElement closeSignUp;

    @FindBy(css = "label[for='email']")
    WebElement emailAddressLabel;

    @FindBy(css = "input[id='email']")
    WebElement emailAddress;

    @FindBy(css = "input[id='username']")
    WebElement username;

    @FindBy(css = "input[id='password']")
    WebElement password;

    @FindBy(css = "input[id='confirmPassword']")
    WebElement confirmPassword;

    @FindBy(css = "input[id='firstName']")
    WebElement firstname;

    @FindBy(css = "input[id='lastName']")
    WebElement lastname;

    @FindBy(xpath = "(//button[@class='custom-select-box-container'])[1]")
    WebElement day;

    @FindBy(xpath = "//div[@class='dropdown-menu show']/div[@class='scrollDropdown']/a[text()='2']")
    WebElement secondOption;

    @FindBy(xpath = "(//button[@class='custom-select-box-container'])[2]")
    WebElement month;

    @FindBy(xpath = "//div[@class='dropdown-menu show']/div[@class='scrollDropdown']/a[text()='4']")
    WebElement fourthOption;

    @FindBy(xpath = "(//button[@class='custom-select-box-container'])[3]")
    WebElement year;

    @FindBy(xpath = "//div[@class='dropdown-menu show']/div[@class='scrollDropdown']/a[text()='2006']")
    WebElement sixthOptionForYear;

    @FindBy(css = "input[id='address']")
    WebElement address;

    @FindBy(css = "div[class='selected-flag']")
    WebElement phoneNumberSelector;

    @FindBy(css = "input[class='search-box']")
    WebElement searchBox;

    @FindBy(xpath = "//li[@data-country-code='au']/span[@class='country-name']")
    WebElement australiaPhoneNumberCountry;

    @FindBy(css = "input[class='form-control phoneInputClass']")
    WebElement phoneNumber;

    @FindBy(css = "input[id='city']")
    WebElement city;

    @FindBy(css = "input[id='zipCode']")
    WebElement postCode;

    @FindBy(css = "div[id='countryCode']")
    WebElement country;

    @FindBy(xpath = "//a[contains(text(), 'Australia')]")
    WebElement australiaCountry;

    @FindBy(css = "div[id='currencyCode']")
    WebElement currency;

    @FindBy(xpath = "//div[@class='dropdown-menu show']//a[contains(text(),'CAD')]")
    WebElement cadCurrency;

    @FindBy(css = "div[id='preferredLanguage']")
    WebElement prefeeredLanguage;

    @FindBy(xpath = "//div[@class='dropdown-menu show']//a[@class='dropdown-item'][5]")
    WebElement frenchLanguage;

    @FindBy(css = "span[class='circle-check']")
    WebElement termsAndCondition;

    @FindBy(css = "button[type='submit']")
    WebElement createAnAccountButton;

    @FindBy(xpath = "//div[@class='Toastify__toast-body']/div//span[2]")
    WebElement successMessage;

    @FindBy(css = "span:nth-of-type(2)")
    WebElement signUpPleaseCheckTheRequestDataErrorMessage;

    @FindBy(xpath = "//div[@class='signup-form-detail'][1]/div[@class='custom-form-group'][1]//div[@class='error-message']")
    WebElement invalidEmail;

    @FindBy(css = "div[class='signup-form-detail']:nth-of-type(1)>div[class='custom-form-group']:nth-of-type(2) div[class='error-message']")
    WebElement usernameRequired;

    @FindBy(css = "div[class='position-relative']:nth-of-type(2) div[class='error-message']")
    WebElement passwordIsRequired;

    @FindBy(css = "div[class='custom-form-group icon_include password-info']:nth-of-type(4) div[class='error-message']")
    WebElement confirmPasswordRequired;

    @FindBy(css = "div[class='signup-form-detail']:nth-of-type(2)>div[class='custom-form-group']:nth-of-type(1) div[class='error-message']")
    WebElement firstNameRequired;

    @FindBy(css = "div[class='signup-form-detail']:nth-of-type(2)>div[class='custom-form-group']:nth-of-type(2) div[class='error-message']")
    WebElement lastNameRequired;

    @FindBy(css = "div[class='custom-form-group']:nth-of-type(4) div[class='error-message']")
    WebElement addressRequired;

    @FindBy(css = "div[class='sign-error-container']:nth-of-type(2) > div[class='error-message']")
    WebElement phoneNumberRequired;

    @FindBy(css = "div[class='custom-form-group']:nth-of-type(6) div[class='error-message']")
    WebElement cityRequired;

    @FindBy(css = "div[class='custom-form-group']:nth-of-type(7) div[class='error-message']")
    WebElement postCodeRequired;

    @FindBy(xpath = "//span[contains(text(), 'Please accept Terms and Condition before moving to the next step')]")
    WebElement termAndConditionErrorMessage;

    @FindBy(css = "label[for='male'] > span[class='checkmark']")
    WebElement man;

    @FindBy(css = "div[class='custom-form-group']:nth-of-type(11) div[class='error-message']")
    WebElement genderRequired;


    public SignUpPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver,this);
        site = ConfigManager.getSite();

    }

    public void clickOnSignUpButton(){
        wait.until(ExpectedConditions.elementToBeClickable(signUpButton));
        signUpButton.click();
    }

    public void enterEmailAddress(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailAddress));
        wait.until(ExpectedConditions.elementToBeClickable(emailAddress));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", emailAddress);
        emailAddress.clear();

        // Small pause if dynamic JS is interfering
        try {
            Thread.sleep(1500); // optional, but helps in flaky apps
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        emailAddress.sendKeys(email);

        // Final check
        String value = emailAddress.getAttribute("value");
        System.out.println("Email entered: " + value);
        if (!value.equals(email)) {
            System.out.println("Email input did not persist. Retrying...");
            emailAddress.clear();
            emailAddress.sendKeys(email);
        }
    }


    public void enterUsername(String UserName){
        wait.until(ExpectedConditions.visibilityOf(username));
        wait.until(ExpectedConditions.elementToBeClickable(username));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", username);
        username.clear();

        // Small pause if dynamic JS is interfering
        try {
            Thread.sleep(500); // optional, but helps in flaky apps
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        username.sendKeys(UserName);

        // Final check
        String value = username.getAttribute("value");
        if (!value.equals(UserName)) {
            username.clear();
            username.sendKeys(UserName);
        }
    }

    public void enterPassword(String Password){
        wait.until(ExpectedConditions.visibilityOf(password));
        wait.until(ExpectedConditions.elementToBeClickable(password));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", password);
        password.clear();

        // Small pause if dynamic JS is interfering
        try {
            Thread.sleep(500); // optional, but helps in flaky apps
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        password.sendKeys(Password);

        // Optional: validate field was filled
        String value = password.getAttribute("value");

        // Final check
        if (!value.equals(Password)) {
            password.clear();
            password.sendKeys(Password);
        }
    }

    public void enterConfirmPassword(String ConfirmPassword){
        wait.until(ExpectedConditions.visibilityOf(confirmPassword));
        wait.until(ExpectedConditions.elementToBeClickable(confirmPassword));
        confirmPassword.sendKeys(ConfirmPassword);
    }

    public void enterFirstName(String Firstname){
        wait.until(ExpectedConditions.visibilityOf(firstname));
        wait.until(ExpectedConditions.elementToBeClickable(firstname));
        firstname.sendKeys(Firstname);
    }

    public void enterLastName(String Lastname){
        wait.until(ExpectedConditions.visibilityOf(lastname));
        wait.until(ExpectedConditions.elementToBeClickable(lastname));
        lastname.sendKeys(Lastname);
    }

    public void enterAddress(String Address){
        wait.until(ExpectedConditions.visibilityOf(address));
        wait.until(ExpectedConditions.elementToBeClickable(address));
        address.sendKeys(Address);
    }

    public void selectPhoneNumberCountry(){
        wait.until(ExpectedConditions.visibilityOf(phoneNumberSelector));
        phoneNumberSelector.click();
        searchBox.click();
        searchBox.sendKeys("Australia");
        australiaPhoneNumberCountry.click();

    }
    public void enterPhoneNumber(String PhoneNumber){
        wait.until(ExpectedConditions.visibilityOf(phoneNumber));
        phoneNumber.click();
        phoneNumber.sendKeys(PhoneNumber);
        System.out.println(phoneNumber);
    }

    public void enterCity(String City){
        wait.until(ExpectedConditions.visibilityOf(city));
        city.sendKeys(City);
    }

    public void enterPostCode(String PostCode){
        wait.until(ExpectedConditions.visibilityOf(postCode));
        postCode.sendKeys(PostCode);
    }
    public void clickOnConfirmTermAndCondition(){
        wait.until(ExpectedConditions.elementToBeClickable(termsAndCondition));
        termsAndCondition.click();
    }

    public void clickOnCreateAnAccountButton(){
        wait.until(ExpectedConditions.elementToBeClickable(createAnAccountButton));
        createAnAccountButton.click();
    }

    public void fillSignUpFormWithValidData(SignupData data){
        enterPassword(data.getPassword());
        enterConfirmPassword(data.getConfirmPassword());
        enterFirstName(data.getFirstName());
        enterLastName(data.getLastName());
        day.click();
        wait.until(ExpectedConditions.elementToBeClickable(secondOption));
        secondOption.click();
        month.click();
        wait.until(ExpectedConditions.elementToBeClickable(fourthOption));
        fourthOption.click();
        year.click();
        wait.until(ExpectedConditions.elementToBeClickable(sixthOptionForYear));
        sixthOptionForYear.click();
        enterAddress(data.getAddress());
        selectPhoneNumberCountry();
        enterPhoneNumber(timestampData.getPhoneNumber());
        enterCity(data.getCity());
        enterPostCode(data.getPostCode());
        country.click();
        wait.until(ExpectedConditions.elementToBeClickable(australiaCountry));
        australiaCountry.click();
        currency.click();
        wait.until(ExpectedConditions.elementToBeClickable(cadCurrency));
        cadCurrency.click();
        if (!driver.findElements(By.cssSelector("div[id='preferredLanguage']")).isEmpty()) {
            WebElement preferredLang = driver.findElement(org.openqa.selenium.By.cssSelector("div[id='preferredLanguage']"));
            preferredLang.click();
            wait.until(ExpectedConditions.elementToBeClickable(frenchLanguage));
            frenchLanguage.click();
        } else {
            System.out.println("Preferred language field is not present for this site");
        }
        //man.click();

    }

    public void enterInvalidPassword(){
        SignupData invalidData = Hooks.signupDataWrapper.getSignupWithInvalidData();
        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys(invalidData.getPassword());
        wait.until(ExpectedConditions.visibilityOf(confirmPassword));
        confirmPassword.sendKeys(invalidData.getConfirmPassword());
    }

    public void verifySignupSuccessfulMessage(){
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        successMessage.isDisplayed();
        Assert.assertEquals(successMessage.getText(),"Sign Up Successful");
    }

    public void verifyInvalidEmailIdErrorMessage(){
        wait.until(ExpectedConditions.visibilityOf(invalidEmail));
        invalidEmail.isDisplayed();
        Assert.assertEquals(invalidEmail.getText(),"InvalidEmail");
    }

    public void verifyMismatchedPasswordErrorMessage(){
        wait.until(ExpectedConditions.visibilityOf(confirmPasswordRequired));
        confirmPasswordRequired.isDisplayed();
        Assert.assertEquals(confirmPasswordRequired.getText(),"Password must match");
    }

    public void verifyWeakPasswordErrorMessage(){
        wait.until(ExpectedConditions.visibilityOf(passwordIsRequired));
        passwordIsRequired.isDisplayed();
        Assert.assertEquals(passwordIsRequired.getText(),"Password must be at least 8 characters long");
    }

    public void verifyEmailIsAlreadyRegisteredErrorMessage(){
        String currentUrl = driver.getCurrentUrl();
        if(currentUrl.contains("shinywilds")){
            wait.until(ExpectedConditions.visibilityOf(invalidEmail));
            Assert.assertEquals(invalidEmail.getText(), "This email is already registered");
        }else {
            wait.until(ExpectedConditions.visibilityOf(successMessage));
            Assert.assertEquals(successMessage.getText(), "Duplicate account detected");
        }
    }

    public void verifyTermAndConditionErrorMessage(){
        wait.until(ExpectedConditions.visibilityOf(termAndConditionErrorMessage));
        termAndConditionErrorMessage.isDisplayed();
        Assert.assertEquals(termAndConditionErrorMessage.getText(),"Please accept Terms and Condition before moving to the next step");
    }

    public void verifyErrorMessage(){
        Map<WebElement,String> expectedErrors = new HashMap<>();
        expectedErrors.put(passwordIsRequired,"Password is required");
        expectedErrors.put(confirmPasswordRequired,"Confirm Password Required");
        expectedErrors.put(firstNameRequired,"First Name Required");
        expectedErrors.put(lastNameRequired,"Last Name Required");
        expectedErrors.put(addressRequired,"Address Required");
        expectedErrors.put(phoneNumberRequired,"Phone Required");
        expectedErrors.put(cityRequired,"City Required");
        expectedErrors.put(postCodeRequired,"Post Code Required");
        //expectedErrors.put(genderRequired,"Gender Required");

        for(Map.Entry<WebElement, String> entry: expectedErrors.entrySet()){
            WebElement errorElement = entry.getKey();
            String expectedMessage = entry.getValue();

            Assert.assertTrue(errorElement.isDisplayed(),"Error not displayed for field.");
            Assert.assertEquals(errorElement.getText(),expectedMessage,"Mismatch in error message.");
        }
    }

    public void verifyEmailAndUsernameErrorMessage(){
        Map<WebElement,String> expectedErrors = new HashMap<>();
        expectedErrors.put(invalidEmail,"Email Required");
        expectedErrors.put(usernameRequired,"UserName Required");

        for(Map.Entry<WebElement, String> entry: expectedErrors.entrySet()){
            WebElement errorElement = entry.getKey();
            String expectedMessage = entry.getValue();

            Assert.assertTrue(errorElement.isDisplayed(),"Error not displayed for field.");
            Assert.assertEquals(errorElement.getText(),expectedMessage,"Mismatch in error message.");
        }
    }

}
