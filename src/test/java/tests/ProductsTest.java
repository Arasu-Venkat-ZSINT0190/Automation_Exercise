package tests;

import base.TestBase;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;

@Epic("AutomationExercise")
@Feature("Products")
public class ProductsTest extends TestBase {

    @Test(description = "Add product to cart")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Add first product to cart")
    public void testAddProductToCart() {
        driver.get("https://automationexercise.com/products");
        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.clickAddToCartByIndex(0); // Add first product
        productsPage.clickContinueShopping();

        productsPage.goToCart();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("view_cart"), "Did not navigate to cart page");
    }
}
