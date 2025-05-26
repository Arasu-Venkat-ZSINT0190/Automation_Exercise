package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

public class ContactUsPage {

    WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@data-qa='name']")
    private WebElement inputName;

    @FindBy(xpath = "//input[@data-qa='email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@data-qa='subject']")
    private WebElement inputSubject;

    @FindBy(xpath = "//textarea[@data-qa='message']")
    private WebElement inputMessage;

    @FindBy(xpath = "//input[@name='upload_file']")
    private WebElement inputUploadFile;

    @FindBy(xpath = "//input[@data-qa='submit-button']")
    private WebElement btnSubmit;

    @FindBy(xpath = "//div[@class='status alert alert-success']")
    private WebElement successMessage;

    // Actions
    public void enterName(String name) {
        ElementUtils.type(inputName, name);
    }

    public void enterEmail(String email) {
        ElementUtils.type(inputEmail, email);
    }

    public void enterSubject(String subject) {
        ElementUtils.type(inputSubject, subject);
    }

    public void enterMessage(String message) {
        ElementUtils.type(inputMessage, message);
    }

    public void uploadFile(String filePath) {
        inputUploadFile.sendKeys(filePath);
    }

    public void clickSubmit() {
        ElementUtils.click(btnSubmit);
    }

    public String getSuccessMessage() {
        return ElementUtils.getElementText(successMessage);
    }
}
