package com.epam.training.framework.core.elements;

import com.epam.training.framework.core.DriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import com.epam.training.framework.core.interfaces.elements.ILabel;

import java.util.List;

public class Label extends Element implements ILabel {
    public Label(final WebElement base) {
        super(base);
    }

    public String getLabelText() {
        return base.getText();
    }

    public String getLabelContent() {
        return base.getAttribute("content");
    }

    public String getTextNode() {
        String text = base.getText().trim();
        List<WebElement> children = base.findElements(By.xpath("./*"));
        for (WebElement child : children) {
            text = text.replaceFirst(child.getText(), "").trim();
        }
        return text;
    }

    public String getChildNodeText() {
        List<WebElement> children = base.findElements(By.xpath("./*"));
        return children.get(0).getText();
    }

    public WebElement getBase(){
        return this.base;
    }

}
