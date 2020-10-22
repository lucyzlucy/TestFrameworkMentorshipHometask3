package tests.cucumberJava.test;


import applicationPages.navigationUtil.PageNavigationUtil;
import applicationPages.pages.BasePage;
import applicationPages.pages.CartPage;
import applicationPages.pages.ProductPage;
import com.epam.training.framework.core.DriverWrapper;
import com.epam.training.framework.core.entityBuilders.builders.ProductBuilder;
import com.epam.training.framework.core.entityBuilders.entities.Product;
import cucumber.api.java.en.Given;
import cucumber.api.java8.En;

import static applicationPages.navigationUtil.PageNavigationUtil.*;
import static com.epam.training.framework.data.TestData.CART_PAGE_URL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class cartStepDefs implements En {
    private BasePage basePage;
    private Product product;

    public cartStepDefs() {
        Before(DriverWrapper::setDriver);
        Given("^user is on (\\w+) page$", (String page) -> {
            switch (page) {
                case "Main": {
                    basePage = toMainPage();
                }
                case "Product": {
                    basePage = toProductPage();
                }
                case "Catalogue": {
                    basePage = toCatalogue();
                }
            }
        });

        When("user clicks on cart button", () -> {
            basePage.explicitWait(1000);
            basePage.clickOnCartButton();
        });

        Then("user navigates to cart page", () -> {
            assertEquals(basePage.getUrl(), CART_PAGE_URL);
        });

        Given("user has added products to cart", () -> {
            basePage = toProductPage();
            product = new ProductBuilder()
                    .setName(((ProductPage)basePage).getProductTitle())
                    .setPrice(((ProductPage)basePage).getProductPrice())
                    .setAvailableItems(((ProductPage)basePage).getProductAvailableQuantity()).make();

            product.setQuantity(product.getAvailableItems());
            ((ProductPage)basePage).writeQuantity(product.getQuantity()).addToCart();
            basePage.explicitWait(10000);
        });

        When("user navigates to Cart", () -> {
            basePage = toCartPage();
        });

        Then("user can see product details", () -> {
            basePage = toCartPage();
            assertThat(((CartPage)basePage).getProductTitle().equals(product.getName()));
            assertThat(((CartPage)basePage).getProductPrice().equals(product.getPrice()));
            assertThat(((CartPage)basePage).getProductQuantity().equals(product.getQuantity()));
        });

        When("user clicks on delete button", () -> {
            ((CartPage)basePage).clickOnDelete();
        });

        Then("user can see empty cart label", () -> {
            assertThat(((CartPage)basePage).emptyCartLabelIsShown());
        });

        Then("user sees no product details", () -> {
            basePage = toCartPage();
            assertThat(!((CartPage)basePage).productTitleIsShown());
        });

        After(DriverWrapper::killDriverInstance);
    }
}

