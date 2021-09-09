package unibet;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:configuration.properties"})
public interface Configuration extends Config {
    // Optional parameters
    @DefaultValue("9999")
    int port();

    @DefaultValue("0.0.0.0")
    String hostname();

    // Mandatory parameters
    String baseUrl();

    String platform();

    String platformVersion();

    String automationName();

    String browser();

    String deviceName();
}