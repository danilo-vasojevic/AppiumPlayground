package unibet.pageObject.components;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import unibet.pageObject.components.base.BaseComponent;

import static java.time.Duration.ofSeconds;
import static unibet.Utils.pause;

@FindBy(xpath = "//*[@class='bx-align']")
public class WelcomeBonusModal extends BaseComponent {
    // Elements
    @FindBy(xpath = ".//a[@data-click='close' and contains(@id, 'inside')]")
    private MobileElement closeButton;

    public WelcomeBonusModal(AppiumDriver driver) {
        super(driver);
    }

    // Core Steps
    public void closeModal() {
        pause(ofSeconds(5));
        try {
            closeButton.click();
        } catch (NoSuchElementException ignored) {
        }
    }
}
