package com.epam.training.framework.core.elements;

import org.openqa.selenium.WebElement;

import com.epam.training.framework.core.interfaces.elements.ILabel;

public class Label implements ILabel{
    WebElement base;
    public Label(WebElement base) {
        this.base = base;
    }
    public String getLabelText() {
        return base.getText();
    }
}
