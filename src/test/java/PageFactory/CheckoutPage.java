package PageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*
This is the Checkout Page for all identifing all elements that exists in the checkout screen
and the required function where the tester will include in the checkout test, also this class inherits from
loginPage as login to the website is a prequisite for the checkout test
 */
public class CheckoutPage extends LoginPage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Women")
    private WebElement womenLink;

    @FindBy(linkText = "Faded Short Sleeve T-shirts")
    private WebElement fadedShortSleeveItem;

    @FindBy(name = "Submit")
    private WebElement addToCart;

    @FindBy(xpath = "//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']")
    private WebElement proceedToCheckoutButton;

    @FindBy(css = "#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium > span")
    private WebElement proceedToCheckoutSecondButton;

    @FindBy(name = "processAddress")
    private WebElement processAddress;

    @FindBy(xpath = "//*[@class='cheque-indent']/strong")
    private WebElement chequeStatus;

    @FindBy(xpath = "//li[@id='step_end' and @class='step_current last']")
    private WebElement lastStepConfirmation;

    @FindBy(xpath = "//li[@class='step_done step_done_last four']")
    private WebElement lastStepInProgress;

    public WebElement getLastStepConfirmation() {
        return lastStepConfirmation;
    }

    public WebElement getLastStepInProgress() {
        return lastStepInProgress;
    }

    public WebElement getChequeStatus() {
        return chequeStatus;
    }

    public WebElement getWomenLink() {
        return womenLink;
    }

    public WebElement getFadedShortSleeveItem() {
        return fadedShortSleeveItem;
    }

    public WebElement getAddToCart() {
        return addToCart;
    }

    public WebElement getProceedToCheckoutButton() {
        return proceedToCheckoutButton;
    }

    public WebElement getProceedToAddress() {
        return proceedToCheckoutSecondButton;
    }

    public WebElement getProcessAddress() {
        return processAddress;
    }

    public WebElement getAgreeOnTermsAndCondition() {
        return agreeOnTermsAndCondition;
    }

    public WebElement getProccessCarrier() {
        return proccessCarrier;
    }

    public WebElement getPayByBankWireCard() {
        return payByBankWireCard;
    }

    public WebElement getNavigateFromCardButton() {
        return navigateFromCardButton;
    }

    @FindBy(id = "uniform-cgv")
    private WebElement agreeOnTermsAndCondition;

    @FindBy(name = "processCarrier")
    private WebElement proccessCarrier;

    @FindBy(className = "bankwire")
    private WebElement payByBankWireCard;

    @FindBy(css = "#cart_navigation > button > span")
    private WebElement navigateFromCardButton;

    public void clickOnWomenLink() {
        clickElement(womenLink);
    }

    public void clickOnFadedShortSleeveItem() {
        clickElement(fadedShortSleeveItem);
    }

    public void clickOnAddToCard() {
        clickElement(addToCart);
    }

    public void clickOnProceedToCheckOut() {
        clickElement(proceedToCheckoutButton);
    }

    public void clickOnProceedToAddress() {
        clickElement(proceedToCheckoutSecondButton);
    }
    public void clickOnProcessAddress() {
        clickElement(processAddress);
    }

    public void agreeOnTermAndConditions() {
        clickElement(agreeOnTermsAndCondition);
    }

    public void clickOnProccessCarrier() {
        clickElement(proccessCarrier);
    }

    public void clickOnPayByBankWire() {
        clickElement(payByBankWireCard);
    }

    public void clickOnSubmitCart() {
        clickElement(navigateFromCardButton);
    }
    @Override
    public void goToLoginPage() {
        super.goToLoginPage();
    }

    @Override
    public void login(String userMail, String Password) throws InterruptedException {
        super.login(userMail, Password);
    }
}
