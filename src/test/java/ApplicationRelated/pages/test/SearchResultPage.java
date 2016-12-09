package ApplicationRelated.pages.test;


import ApplicationRelated.pages.test.BasePage;
import core.ElementWrapper;
import core.elements.Input;
import lombok.Getter;
import org.openqa.selenium.By;

public class SearchResultPage extends BasePage {
    @Getter
    private Input str = new Input(ElementWrapper.find(By.name("q")));

    public String getSearchTitle() {
        return str.getSearchTitle();
    }
}
