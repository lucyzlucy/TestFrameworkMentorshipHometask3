package com.epam.training.framework.core.elements;

import org.openqa.selenium.WebElement;

import com.epam.training.framework.core.interfaces.elements.ILink;

public class Link implements ILink{
    WebElement base;
    public Link(WebElement base) {
        this.base = base;
    }
    public void click() {
        base.click();
    }
    public String getLinkText() {
        return base.getText();
    }
}
