package com.epam.training.framework.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.base.Function;

import java.util.List;

public class ElementWrapper {

    public static WebElement find(final By by) {
        return DriverWrapper.getFindFluentWait().until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return AutomationWait.waitVisibleClickable(driver.findElement(by));
              }
            });
    }
    public static WebElement findOne(final By by) {
        return DriverWrapper.getDriver().findElement(by);
    }

    public static List<WebElement> findList(final By by) {
        return DriverWrapper.getDriver().findElements(by);
    }
}