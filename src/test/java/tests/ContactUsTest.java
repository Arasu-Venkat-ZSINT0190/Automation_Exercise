package tests;

import base.TestBase;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;

import java.nio.file.Paths;

@Epic("AutomationExercise")
@Feature("Contact Us")
public class ContactUsTest extends TestBase {

    @Test(description = "Submit contact us form successfully")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Submit contact form with valid data")
    public void testSubmitContactUs() {
        driver.get("https://automationexercise.com/contact_us");
        ContactUsPage contactUsPage = new ContactUsPage(driver);

        contactUsPage.enterName("John Doe");
        contactUsPage.enterEmail("john.doe@example.com");
        contactUsPage.enterSubject("Testing Contact Us");
        contactUsPage.enterMessage("This is a test message from automation script.");

        String filePath = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "testfile.txt").toString();
        contactUsPage.uploadFile(filePath);

        contactUsPage.clickSubmit();
        driver.switchTo().alert().accept();
        String msg = contactUsPage.getSuccessMessage();
        Assert.assertTrue(msg.contains("Success! Your details have been submitted successfully."), "Success message not shown");
    }
}
