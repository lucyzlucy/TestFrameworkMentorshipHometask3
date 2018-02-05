package cucumberJava.test2;

import applicationPages.navigationUtil.PageNavigationUtil;
import applicationPages.pages.SearchResultPage;
import com.epam.training.framework.core.DriverWrapper;
import com.epam.training.framework.core.Log;
import cucumber.api.java8.En;

import static org.assertj.core.api.Assertions.assertThat;

public class secondTest implements En {

    public secondTest() {
        Given("I google (\\w+)", (String url) -> {
            Log.log("second test");
            SearchResultPage searchResultPage = PageNavigationUtil.toMainPage().writeButton(url);
            assertThat(searchResultPage.getSearchTitle()).as("wrong text").isEqualTo("Пошук");
        });
        Then("close browser (\\w+)", (String brows) -> {
            DriverWrapper.getDriver().quit();
        });


    }
}
