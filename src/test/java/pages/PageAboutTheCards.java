package pages;

import base.Keywords;
import exceptions.ApplicationException;
import helper.Device;
import xpath.Matching;

public class PageContactUs extends Keywords {

    private String keyLblPageTitle = "Getgo.ContactUs.LblPageTitle";
    private String keyBtnClose= "Getgo.ContactUs.BtnClose";
    private String keyIMGUnionBankLogo = "Getgo.ContactUs.IMGUnionBankLogo";
    private String keyLblUnionbkDescription = "Getgo.ContactUs.LblUnionbkDescription";
    private String keyIMGUnionbkPhonelocal = "Getgo.ContactUs.IMGUnionbkPhonelocal";
    private String keyLblUnionbkPhonelocal= "Getgo.ContactUs.LblUnionbkPhonelocal";
    private String keyLblUnionbkPhonetollfree = "Getgo.ContactUs.LblUnionbkPhonetollfree";
    private String keyIMGUnionbkEmail = "Getgo.ContactUs.IMGUnionbkEmail";
    private String keyLblUnionbkEmail = "Getgo.ContactUs.LblUnionbkEmail";
    private String keyIMGUnionbkFacebook = "Getgo.ContactUs.IMGUnionbkFacebook";
    private String keyLblUnionbkFacebook = "Getgo.ContactUs.LblUnionbkFacebook";
    private String keyIMGUnionbkTwitter = "Getgo.ContactUs.IMGUnionbkTwitter";
    private String keyLblUnionbkTwitter = "Getgo.ContactUs.LblUnionbkTwitter";

    private String keyIMGGetGoLogo = "Getgo.ContactUs.IMGGetGoLogo";
    private String keyLblGetGoDescription = "Getgo.ContactUs.LblGetGoDescription";
    private String keyIMGGetGoHelpline = "Getgo.ContactUs.IMGGetGoHelpline";
    private String keyLblGetGoHelpline = "Getgo.ContactUs.LblGetGoHelpline";
    private String keyIMGGetGoFacebook = "Getgo.ContactUs.IMGGetGoFacebook";
    private String keyLblGetGoFacebook = "Getgo.ContactUs.LblGetGoFacebook";
    private String keyIMGGetGoTwitter = "Getgo.ContactUs.IMGGetGoTwitter";
    private String keyLblGetGoTwitter = "Getgo.ContactUs.LblGetGoTwitter";
    private String keyIMGGetGoInstagram = "Getgo.ContactUs.IMGGetGoInstagram";
    private String keyLblGetGoInstagram = "Getgo.ContactUs.LblGetGoInstagram";



    public void verifyPageTitle(String ititle) throws ApplicationException {
        WAIT.forSeconds(5);
            verify.elementTextContains(keyLblPageTitle, ititle);

    }

    public void verifyPageContents() throws ApplicationException {
        WAIT.forSeconds(10);
        if(Device.isAndroid()) {
            //unionbank section
            verify.elementIsPresent(keyBtnClose);
            verify.elementIsPresent(keyIMGUnionBankLogo);
            verify.elementTextMatching(keyLblUnionbkDescription,"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolor dolorum error laudantium nemo nobis omnis quae qui temporibus, vel voluptatum?");
            verify.elementIsPresent(keyIMGUnionbkPhonelocal);
            verify.elementTextMatching(keyLblUnionbkPhonelocal,"Local: +632 981-3699");
            verify.elementTextMatching(keyLblUnionbkPhonetollfree,"Universal Toll Free (IAC): +800 8277 2273");
            verify.elementIsPresent(keyIMGUnionbkEmail);
            verify.elementTextMatching(keyLblUnionbkEmail,"getgoprepaid@unionbankph.com");
            verify.elementIsPresent(keyIMGUnionbkFacebook);
            verify.elementTextMatching(keyLblUnionbkFacebook,"m.me/unionbankph");
            verify.elementIsPresent(keyIMGUnionbkTwitter);
            verify.elementTextMatching(keyLblUnionbkTwitter,"twitter.com/unionbankph");

            swipe.vertical(2,0.9,0.2,5);
            //GetGopay section
            verify.elementIsPresent(keyIMGGetGoLogo);
            verify.elementTextMatching(keyLblGetGoDescription,"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Atque beatae ducimus ea esse et ex fugit iusto rerum sit soluta.");
            verify.elementIsPresent(keyIMGGetGoHelpline);
            verify.elementTextMatching(keyLblGetGoHelpline,"helpcenter.getgo.com.ph");
            verify.elementIsPresent(keyIMGGetGoFacebook);
            verify.elementTextMatching(keyLblGetGoFacebook,"m.me/GetGoPH");
            verify.elementIsPresent(keyIMGGetGoTwitter);
            verify.elementTextMatching(keyLblGetGoTwitter,"twitter.com/GetGoPh");
            verify.elementIsPresent(keyIMGGetGoInstagram);
            verify.elementTextMatching(keyLblGetGoInstagram,"instagram.com/GetGoPh");

        }
        else
        {
            verify.elementIsPresent(keyBtnClose);
            verify.elementIsPresent(keyIMGUnionBankLogo);
            verify.elementTextMatching(keyLblUnionbkDescription,"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolor dolorum error laudantium nemo nobis omnis quae qui temporibus, vel voluptatum?");
            verify.elementIsPresent(keyIMGUnionbkPhonelocal);
            verify.elementTextMatching(xpathOf.textView(Matching.youDecide("Local:")),"Local:");
            verify.elementTextMatching(keyLblUnionbkPhonelocal,"+632 981-3699");
            verify.elementTextMatching(xpathOf.textView(Matching.youDecide("Universal Toll Free (IAC):")),"Universal Toll Free (IAC):");
            verify.elementTextMatching(keyLblUnionbkPhonetollfree,"+800 8277 2273");
            verify.elementIsPresent(keyIMGUnionbkEmail);
            verify.elementTextMatching(keyLblUnionbkEmail,"getgoprepaid@unionbankph.com");
            verify.elementIsPresent(keyIMGUnionbkFacebook);
            verify.elementTextMatching(keyLblUnionbkFacebook,"m.me/unionbankph");
            verify.elementIsPresent(keyIMGUnionbkTwitter);
            verify.elementTextMatching(keyLblUnionbkTwitter,"twitter.com/unionbankph");

            swipe.vertical(2,0.9,0.2,5);
            //GetGopay section
            verify.elementIsPresent(keyIMGGetGoLogo);
            verify.elementTextMatching(keyLblGetGoDescription,"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Atque beatae ducimus ea esse et ex fugit iusto rerum sit soluta.");
            verify.elementIsPresent(keyIMGGetGoHelpline);
            verify.elementTextMatching(keyLblGetGoHelpline,"helpcenter.getgo.com.ph");
            verify.elementIsPresent(keyIMGGetGoFacebook);
            verify.elementTextMatching(keyLblGetGoFacebook,"m.me/GetGoPH");
            verify.elementIsPresent(keyIMGGetGoTwitter);
            verify.elementTextMatching(keyLblGetGoTwitter,"twitter.com/GetGoPh");
            verify.elementIsPresent(keyIMGGetGoInstagram);
            verify.elementTextMatching(keyLblGetGoInstagram,"instagram.com/GetGoPh");

        }

    }

    public void clickBackBtn() throws ApplicationException {
        click.elementBy(keyBtnClose);
        WAIT.forSeconds(2);
    }


}


