package applicationPages.pages;

import com.epam.training.framework.core.elements.Label;
import com.epam.training.framework.core.elements.Link;
import org.openqa.selenium.support.FindBy;

import static com.epam.training.framework.utils.StripNonDigitsUtil.stripNonDigits;

public class CataloguePage extends BasePage {


    @FindBy(partialLinkText = "Годинники")
    private Link watchesLink;

    @FindBy(partialLinkText = "Одяг")
    private Link clothesLink;

    @FindBy(className = "content-header")
    private Label pageHeader;

    @FindBy(xpath = "//div[contains(@class, \"product-listing-item\")][1]//a[@itemprop = \"name\"]")
    private Link productItemName;


    @FindBy(xpath = "//div[contains(@class, \"product-listing-item\")][1]//span[@itemprop = \"price\"]")
    private Label productPrice;


    public void chooseCategory(String categoryName) {
        switch (categoryName) {
            case "Одяг": {
                clothesLink.click();
            }
            case "Годинники": {
                watchesLink.click();
            }
        }
    }

    public String getPageHeaderText() {
        return pageHeader.getLabelText();
    }

    public boolean productItemIsDisplayed() {
        return productItemName.isDisplayed();
    }

    public ProductPage chooseProduct() {
        productItemName.click();
        return new ProductPage();
    }

    public double getProductPrice() {
        return Double.parseDouble((stripNonDigits(productPrice.getLabelText())));
    }

    public String getProductName() {
        return productItemName.getLinkText();
    }

}
