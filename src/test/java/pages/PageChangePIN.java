package pages;

import base.Keywords;
import exceptions.ApplicationException;
import helper.Device;
import xpath.Contains;
import xpath.Matching;

public class PageChangePIN extends Keywords {

    private String keyTXTCurrentPIN ="Getgo.ChangePIN.TXTCurrentPIN";
    private String keyTXTNewPIN ="Getgo.ChangePIN.TXTNewPIN";
    private String keyTXTConfirmNewPIN ="Getgo.ChangePIN.TXTConfirmNewPIN";
    private String keyLblContentsverbiage ="Getgo.ChangePIN.LblContentsverbiage";
    private String keyBTNSubmit ="Getgo.ChangePIN.BTNSubmit";
    private String keyBtnClose ="Getgo.ChangePIN.BtnClose";

    private String keyIMGGetGopayLogo ="Getgo.ChangePIN.IMGGetGopayLogo";
    private String keyLBLCongratulations ="Getgo.ChangePIN.LBLCongratulations";
    private String keyLBLSuccessfullUpdatePINVerbiage ="Getgo.ChangePIN.LBLSuccessfullUpdatePINVerbiage";
    private String keyBTNGoToProfile ="Getgo.ChangePIN.BTNGoToProfile";




    public void verifyChangePINPageTitle(String ititle) throws ApplicationException {
        if (Device.isAndroid())

            verify.elementTextMatching(xpathOf.textView(Matching.youDecide("Update Card PIN")), ititle);

    else{
        //doubt of PIN verbiage and its differentt
        verify.elementTextMatching(xpathOf.textView(Matching.youDecide("Update Card Pin")), ititle);

    }

    }
    public void verifyChangePINPageElements() throws ApplicationException {
        verify.elementIsPresent(keyTXTCurrentPIN);
        verify.elementIsPresent(keyTXTNewPIN);
        verify.elementIsPresent(keyTXTConfirmNewPIN);
        verify.elementTextMatching(keyLblContentsverbiage,"Enter your PIN details in the fields below");
        verify.elementIsPresent(keyBTNSubmit);
        verify.elementIsPresent(keyBtnClose);

    }

    public void enterPINDetailsToUpdate(String currentpin,String newpin,String confirmpin) throws ApplicationException {

        type.sensitiveData(keyTXTCurrentPIN,currentpin);
        type.sensitiveData(keyTXTNewPIN,newpin);
        type.sensitiveData(keyTXTConfirmNewPIN,confirmpin);
    }

    public void clicksubmit() throws ApplicationException {
        click.elementBy(keyBTNSubmit);
    }

    public void clickBackBtn() throws ApplicationException {
        click.elementBy(keyBtnClose);
    }

    public void verifyPINChangeIsSuccessfull() throws ApplicationException {
        verify.elementIsPresent(keyIMGGetGopayLogo);
        verify.elementIsPresent(keyLBLCongratulations);
        verify.elementIsPresent(keyLBLSuccessfullUpdatePINVerbiage);
        verify.elementIsPresent(keyBTNGoToProfile);

        verify.elementTextMatching(keyLBLCongratulations,"Congratulations!");
        verify.elementTextMatching(keyLBLSuccessfullUpdatePINVerbiage,"Successfully updated pin.");

        if(Device.isAndroid())
        {
            verify.elementTextMatching(keyBTNGoToProfile,"GO TO PROFILE");
        }

        WAIT.forSeconds(2);

    }

    public void clickGoToProfileBtn() throws ApplicationException {
        click.elementBy(keyBTNGoToProfile);
    }

}


