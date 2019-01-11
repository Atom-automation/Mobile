package pages;

import base.Keywords;
import exceptions.ApplicationException;
import helper.Device;
import io.appium.java_client.MobileBy;
import xpath.Matching;

public class PageLoadingPartner extends Keywords {

    private String keyLblPageTitle = "Getgo.LoadingPartner.LblPageTitle";
    private String keyTxtSearchLoadPartners = "Getgo.LoadingPartner.TxtSearchLoadPartners";
    private String keyLblLocationName = "Getgo.LoadingPartner.LblLocationName";
    private String keyLblLocationAddress = "Getgo.LoadingPartner.LblLocationAddress";
    private String keyLblLocationMap = "Getgo.LoadingPartner.LblLocationMap";
    private String keyBtnMenu = "Getgo.LoadingPartner.BtnMenu";
    private String keyIMGGoogleMap = "Getgo.LoadingPartner.IMGGoogleMap";


    public void verifyPageTitle(String ititle) throws ApplicationException {
        WAIT.forSeconds(2);

            verify.elementTextMatching(keyLblPageTitle, ititle);


    }

    public void verifyLoadingPartnersPageContents(String placeholder) throws ApplicationException {

        verify.elementIsPresent(keyTxtSearchLoadPartners);
        verify.elementIsPresent(keyTxtSearchLoadPartners);
        verify.elementIsPresent(keyLblLocationName);
        verify.elementIsPresent(keyLblLocationAddress);
        verify.elementIsPresent(keyBtnMenu);
    if(Device.isAndroid()) {
        verify.elementIsPresent(keyLblLocationMap);
        verify.elementAttributeMatching(keyTxtSearchLoadPartners, "text", placeholder);
    }
    else
    {
        verify.elementAttributeMatching(keyTxtSearchLoadPartners, "name", placeholder);
    }

    }

    public void searchLoadPartners(String isearchText) throws ApplicationException {

            swipe.scrollDownToTextandClick(isearchText);

    }

    public void CheckIFGoogleMapIsOpened() throws ApplicationException
    {
        WAIT.forSeconds(5);
        verify.elementIsPresent(keyIMGGoogleMap);
    }

    public void searchLoadPartnersIOS(String isearchText) throws ApplicationException {

        swipe.scrollDownToText(isearchText);
        WAIT.forSeconds(3);
        click.elementBy(MobileBy.AccessibilityId(isearchText));
    }




}


