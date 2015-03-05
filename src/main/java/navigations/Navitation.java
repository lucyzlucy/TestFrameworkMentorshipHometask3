package navigations;

import page.MainPage;
import page.SoftServeMain;
import core.DriverWrapper;
import core.Log;

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
        DriverWrapper.getDriver().navigate().to(SoftServeMain.URL_ADDRESS);
        return new SoftServeMain();
    }
}