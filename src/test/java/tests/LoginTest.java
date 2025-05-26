package tests;

import base.TestBase;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

@Epic("AutomationExercise")
@Feature("Login")
public class LoginTest extends TestBase {

    @Test(description = "Valid user login", priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login with valid credentials")
    public void testValidLogin() {
        driver.get("https://automationexercise.com/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("arasubhv@gmail.com");
        loginPage.enterPassword("12345");
        loginPage.clickLogin();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("account_created") || !currentUrl.contains("login"), "Login failed or redirected incorrectly");
    }

    @Test(description = "Invalid user login",priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Story("Login with invalid credentials")
    public void testInvalidLogin() {
        driver.get("https://automationexercise.com/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("wrongemail@example.com");
        loginPage.enterPassword("wrongpassword");
        loginPage.clickLogin();

        String errorMsg = loginPage.getLoginErrorMessage();
        Assert.assertTrue(errorMsg.contains("Your email or password is incorrect!"), "Error message not shown for invalid login");
    }
}