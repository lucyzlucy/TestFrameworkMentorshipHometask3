package TestFolder;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Core.Listener;
import Navigations.Navitation;
import Page.MainPage;
import Page.SoftServeMain;

@Listeners(Listener.class)
public class TestClass {
    @Test
    public void testsomething() {
        Navitation.toMainPage().writeButton(MainPage.FIND_MESSAGE);
        assertThat(Navitation.toSoftserve().getUrl()).as("Fail URL").isEqualTo(SoftServeMain.URL_ADDRESS);
    }
}