package Test;

import PageFactory.LoginPage;
import PageFactory.SignInPage;
import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Helper;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
/*
This test is designed to test the basic scenario for sign in using random email which was generated using
Faker library and it asserts that account is created and log the results in log4j-properties file found
in resources folder and takes screenshot with the class name in case for failure
 */
public class SignInTest extends TestBase{

    Logger log = Logger.getLogger(LoginTest.class.getName());
    SignInPage signInPage;
    Faker faker = new Faker();
    String email = Helper.generateRandomEmailAddress();
    String name = faker.name().firstName();
    String surname = faker.name().lastName();
    String firstAddress = faker.address().streetName();
    String secondAddress = faker.address().streetAddress();
    String companyName = faker.company().name();
    String cityName = faker.address().cityName();
    String homeNumber = faker.number().digits(11);
    String cellNumber = faker.number().digits(11);
    String alias = faker.address().streetName();
    String additionalInfo = faker.lorem().fixedString(10);
    String password = faker.superhero().name();



    @Test
    public void validSignIn() throws InterruptedException, FileNotFoundException {
        wait = new WebDriverWait(driver, 30);
        signInPage = new SignInPage(driver);
        wait.until(ExpectedConditions.visibilityOf(signInPage.getSignInButton()));
        signInPage.clickOnSignIn();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email_create")));
        signInPage.createAnAccount(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender2")));
        signInPage.selectMaleGender();
        signInPage.typeCustomerName(name, surname);
        signInPage.typePassword("wqtyuwqfe");
        signInPage.setDateOfBirth("1", "1", "2000");
        signInPage.typeCompanyName(companyName);
        signInPage.typeFirstAddressLine(firstAddress);
        signInPage.typeSecondAddressLine(secondAddress);
        signInPage.typeCityName(cityName);
        signInPage.selectState("Colorado");
        signInPage.typePostCode("00000");
        signInPage.typeAdditionalInfo(additionalInfo);
        signInPage.typeHomePhoneNumber(homeNumber);
        signInPage.typeMobilePhoneNumber(cellNumber);
        signInPage.typeAliasAddress(alias);
        signInPage.register();
        wait.until(ExpectedConditions.visibilityOf(signInPage.getHeading()));
        Assert.assertEquals(signInPage.getHeading().getText(), "MY ACCOUNT");
        log.debug("Account is created successfully");
        assertEquals(signInPage.getAccountName().getText(), name + " " + surname);
        log.debug("Account name is displayed corrrectly");
        assertTrue(signInPage.getAccountInfo().getText().contains("Welcome to your account."));
        log.debug("Welcome to your account title is displayed");
        assertTrue(signInPage.getLogoutBtn().isDisplayed());
        log.debug("Log out button is displayed correctly");
        assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
    }
}
