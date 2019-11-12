package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*
This is the Sign Page for all identifing all elements that exists in the sign in screen
and the defining the sign in functions where the tester will include in the sign in test
 */
public class SignInPage extends PageBase{
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "login")
    private WebElement signInButton;

    @FindBy(id = "email_create")
    private WebElement createEmail;

    @FindBy(id = "SubmitCreate")
    private WebElement submitCreate;

    @FindBy(id = "id_gender1")
    private WebElement maleRadioButton;

    @FindBy(id = "id_gender2")
    private WebElement femaleRadioButton;

    @FindBy(id = "customer_firstname")
    private WebElement customerFirstName;

    @FindBy(id = "customer_lastname")
    private WebElement customerLastName;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "days")
    private WebElement daySelector;

    @FindBy(id = "months")
    private WebElement monthSelector;

    @FindBy(id = "years")
    private WebElement yearSelector;

    @FindBy(id = "company")
    private WebElement company;

    @FindBy(id = "address1")
    private WebElement firstAddress;

    @FindBy(id = "address2")
    private WebElement secondAddress;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "id_state")
    private WebElement stateSelector;

    @FindBy(id = "postcode")
    private WebElement postcode;

    @FindBy(id = "other")
    private WebElement additionalInformation;

    @FindBy(id = "phone")
    private WebElement homePhone;

    @FindBy(id = "phone_mobile")
    private WebElement phoneMobile;

    @FindBy(id = "alias")
    private WebElement aliasAddress;

    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    public WebElement getSubmitCreate() {
        return submitCreate;
    }

    public WebElement getMaleRadioButton() {
        return maleRadioButton;
    }

    public WebElement getFemaleRadioButton() {
        return femaleRadioButton;
    }

    public WebElement getCustomerFirstName() {
        return customerFirstName;
    }

    public WebElement getCustomerLastName() {
        return customerLastName;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getDaySelector() {
        return daySelector;
    }

    public WebElement getMonthSelector() {
        return monthSelector;
    }

    public WebElement getYearSelector() {
        return yearSelector;
    }

    public WebElement getCompany() {
        return company;
    }

    public WebElement getFirstAddress() {
        return firstAddress;
    }

    public WebElement getSecondAddress() {
        return secondAddress;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getStateSelector() {
        return stateSelector;
    }

    public WebElement getPostcode() {
        return postcode;
    }

    public WebElement getAdditionalInformation() {
        return additionalInformation;
    }

    public WebElement getHomePhone() {
        return homePhone;
    }

    public WebElement getPhoneMobile() {
        return phoneMobile;
    }

    public WebElement getAliasAddress() {
        return aliasAddress;
    }

    public WebElement getRegisterButton() {
        return registerButton;
    }

    public WebElement getCreateEmail() {
        return createEmail;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public void clickOnSignIn() {
        clickElement(signInButton);
    }
    public void createAnAccount(String email) {
        setElementsText(createEmail, email);
        clickElement(submitCreate);
    }

    public void selectMaleGender() {
        clickElement(maleRadioButton);
    }

    public void selectFemaleGender() {
        clickElement(femaleRadioButton);
    }

    public void typeCustomerName(String firstName, String lastName) {
        setElementsText(customerFirstName, firstName);
        setElementsText(customerLastName, lastName);
    }

    public void typePassword(String passwordText) {
        setElementsText(password, passwordText);
    }

    public void setDateOfBirth(String day, String month, String year) {
        selectElementFromListByValue(daySelector, day);
        selectElementFromListByValue(monthSelector, month);
        selectElementFromListByValue(yearSelector, year);
    }

    public void typeCompanyName(String companyName) {
        setElementsText(company, companyName);
    }

    public void typeFirstAddressLine(String address1) {
        setElementsText(firstAddress, address1);
    }
    public void typeSecondAddressLine(String address2) {
        setElementsText(secondAddress, address2);
    }

    public void typeCityName(String cityName) {
        setElementsText(city, cityName);
    }

    public void selectState(String stateName) {
        selectElementFromListByText(stateSelector, stateName);
    }

    public void typePostCode(String postcodeNumber) {
        setElementsText(postcode, postcodeNumber);
    }

    public void typeAdditionalInfo(String additionalInfoText) {
        setElementsText(additionalInformation, additionalInfoText);
    }

    public void typeHomePhoneNumber(String homePhoneNumber) {
        setElementsText(homePhone, homePhoneNumber);
    }

    public void typeMobilePhoneNumber(String mobilePhoneNumber) {
        setElementsText(phoneMobile, mobilePhoneNumber);
    }

    public void typeAliasAddress(String aliasAdd) {
        setElementsText(aliasAddress, aliasAdd);
    }
    public void register() {
        clickElement(registerButton);
    }
}
