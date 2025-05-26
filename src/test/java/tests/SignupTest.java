package tests;

import base.TestBase;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignupPage;
import utils.FakeDataGenerator;

@Epic("AutomationExercise")
@Feature("Signup")
public class SignupTest extends TestBase {

    @Test(description = "Valid user signup")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Signup with valid data")
    @Description("Test signup process with valid data and verify account creation")
    public void testValidSignup() throws InterruptedException {
        driver.get("https://automationexercise.com/signup");
        SignupPage signup = new SignupPage(driver);

        // Generate fake data
        String firstName = FakeDataGenerator.getFirstName();
        String lastName = FakeDataGenerator.getLastName();
        String email = FakeDataGenerator.getEmail();
        String password = FakeDataGenerator.getPassword();
        String address1 = FakeDataGenerator.getAddress();
        String address2 = FakeDataGenerator.getAddress();
        String city = FakeDataGenerator.getCity();
        String state = "California";
        String zipcode = FakeDataGenerator.getZip();
        String mobile = FakeDataGenerator.getMobileNumber();

        // Step 1
        signup.enterName(firstName + " " + lastName);
        signup.enterEmail(email);
        signup.clickSignup();

        // Step 2 - Account info
        signup.selectTitleMr();
        signup.enterPassword(password);
        signup.selectDateOfBirth("10", "May", "1990");
        signup.enterFirstName(firstName);
        signup.enterLastName(lastName);
        signup.enterCompany("TestCompany");
        signup.enterAddress1(address1);
        signup.enterAddress2(address2);
        signup.selectCountry("United States");
        signup.enterState(state);
        signup.enterCity(city);
        signup.enterZipcode(zipcode);
        signup.enterMobileNumber(mobile);
        signup.clickCreateAccount();
        Thread.sleep(3000);
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("account_created"), "Account was not created successfully");
    }
}
