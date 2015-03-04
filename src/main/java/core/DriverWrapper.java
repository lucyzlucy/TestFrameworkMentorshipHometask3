package core;

import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import io.selendroid.standalone.SelendroidConfiguration;
import io.selendroid.standalone.SelendroidLauncher;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import utils.Propertiator;

public class DriverWrapper {
    private static WebDriver driver = null;
    private static FluentWait<WebDriver> wait = null;

    private DriverWrapper() {
        EventFiringWebDriver eDriver = null;
        SelendroidDriver sDriver = null;
        String type = Propertiator.getPropertie("driver");
        switch(type) {
        case "Chrome":
            eDriver  = new EventFiringWebDriver(new ChromeDriver());
            break;
        case "Firefox":
            eDriver  = new EventFiringWebDriver(new FirefoxDriver());
            break;
        case "Selen":
            SelendroidConfiguration config = new SelendroidConfiguration();
            config.addSupportedApp("selendroid-test-app-0.15.0.apk");
            SelendroidLauncher selendroidServer = new SelendroidLauncher(config);
            selendroidServer.launchSelendroid();
            SelendroidCapabilities caps = new SelendroidCapabilities("io.selendroid.testapp:0.15.0");
            try {
                sDriver = new SelendroidDriver(caps);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            break;
     }
      eDriver.register(new MyEventListener());
      if(driver!=null){
          driver = eDriver;
          driver.manage().window().maximize();
      }
      else {
          driver = sDriver;
      }
  }

    public static WebDriver getDriver() {
        if(driver != null) {
            return driver;
        } else {
            new DriverWrapper();
            return driver;
        }
    }
    
    public static FluentWait<WebDriver> getFindFluentWait() {
       getFluentWait().withTimeout(30, TimeUnit.SECONDS)
                    .pollingEvery(5, TimeUnit.SECONDS)
                    .ignoring(NoSuchElementException.class);
            return wait;
        }
    
    public static FluentWait<WebDriver> getFluentWait() {
        if(wait != null) {
            return wait;
        } else {
            wait =  new FluentWait<WebDriver>(driver);
            return wait;
        }
    }
    
}
