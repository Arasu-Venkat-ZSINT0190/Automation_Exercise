package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.DriverFactory;

public class TestBase {
    protected WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        driver = DriverFactory.initDriver(browser);
        driver.get("https://automationexercise.com");
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
