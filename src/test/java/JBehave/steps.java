package JBehave;

import ApplicationRelated.navigations.Navitation;
import ApplicationRelated.pages.test.SearchResultPage;
import core.Log;
import org.jbehave.core.annotations.Given;
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

    @When("user google $address")
    public void google(String address) {
        searchResultPage = Navitation.toMainPage().writeButton(address);

    }

    @When("user filter results by time - $criteria")
    public void filterByTime(String criteria) {
        searchResultPage.filterResultsByTime();
    }

    @Then("default time filter changed to - $criteria")
    public void verifyDefaultFilterChanged(String criteria){
        assertThat(searchResultPage.getSelectedFilter().getText()).isEqualTo("За минулі 24 години");
    }

    @Then("$address search page opened")
    public void addressSearchPageOpened(String address) {
        assertThat(searchResultPage.getSearchTitle()).as("wrong text").isEqualTo("Пошук");
    }

    @Then("first link contains $searchWord")
    public void linkContains(String searchWord) {
        assertThat(searchResultPage.getFirstResult()).contains(searchWord);
    }

}
