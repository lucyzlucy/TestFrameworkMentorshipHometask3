package com.epam.training.framework.core.elements;

import com.epam.training.framework.core.interfaces.elements.IElement;
import org.openqa.selenium.WebElement;

 class Element implements IElement {
    protected final WebElement base;

    public Element(final WebElement base) {
        this.base = base;
    }

    public boolean isDisplayed() {
        try {
            return this.base.isDisplayed();
        } catch (Throwable e) {
            return false;
        }
    }
}