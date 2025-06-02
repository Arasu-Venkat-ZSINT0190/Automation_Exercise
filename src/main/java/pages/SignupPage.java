package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class SignupPage {

    WebDriver driver;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//input[@data-qa='signup-name']")
    private WebElement inputName;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private WebElement btnSignup;

    // Step 2 fields - Account Information
    @FindBy(id = "id_gender1")
    private WebElement radioMr;

    @FindBy(id = "id_gender2")
    private WebElement radioMrs;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(id = "days")
    private WebElement dropdownDays;

    @FindBy(id = "months")
    private WebElement dropdownMonths;

    @FindBy(id = "years")
    private WebElement dropdownYears;

    @FindBy(id = "first_name")
    private WebElement inputFirstName;

    @FindBy(id = "last_name")
    private WebElement inputLastName;

    @FindBy(id = "company")
    private WebElement inputCompany;

    @FindBy(id = "address1")
    private WebElement inputAddress1;

    @FindBy(id = "address2")
    private WebElement inputAddress2;

    @FindBy(id = "country")
    private WebElement dropdownCountry;

    @FindBy(id = "state")
    private WebElement inputState;

    @FindBy(id = "city")
    private WebElement inputCity;

    @FindBy(id = "zipcode")
    private WebElement inputZipcode;

    @FindBy(id = "mobile_number")
    private WebElement inputMobileNumber;

    @FindBy(xpath = "//button[contains(text(),'Create Account')]")
    private WebElement btnCreateAccount;

    @FindBy(xpath = "//h2[contains(text(),'ACCOUNT CREATED!')]")
    private WebElement accountCreatedMessage;

    // Step 1 actions
    public void enterName(String name) {
        ElementUtils.type(inputName, name);
    }

    public void enterEmail(String email) {
        ElementUtils.type(inputEmail, email);
    }

    public void clickSignup() {
        ElementUtils.click(btnSignup);
    }

    // Step 2 actions
    public void selectTitleMr() {
        ElementUtils.click(radioMr);
    }

    public void selectTitleMrs() {
        ElementUtils.click(radioMrs);
    }

    public void enterPassword(String password) {
        ElementUtils.type(inputPassword, password);
    }

    public void selectDateOfBirth(String day, String month, String year) {
        ElementUtils.selectByVisibleText(dropdownDays, day);
        ElementUtils.selectByVisibleText(dropdownMonths, month);
        ElementUtils.selectByVisibleText(dropdownYears, year);
    }

    public void enterFirstName(String firstName) {
        ElementUtils.type(inputFirstName, firstName);
    }

    public void enterLastName(String lastName) {
        ElementUtils.type(inputLastName, lastName);
    }

    public void enterCompany(String company) {
        ElementUtils.type(inputCompany, company);
    }

    public void enterAddress1(String address1) {
        ElementUtils.type(inputAddress1, address1);
    }

    public void enterAddress2(String address2) {
        ElementUtils.type(inputAddress2, address2);
    }

    public void selectCountry(String country) {
        ElementUtils.selectByVisibleText(dropdownCountry, country);
    }

    public void enterState(String state) {
        ElementUtils.type(inputState, state);
    }

    public void enterCity(String city) {
        ElementUtils.type(inputCity, city);
    }

    public void enterZipcode(String zipcode) {
        ElementUtils.type(inputZipcode, zipcode);
    }

    public void enterMobileNumber(String mobileNumber) {
        ElementUtils.type(inputMobileNumber, mobileNumber);
    }

    public void clickCreateAccount() {
        ElementUtils.click(btnCreateAccount);
    }

    // Validation
    public String getAccountCreatedMessage() {
        return ElementUtils.getElementText(accountCreatedMessage);
    }
}
