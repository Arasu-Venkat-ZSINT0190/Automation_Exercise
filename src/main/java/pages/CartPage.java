package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

import java.util.List;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//table[@id='cart_info_table']//tbody//tr")
    private List<WebElement> cartItems;



    @FindBy(xpath = "//td[@class='cart_description']/h4/a")
    private List<WebElement> productNames;

    public int getCartItemsCount() {
        return cartItems.size();
    }

    public boolean isProductInCart(String productName) {
        for (WebElement name : productNames) {
            if (name.getText().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }
}
