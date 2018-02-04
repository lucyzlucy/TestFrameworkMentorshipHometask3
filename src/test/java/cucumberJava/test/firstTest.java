package cucumberJava.test;


import applicationPages.navigations.PageNavigationUtil;
import applicationPages.pages.SearchResultPage;
import com.epam.training.framework.core.DriverWrapper;
import cucumber.api.java8.En;

import static org.assertj.core.api.Assertions.assertThat;
public class firstTest implements En {

    public firstTest() {
        Given("I google (\\w+)", (String url) -> {
            SearchResultPage searchResultPage = PageNavigationUtil.toMainPage().writeButton(url);
            assertThat(searchResultPage.getSearchTitle()).as("wrong text").isEqualTo("Пошук");
        });
        Then("close browser (\\w+)", (String brows) -> {
            DriverWrapper.getDriver().close();
            DriverWrapper.getDriver().quit();
            });


    }
}
