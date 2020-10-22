package tests.simpleFramework;

import applicationPages.navigationUtil.PageNavigationUtil;
import applicationPages.pages.BasePage;
import applicationPages.pages.LoginPage;
import applicationPages.pages.MainPage;
import applicationPages.pages.RegisterPage;
import com.epam.training.framework.core.entityBuilders.entities.User;
import com.epam.training.framework.core.factory.UserFactory;
import com.epam.training.framework.utils.StringGenerateUtils;
import dataProvider.TestDataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static applicationPages.navigationUtil.PageNavigationUtil.*;
import static com.epam.training.framework.data.TestData.*;

public class RegisterTests extends BaseTest{

    @Test
    public void userCanNavigateToRegisterPageFromMain() {
        BasePage page =
                toMainPage()
                .openLoginPage()
                .openRegisterPage();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(page.getUrl(), REGISTER_PAGE_URL, "The user navigates to register page");
        softAssert.assertAll();

    }

    @Test
    public void verifyCanRegister() {
        User user = UserFactory.getNewUser();

        MainPage page =
                toRegisterPage()
                .submitLoginCredentials(user.getEmail(), user.getPassword());

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(page.getUrl(), (MAIN_PAGE_URL), "The user is redirected to main page");
        softAssert.assertTrue(page.logoutButtonIsVisible(), "The logout link is shown");
        softAssert.assertTrue(page.welcomeBlockIsVisible(), "ErrorMessage block is visible");
        softAssert.assertEquals(page.welcomeBlockContainsText(), (WELCOME_MESSAGE), "The welcoming message is correct");
        softAssert.assertAll();
    }

    @Test
    public void verifyCannotRegisterWithEmptyFields() {

        RegisterPage page =
                (RegisterPage) toRegisterPage()
                .submitLoginCredentials();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(page.getUrl(), (REGISTER_PAGE_URL), "The user stays on REGISTER page");
        softAssert.assertTrue(page.errorMessageIsVisible(), "ErrorMessage block is visible");
        softAssert.assertAll();

    }

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "invalidEmails")
    public void verifyCannotRegisterWithInvalidEmail(String invalidEmail) {

        RegisterPage page =
                toRegisterPage()
                .submitLoginCredentialsInvalid(invalidEmail, PASSWORD);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(page.getUrl(), (REGISTER_PAGE_URL), "The user stays on REGISTER page");
        softAssert.assertAll();

    }

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "invalidPasswords")
    public void verifyCannotRegisterWithInvalidPassword(String invalidPass) {

        RegisterPage page =
                toRegisterPage()
                .submitLoginCredentialsInvalid(StringGenerateUtils.getEmail(), invalidPass);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(page.getUrl(), (REGISTER_PAGE_URL), "The user stays on REGISTER page");
        softAssert.assertTrue(page.errorMessageIsVisible(), "ErrorMessage block is visible");
        softAssert.assertEquals(page.errorMessageContainsText(), (ERROR_WRONG_PASS), "The message about invalid pass is correct");
        softAssert.assertAll();

    }

    @Test
    public void verifyCannotRegisterWithEmptyPassword() {

        RegisterPage page =
                toRegisterPage()
                .submitLoginCredentialsInvalid(StringGenerateUtils.getEmail(), "      ");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(page.getUrl(), (REGISTER_PAGE_URL), "The user stays on REGISTER page");
        softAssert.assertTrue(page.errorMessageIsVisible(), "ErrorMessage block is visible");
        softAssert.assertEquals(page.errorMessageContainsText(), (ERROR_EMPTY_PASS), "The message about empty pass is correct");
        softAssert.assertAll();

    }

    @Test
    public void verifyCannotRegisterWithExistingEmail() {
        User user = UserFactory.getExistingUser();

        RegisterPage page =
                toRegisterPage()
                .submitLoginCredentialsInvalid(user.getEmail(), user.getPassword());


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(page.getUrl(), (REGISTER_PAGE_URL), "The user stays on REGISTER page");
        softAssert.assertTrue(page.errorMessageIsVisible(), "ErrorMessage block is visible");
        softAssert.assertEquals(page.errorMessageContainsText(), (ERROR_EXISTING_EMAIL), "The message about existing email is correct");


        softAssert.assertAll();

    }

    @Test
    public void verifyCannotRegisterPasswordsDoNotMatch() {
        RegisterPage page =
                toRegisterPage()
                .submitLoginCredentialsDifferentPass(StringGenerateUtils.getEmail(), PASSWORD, (PASSWORD + "aaaaa"));


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(page.getUrl(), (REGISTER_PAGE_URL), "The user stays on REGISTER page");
        softAssert.assertTrue(page.errorMessageIsVisible(), "ErrorMessage block is visible");
        softAssert.assertEquals(page.errorMessageContainsText(), (ERROR_WRONG_PASS_CONFIRM), "The message about pass confirmation is correct");


        softAssert.assertAll();

    }
}
