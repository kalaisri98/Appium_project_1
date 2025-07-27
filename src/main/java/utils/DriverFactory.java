package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private static final Logger logger = LogManager.getLogger(DriverFactory.class);
    private static AppiumDriver driver;

    public static AppiumDriver getDriver() {
        return driver;
    }

    public static void initDriver() throws MalformedURLException {
        logger.info("Initializing Appium driver...");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", ConfigReader.get("platformName"));
        caps.setCapability("deviceName", ConfigReader.get("deviceName"));
        caps.setCapability("app", ConfigReader.get("appPath"));

        String serverUrl = ConfigReader.get("appiumServerUrl");
        logger.debug("Connecting to Appium server at: " + serverUrl);
        driver = new AndroidDriver(new URL(serverUrl), caps);
        logger.info("Appium driver initialized successfully.");
    }

    public static void quitDriver() {
        if (driver != null) {
            logger.info("Quitting Appium driver...");
            driver.quit();
            logger.info("Appium driver session ended.");
        }
    }
}
