package fluentInterface;

import applicationPages.navigationUtil.PageNavigationUtil;
import applicationPages.pages.MainPage;
import applicationPages.pages.EpamMain;
import com.epam.training.framework.core.Listener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Listeners(Listener.class)
public class TestExample {
    @Test
    public void testsomething() {
        PageNavigationUtil.toMainPage().writeButton(MainPage.FIND_MESSAGE);
        assertThat(PageNavigationUtil.toSoftserve().getUrl()).as("Fail URL").isEqualTo(EpamMain.URL_ADDRESS);
    }
    @Test
    public void testsomething1() {
        PageNavigationUtil.toMainPage().writeButton(MainPage.FIND_MESSAGE);
        assertThat(PageNavigationUtil.toSoftserve().getUrl()).as("Fail URL").isEqualTo(EpamMain.URL_ADDRESS_FAIL);
    }
    @Test
    public void testsomething2() {
        PageNavigationUtil.toMainPage().writeButton(MainPage.FIND_MESSAGE);
        assertThat(PageNavigationUtil.toSoftserve().getUrl()).as("Fail URL").isEqualTo(EpamMain.URL_ADDRESS_FAIL);
    }

}