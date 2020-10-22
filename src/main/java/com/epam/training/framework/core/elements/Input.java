package com.epam.training.framework.core.elements;

import org.openqa.selenium.WebElement;

import com.epam.training.framework.core.interfaces.elements.IInput;

public class Input extends Element implements IInput {

    public Input(final WebElement base) {
        super(base);
    }
    public void write(String str) {
        base.sendKeys(str);
    }
    public void clearContent() {
        base.clear();
    }
    public String getSearchTitle() {
        return base.getAttribute("title");
    }

    public void submit() {
        base.submit();
    }
    public void click() {
        base.click();
    }
}