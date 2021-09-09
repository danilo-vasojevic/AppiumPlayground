package unibet.pageObject.components;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import unibet.pageObject.components.base.BaseComponent;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;
import static unibet.Utils.pause;

@FindBy(xpath = "//*[contins(@class, '_2ad3bkGSi1gMUuL44NeoUd']")
public class MainMenu extends BaseComponent {
    // Elements
    @FindBy(xpath = "//*[contains(@class, '_2zBdlixhoC1aMeu3UOVfQF')]")
    private MobileElement expandMenu;
    @FindBy(xpath = ".//input[contains(@class, '_2wd9gLhmkYlXBxVhBXNH6i')]")
    private MobileElement search;

    public MainMenu(AppiumDriver driver) {
        super(driver);
    }

    // Core Steps
    public void searchFor(String searchQuery) {
        expandMenu.click();
        // TODO: Replace explicit wait with impllicit waiting for menu to expand
        pause(ofSeconds(2)); // Menu expanding
        search.sendKeys(searchQuery + Keys.ENTER);
    }
}
