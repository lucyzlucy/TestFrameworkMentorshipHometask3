package applicationPages.pages;

import com.epam.training.framework.core.DriverWrapper;

public class LoginPage extends BasePage {
    public static final String URL_ADDRESS_FAIL = "https://www.epam1.com/";
    public static final String URL_ADDRESS = "https://www.epam.com/";

    public String getUrl() {
        return DriverWrapper.getDriver().getCurrentUrl();
    }
}