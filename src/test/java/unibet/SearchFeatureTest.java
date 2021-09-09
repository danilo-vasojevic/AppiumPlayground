package unibet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("Search Feature")
public class SearchFeatureTest extends Runner {

    @Test
    @DisplayName("Search criteria is entered in input field on search results page")
    void simpleTest() {
        getHomePage()
                .closeWelcomeModal()
                .acceptCookies()
                .performSearch("football")
                // Goes to SearchResultsPage
                .assertValueOfSearchField("football");
    }

    @Test
    @DisplayName("No search Results for search term")
    public void testMethod() {
        String searchCriteria = "123123";
        getSearchResultPage(searchCriteria)
                .assertValueOfSearchField(searchCriteria)
                .assertNoResultsDisplayed();
    }
}
