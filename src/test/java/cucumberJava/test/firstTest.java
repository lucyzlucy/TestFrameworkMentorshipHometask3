package cucumberJava.test;


import ApplicationRelated.navigations.Navitation;
import ApplicationRelated.pages.test.SearchResultPage;
import core.DriverWrapper;
import cucumber.api.java8.En;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Andrii_Valkovskyi on 12/7/2016.
 */
public class firstTest implements En {

    public firstTest() {
        Given("I google (\\w+)", (String url) -> {
            SearchResultPage searchResultPage = Navitation.toMainPage().writeButton(url);
            assertThat(searchResultPage.getSearchTitle()).as("wrong text").isEqualTo("Пошук");
        });
        Then("close browser (\\w+)", (String brows) -> {
            DriverWrapper.getDriver().close();
            DriverWrapper.getDriver().quit();
            });


    }
}
