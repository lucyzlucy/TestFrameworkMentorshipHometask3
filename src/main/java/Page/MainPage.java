package Page;

import lombok.Getter;

import org.openqa.selenium.By;

import Core.ElementWrapper;
import Core.Log;
import Core.Elements.Input;

public class MainPage extends BasePage{
    public static final String FIND_MESSAGE = "selenium";

    @Getter private Input str = new Input(ElementWrapper.find(By.name("q")));

    public SearchResultPage writeButton(String message) {
        Log.log(String.format("writting %s to Button", message));
        str.write(message);
        return new SearchResultPage();
    }
}