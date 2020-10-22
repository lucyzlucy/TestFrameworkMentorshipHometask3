package applicationPages.pages;

import com.epam.training.framework.core.DriverWrapper;
import com.epam.training.framework.core.elements.Button;
import com.epam.training.framework.core.elements.FieldDecorator;
import com.epam.training.framework.core.elements.Label;
import com.epam.training.framework.core.elements.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.epam.training.framework.utils.StripNonDigitsUtil.stripNonDigits;

public class BasePage {
    @FindBy(id = "link-to-login")
    protected Link loginLink;

    @FindBy(xpath = "//a[@href='/logout']")
    protected Link logoutLink;

    @FindBy(xpath = "//a[@href='/cart']")
    protected Button cart;

    @FindBy(xpath = "//a[@href='/cart' and contains(@class, 'full')]")
    protected Label cartItems;

    @FindBy(xpath = "//img[@alt='loading']")
    protected Label loader;


    public BasePage() {
        PageFactory.initElements(new FieldDecorator(DriverWrapper.getDriver()), this);
    }

    public String getUrl() {
        return DriverWrapper.getDriver().getCurrentUrl();
    }

    public LoginPage openLoginPage() {
        loginLink.click();
        return new LoginPage();
    }

    public BasePage clickOnLogout() {
        logoutLink.click();
        return this;
    }

    public boolean loginButtonIsVisible() {
        return loginLink.isDisplayed();
    }

    public boolean logoutButtonIsVisible() {
        return logoutLink.isDisplayed();
    }

    public double getCartTotalPrice() {
        if (cartItems.isDisplayed()) {
            return Double.parseDouble(stripNonDigits(cartItems.getChildNodeText()));
        } else return 0.00;
    }

    public int getCartItems() {
        if (cartItems.isDisplayed()) {
            return Integer.parseInt(stripNonDigits(cartItems.getTextNode()));
        } else return 0;

    }

    public CartPage clickOnCartButton() {
        cart.click();
        return new CartPage();
    }

    public void explicitWait(long milliseconds) {
        try {
            synchronized (DriverWrapper.getDriver()) {
                DriverWrapper.getDriver().wait(milliseconds);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
