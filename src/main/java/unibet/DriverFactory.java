package unibet;

import io.appium.java_client.AppiumDriver;
import lombok.Getter;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.MobileCapabilityType.AUTOMATION_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.BROWSER_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.DEVICE_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.PLATFORM_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.PLATFORM_VERSION;

public class DriverFactory {

    @Getter static final Configuration config = ConfigFactory.create(Configuration.class);
    @Getter static AppiumDriver driver;


    private static DesiredCapabilities getCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(PLATFORM_NAME, config.platform());
        caps.setCapability(PLATFORM_VERSION, config.platformVersion());
        caps.setCapability(AUTOMATION_NAME, config.automationName());
        caps.setCapability(BROWSER_NAME, config.browser());
        caps.setCapability(DEVICE_NAME, config.deviceName());
        return caps;
    }

    public static AppiumDriver getAppiumDriver() {
        if(driver != null) return driver;

        String appiumServerURL = String.format("http://%s:%s/wd/hub", config.hostname(), config.port());
        try {
            driver = new AppiumDriver(new URL(appiumServerURL), getCapabilities());
            return driver;
        } catch (MalformedURLException e) {
            // TODO: Add meaningful error handling
        } catch (WebDriverException e) {
            // TODO: Here we could handle web driver errors
            throw e;
        }
        throw new WebDriverException("Could not initialize Appium driver properly.");
    }
}
