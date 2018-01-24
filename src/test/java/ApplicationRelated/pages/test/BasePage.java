package ApplicationRelated.pages.test;

import core.DriverWrapper;
import core.elements.FieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage() {
        PageFactory.initElements(new FieldDecorator(DriverWrapper.getDriver()), this);
    }

}
