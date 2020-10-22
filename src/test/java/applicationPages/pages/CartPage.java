package applicationPages.pages;

import com.epam.training.framework.core.elements.Button;
import com.epam.training.framework.core.elements.Label;
import org.openqa.selenium.support.FindBy;

import static com.epam.training.framework.utils.StripNonDigitsUtil.stripNonDigits;

public class CartPage extends BasePage {
    @FindBy(xpath = "//*[@class= 'cart-item-description']/h4/a")
    private Label productTitle;

    @FindBy(xpath = "//*[@class= 'cart-item-price']")
    private Label productPrice;

    @FindBy(xpath = "//*[@class= 'cart-item-quantity']")
    private Label productQuantity;

    @FindBy(xpath = "//*[@class= 'cart-item-total']")
    private Label totalPrice;

    @FindBy(xpath = "//td[@class='cart-item-delete']/a[1]/img")
    private Button deleteButton;

    @FindBy(xpath = "//*[@data-hook= 'empty_cart']")
    private Label emptyCartLabel;

    @FindBy(id = "cartTotalValue")
    private Label finalTotalPrice;

    @FindBy(id = "cartTotalQuantity")
    private Label finalTotalQuantity;

    public String getProductTitle() {
        return productTitle.getLabelText();
    }

    public Double getProductPrice() {
        return Double.parseDouble(stripNonDigits(productPrice.getLabelText()));
    }

    public Integer getProductQuantity() {
        return Integer.parseInt(stripNonDigits(productQuantity.getLabelText()));
    }

    public Double getTotalPrice() {
        return Double.parseDouble(stripNonDigits(totalPrice.getLabelText()));
    }

    public Double getFinalTotalPrice() {
        return Double.parseDouble(stripNonDigits(finalTotalPrice.getLabelText()));
    }

    public Integer getFinalTotalQuantity() {
        return Integer.parseInt(stripNonDigits(finalTotalQuantity.getLabelText()));
    }

    public CartPage clickOnDelete(){
        deleteButton.click();
        return this;
    }

    public boolean emptyCartLabelIsShown(){
        return emptyCartLabel.isDisplayed();
    }

    public boolean productTitleIsShown(){
        return productTitle.isDisplayed();
    }
}

