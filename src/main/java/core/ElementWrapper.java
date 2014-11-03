package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.base.Function;

public class ElementWrapper {

    public static WebElement find(final By by) {
        return DriverWrapper.getFindFluentWait().until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return AutomationWait.waitVisibleClickable(driver.findElement(by));
              }
            });
    }
}