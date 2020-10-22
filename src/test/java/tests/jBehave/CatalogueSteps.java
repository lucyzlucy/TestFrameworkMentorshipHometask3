package tests.jBehave;

import applicationPages.navigationUtil.PageNavigationUtil;
import applicationPages.pages.CataloguePage;
import com.epam.training.framework.core.Log;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.assertj.core.api.Assertions.assertThat;

public class steps {

    CataloguePage catalogue;


    @Given("user navigates to Catalogue")
    public void navigateToCatalogue() {
        catalogue = PageNavigationUtil.toCatalogue();
    }

    @When("user chooses '$category'")
    public void chooseCategory(@Named("category") String category) {
//        searchResultPage = PageNavigationUtil.toMainPage().writeButton(address);

    }

//    @When("user filter results by time - $criteria")
//    public void filterByTime(String criteria) {
//        searchResultPage.filterResultsByTime();
//    }
//
//    @Then("default time filter changed to - $criteria")
//    public void verifyDefaultFilterChanged(String criteria){
//        assertThat(searchResultPage.getSelectedFilter().getText()).isEqualTo("За минулі 24 години");
//    }
//
//    @Then("$address search page opened")
//    public void addressSearchPageOpened(String address) {
//        assertThat(searchResultPage.getSearchTitle()).as("wrong text").isEqualTo("Пошук");
//    }
//
//    @Then("first link contains $searchWord")
//    public void linkContains(String searchWord) {
//        assertThat(searchResultPage.getFirstResult()).contains(searchWord);
//    }

}
