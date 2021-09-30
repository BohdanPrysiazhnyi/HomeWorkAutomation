package pageObject;

import io.cucumber.java.bs.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//span[@class='a-size-small sc-action-delete']")
    private WebElement deleteItemFromCart;


    @FindBy(xpath = "//div[@class='sc-list-item-content']")
    private WebElement productInShopingCart;


    public WebElement productInShopingCart() {
        return productInShopingCart;
    }


    public void deleteFromCart() {
        deleteItemFromCart.click();
    }


}
