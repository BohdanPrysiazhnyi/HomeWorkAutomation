package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private WebElement addToCart;

    @FindBy(xpath = "//div[@id='nav-cart-count-container']")
    private WebElement cartIcon;

    @FindBy(id = "nav-cart-count")
    private WebElement cartIconDisplayedCountOfAddedItems;


    public void clickOnAddTocartButton() {
        addToCart.click();
    }

    public void clickOnCartIcon() {
        cartIcon.click();
    }

    public String actualProductsCountInCart() {
        WebElement count = driver.findElement(By.id("nav-cart-count"));
        return count.getText();
    }

    public void refresh() {
        driver.navigate().refresh();
    }
}
