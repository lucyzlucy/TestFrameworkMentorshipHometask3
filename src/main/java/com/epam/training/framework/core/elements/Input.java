package com.epam.training.framework.core.elements;

import org.openqa.selenium.WebElement;

import com.epam.training.framework.core.interfaces.elements.IInput;

public class Input implements IInput {
        WebElement base;
        public Input(WebElement base) {
            this.base = base;
        }
    public void write(String str) {
        base.sendKeys(str);
    }
    public String getSearchTitle() {
        return base.getAttribute("title");
    }
    public void submit(){base.submit();}
}