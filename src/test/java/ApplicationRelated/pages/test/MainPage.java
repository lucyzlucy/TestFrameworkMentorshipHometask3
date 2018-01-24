package ApplicationRelated.pages.test;

import core.ElementWrapper;
import core.Log;
import core.elements.Input;
import lombok.Getter;
import org.openqa.selenium.By;

public class MainPage extends BasePage {
    public static final String FIND_MESSAGE = "selenium";

    @Getter private Input str = new Input(ElementWrapper.find(By.name("q")));

    public SearchResultPage writeButton(String message) {
        Log.log(String.format("writting %s to Button", message));
        str.write(message);
        str.submit();
        return new SearchResultPage();
    }
}