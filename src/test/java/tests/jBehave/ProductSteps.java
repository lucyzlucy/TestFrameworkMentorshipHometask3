package tests.jBehave;

import applicationPages.navigationUtil.PageNavigationUtil;
import applicationPages.pages.ProductPage;
import com.epam.training.framework.core.entityBuilders.builders.ProductBuilder;
import com.epam.training.framework.core.entityBuilders.entities.Product;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

public class ProductSteps {
    ProductPage productPage;
    Product product;
    int initialItemsInCart;
    double initialPriceInCart;

    @Given("user navigates to Product page")
    public void navigateToProduct() {
        productPage = PageNavigationUtil.toProductPage();
        product = new ProductBuilder().setPrice(productPage.getProductPrice())
                .setAvailableItems(productPage.getProductAvailableQuantity())
                .make();
        initialItemsInCart = productPage.getCartItems();
        initialPriceInCart = productPage.getCartTotalPrice();
    }

    @When("user clicks on 'Add to cart' button")
    public void addtoCart() {
        productPage.addToCart();
        productPage.explicitWait(10000);
    }

    @When("user adds all available products to cart")
    public void addAllAvailableProducts() {
        productPage.writeQuantity(product.getAvailableItems());
        product.setQuantity(product.getAvailableItems());
    }

    @When("user adds more than available products to cart")
    public void addMoreThanAvailableProducts() {
        productPage.writeQuantity(product.getAvailableItems() + 1);
    }

    @Then("product is added")
    public void verifyNumberOfItemsInTheCartHasChanged() {
        Assert.assertEquals(productPage.getCartItems(), initialItemsInCart + product.getQuantity());
    }

    @Then("the product price is added to the total")
    public void verifyPriceOfItemsInTheCartHasChanged() {
        Assert.assertEquals(productPage.getCartTotalPrice(), initialPriceInCart + product.getPrice() * product.getQuantity());
    }

    @Then("an error is shown")
    public void verifyAnErrorAboutMoreThanAvailableItems() {
        assertTrue(productPage.notEnoughItemsErrorMessagesShown());
    }

    @Then("start ordering button is shown")
    public void verifyStartOrderingButtonIsShown() {
        assertTrue(productPage.startOrderingButtonIsShown());
    }


}