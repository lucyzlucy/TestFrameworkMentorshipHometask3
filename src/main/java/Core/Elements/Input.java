package Core.Elements;

import org.openqa.selenium.WebElement;

import Core.Interfaces.Elements.IInput;

public class Input implements IInput {
        WebElement base;
        public Input(WebElement base) {
            this.base = base;
        }
    public void write(String str) {
        base.sendKeys(str);
    }
}
