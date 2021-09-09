package unibet;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import unibet.pageObject.pages.HomePage;
import unibet.pageObject.pages.SearchResultPage;

import static unibet.DriverFactory.config;
import static unibet.DriverFactory.getAppiumDriver;
import static unibet.DriverFactory.getConfig;


public class Runner {

    // Pages
    private HomePage homePage;
    private SearchResultPage searchResultPage;

    @BeforeAll
    static void beforeAll() {
    }

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(getAppiumDriver());
        searchResultPage = new SearchResultPage(getAppiumDriver());
    }

    @AfterEach
    void afterEach() {
        getAppiumDriver().quit();
    }

    @AfterAll
    static void afterAll() {
        // Cleanup db, test data, workspace, memory etc.
    }

    public HomePage getHomePage() {
        getAppiumDriver().get(getConfig().baseUrl());
        return homePage;
    }

    public SearchResultPage getSearchResultPage() {
        getAppiumDriver().get(config.baseUrl() + "/search");
        return searchResultPage;
    }
}
