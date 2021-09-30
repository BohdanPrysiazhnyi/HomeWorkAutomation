package definitionSteps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import manager.PageFactoryManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.*;

import static context.RunContext.RUN_CONTEXT;
import static io.github.bonigarcia.wdm.WebDriverManager.getInstance;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class MyStepsDefinition {
    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    HomePage homePage;
    PageFactoryManager pageFactoryManager;
    SearchResultPage searchResultPage;
    ProductPage productPage;
    CartPage cartPage;
    SignInPage signInPage;
    ChangeLanguagePage changeLanguagePage;


    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @Given("User open {string} page")
    public void userOpenHttpsWwwEbayComPage(final String homepage) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(homepage);
    }

    @When("User makes search by keyword {string}")
    public void userMakesSearchByKeywordSearchWord(String searchWord) {
        homePage.waitForPageLoadComplete(90);
        homePage.inputTextInSearchField(searchWord);
        homePage.clickOnSearchButton();
    }

    @And("User makes choose first product")
    public void userMakesChooseFirstProduct() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.refresh();
        searchResultPage.clickOnFirstResultItem();
    }

    @And("User click on add to cart button")
    public void userClickOnAddToCartButton() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(90);
//        productPage.waitForAjaxToComplete(90);
        productPage.clickOnAddTocartButton();
    }

    @And("User click on cart icon")
    public void userClickOnCartIcon() {
        productPage.refresh();
        productPage.waitForPageLoadComplete(30);
        productPage.clickOnCartIcon();

    }


    @After
    public void tearDown() {
        driver.close();
    }


    @Then("User checks that product is added to cart equals{string}")
    public void userChecksThatProductIsAddedToCartEquals(String countOfItems) {
        productPage.waitForPageLoadComplete(90);
        assertEquals(productPage.actualProductsCountInCart(), countOfItems);
    }

    @When("User delete item from cart")
    public void userDeleteItemFromCart() {
        cartPage=pageFactoryManager.getCartPage();
        cartPage.waitForPageLoadComplete(30);
        cartPage.deleteFromCart();
    }

    @And("User click on account list")
    public void userClickOnAccountList() {
        homePage.clickOnAccountList();
    }

    @And("User click on create new account")
    public void userClickOnCreateNewAccount() {
        signInPage=pageFactoryManager.getSignInPage();
        signInPage.waitForPageLoadComplete(30);
        signInPage.clickOnCreateNewAccountButton();

    }



    @And("User fill out all mandatory fields{string} {string} {string}")
    public void userFillOutAllMandatoryFieldsUserNameEmailOrPhoneNumberPassword( String userName, String emailOrPhoneNumber, String password) {
        signInPage.waitForPageLoadComplete(30);
        signInPage.inputNameInCustomerNameField(userName);
        signInPage.inputEmeilOrPhoneNumberInCustomerPhoneNumberOrEmailField(emailOrPhoneNumber);
        signInPage.inputPasswordInPasswordField(password);
    }

    @And("User click on continue button")
    public void userClickOnContinueButton() {
        signInPage.clickOnContinueButtonOnSignInPage();
    }



    @Then("User checks that error message {string} near re-enter password field is appeared")
    public void userChecksThatErrorMessageErrorNearReEnterPasswordFieldIsAppeared(String error) {
        assertEquals(signInPage.getErrorMessageApearedNearReEnterPasswordField(), error);
    }

    @And("User fill out all mandatory fields{string} {string} {string} {string}")
    public void userFillOutAllMandatoryFieldsUserNameEmailOrPhoneNumberPasswordReEnter(String userName, String emailOrPhoneNumber, String password, String reEnter) {
        signInPage.waitForPageLoadComplete(30);
        signInPage.inputNameInCustomerNameField(userName);
        signInPage.inputEmeilOrPhoneNumberInCustomerPhoneNumberOrEmailField(emailOrPhoneNumber);
        signInPage.inputPasswordInPasswordField(password);
        signInPage.inputPasswordInReEnterPasswordField(reEnter);

    }

    @Then("User check that error message {string} near re-enter field when does not matc passwords is appeared")
    public void userCheckThatErrorMessageErrorNearReEnterFieldWhenDoesNotMatcPasswordsIsAppeared(String error) {
        assertEquals(signInPage.getErrorMessageApearedNearReEnterPasswordFieldWhenDoesNotMatch(),error );
    }

    @And("User click on language icon")
    public void userClickOnLanguageIcon() {
        homePage.clickOnChangeLanguageIcon();
    }

    @When("User choose language for changing")
    public void userChooseLanguageForChanging() {
        changeLanguagePage=pageFactoryManager.getChangeLanguagePage();
        changeLanguagePage.clickOnFirstRadioButtonInChangeLanguageList();
    }

    @And("User click on save changes button")
    public void userClickOnSaveChangesButton() {
        changeLanguagePage.clickOnConfirmChangesButton();
    }



    @Then("User check that language is changed {string}")
    public void userCheckThatLanguageIsChangedLanguage(String language) {
        assertEquals(changeLanguagePage.verifyLanguageThT(), language);
    }

    @Given("Get Articles {string} Request")
    public void getArticlesRequest(String url) {
        articleService.getArticles(url);
    }

    @Then("Response code is: {string}")
    public void responseCodeIs(String status) {
        ValidatableResponse response = RUN_CONTEXT.get("response", ValidatableResponse.class);
        int actualStatus = response.extract().statusCode();
        int expectStatus = Integer.parseInt(status);
        Assert.assertEquals(actualStatus, expectStatus);
    }
}
