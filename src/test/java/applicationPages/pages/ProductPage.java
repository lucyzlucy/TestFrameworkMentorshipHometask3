package applicationPages.pages;

import com.epam.training.framework.core.DriverWrapper;
import com.epam.training.framework.core.elements.Button;
import com.epam.training.framework.core.elements.Input;
import com.epam.training.framework.core.elements.Label;
import com.epam.training.framework.utils.StripNonDigitsUtil;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.epam.training.framework.utils.StripNonDigitsUtil.stripNonDigits;

public class ProductPage extends BasePage {
    @FindBy(id = "add-to-cart-button")
    private Button addToCartButton;

    @FindBy(id = "quantity")
    private Input quantityField;

    @FindBy(xpath = "//div[@data-hook='product_right_part']//h1[@class= 'product-title']")
    private Label productTitle;

    @FindBy(xpath = "//div[@data-variant][1]//*[@itemprop='price']")
    private Label productPrice;

    @FindBy(xpath = "//*[@class= 'product-stock']")
    private Label itemsAvailable;

    @FindBy(id = "not-enough-at-stock")
    private Label notEnoughItemsErrorMessage;

    @FindBy(id = "start-ordering")
    private Button startOrderingButton;

    public ProductPage addToCart() {
        addToCartButton.click();
        return this;
    }

    public ProductPage writeQuantity(int quantity) {
        quantityField.clearContent();
        quantityField.write(String.valueOf(quantity));
        return this;

    }

    public String getProductTitle() {
        return productTitle.getLabelText();
    }

    public Double getProductPrice() {
        return Double.parseDouble(stripNonDigits(productPrice.getLabelContent()));
    }

    public boolean productAvailableQuantityIsShown() {
        return itemsAvailable.isDisplayed();
    }

    public int getProductAvailableQuantity() {
        return Integer.parseInt(itemsAvailable.getLabelText());
    }

    public boolean notEnoughItemsErrorMessagesShown() {
        return notEnoughItemsErrorMessage.isDisplayed();
    }

    public boolean startOrderingButtonIsShown() {
        return startOrderingButton.isDisplayed();
    }


}
