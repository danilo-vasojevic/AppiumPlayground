package unibet.pageObject.components.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static java.time.Duration.ofSeconds;

public class BaseComponent {
    protected AppiumDriver driver;

    public BaseComponent(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, ofSeconds(5)), this);
    }
}
