package tests.cucumberJava.test;


import applicationPages.navigationUtil.PageNavigationUtil;
import applicationPages.pages.BasePage;
import com.epam.training.framework.core.DriverWrapper;
import cucumber.api.java.en.Given;
import cucumber.api.java8.En;

import static applicationPages.navigationUtil.PageNavigationUtil.*;
import static com.epam.training.framework.data.TestData.CART_PAGE_URL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class firstTest implements En {
    private BasePage basePage;

    public firstTest() {
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
            basePage.clickOnCartButton();
        });
        Then("user navigates to cart page", () -> {
            assertEquals(basePage.getUrl(), CART_PAGE_URL);
        });

       After(DriverWrapper::killDriverInstance);
    }
}

