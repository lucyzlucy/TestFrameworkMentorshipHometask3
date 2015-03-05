package core.elements;

import org.openqa.selenium.WebElement;

import core.interfaces.elements.ILabel;

public class Label implements ILabel{
    WebElement base;
    public Label(WebElement base) {
        this.base = base;
    }
    public String getLabelText() {
        return base.getText();
    }
}
