package unibet.pageObject.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import unibet.pageObject.components.MainMenu;
import unibet.pageObject.components.WelcomeBonusModal;
import unibet.pageObject.pages.base.BasePage;

public class HomePage extends BasePage {
    // Components
    private WelcomeBonusModal welcomeBonusModal;
    private MainMenu mainMenu;

    // Elements
    @FindBy(xpath = "./img")
    private MobileElement resultImage;
    @FindBy(xpath = "//a[@id='CybotCookiebotDialogBodyButtonAccept']")
    private MobileElement acceptCookiesButton;

    public HomePage(AppiumDriver driver) {
        super(driver);
        // Init. components
        welcomeBonusModal = new WelcomeBonusModal(driver);
        mainMenu = new MainMenu(driver);
    }

    // Steps
    public HomePage closeWelcomeModal() {
        welcomeBonusModal.closeModal();
        return this;
    }

    public HomePage acceptCookies() {
        try {
            acceptCookiesButton.click();
        } catch (NoSuchElementException ignored) {
        }
        return this;
    }

    public SearchResultPage performSearch(String searchCriteria) {
        mainMenu.searchFor(searchCriteria);
        return new SearchResultPage(driver);
    }
}
