package pages;

import base.Keywords;
import exceptions.ApplicationException;
import helper.Device;
import org.openqa.selenium.By;
import xpath.Matching;

public class PageMore extends Keywords {

    private String keyLblPageTitle = "Getgo.More.LblPageTitle";


    public void verifyPageTitle(String ititle) throws ApplicationException {

            verify.elementTextContains(keyLblPageTitle, ititle);

    }

    public void verifyMorePageContents() throws ApplicationException {

        verify.elementIsPresent(xpathOf.textView(Matching.youDecide("About the Cards")));
        verify.elementIsPresent(xpathOf.textView(Matching.youDecide("Contact Us")));
        verify.elementIsPresent(xpathOf.textView(Matching.youDecide("Frequently Asked Questions")));
        verify.elementIsPresent(xpathOf.textView(Matching.youDecide("Terms & Conditions")));
    }

    public void clickoptions(String option) throws ApplicationException {
        click.elementBy(xpathOf.textView(Matching.youDecide(option)));
    }




}


