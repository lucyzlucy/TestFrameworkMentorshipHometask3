package page;

import core.DriverWrapper;

public class SoftServeMain extends BasePage {
    public static final String URL_ADDRESS = "http://softserve.ua/";
    public String getUrl() {

        return DriverWrapper.getDriver().getCurrentUrl();
    }
}