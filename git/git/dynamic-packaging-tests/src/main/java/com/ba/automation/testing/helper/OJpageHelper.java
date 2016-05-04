package com.ba.automation.testing.helper;

import com.ba.automation.testing.ui.pages.OpenJawHomePage;
import com.google.inject.Inject;
import com.google.inject.Provider;
import cucumber.api.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * Created by n459280 on 19/04/2016.
 */
public class OJpageHelper {
    @Inject
    Provider<WebDriver> driver;
    public void loadOjpage(){
        driver.get().manage().window().maximize();
        driver.get().navigate().to("http://dublin.openjawtech.com//badev/autobuild/badp/rdp/poc.do");
        driver.get().navigate().to("http://dublin.openjawtech.com//badev/autobuild/badp/rdp/poc.do");
    }
}
