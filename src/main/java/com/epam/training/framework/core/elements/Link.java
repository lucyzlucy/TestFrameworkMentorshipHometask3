package com.epam.training.framework.core.elements;

import org.openqa.selenium.WebElement;

import com.epam.training.framework.core.interfaces.elements.ILink;

public class Link extends Element implements ILink {

    public Link(final WebElement base) {
        super(base);
    }
    public void click() {
        base.click();
    }

    public String getLinkText() {
        return base.getText();
    }

}
