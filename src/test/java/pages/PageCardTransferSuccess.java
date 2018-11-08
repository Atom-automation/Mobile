package pages;

import base.Keywords;
import base.Test;
import constants.Keys;
import constants.OS;
import exceptions.ApplicationException;

public class PageCardTransferSuccess extends Keywords {

    private String keyImgGetgoLogo="Getgo.CardTransferSuccess.ImgGetgoLogo";
    private String keyLblCongrats="Getgo.CardTransferSuccess.LblCongrats";
    private String keyLblMessage="Getgo.CardTransferSuccess.LblMessage";
    private String keyBtnViewDetails="Getgo.CardTransferSuccess.BtnViewDetails";
    private String keyBtnDashboard="Getgo.CardTransferSuccess.BtnDashboard";


    public void isTransferSuccess() throws ApplicationException {
        verify.elementIsPresent(keyImgGetgoLogo);
        if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.ANDROID))
        {
            WAIT.forSeconds(6);
            verify.elementTextContains(keyLblCongrats,"You did it!");
            verify.elementTextContains(keyLblMessage,"You just sent money!");
        }else if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.iOS))
        {
            WAIT.forSeconds(5);
            verify.elementIsPresent(keyLblCongrats);
            verify.elementIsPresent(keyLblMessage);
            WAIT.forSeconds(2);
        }
    }

    public void viewDetails() throws ApplicationException {
        click.elementBy(keyBtnViewDetails);
        WAIT.forSeconds(10);
    }

    public void gotoDashboard() throws ApplicationException {
        click.elementBy(keyBtnDashboard);
        WAIT.forSeconds(5);
    }
}
