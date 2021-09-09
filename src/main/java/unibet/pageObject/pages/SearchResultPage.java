package unibet.pageObject.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import unibet.pageObject.components.MainMenu;
import unibet.pageObject.pages.base.BasePage;

import javax.naming.directory.SearchResult;
import java.util.List;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static unibet.Utils.pause;

public class SearchResultPage extends BasePage {
    // Components
    private MainMenu mainMenu;
    private List<SearchResult> results;

    // Elements
    @FindBy(xpath = "//*[contains(@class, '_3Hr3qONzU09D2EpcszWrzd')]")
    private MobileElement searchInput;
    @FindBy(xpath = "//h1[@class='_3j1YMd3zjL1xNt87XF8hqO']")
    private MobileElement noResultsNotice;

    public SearchResultPage(AppiumDriver driver) {
        super(driver);
        // Init. components
        mainMenu = new MainMenu(driver);
    }

    // Steps
    public void assertNumberOfResults(int expNum) {
        // TODO: Replace with implicit waiting
        pause(ofSeconds(5));
        assertEquals(
                results.size(), expNum,
                "Wrong number of search results"
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
