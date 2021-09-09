package unibet.pageObject.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import unibet.pageObject.components.MainMenu;
import unibet.pageObject.components.SearchResult;
import unibet.pageObject.pages.base.BasePage;

import java.util.List;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static unibet.Utils.pause;

public class SearchResultPage extends BasePage {
    // Components
    private MainMenu mainMenu;

    // Elements
    @FindBy(xpath = "//*[contains(@class, '_3Hr3qONzU09D2EpcszWrzd')]")
    private MobileElement searchInput;
    @FindBy(xpath = "//h1[@class='_3j1YMd3zjL1xNt87XF8hqO']")
    private MobileElement noResultsNotice;
    @FindBy(xpath = "//ul[@class='_1p7av0gr']/li//a")
    private List<MobileElement> suggestions;
    @FindBy(xpath = ".//*[contains(@class, '_2yltr7pih7eh3s3dI8W38D')]")
    private List<MobileElement> results;

    public SearchResultPage(AppiumDriver driver) {
        super(driver);
        // Init. components
        mainMenu = new MainMenu(driver);
    }

    // Steps
    public SearchResultPage enterSearchCriteria(String query) {
        searchInput.sendKeys(query);
        return this;
    }
    public void assertNumberOfResults(int expNum) {
        // TODO: Replace with implicit waiting
        pause(ofSeconds(5));
        assertEquals(
                expNum, results.size(),
                "Wrong number of search results"
        );
    }

    public void assertNumberOfSuggestions(int expNum) {
        pause(ofSeconds(5));
        assertEquals(
                expNum, suggestions.size(),
                "Wrong number of search suggestions"
        );
    }

    public void assertNoResultsDisplayed() {
        pause(ofSeconds(2));
        assertTrue(noResultsNotice.isDisplayed());
    }

    public SearchResultPage assertValueOfSearchField(String expected) {
        assertEquals(searchInput.getAttribute("value"), expected);
        return this;
    }
}
