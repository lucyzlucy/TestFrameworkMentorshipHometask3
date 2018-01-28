package ApplicationRelated.pages.test;

import com.epam.training.framework.core.DriverWrapper;
import com.epam.training.framework.core.elements.FieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage() {
        PageFactory.initElements(new FieldDecorator(DriverWrapper.getDriver()), this);
    }

}
