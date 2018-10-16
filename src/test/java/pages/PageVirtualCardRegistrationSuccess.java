package pages;

import base.Keywords;
import base.Test;
import exceptions.ApplicationException;

public class PageVirtualCardRegistrationSuccess extends Keywords {

    private String keyLblMessage2="Getgo.CreateVirtualCardSuccess.LblMessage";
    private String keyLblMessage1="Getgo.CreateVirtualCardSuccess.LblAlmostThere";
    private String keyBtnGetStarted="Getgo.CreateVirtualCardSuccess.BtnGetStarted";

    private String keyIMGGetGoPayLogo="Getgo.CreateVirtualCardSuccess.IMGGetGoPayLogo";
    private String keyLblSuccessPageNotes1="Getgo.CreateVirtualCardSuccess.LblSuccessPageNotes1";
    private String keyLblSuccessPageNotes2="Getgo.CreateVirtualCardSuccess.LblSuccessPageNotes2";
    private String keyLblEmailAddress="Getgo.CreateVirtualCardSuccess.LblEmailAddress";

    public void isRegistrationSuccess(String iemailid) throws ApplicationException {
        verify.elementIsPresent(keyIMGGetGoPayLogo);
        verify.elementIsPresent(keyBtnGetStarted);
        verify.elementTextMatching(keyLblMessage1,"Almost there!");
        verify.elementTextMatching(keyLblSuccessPageNotes1,"A confirmation link has been sent to");
        verify.elementTextMatching(keyLblEmailAddress,iemailid);
        verify.elementTextMatching(keyLblSuccessPageNotes2,"Please click on the link to verify your email address.");



        /*String actualMsg=get.elementText(keyLblMessage2);
        actualMsg=actualMsg.replaceAll("\n"," ").replaceAll("\\u00A0"," ").replaceAll("  "," ");
        String expectedMsg="All you need to do is verify your email and you're set to shop online with your GetGo Virtual Prepaid Card.";
        verify.isMatching(expectedMsg,actualMsg);
        */
    }

    public void verifyNow() throws ApplicationException {
        click.elementBy(keyBtnGetStarted);
    }
}
