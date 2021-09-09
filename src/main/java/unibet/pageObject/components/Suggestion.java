package unibet.pageObject.components;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import unibet.pageObject.components.base.BaseComponent;

@FindBy(xpath = "//ul[@class='_1p7av0gr']/li//a")
public class Suggestion extends BaseComponent {
    // Elements

    public Suggestion(AppiumDriver driver) {
        super(driver);
    }
}
