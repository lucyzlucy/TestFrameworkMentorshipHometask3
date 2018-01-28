package com.epam.training.framework.core.elements;

import org.openqa.selenium.WebElement;

import com.epam.training.framework.core.interfaces.elements.IButton;

public class Button implements IButton {
    WebElement base;
    public Button(WebElement base) {
        this.base = base;
    }
    public void click() {
        base.click();
    }

    public String getButtonText(){
        return base.getAttribute("aria-label");
    }

    public WebElement getBase() {
        return base;
    }
    public String getText(){
        return base.getText();
    }
}
