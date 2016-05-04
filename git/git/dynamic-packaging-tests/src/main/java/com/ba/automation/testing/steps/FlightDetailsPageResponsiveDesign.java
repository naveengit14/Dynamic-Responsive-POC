package com.ba.automation.testing.steps;

import com.ba.automation.testing.enums.ScreenType;
import com.ba.automation.testing.ui.pages.OpenJawHomePage;
import com.ba.automation.testing.helper.OJpageHelper;
import com.google.inject.Inject;
import com.google.inject.Provider;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

/**
 * Created by n450777 on 12/04/2016.
 */
public class FlightDetailsPageResponsiveDesign {
    @Inject
    Provider<WebDriver> driver;
    @Inject
    OpenJawHomePage ojHomepage;
    @Inject
    OJpageHelper ojHelper;

    @Given("^I am on the OJ home page$")
    public void iAmOnOJPage_1() throws Throwable {
        ojHelper.loadOjpage();
    }
    @And("^I am navigating to responsive page by selecting Hand_off_1 button$")
    public void select_firts_button()throws Throwable{ojHomepage.selectExample(0);}
    @And("^I am viewing using (.*)$")
    public void iAmViewingUsingScreenType(ScreenType screenType) throws Throwable {
        int width = 640;
        Dimension fullScreenSize = driver.get().manage().window().getSize();
        switch (screenType) {
            case Desktop:
                width = 1440;
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

    @When("^I click expand view system shows flight expand view$")
    public void ClickExpandView() throws Throwable {
        ojHomepage.clickexpand_lnk();
    }

    @When("^I click hide option system displays flight summery view$")
    public void ClickHideOption() throws Throwable {
        ojHomepage.clickhide_lnk();
    }

    @When("^I click back option system displays oj home page$")
    public void ClickBackOption() throws Throwable {
        ojHomepage.clickbask_btn();
    }

    @And("^I navigate back to OJ page and select second option$")
    public void select_second_button() throws Throwable {
        ojHomepage.selectExample(1);}
}
