package core.elements;

import org.openqa.selenium.WebElement;

import core.interfaces.elements.IButton;

public class Button implements IButton {
    WebElement base;
    public Button(WebElement base) {
        this.base = base;
    }
    public void click() {
        base.click();
    }
}
