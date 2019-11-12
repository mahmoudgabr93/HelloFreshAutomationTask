package Test;

import PageFactory.LoginPage;
import com.opencsv.CSVReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import utilities.Helper;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.Thread.*;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/*
This test is designed to test the basic scenario for login using credentials found inside LoginCredentials.csv
 and it asserts that user login successfully to the app and log the results in log4j-properties file found
in resources folder and takes screenshot with the class name in case for failure
 */

public class LoginTest extends TestBase {

    Logger log = Logger.getLogger(LoginTest.class.getName());
    LoginPage loginPage;


    @Test
    public void validLogin() throws InterruptedException, IOException {
        String email = Helper.readCredentials()[0];
        String password = Helper.readCredentials()[1];
        String fullName = Helper.readCredentials()[2];
        wait = new WebDriverWait(driver, 30);
        loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getEmail()));
        loginPage.login(email, password);
        wait.until(ExpectedConditions.visibilityOf((loginPage.getHeading())));
        assertEquals("MY ACCOUNT", loginPage.getHeading().getText());
        log.debug("Title matches");
        assertEquals(fullName, loginPage.getAccountName().getText());
        assertTrue(loginPage.getAccountInfo().getText().contains("Welcome to your account."));
        log.debug("Account Info is displayed correctly");
        assertTrue(loginPage.getLogoutButton().isDisplayed());
        log.debug("Logout button is displayed correctly");
        assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
        log.debug("Current URL contains my account");
    }
}
