package pages;

import base.Keywords;
import exceptions.ApplicationException;

public class PageSignUp extends Keywords {

    private String keyImgGetgoCard = "Getgo.SignUp.ImgGetgoCard.ID";
    private String keyLblPageCaption1 = "Getgo.SignUp.LblCaption1.XPATH";
    private String KeyLblPageCaption2 = "Getgo.SignUp.LblCaption2.XPATH";
    private String keyBtnCreateVirutalCard = "Getgo.SignUp.BtnCreateVirtualCard.XPATH";
    private String keyBtnRegisterPesoCard = "Getgo.SignUp.BtnRegisterPhysicalCard.XPATH";

    public void doesPageContains(String caption, String caption2, String createVirutalCardBtnTxt, String registerPhysicalCardBtnTxt) throws ApplicationException
    {
        verify.elementIsPresent(keyImgGetgoCard);
        verify.elementTextMatching(keyBtnCreateVirutalCard,createVirutalCardBtnTxt);
        verify.elementTextMatching(keyBtnRegisterPesoCard,registerPhysicalCardBtnTxt);
        verify.elementTextMatching(keyLblPageCaption1,caption);
        verify.elementTextMatching(KeyLblPageCaption2,caption2);
    }
}
