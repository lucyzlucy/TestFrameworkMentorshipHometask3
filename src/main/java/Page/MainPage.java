package Page;

import lombok.Getter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Core.DriverWrapper;
import Core.Log;
import Core.Elements.Input;

public class MainPage extends BasePage{
    public static final String FIND_MESSAGE = "selenium";

    private WebDriver driver = DriverWrapper.getDriver();
    @Getter private Input str = new Input(driver.findElement(By.name("q")));

    public SearchResultPage writeButton(String message) {
        Log.log(String.format("writting %s to Button", message));
        str.write(message);
        return new SearchResultPage();
    }
}
