package simpleFramework;

import applicationPages.navigationUtil.PageNavigationUtil;
import applicationPages.pages.BasePage;
import applicationPages.pages.LoginPage;
import com.epam.training.framework.core.Listener;
import com.epam.training.framework.utils.StringGenerateUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static data.TestData.LOGIN_PAGE_URL;
import static data.TestData.MAIN_PAGE_URL;
import static org.assertj.core.api.Assertions.assertThat;

@Listeners(Listener.class)
public class LoginTests {
    @Test
    public void userCanNavigateToLoginPageFromMain() {
        LoginPage loginPage = PageNavigationUtil.toMainPage().openLoginPage();
        assertThat(loginPage.getUrl()).isEqualTo(LOGIN_PAGE_URL);
    }

    @Test
    public void verifyCannotSubmitEmptyFields() {
        BasePage page = PageNavigationUtil.toLoginPage().submitLoginCredentials();
        assertThat(page.getUrl()).isEqualTo(LOGIN_PAGE_URL);
    }

    @Test
    public void verifyCannotLoginWithInvalidCredentials() {
        BasePage page = PageNavigationUtil.toLoginPage().submitLoginCredentialsInvalid(StringGenerateUtils.getEmail(), "123456");
        assertThat(page.getUrl()).isEqualTo(LOGIN_PAGE_URL);
    }

    @Test
    public void verifyCanLoginWithValidCredentials() {
        BasePage page = PageNavigationUtil.toLoginPage().submitLoginCredentials("ltuteiko@gmail.com", "123456");
        assertThat(page.getUrl()).isEqualTo(MAIN_PAGE_URL);
    }

//    @Test
//    public void testsomething2() {
//        PageNavigationUtil.toMainPage().writeButton(MainPage.FIND_MESSAGE);
//        assertThat(PageNavigationUtil.toSoftserve().getUrl()).as("Fail URL").isEqualTo(EpamMain.URL_ADDRESS_FAIL);
//    }

}