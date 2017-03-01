package JBehave;

import ApplicationRelated.navigations.Navitation;
import ApplicationRelated.pages.test.SearchResultPage;
import core.Log;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Andrii_Valkovskyi on 2/28/2017.
 */
public class steps {
    SearchResultPage searchResultPage;

    @Given("selenium")
    public void selenium() {
        Log.log("In selenium module");
    }
    @When("user googles $address")
    public void googles(String address) {
        searchResultPage = Navitation.toMainPage().writeButton(address);

    }

    @Then("$address search page opened")
    public void addressSearchPageOpened(String address){
        assertThat(searchResultPage.getSearchTitle()).as("wrong text").isEqualTo("Пошук");
    }

}
