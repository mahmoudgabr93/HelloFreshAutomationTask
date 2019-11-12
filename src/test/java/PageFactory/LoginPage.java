package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*
This is the Login Page for all identifing all elements that exists in the login screen
and the defining the login function where the tester will include in the login test
 */
public class LoginPage extends PageBase
{
    public LoginPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(className = "login")
    private WebElement signIn;

    @FindBy(id = "SubmitLogin")
    private WebElement submitLogin;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "passwd")
    private WebElement password;


    @FindBy(className = "account")
    private WebElement accountName;

    @FindBy(className = "info-account")
    private WebElement accountInfo;

    @FindBy(className = "logout")
    private WebElement logoutButton;

    public WebElement getAccountName() {
        return accountName;
    }

    public WebElement getAccountInfo() {
        return accountInfo;
    }

    public WebElement getLogoutButton() {
        return logoutButton;
    }

    public WebElement getEmail() {
        return email;
    }
    public void goToLoginPage () {
        clickElement(signIn);
    }
    public void login(String userMail,String Password) throws InterruptedException {
        Thread.sleep(2000);
        setElementsText(email,userMail);
        setElementsText(password,Password);
        clickElement(submitLogin);
    }
}
