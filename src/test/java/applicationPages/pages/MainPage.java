package applicationPages.pages;

import com.epam.training.framework.core.DriverWrapper;
import com.epam.training.framework.core.ElementWrapper;
import com.epam.training.framework.core.Log;
import com.epam.training.framework.core.elements.Button;
import com.epam.training.framework.core.elements.Input;
import com.epam.training.framework.core.elements.Label;
import com.epam.training.framework.core.elements.Link;
import com.epam.training.framework.core.interfaces.elements.IElement;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(id = "flash-messages")
    private Label welcomeBlock;


    public boolean welcomeBlockIsVisible() {
        return welcomeBlock.isDisplayed();
    }

    public String welcomeBlockContainsText() {
        return welcomeBlock.getLabelText();
    }


}