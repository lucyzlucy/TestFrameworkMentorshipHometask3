package com.epam.training.framework.core.elements;

import org.openqa.selenium.WebElement;

import com.epam.training.framework.core.interfaces.elements.IButton;

public class Button extends Element implements IButton {

    public Button(final WebElement base) {
        super(base);
    }

    public void click() {
        base.click();
    }

    public String getButtonText() {
        return base.getAttribute("aria-label");
    }

    public WebElement getBase() {
        return base;
    }

    public String getText() {
        return base.getText();
    }
}
