package TestFolder;

import static org.assertj.core.api.Assertions.assertThat;
import navigations.Navitation;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import page.MainPage;
import page.SoftServeMain;
import core.Listener;

@Listeners(Listener.class)
public class TestClass {
    @Test
    public void testsomething() {
        Navitation.toMainPage().writeButton(MainPage.FIND_MESSAGE);
        assertThat(Navitation.toSoftserve().getUrl()).as("Fail URL").isEqualTo(SoftServeMain.URL_ADDRESS);
    }
}