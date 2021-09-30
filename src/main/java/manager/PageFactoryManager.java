package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageObject.*;

public class PageFactoryManager {
    WebDriver driver;


    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }
    public SearchResultPage getSearchResultPage (){return new SearchResultPage(driver);}
    public ProductPage getProductPage (){return new ProductPage(driver);}
    public CartPage getCartPage(){return new CartPage(driver);}
    public SignInPage getSignInPage(){return new SignInPage(driver);}
    public ChangeLanguagePage getChangeLanguagePage(){return new ChangeLanguagePage(driver);}

}
