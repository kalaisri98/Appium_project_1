package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private static AppiumDriver driver;

    public static AppiumDriver getDriver() {
        return driver;
    }

    public static void initDriver() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", ConfigReader.get("platformName"));
        caps.setCapability("deviceName", ConfigReader.get("deviceName"));
        caps.setCapability("app", ConfigReader.get("appPath"));
        String serverUrl = ConfigReader.get("appiumServerUrl");
        driver = new AndroidDriver(new URL(serverUrl), caps);;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
