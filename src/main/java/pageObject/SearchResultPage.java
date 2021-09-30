package pageObject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage {
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//div[@class='a-section aok-relative s-image-fixed-height']")
    private List<WebElement> searchResultItems;


    public void refresh() {
        driver.navigate().refresh();
    }

    public void clickOnFirstResultItem() {
        searchResultItems.get(0).click();
    }


}
