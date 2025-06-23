package Pages;

import Utils.ConfigManager;
import Utils.JsonReader;
import hooks.Hooks;
import model.SignupData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MyAccountPage {

    WebDriver driver;
    WebDriverWait wait;

    public MyAccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @FindBy(css = "svg[aria-hidden='true']")
    WebElement successLoginPopupCrossButton;

    @FindBy(css = "[class='Toastify__toast-body'] span:nth-of-type(2)")
    WebElement passwordUpdateSuccessfullyMessage;

    @FindBy(css = "div[class='Toastify__toast-body'] span:nth-of-type(2)")
    WebElement errorMsgWithSamePassword;

    @FindBy(css = "button[id='dropdownMenuButton'] img")
    WebElement dropdownMenuButton;

    @FindBy(css = "a[class='dropdown-item user']:nth-of-type(5)")
    WebElement myAccountLabel;

    @FindBy(css = "h2[class='tab-title']")
    WebElement myAccountHeading;

    @FindBy(css = "button[class='close-btn modal-close filters-selected-false btn btn-danger']")
    WebElement crossButton;

    @FindBy(css = "div[class='username-email'] > p:nth-of-type(1)")
    WebElement loggedInEmailId;

    @FindBy(css = "div[class='username-email'] > p:nth-of-type(2)")
    WebElement loggedInUsername;

    @FindBy(css = "button[data-rr-ui-event-key='private-data']")
    WebElement  privateDataSection;

    @FindBy(css = "input[id='firstName']")
    WebElement firstName;

    @FindBy(css = "input[id='lastName']")
    WebElement lastName;

    @FindBy(css = "input[id='username']")
    WebElement username;

    @FindBy(css = "div[class*='react-tel-input'] > input[disabled]")
    WebElement phoneNumber;

    @FindBy(css = "[class='icon-left pe-none dropdown']:nth-of-type(1) button[class='custom-select-box-container']>div")
    WebElement day;

    @FindBy(css = "[class='icon-left pe-none dropdown']:nth-of-type(2) button[class='custom-select-box-container']>div")
    WebElement month;

    @FindBy(css = "[class='icon-left pe-none dropdown']:nth-of-type(3) button[class='custom-select-box-container']>div")
    WebElement year;

    @FindBy(css = "div[id='preferredLanguage'] button span")
    WebElement preferredLanguage;

    @FindBy(css = "button[data-rr-ui-event-key='address']")
    WebElement addressSection;

    @FindBy(css = "div[id='countryCode'] button span")
    WebElement country;

    @FindBy(css = "input[id='currencyCode']")
    WebElement currency;

    @FindBy(css = "input[id='address']")
    WebElement address;

    @FindBy(css = "input[id='city']")
    WebElement city;

    @FindBy(css = "input[id='zipCode']")
    WebElement postcode;

    @FindBy(css = "button[data-rr-ui-event-key='change-password']")
    WebElement changePasswordSection;

    @FindBy(css = "input[id='password']")
    WebElement password;

    @FindBy(css = "input[id='confirmPassword']")
    WebElement confirmPassword;

    @FindBy(css = "div[class*='submit-btn'] button")
    WebElement saveChanges;

    public void clickOnDropdownMenuButton(){
        try {
            Thread.sleep(3000);
            wait.until(ExpectedConditions.visibilityOf(successLoginPopupCrossButton));
            wait.until(ExpectedConditions.elementToBeClickable(successLoginPopupCrossButton));
            successLoginPopupCrossButton.click();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        wait.until(ExpectedConditions.visibilityOf(dropdownMenuButton));
        wait.until(ExpectedConditions.elementToBeClickable(dropdownMenuButton));
        dropdownMenuButton.click();
    }

    public void clickOnMyAccountLabel(){
        wait.until(ExpectedConditions.visibilityOf(myAccountLabel));
        wait.until(ExpectedConditions.elementToBeClickable(myAccountLabel));
        myAccountLabel.click();
        wait.until(ExpectedConditions.visibilityOf(myAccountHeading));
        myAccountHeading.isDisplayed();
    }

    public void verifyEmailAndUsername(){
        SignupData data = Hooks.signupDataWrapper.getMyAccountData();

        wait.until(ExpectedConditions.visibilityOf(privateDataSection));
        String actualEmailText = loggedInEmailId.getText();
        String actualEmail = actualEmailText.split(":")[1].trim();
        Assert.assertEquals(actualEmail,data.getEmail(),"Email is mismatched");

        String actualUsernameText = loggedInUsername.getText();
        String actualUsername = actualUsernameText.replace("Username:","").trim();
        Assert.assertEquals(actualUsername,data.getUsername(),"Username is mismatched");
    }

    public void openPrivateDataSection(){
        wait.until(ExpectedConditions.visibilityOf(privateDataSection));
        privateDataSection.isDisplayed();
    }

    public void verifyPrivateData(){
        SignupData data = Hooks.signupDataWrapper.getMyAccountData();
        Assert.assertEquals(firstName.getDomAttribute("value"),data.getFirstName(),"First name is mismatched");
        Assert.assertEquals(lastName.getDomAttribute("value"),data.getLastName(),"Last name is mismatched");
        Assert.assertEquals(username.getDomAttribute("value"),data.getUsername(),"Username is mismatched");
        Assert.assertEquals(phoneNumber.getDomAttribute("value"),data.getPhoneNumber(),"Phone number is mismatched");
        Assert.assertEquals(day.getText(),data.getDay(),"Day is mismatched");
        Assert.assertEquals(month.getText(),data.getMonth(),"Month is mismatched");
        Assert.assertEquals(year.getText(),data.getYear(),"Year is mismatched");
        Assert.assertEquals(preferredLanguage.getText(),data.getPreferredLanguage(),"Preferred Language is mismatched");
    }

    public void clickOnAddressSection(){
        wait.until(ExpectedConditions.visibilityOf(addressSection));
        addressSection.isDisplayed();
        wait.until(ExpectedConditions.elementToBeClickable(addressSection));
        addressSection.click();
    }

    public void verifyAddressData(){
        SignupData data = Hooks.signupDataWrapper.getMyAccountData();
        Assert.assertEquals(country.getText(),data.getCountry(),"Country is mismatched");
        Assert.assertEquals(currency.getDomAttribute("value"),data.getCurrency(),"Currency is mismatched");
        Assert.assertEquals(address.getDomAttribute("value"),data.getAddress(),"Address is mismatched");
        Assert.assertEquals(city.getDomAttribute("value"),data.getCity(),"City is mismatched");
        Assert.assertEquals(postcode.getDomAttribute("value"),data.getPostCode(),"Postcode is mismatched");
    }
    public void clickOnChangePasswordSection(){
        wait.until(ExpectedConditions.visibilityOf(changePasswordSection));
        changePasswordSection.isDisplayed();
        wait.until(ExpectedConditions.elementToBeClickable(changePasswordSection));
        changePasswordSection.click();
    }

    public void enterPassword(){
        SignupData data = Hooks.signupDataWrapper.getMyAccountData();
        wait.until(ExpectedConditions.elementToBeClickable(password));
        password.click();
        password.sendKeys(data.getPassword());
    }

    public void enterConfirmPassword(){
        SignupData data = Hooks.signupDataWrapper.getMyAccountData();
        wait.until(ExpectedConditions.elementToBeClickable(confirmPassword));
        confirmPassword.click();
        confirmPassword.sendKeys(data.getConfirmPassword());
    }

    public void clickOnSaveChanges(){
        wait.until(ExpectedConditions.visibilityOf(saveChanges));
        wait.until(ExpectedConditions.elementToBeClickable(saveChanges));
        saveChanges.click();
    }

    public void reEnterPassword(){
        SignupData data = Hooks.signupDataWrapper.getMyAccountData();
        wait.until(ExpectedConditions.elementToBeClickable(password));
        password.click();
        password.sendKeys(data.getChangePassword());
    }

    public void reEnterConfirmPassword(){
        SignupData data = Hooks.signupDataWrapper.getMyAccountData();
        wait.until(ExpectedConditions.elementToBeClickable(confirmPassword));
        confirmPassword.click();
        confirmPassword.sendKeys(data.getChangePassword());
    }


    public void verifyPasswordUpdateSuccessfully(){
        String accountValidation = ConfigManager.getAccountValidationMessage();
        String successfullyPasswordChangeMsg = JsonReader.getValueFromConfig(accountValidation,"expectedPasswordChangeSuccessfullyMsg","src/test/TestData/messageValidation.json");
        wait.until(ExpectedConditions.visibilityOf(passwordUpdateSuccessfullyMessage));
        String actualMessage = passwordUpdateSuccessfullyMessage.getText();
        Assert.assertEquals(successfullyPasswordChangeMsg,actualMessage,"Password is not changed");
    }

    public void verifyErrorMsgWithSamePassword(){
        String accountValidation = ConfigManager.getAccountValidationMessage();
        String errorMsgWithSamePasswordAsLogin = JsonReader.getValueFromConfig(accountValidation,"expectedErrorMsgWithSamePassword","src/test/TestData/messageValidation.json");
        wait.until(ExpectedConditions.visibilityOf(errorMsgWithSamePassword));
        String actualMessage = errorMsgWithSamePassword.getText();
        Assert.assertEquals(errorMsgWithSamePasswordAsLogin,actualMessage,"Password is not the same");
    }

}
