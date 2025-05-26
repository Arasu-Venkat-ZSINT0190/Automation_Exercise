package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    private WebElement btnLogin;

    @FindBy(xpath = "//p[contains(text(),'Your email or password is incorrect!')]")
    private WebElement loginErrorMessage;

    // Actions
    public void enterEmail(String email) {
        ElementUtils.type(inputEmail, email);
    }

    public void enterPassword(String password) {
        ElementUtils.type(inputPassword, password);
    }

    public void clickLogin() {
        ElementUtils.click(btnLogin);
    }

    public String getLoginErrorMessage() {
        return ElementUtils.getElementText(loginErrorMessage);
    }
}
