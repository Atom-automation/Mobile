package pages;

import base.Keywords;
import exceptions.ApplicationException;
import helper.Device;
import xpath.Matching;

public class PageSignUp extends Keywords {

    private String keyImgGetgoCard = "Getgo.SignUp.ImgGetgoCard";
    private String keyLblPageCaption1 = "Getgo.SignUp.LblCaption1";
    private String KeyLblPageCaption2 = "Getgo.SignUp.LblCaption2";
    private String keyBtnCreateVirutalCard = "Getgo.SignUp.BtnCreateVirtualCard";
    private String keyBtnRegisterPesoCard = "Getgo.SignUp.BtnRegisterPhysicalCard";

    private String keyTxtEmailAddress = "Getgo.SignUp.TxtEmailAddress";
    private String keyBtnNext = "Getgo.SignUp.BtnNext";
    private String keyLinkAlreadyHaveaPrepaidCard = "Getgo.SignUp.LinkAlreadyHaveaPrepaidCard";
    private String keyLblPageTitle = "Getgo.SignUp.LblPageTitle";
    private String keyLblPageHeader = "Getgo.SignUp.LblPageHeader";
    private String keyBtnBack = "Getgo.SignUp.BtnBack";
    private String keyLblErrorMessage = "Getgo.SignUp.LblErrorMessage";


    public void doesPageContains(String caption, String caption2, String createVirutalCardBtnTxt, String registerPhysicalCardBtnTxt) throws ApplicationException
    {
        WAIT.forSeconds(5);
        verify.elementIsPresent(keyImgGetgoCard);
        if(Device.isAndroid()) {
           // nned to check thi sone
           // verify.elementTextMatching(xpathOf.button(Matching.youDecide(createVirutalCardBtnTxt)),createVirutalCardBtnTxt);
           // verify.elementTextMatching(xpathOf.button(Matching.youDecide(registerPhysicalCardBtnTxt)),registerPhysicalCardBtnTxt);
        }
        else
        {
            verify.elementTextMatching(keyBtnCreateVirutalCard,createVirutalCardBtnTxt);
            verify.elementTextMatching(keyBtnRegisterPesoCard,registerPhysicalCardBtnTxt);
        }

        verify.elementTextMatching(keyLblPageCaption1,caption);
        verify.elementTextMatching(KeyLblPageCaption2,caption2);
    }

    public void registerVirtualCard() throws ApplicationException {
        WAIT.forSeconds(1);
        click.elementBy(keyBtnCreateVirutalCard);
        //click.elementMobileBy("com.unionbankph.getgopay.qat:id/btnCreateVirtualCard");
    }

    public void verifyPageTitle(String ititle) throws ApplicationException {
        WAIT.forSeconds(2);
        verify.elementTextMatching(keyLblPageTitle,ititle);

    }


    public void verifySignUpPageContents () throws ApplicationException
    {
        WAIT.forSeconds(2);
        verify.elementTextMatching(keyLblPageHeader,"Enter your email address to sign-up");
        verify.elementIsPresent(keyTxtEmailAddress);
        verify.elementIsPresent(keyBtnBack);
        verify.elementIsPresent(keyBtnNext);
        verify.elementIsPresent(keyLinkAlreadyHaveaPrepaidCard);
        if(Device.isAndroid())
        {
            verify.elementAttributeMatching(keyTxtEmailAddress,"text","Email Address");
        }
        else
        {
            verify.elementAttributeMatching(keyTxtEmailAddress,"value","Email address");
        }

    }

    public void verifyErrorMessage(String ierror) throws ApplicationException
    {
        WAIT.forSeconds(1);
        verify.elementTextMatching(keyLblErrorMessage,ierror);

    }

    public void enterEmailAddress(String iemail) throws ApplicationException
    {
        type.data(keyTxtEmailAddress,iemail);
        WAIT.forSeconds(2);
    }

    public void clickNext() throws ApplicationException
    {
        WAIT.forSeconds(3);
        click.elementBy(keyBtnNext);
    }

}
