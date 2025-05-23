package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

@FindBy(css = "input[id='email']")
WebElement enterUserName;

@FindBy(css = "input[id='password']")
WebElement enterPassword;

@FindBy(xpath = "//button[text()='Log In']")
WebElement loginButton;

@FindBy(css = "button[class='cookie-consent success-button']")
WebElement acceptCookie;

@FindBy(css = "a[class='login-btn btn-hover-effect']")
WebElement loginButtonOnHomePage;


public LoginPage(WebDriver driver){
    this.driver = driver;
    PageFactory.initElements(driver,this);
    wait = new WebDriverWait(driver,Duration.ofSeconds(10));

}

     public void clickOnAccept(){
    wait.until(ExpectedConditions.elementToBeClickable(acceptCookie));
    acceptCookie.click(); }

    public void clickOnLoginButtonOnHomePage(){
        clickOnAccept();
        wait.until(ExpectedConditions.elementToBeClickable(loginButtonOnHomePage));
        loginButtonOnHomePage.click(); }

    public void setEnterUserName(String userName){
    wait.until(ExpectedConditions.elementToBeClickable(enterUserName));
    enterUserName.sendKeys(userName);
    }

    public void setEnterPassword(String password){
    wait.until(ExpectedConditions.elementToBeClickable(enterPassword));
    enterPassword.sendKeys(password);
    }
    public void clickOnLoginButton(){
    wait.until(ExpectedConditions.elementToBeClickable(loginButton));
    loginButton.isDisplayed();
    loginButton.click();
    }
    public  void login(String username, String password){
    //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6000));
    setEnterUserName(username);
    setEnterPassword(password);
    }

    public void verifyLoginIsSuccessfull(){
    String currentURL = "https://www.shinywilds5.com/en/";
    Assert.assertEquals(currentURL,driver.getCurrentUrl());
    System.out.println("Logged in successfully");
    }

}

