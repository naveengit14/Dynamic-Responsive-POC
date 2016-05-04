package com.ba.automation.testing.ui.pages;

import com.ba.automation.testing.helper.OJpageHelper;
import org.openqa.selenium.support.FindBy;
import uk.sponte.automation.seleniumpom.PageElement;

import uk.sponte.automation.seleniumpom.helpers.OperationHelper;

import java.util.List;

/**
 * Created by n450777 on 12/04/2016.
 */
public class OpenJawHomePage {

    @FindBy(css = "[role=button]")
    private List<PageElement> buttons;

    @FindBy(id = "expandFlightDetails")
    private PageElement lnk_expand;

    @FindBy(id = "hideFlightDetails")
    private PageElement lnk_hide;

    @FindBy(xpath = "//span[contains(.,'Back')]")
    private PageElement btn_back;


    public void selectExample(int index) {
        System.out.println(buttons.get(index).getText()+"\n");
        buttons.get(index).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickexpand_lnk() {
        lnk_expand.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickhide_lnk() {
        lnk_hide.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickbask_btn() {
        btn_back.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
