package Test;

import PageFactory.CheckoutPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Helper;

import java.io.IOException;

import static junit.framework.TestCase.assertTrue;

/*
This test is designed to test the basic scenario for checkout and it asserts that
order is created and log the results in log4j-properties file found
in resources folder and takes screenshot with the class name in case for failure
 */
public class CheckoutTest extends TestBase {

    Logger log = Logger.getLogger(LoginTest.class.getName());
    CheckoutPage checkoutPage;


    @Test
    public void validCheckoutScenario() throws InterruptedException, IOException {
        String email = Helper.readCredentials()[0];
        String password = Helper.readCredentials()[1];
        wait = new WebDriverWait(driver, 30);
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.goToLoginPage();
        checkoutPage.login(email, password);
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getWomenLink()));
        checkoutPage.clickOnWomenLink();
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getFadedShortSleeveItem()));
        checkoutPage.clickOnFadedShortSleeveItem();
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getAddToCart()));
        checkoutPage.clickOnAddToCard();
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getProceedToCheckoutButton()));
        checkoutPage.clickOnProceedToCheckOut();
        checkoutPage.clickOnProceedToAddress();
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getProcessAddress()));
        checkoutPage.clickOnProcessAddress();
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getAgreeOnTermsAndCondition()));
        checkoutPage.agreeOnTermAndConditions();
        checkoutPage.clickOnProccessCarrier();
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getPayByBankWireCard()));
        checkoutPage.clickOnPayByBankWire();
        checkoutPage.clickOnSubmitCart();
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getHeading()));
        Assert.assertEquals(checkoutPage.getHeading().getText(), "ORDER CONFIRMATION");
        log.debug("Order is added successfully");
        assertTrue(checkoutPage.getLastStepInProgress().isDisplayed());
        assertTrue(checkoutPage.getLastStepConfirmation().isDisplayed());
        assertTrue(checkoutPage.getChequeStatus().getText().contains("Your order on My Store is complete."));
        assertTrue(driver.getCurrentUrl().contains("controller=order-confirmation"));
        log.debug("Order has been added to the store");
    }
}
