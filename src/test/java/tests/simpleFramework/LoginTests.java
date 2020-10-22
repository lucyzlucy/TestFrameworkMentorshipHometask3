package tests.simpleFramework;

import applicationPages.navigationUtil.PageNavigationUtil;
import applicationPages.pages.BasePage;
import applicationPages.pages.LoginPage;
import applicationPages.pages.MainPage;
import com.epam.training.framework.core.Listener;
import com.epam.training.framework.core.entityBuilders.entities.User;
import com.epam.training.framework.core.factory.UserFactory;
import com.epam.training.framework.utils.StringGenerateUtils;
import dataProvider.TestDataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import static applicationPages.navigationUtil.PageNavigationUtil.*;
import static com.epam.training.framework.data.TestData.*;

@Listeners(Listener.class)
public class LoginTests extends BaseTest {
    @Test
    public void userCanNavigateToLoginPageFromMain() {
        LoginPage page =
                toMainPage()
                        .openLoginPage();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(page.getUrl(), LOGIN_PAGE_URL, "The user navigates to login page");
        softAssert.assertAll();

    }

    @Test
    public void verifyCanLoginWithValidCredentials() {
        User user = UserFactory.getExistingUser();

        MainPage page =
                toLoginPage()
                        .submitLoginCredentials(user.getEmail(), user.getPassword());

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(page.getUrl(), (MAIN_PAGE_URL), "The user is redirected to main page");
        softAssert.assertTrue(page.logoutButtonIsVisible(), "The logout link is shown");
        softAssert.assertAll();

    }

    @Test
    public void verifyCannotSubmitEmptyFields() {
        BasePage page =
                toLoginPage()
                        .submitLoginCredentials();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(page.getUrl(), LOGIN_PAGE_URL, "The user stays on login page");
        softAssert.assertAll();

    }

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "invalidEmails")
    public void verifyCannotLoginWithInvalidEmail(String invalidEmail) {
        BasePage page =
                toLoginPage()
                        .submitLoginCredentialsInvalid(StringGenerateUtils.getEmail(), invalidEmail);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(page.getUrl(), LOGIN_PAGE_URL, "The user stays on login page");
        softAssert.assertAll();

    }


    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "invalidPasswords")
    public void verifyCannotLoginWithInvalidPassword(String invalidPassword) {
        BasePage page =
                toLoginPage()
                        .submitLoginCredentialsInvalid(StringGenerateUtils.getEmail(), invalidPassword);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(page.getUrl(), LOGIN_PAGE_URL, "The user stays on login page");
        softAssert.assertAll();

    }

    @Test
    public void verifyCannotLoginWithIncorrectCredentials() {
        BasePage page =
                toLoginPage()
                        .submitLoginCredentialsInvalid(StringGenerateUtils.getEmail(), PASSWORD);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(page.getUrl(), LOGIN_PAGE_URL, "The user stays on login page");
        softAssert.assertAll();

    }

    @Test
    public void verifyCanLogout() {
        BasePage page =
                toLoginPage()
                        .submitLoginCredentials(USERNAME, PASSWORD)
                        .clickOnLogout();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(page.getUrl(), (MAIN_PAGE_URL), "The user is redirected to main page");
        softAssert.assertTrue(page.loginButtonIsVisible(), "The login link is shown");
        softAssert.assertAll();

    }

}