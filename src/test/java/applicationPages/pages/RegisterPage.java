package applicationPages.pages;

import com.epam.training.framework.core.elements.*;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends LoginPage {
    @FindBy(id = "spree_user_password_confirmation")
    private Input passConfirmInput;

    @FindBy(id = "errorExplanation")
    private Label errorMessageBlock;

    @Override
    public MainPage submitLoginCredentials(String email, String password) {
        passConfirmInput.write(password);
        return super.submitLoginCredentials(email, password);
    }


    @Override
    public RegisterPage submitLoginCredentialsInvalid(String email, String password) {
        passConfirmInput.write(password);
        return (RegisterPage) super.submitLoginCredentialsInvalid(email, password);
    }

    public RegisterPage submitLoginCredentialsDifferentPass(String email, String password, String invalidPassword) {
        passConfirmInput.write(invalidPassword);
        return (RegisterPage) super.submitLoginCredentialsInvalid(email, password);
    }

    public boolean errorMessageIsVisible() {
        return errorMessageBlock.isDisplayed();
    }

    public String errorMessageContainsText() {
        return errorMessageBlock.getLabelText();
    }


}