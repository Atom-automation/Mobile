package pages;

import base.Keywords;
import exceptions.ApplicationException;
import helper.Device;
import org.openqa.selenium.By;
import xpath.Matching;

public class PageMore extends Keywords {

    private String keyLblPageTitle = "Getgo.More.LblPageTitle";
    private String keyBtnAbouttheCard = "Getgo.More.BtnAbouttheCard";
    private String keyBtnContactus = "Getgo.More.BtnContactus";
    private String keyBtnFAQ = "Getgo.More.BtnFAQ";
    private String keyBtnTermsandConditions = "Getgo.More.BtnTermsandConditions";
    private String keyBtnPrivacy = "Getgo.More.BtnPrivacy";
    private String keyBtnMenu = "Getgo.More.BtnMenu";


    public void verifyPageTitle(String ititle) throws ApplicationException {
        WAIT.forSeconds(2);

            verify.elementTextContains(keyLblPageTitle, ititle);

    }

    public void verifyMorePageContents() throws ApplicationException {

        verify.elementIsPresent(keyBtnMenu);
            verify.elementIsPresent(xpathOf.textView(Matching.youDecide("About the Cards")));
            verify.elementIsPresent(xpathOf.textView(Matching.youDecide("Contact Us")));
            verify.elementIsPresent(xpathOf.textView(Matching.youDecide("Frequently Asked Questions")));
            //need to check and its a issue
        if(Device.isAndroid()) {
            verify.elementIsPresent(xpathOf.textView(Matching.youDecide("Terms & Conditions")));
        }
        else
        {
            verify.elementIsPresent(xpathOf.textView(Matching.youDecide("Terms and Conditions")));
        }
        verify.elementIsPresent(xpathOf.textView(Matching.youDecide("Privacy Policy")));

    }

    public void clickoptions(String option) throws ApplicationException {
        if(Device.isAndroid()) {
            if(option.toLowerCase().contains("terms"))
            {
                click.elementBy(xpathOf.textView(Matching.youDecide("Terms & Conditions")));
            }
            else {
                click.elementBy(xpathOf.textView(Matching.youDecide(option)));
            }
        }
        else {
            switch (option) {
                case "About the Cards":
                    click.elementBy(keyBtnAbouttheCard);
                    break;
                case "Contact Us":
                    click.elementBy(keyBtnContactus);
                    break;
                case "Frequently Asked Questions":
                    click.elementBy(keyBtnFAQ);
                    break;
                case "Terms and Conditions":
                    click.elementBy(keyBtnTermsandConditions);
                    break;
                case "Privacy Policy":
                    click.elementBy(keyBtnPrivacy);
                    break;
            }
        }
    }




}


