package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.XMLFormatter;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@aria-label='Search']")
    private WebElement searchField;

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    private WebElement searchButtons;

    @FindBy(xpath = "//a[@id='nav-link-accountList']")
    private WebElement accountList;

    @FindBy(xpath = "//a[@id='icp-nav-flyout']")
    private WebElement changeLanguageIcon;



    public void openHomePage(String url) {
        driver.get(url);
    }

    public void inputTextInSearchField(String searchWord) {
        searchField.clear();
        searchField.sendKeys(searchWord);
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }

    public void clickOnAccountList(){
        accountList.click();
    }
    public void clickOnChangeLanguageIcon(){
        changeLanguageIcon.click();
    }


}
