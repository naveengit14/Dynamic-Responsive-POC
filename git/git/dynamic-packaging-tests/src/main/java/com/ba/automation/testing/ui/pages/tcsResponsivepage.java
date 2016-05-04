package com.ba.automation.testing.ui.pages;

import org.openqa.selenium.lift.find.LinkFinder;
import org.openqa.selenium.support.FindBy;
import uk.sponte.automation.seleniumpom.PageElement;
import uk.sponte.automation.seleniumpom.PageSection;

/**
 * Created by n459280 on 13/04/2016.
 */
public class tcsResponsivepage {
    @FindBy(id = "expandFlightDetails")
    public PageElement ViewChangeFlightDetails_lnk;

    @FindBy(id = "hideFlightDetails")
    public PageElement HideDetails_lnk;

}
