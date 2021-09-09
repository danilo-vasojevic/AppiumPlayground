package unibet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("Search Feature")
public class SearchFeatureTest extends Runner {

    @Test
    @DisplayName("Search criteria is entered in input field on search results page")
    void searchFromMenu() {
        getHomePage()
                .closeWelcomeModal()
                .acceptCookies()
                .performSearch("football")
                // Goes to SearchResultsPage
                .assertValueOfSearchField("football");
    }

    @Test
    @DisplayName("No search Results for search term")
    public void noResultsSearch() {
        String searchCriteria = "123123";
        getSearchResultPage(searchCriteria)
                .assertValueOfSearchField(searchCriteria)
                .assertNoResultsDisplayed();
    }

    @Test
    @DisplayName("Entering search term suggests pages")
    public void searchSuggestions() {
        getSearchResultPage("")
                .enterSearchCriteria("football")
                .assertNumberOfSuggestions(5);
    }

    @Test
    @DisplayName("Popular search term gives 100 results")
    public void popularSearchResultLimit() {
        getSearchResultPage("football")
                .assertNumberOfResults(100);
    }
}
