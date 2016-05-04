package com.ba.automation.testing.steps;

import com.ba.automation.testing.enums.ScreenType;
import com.ba.automation.testing.helper.tcsResponsiveHelper;
import com.google.inject.Inject;
import com.google.inject.Provider;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

/**
 * Created by n459280 on 13/04/2016.
 */
public class Flight_Options {
    @Inject
    tcsResponsiveHelper pageHelper;
    @Inject
    Provider<WebDriver> driver;

    @Given("^I am on the home page")
    public void navigate_to_home(){

        pageHelper.load_page();
    }
    @And("^I am choosing (.*)$")
    public void SetScreenType(ScreenType screenType) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        int width = 640;
        Dimension fullScreenSize = driver.get().manage().window().getSize();
        switch (screenType) {
            case Desktop:
                width = fullScreenSize.width;
                break;
            case Tablet:
                width = 1024;
                break;
            case Mobile:
                width = 640;
                break;
            default:
                throw new IllegalArgumentException();
        }

        driver.get().manage().window().setSize(new Dimension(width, fullScreenSize.height));
        Thread.sleep(1000);
    }
    @When("^I perform expand Flight Option display Expanded view$")
    public void expand_details(){
        pageHelper.expandflight();
    }

    @When("^I perform hide Flight Option display flight summery view$")
    public void hide_details(){
        pageHelper.hidepage();
    }
}
