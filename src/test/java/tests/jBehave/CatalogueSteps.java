package tests.jBehave;

import applicationPages.navigationUtil.PageNavigationUtil;
import applicationPages.pages.CataloguePage;
import applicationPages.pages.ProductPage;
import com.epam.training.framework.core.entityBuilders.entities.Product;
import org.jbehave.core.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

public class CatalogueSteps {

    CataloguePage catalogue;
    ProductPage productPage;
    Product product;

    @Given("user navigates to Catalogue")
    public void navigateToCatalogue() {
        catalogue = PageNavigationUtil.toCatalogue();
    }

    @When("user chooses '$category'")
    @Given("user chooses '$category'")
    public void chooseCategory(@Named("category") String category) {
        catalogue.chooseCategory(category);
    }

    @Then("user sees '$category' page")
    public void checkCategoryPage(@Named("category") String category) {
        assertThat(catalogue.getPageHeaderText().equals(category));
    }

    @Then("user sees products")
    public void productsShown() {
        assertTrue(catalogue.productItemIsDisplayed());
    }

    @When("user clicks on Product")
    public void chooseProduct() {
        product = new Product(catalogue.getProductName(), catalogue.getProductPrice());
        productPage = catalogue.chooseProduct();
    }
    @Then("user navigates to Product page")
    @Alias("user sees the correct Product title")
        public void productPageIsShown() {
        assertThat(productPage.getProductTitle().equals(product.getName()));
    }

    @Then("user sees the correct Product price")
    public void productPriceIsShown() {
        assertThat(productPage.getProductPrice().equals(product.getPrice()));
    }

    @Then("user sees available Product quantity")
    public void productAvailableItemsIsShown() {
        assertTrue(productPage.productAvailableQuantityIsShown());
    }

}
