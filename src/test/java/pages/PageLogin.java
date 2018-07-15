package pages;

import base.Keywords;
import base.Test;
import constants.Keys;
import constants.OS;
import exceptions.ApplicationException;
import xpath.Matching;

public class PageLogin extends Keywords {

    private String keyLblPageCaption="Getgo.Login.LblCaption.XPATH";
    private String keyTxtEmailAddress="Getgo.Login.TxtEmailAddress.XPATH";
    private String keyBtnNext="Getgo.Login.BtnNext.XPATH";
    private String keyBtnBackAndroid="Getgo.Login.BtnBack.XPATH";
    private String keyBtnBackIOS="";
    private String keyBtnLogin="Getgo.Login.BtnLogin.XPATH";
    private String keyTogglePasswordVisibility="Getgo.Login.TogglePasswordVisibility.ID";
    private String keyTxtPassword="Getgo.Login.TxtPassword.XPATH";


    public void enterEmail(String emailID) throws ApplicationException {
        type.data(keyTxtEmailAddress,emailID);
    }

    public void enterPassword(String password) throws ApplicationException {
        type.sensitiveData(keyTxtPassword,password);
    }

    public void clickNext() throws ApplicationException {
        click.elementBy(keyBtnNext);
    }

    public void clickLogin() throws ApplicationException {
        click.elementBy(keyBtnLogin);
    }

    public void isLoginSuccess(String username,String accountType) throws ApplicationException {
        PageAccountDashboard pageAccountDashboard=new PageAccountDashboard();
        pageAccountDashboard.isOk(username);
        pageAccountDashboard.displayMyAccountBalance(accountType);
    }

    public void doesUserNameScreenContains(String pageTitle, String pageCaption, String usernameBoxText, String passwordResetLinkText, String nextButtonText, String signUpLinkText) throws ApplicationException {
        if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.ANDROID)){
            verify.elementIsPresent(keyBtnBackAndroid);
        }else if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.iOS)){
            verify.elementIsPresent(keyBtnBackIOS);
        }
        keyboard.hideIfAndroid();
        verify.elementIsPresent(xpathOf.textView(Matching.youDecide(pageTitle)));
        verify.elementTextMatching(keyLblPageCaption,pageCaption);
        verify.elementTextMatching(keyTxtEmailAddress,usernameBoxText);
        verify.elementIsPresent(xpathOf.textView(Matching.youDecide(passwordResetLinkText)));
        verify.elementTextMatching(keyBtnNext,nextButtonText);
        verify.elementIsPresent(xpathOf.textView(Matching.youDecide(signUpLinkText)));
    }

    public void doesPasswordScreenContains(String pageTitle, String pageCaption, String passwordBoxText, String passwordResetLinkText, String loginButtonText) throws ApplicationException {
        verify.elementIsPresent(keyTogglePasswordVisibility);
        keyboard.hideIfAndroid();
        if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.ANDROID)){
            verify.elementIsPresent(keyBtnBackAndroid);
        }else if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.iOS)){
            verify.elementIsPresent(keyBtnBackIOS);
        }
        verify.elementIsPresent(xpathOf.textView(Matching.youDecide(pageTitle)));
        verify.elementTextMatching(keyLblPageCaption,pageCaption);
        verify.elementTextMatching(keyTxtPassword,passwordBoxText);
        verify.elementIsPresent(xpathOf.textView(Matching.youDecide(passwordResetLinkText)));
        verify.elementTextMatching(keyBtnLogin,loginButtonText);
    }
}