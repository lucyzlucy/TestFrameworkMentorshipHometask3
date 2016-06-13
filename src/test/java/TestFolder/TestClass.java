package TestFolder;

import static org.assertj.core.api.Assertions.assertThat;
import ApplicationRelated.navigations.Navitation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ApplicationRelated.pages.test.MainPage;
import ApplicationRelated.pages.test.SoftServeMain;
import core.DriverWrapper;
import core.Listener;

@Listeners(Listener.class)
public class TestClass {
    @Test
    public void testsomething() {
        Navitation.toMainPage().writeButton(MainPage.FIND_MESSAGE);
        assertThat(Navitation.toSoftserve().getUrl()).as("Fail URL").isEqualTo(SoftServeMain.URL_ADDRESS);
    }
    @Test
    public void testsomething1() {
        Navitation.toMainPage().writeButton(MainPage.FIND_MESSAGE);
        assertThat(Navitation.toSoftserve().getUrl()).as("Fail URL").isEqualTo(SoftServeMain.URL_ADDRESS_FAIL);
    }
    @Test
    public void testsomething2() {
        Navitation.toMainPage().writeButton(MainPage.FIND_MESSAGE);
        assertThat(Navitation.toSoftserve().getUrl()).as("Fail URL").isEqualTo(SoftServeMain.URL_ADDRESS_FAIL);
    }

    @Test
    public void assertUserAccountCanRegistered() throws Exception {
        WebDriver driver = DriverWrapper.getDriver();
        WebElement inputField = driver.findElement(By.id("my_text_field"));
        //enter a text into the text field
        inputField.sendKeys("Selendroid");
        //check if the text has been entered into the text field
        assertThat(true);
    }
}