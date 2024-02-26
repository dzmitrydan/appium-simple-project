package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import static utils.PropertyFileReader.*;

public class DriverManager {
    private static AppiumDriver driver;

    private DriverManager() {
    }

    public static AppiumDriver getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }

    private static void initializeDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", getProperty("platform.name"));
        capabilities.setCapability("platformVersion", getProperty("platform.version"));
        capabilities.setCapability("deviceName", getProperty("device.name"));
        capabilities.setCapability("appPackage", getProperty("app.package"));
        capabilities.setCapability("appActivity", getProperty("app.activity"));
        if ("org.wikipedia".equals(getProperty("app.package"))) {
            capabilities.setCapability("app", new File(getProperty("app.path")).getAbsolutePath());
        }
        capabilities.setCapability("udid", getProperty("udid"));
        capabilities.setCapability("automationName", "UiAutomator2");

        URL appiumServerURL;
        try {
            appiumServerURL = new URL(getProperty("appium.server.url"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver = new AndroidDriver(appiumServerURL, capabilities);
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
