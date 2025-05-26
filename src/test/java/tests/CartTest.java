package tests;

import base.TestBase;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;

@Epic("AutomationExercise")
@Feature("Cart")
public class CartTest extends TestBase {

    @Test(description = "Verify product in cart")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Add product and verify in cart")
    public void testVerifyProductInCart() {
        driver.get("https://automationexercise.com/products");
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickAddToCartByIndex(0);
        productsPage.clickContinueShopping();
        productsPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.getCartItemsCount() > 0, "Cart is empty");

        // Ideally, you should know product name before adding, here just checking first item
        // You can improve by fetching product name before adding and pass here
        Assert.assertTrue(cartPage.isProductInCart("Blue Top") || cartPage.isProductInCart("Sleeveless Dress"), "Product not found in cart");
    }
}
