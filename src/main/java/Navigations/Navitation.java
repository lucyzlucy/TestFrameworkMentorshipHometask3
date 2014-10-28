package Navigations;

import Core.DriverWrapper;
import Core.Log;
import Page.MainPage;
import Page.SoftServeMain;

public class Navitation {
    
    public static void to(String url) {
        DriverWrapper.getDriver().navigate().to(url);
    }
    public static MainPage toMainPage() {
        Log.log("navigating to google.com");
        DriverWrapper.getDriver().navigate().to("http://www.google.com");
        return new MainPage();
    }
    public static SoftServeMain toSoftserve() {
        Log.log("navigation to softserve.com");
        DriverWrapper.getDriver().navigate().to("http://softserve.ua");
        return new SoftServeMain();
    }
}
