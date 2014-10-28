package Core.Elements;

import org.openqa.selenium.WebElement;

import Core.Interfaces.Elements.IButton;

public class Button implements IButton {
    WebElement base;
    public Button(WebElement base) {
        this.base = base;
    }
    public void click() {
        base.click();
    }
}
