package com.ba.automation.testing.configuration;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by n450777 on 12/04/2016.
 */
public class WebDriverFactory implements Provider<WebDriver> {
    @Inject
    private SeleniumConfiguration seleniumConfiguration;

    public WebDriver get() {
        System.setProperty("webdriver.firefox.bin","C:\\Program Files\\New folder\\firefox.exe");
        if(System.getProperty("Webdriver.local") != null) {
            return new FirefoxDriver();
        }
        return new RemoteWebDriver(
                seleniumConfiguration.getSeleniumUrl(),
                seleniumConfiguration.getDesiredCapabilities());
    }
}
