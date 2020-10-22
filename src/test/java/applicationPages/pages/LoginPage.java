package applicationPages.pages;

import com.epam.training.framework.core.elements.Button;
import com.epam.training.framework.core.elements.Input;
import org.openqa.selenium.support.FindBy;
import com.epam.training.framework.core.elements.Link;


public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@name='commit']")
    private Button loginButton;

    @FindBy(id = "spree_user_email")
    protected Input emailInput;

    @FindBy(id = "spree_user_password")
    protected Input passInput;

    @FindBy(xpath = "//p[@class='login-text']/a[@href='/signup']")
    private Link registerLink;

    public RegisterPage openRegisterPage() {
        registerLink.click();
        return new RegisterPage();
    }

    public LoginPage submitLoginCredentials() {
        loginButton.click();
        return this;
    }

    public MainPage submitLoginCredentials(String email, String password) {
        emailInput.write(email);
        passInput.write(password);
        loginButton.click();
        return new MainPage();
    }

    public LoginPage submitLoginCredentialsInvalid(String email, String password) {
        emailInput.write(email);
        passInput.write(password);
        loginButton.click();
        return this;
    }

    public LoginPage clickOnSignupLink (){
        registerLink.click();
        return new RegisterPage();
    }


}