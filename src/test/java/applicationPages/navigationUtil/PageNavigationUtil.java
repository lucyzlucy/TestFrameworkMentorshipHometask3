package applicationPages.navigationUtil;


import applicationPages.pages.*;

import com.epam.training.framework.core.DriverWrapper;
import com.epam.training.framework.core.Log;

import static com.epam.training.framework.data.TestData.*;

public class PageNavigationUtil {
    
    public static void to(String url) {
        DriverWrapper.getDriver().navigate().to(url);
    }
    public static MainPage toMainPage() {
        Log.log("navigating to famo main page");
        DriverWrapper.getDriver().navigate().to(MAIN_PAGE_URL);
        return new MainPage();
    }

    public static LoginPage toLoginPage() {
        Log.log("navigating to login page");
        DriverWrapper.getDriver().navigate().to(LOGIN_PAGE_URL);
        return new LoginPage();
    }

    public static RegisterPage toRegisterPage() {
        Log.log("navigating to register page");
        DriverWrapper.getDriver().navigate().to(REGISTER_PAGE_URL);
        return new RegisterPage();
    }
    public static CataloguePage toCatalogue() {
        Log.log("navigating to catalogue page");
        DriverWrapper.getDriver().navigate().to(CATALOGUE_PAGE_URL);
        return new CataloguePage();
    }

    public static ProductPage toProductPage() {
        Log.log("navigating to product page");
        DriverWrapper.getDriver().navigate().to(PRODUCT_PAGE_URL);
        return new ProductPage();
    }

    public static CartPage toCartPage() {
        Log.log("navigating to cart page");
        DriverWrapper.getDriver().navigate().to(CART_PAGE_URL);
        return new CartPage();
    }

}