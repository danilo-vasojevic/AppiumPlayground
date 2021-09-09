package unibet.pageObject.components;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import unibet.pageObject.components.base.BaseComponent;

@FindBy(xpath = ".//*[@class='qq-Pyd4MklQfqSfWC1B5j']/a")
public class SearchResult extends BaseComponent {
    // Elements
    @FindBy(xpath = "./img")
    private MobileElement resultImage;
    @FindBy(xpath = ".//h1")
    private MobileElement resultTitle;
    @FindBy(xpath = ".//p")
    private MobileElement resultContent;

    public SearchResult(AppiumDriver driver) {
        super(driver);
    }
}
