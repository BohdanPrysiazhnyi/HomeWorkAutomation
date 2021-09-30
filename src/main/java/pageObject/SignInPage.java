package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@id='createAccountSubmit']")
    private WebElement createNewAccountButton;

    @FindBy(xpath = "//input[@id='ap_customer_name']")
    private WebElement custemerNameField;

    @FindBy(xpath = "//input[@id='ap_email']")
    private WebElement customerPhoneNumberOrEmaeilField;

    @FindBy(xpath = "//input[@id='ap_password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='ap_password_check']")
    private WebElement confirmPassword;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//div[contains(text(),'Type your password again')]")
    private WebElement errorMessageApearedNearReEnterPasswordFieldWhenEmpty;

    @FindBy(xpath = "//div[contains(text(), 'Passwords must match')]")
    private WebElement errorMessageApearedNearReEnterPasswordFieldWhenDoesNotMatc;


    public void clickOnCreateNewAccountButton(){
        createNewAccountButton.click();
    }

    public void inputNameInCustomerNameField(String customerName){
        custemerNameField.clear();
        custemerNameField.sendKeys(customerName);
    }

    public void inputEmeilOrPhoneNumberInCustomerPhoneNumberOrEmailField(String emailOrNumber){
        customerPhoneNumberOrEmaeilField.clear();
        customerPhoneNumberOrEmaeilField.sendKeys(emailOrNumber);
    }

    public void inputPasswordInPasswordField(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void inputPasswordInReEnterPasswordField(String reEnter){
        confirmPassword.clear();
        confirmPassword.sendKeys(reEnter);
    }

    public void clickOnContinueButtonOnSignInPage(){
        continueButton.click();
    }
    public String getErrorMessageApearedNearReEnterPasswordField (){
        return errorMessageApearedNearReEnterPasswordFieldWhenEmpty.getText();
    }

    public String getErrorMessageApearedNearReEnterPasswordFieldWhenDoesNotMatch (){
        return errorMessageApearedNearReEnterPasswordFieldWhenDoesNotMatc.getText();
    }
    public WebElement errorMessageDoesNotMatchPassword(){
        return errorMessageApearedNearReEnterPasswordFieldWhenDoesNotMatc;
    }



}
