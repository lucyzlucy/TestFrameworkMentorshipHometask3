package com.epam.training.framework.core;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.epam.training.framework.utils.Propertiator;

public class DriverWrapper {
    private static final ThreadLocal<WebDriver> DRIVER_CONTAINER = new ThreadLocal<>();
    private static WebDriver driver = null;
    private static FluentWait<WebDriver> wait = null;


    private DriverWrapper() {
        EventFiringWebDriver eDriver = null;
        String type = Propertiator.getPropertie("driver");
        switch (type) {
            case "Chrome":

                // Path path = Paths.get(System.getProperty("user.dir")+"\\chromedriver.exe");
                ChromeDriverService service = new ChromeDriverService.Builder()
                        .usingDriverExecutable(new File(System.getProperty("user.dir") + "\\chromedriver.exe"))
                        .usingAnyFreePort()
                        .build();
                try {
                    service.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                eDriver = new EventFiringWebDriver(new RemoteWebDriver(service.getUrl(),
                        DesiredCapabilities.chrome()));
                break;
            case "Firefox":
                eDriver = new EventFiringWebDriver(new FirefoxDriver());
                break;
        }
        eDriver.register(new MyEventListener());
        driver = eDriver;
//          driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return DRIVER_CONTAINER.get();

    }

    public static void setDriver() {
        new DriverWrapper();
        DRIVER_CONTAINER.set(driver);
    }

    public static FluentWait<WebDriver> getFindFluentWait() {
        getFluentWait().withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        return wait;
    }

    public static FluentWait<WebDriver> getFluentWait() {
        if (wait != null) {
            return wait;
        } else {
            wait = new FluentWait<WebDriver>(driver);
            return wait;
        }
    }

    public static void killDriverInstance() {
        if (DRIVER_CONTAINER.get() != null) {
            DRIVER_CONTAINER.get().quit();
            DRIVER_CONTAINER.remove();
        }
    }

}
