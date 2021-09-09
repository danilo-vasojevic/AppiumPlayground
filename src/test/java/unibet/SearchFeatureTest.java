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
                // Accept cookies
                .performSearch("football")
                .assertValueOfSearchField("football");
    }


}
