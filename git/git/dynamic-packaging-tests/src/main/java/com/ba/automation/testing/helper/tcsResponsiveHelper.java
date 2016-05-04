package com.ba.automation.testing.helper;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import com.ba.automation.testing.ui.pages.tcsResponsivepage;

/**
 * Created by n459280 on 13/04/2016.
 */
public class tcsResponsiveHelper {
    @Inject Provider<WebDriver> driver;
    @Inject tcsResponsivepage tcsHomepage;
    public void load_page(){
        driver.get().manage().window().maximize();
        String responsivePage = "http://capdev575.uk.ba.com/apps/RDPPoCUserStory1and2/index.html";
        driver.get().navigate().to(responsivePage);
    }

    public void expandflight() {
        tcsHomepage.ViewChangeFlightDetails_lnk.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void hidepage(){
        tcsHomepage.HideDetails_lnk.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void validatepage(){

    }
}
