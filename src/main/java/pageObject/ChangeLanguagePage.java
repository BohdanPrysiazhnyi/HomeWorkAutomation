package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ChangeLanguagePage extends BasePage{
    public ChangeLanguagePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='a-label a-radio-label']")
    private List<WebElement> listOfLanguages;

    @FindBy(xpath = "//input[@class='a-button-input']")
    private WebElement confirmButton;
    @FindBy(xpath = "//a[contains(text(),'Ofertas del Día')]")
    private WebElement verifyLanguage;


    public void clickOnFirstRadioButtonInChangeLanguageList(){
        listOfLanguages.get(1).click();
    }

    public void clickOnConfirmChangesButton(){
        confirmButton.click();
    }

    public String verifyLanguageThT(){
        return verifyLanguage.getText();
    }

}
