package Pages;

import Utils.ConfigManager;
import Utils.ElementActions;
import Utils.JsonReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    String site, loginValidation;

@FindBy(css = "input[id='email']")
WebElement enterUserName;

@FindBy(css = "input[id='password']")
WebElement enterPassword;

@FindBy(css = "button[class='btn-hover-effect btn-secondary-hover-shadow']")
WebElement loginButton;

@FindBy(css = "button[class='cookie-consent success-button']")
WebElement acceptCookie;

@FindBy(css = "a[class='login-btn btn-hover-effect']")
WebElement loginButtonOnHomePage;

@FindBy(xpath = "//span[@class='toast-title']/following-sibling::span")
WebElement errorMassage;

@FindBy(css = "div[class='custom-form-group'] div[class='error-message']")
WebElement usernameRequired;

@FindBy(css = "div[class='position-relative'] div[class='error-message']")
WebElement passwordRequired;

@FindBy(css = "div[class='dont-have-ac'] > a")
WebElement signUp;

@FindBy(css = "a[class='forget-link']")
WebElement forgotPassword;

@FindBy(css = "img[alt='close-eye']")
WebElement showPassword;

@FindBy(css = "img[class='show-icon']")
WebElement hidePassword;

@FindBy(css = "button[class='dropdown-toggle']")
WebElement languageDropdown;

@FindBy(css = "a[class='dropdown-item user']:nth-of-type(3)")
WebElement german;

@FindBy(css = "button[class='btn btn-secondary dropdown-toggle']")
WebElement dropDownMenuButton;

@FindBy(xpath = "//a[@class='dropdown-item user'][9]")
WebElement logout;

@FindBy(xpath = "//span[@class='toast-title']")
WebElement successMessage;


    public LoginPage(WebDriver driver){
    this.driver = driver;
    PageFactory.initElements(driver,this);
    wait = new WebDriverWait(driver,Duration.ofSeconds(30));
    site = ConfigManager.getSite();
    loginValidation = ConfigManager.getValidationMessage();
}

    public void clickOnAccept(){
    if (acceptCookie.isDisplayed()){
       wait.until(ExpectedConditions.visibilityOf(acceptCookie));
       wait.until(ExpectedConditions.elementToBeClickable(acceptCookie));
       ElementActions.clickWithRetry(acceptCookie);
       //acceptCookie.click();
    }else {
      System.out.println("Accept cookie is not present");}
    }


    public void clickOnLoginButtonOnHomePage(){
    clickOnAccept();
    wait.until(ExpectedConditions.elementToBeClickable(loginButtonOnHomePage));
    loginButtonOnHomePage.click(); }

    public void setEnterUserName(String userName){
    wait.until(ExpectedConditions.visibilityOf(enterUserName));
    wait.until(ExpectedConditions.elementToBeClickable(enterUserName));
    enterUserName.sendKeys(userName);
    }

    public void setEnterPassword(String password){
    wait.until(ExpectedConditions.visibilityOf(enterUserName));
    wait.until(ExpectedConditions.elementToBeClickable(enterPassword));
    enterPassword.sendKeys(password);
    }
    public void clickOnLoginButton(){
    wait.until(ExpectedConditions.elementToBeClickable(loginButton));
    loginButton.isDisplayed();
    loginButton.click();
    }
    public  void enterUsernameAndPassword(String username, String password){
        setEnterUserName(username);
        setEnterPassword(password);
    }

    public void verifyLoginIsSuccessful(){
        String expectedHomePageURL = JsonReader.getValueFromConfig(site,"expectedHomePageUrl","src/test/TestData/urlConfig.json");
        Assert.assertEquals(expectedHomePageURL,driver.getCurrentUrl(),"User is not log In");
    }

    public void verifyInvalidUsernameAndPasswordErrorMassage(){
        String expectedInvalidUsernameAndPasswordErrorMsg = JsonReader.getValueFromConfig(loginValidation,"expectedInvalidUsernameAndPasswordErrorMsg","src/test/TestData/messageValidation.json");
        wait.until(ExpectedConditions.visibilityOf(errorMassage));
        Assert.assertEquals(errorMassage.getText(),expectedInvalidUsernameAndPasswordErrorMsg);
    }

    public void verifyRequiredUsernameError(){
        String expectedUsernameRequiredMsg = JsonReader.getValueFromConfig(loginValidation,"expectedUsernameRequiredMsg","src/test/TestData/messageValidation.json");
        Assert.assertEquals(usernameRequired.getText(),expectedUsernameRequiredMsg);
    }

    public void verifyPasswordUsernameError(){
        String expectedPasswordRequiredMsg = JsonReader.getValueFromConfig(loginValidation,"expectedPasswordRequiredMsg","src/test/TestData/messageValidation.json");
        Assert.assertEquals(passwordRequired.getText(),expectedPasswordRequiredMsg);
    }

    public void clickOnSignUp(){
        signUp.click();
    }

    public void verifySignUpPage(){
        String expectedSignUpPageUrl = JsonReader.getValueFromConfig(site,"expectedSignUpPageUrl","src/test/TestData/urlConfig.json");
        Assert.assertEquals(driver.getCurrentUrl(),expectedSignUpPageUrl);
    }

    public void verifyPasswordIsMasked() {
        wait.until(ExpectedConditions.visibilityOf(enterPassword));
        String type = enterPassword.getDomAttribute("type");
        Assert.assertEquals(type, "password", "Password is not masked.");
    }

    public void clickOnShowPasswordIcon() {
        wait.until(ExpectedConditions.visibilityOf(showPassword));
        wait.until(ExpectedConditions.elementToBeClickable(showPassword));
        showPassword.click();
    }

    public void verifyPasswordIsVisible() {
        wait.until(ExpectedConditions.visibilityOf(enterPassword));
        String type = enterPassword.getDomAttribute("type");
        Assert.assertEquals(type, "text", "Password is not visible in plain text.");
    }

    public void clickOnForgotPassword() {
        forgotPassword.click();
    }

    public void verifyForgotPassword(){
        String expectedForgotPasswordPageUrl = JsonReader.getValueFromConfig(site,"expectedForgotPasswordPageUrl","src/test/TestData/urlConfig.json");
        Assert.assertEquals(driver.getCurrentUrl(),expectedForgotPasswordPageUrl);
    }

    public void clickOnLanguageDropdown() {
        languageDropdown.click();
        german.click();
    }

    public void verifyLanguageDropdown(){
        String expectedGermanLoggedInUrl = JsonReader.getValueFromConfig(site,"expectedGermanLoggedInUrl","src/test/TestData/urlConfig.json");
        Assert.assertEquals(driver.getCurrentUrl(),expectedGermanLoggedInUrl);
    }

    public void clickOnLogoutButton() {
        wait.until(ExpectedConditions.visibilityOf(dropDownMenuButton));
        dropDownMenuButton.click();
        wait.until(ExpectedConditions.visibilityOf(logout));
        logout.click();
    }

    public void verifyLogoutSuccessMessage(){
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        successMessage.isDisplayed();
    }

}

