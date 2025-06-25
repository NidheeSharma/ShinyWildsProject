package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchGamePage {

    WebDriver driver;
    WebDriverWait wait;

    public SearchGamePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @FindBy(xpath = "//span[contains(@class,'loggedin-search-icon ml-')]")
    WebElement searchIconOnHomePage;

    @FindBy(css = "button[class='close-btn modal-close btn btn-danger']")
    WebElement closeButtonOnSearchModel;

    @FindBy(css = "div[class='modal-title']")
    WebElement titleOnSearchModel;

    @FindBy(css = "input[class*='search-input']")
    WebElement searchBoxOnSearchModel;

    @FindBy(css = "div[class*='multi-select-dropdow']>div[id*='react-select-']")
    WebElement selectProviderDropdownOnSearchModel;

    @FindBy(css = "div[class='search-game-listing']>div[class*='game-card-v']:nth-of-type(1) div[class*='-game-name']:nth-of-type(2)")
    WebElement gameTitleOnSearchModel;

    @FindBy(css = "div[class='search-game-listing']>div[class*='game-card-v']:nth-of-type(1) div[class*='-area'] span[class*='-game-provider-name']")
    WebElement providerNameOnSearchModel;



}
