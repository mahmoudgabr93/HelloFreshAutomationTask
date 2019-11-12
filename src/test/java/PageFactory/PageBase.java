package PageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/*
This is the base class for all pages where common elements are identified and the webdriver and webdriverWait are
identified
 */
public class PageBase {

    protected WebDriver driver ;
    public WebDriverWait wait;
    public JavascriptExecutor jse ;
    public Select select ;
    public Actions action ;

    @FindBy(css = "h1")
    private WebElement heading;

    @FindBy(className = "account")
    private WebElement accountName;

    @FindBy(className = "info-account")
    private WebElement accountInfo;

    public WebElement getAccountName() {
        return accountName;
    }

    public WebElement getAccountInfo() {
        return accountInfo;
    }

    public WebElement getLogoutBtn() {
        return logoutBtn;
    }

    @FindBy(className = "logout")
    private WebElement logoutBtn;
    // create constructor
    public PageBase(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    public WebElement getHeading() {
        return heading;
    }


    protected static void clickElement(WebElement element)
    {
        element.click();
    }

    protected static void setElementsText(WebElement textElement , String value)
    {
        textElement.sendKeys(value);
    }

    protected static void selectElementFromListByValue(WebElement selectElement, String value) {
        Select select = new Select(selectElement);
        select.selectByValue(value);
    }
    protected static void selectElementFromListByText(WebElement selectElement, String text) {
        Select select = new Select(selectElement);
        select.selectByVisibleText(text);
    }

    public void clearText(WebElement element)
    {
        element.clear();
    }

}
