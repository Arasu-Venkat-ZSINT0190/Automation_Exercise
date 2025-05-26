package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

import java.util.List;

public class ProductsPage {

    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Product items container
    @FindBy(css = ".product-image-wrapper")
    private List<WebElement> productList;

    // Add to cart buttons inside each product
    @FindBy(css = ".product-image-wrapper .add-to-cart")
    private List<WebElement> addToCartButtons;

    @FindBy(xpath = "//button[contains(text(),'Continue Shopping')]")
    private WebElement btnContinueShopping;

    @FindBy(xpath = "//a[contains(@href,'/view_cart')]")
    private WebElement linkViewCart;

    public void clickAddToCartByIndex(int index) {
        if (index >= 0 && index < addToCartButtons.size()) {
            ElementUtils.click(addToCartButtons.get(index));
        }
    }

    public void clickContinueShopping() {
        ElementUtils.click(btnContinueShopping);
    }

    public void goToCart() {
        ElementUtils.click(linkViewCart);
    }
}
