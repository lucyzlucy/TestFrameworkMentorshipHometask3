package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import Utils.Propertiator;

public class DriverWrapper {
    private static WebDriver driver = null;

    private DriverWrapper() {
        EventFiringWebDriver eDriver = null;
        String type = Propertiator.getPropertie("driver");
        switch(type) {
        case "Chrome":
            eDriver  = new EventFiringWebDriver(new ChromeDriver());
            break;
        case "Firefox":
            eDriver  = new EventFiringWebDriver(new FirefoxDriver());
            break;
     }
        
      eDriver.register(new MyEventListener());
      driver = eDriver;
      driver.manage().window().maximize();
  }

    public static WebDriver getDriver() {
        if(driver != null) {
            return driver;
        } else {
            new DriverWrapper();
            return driver;
        }
    }
}
