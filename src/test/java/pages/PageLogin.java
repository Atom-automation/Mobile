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
    private String keyBtnBack="Getgo.Login.BtnBack.XPATH";
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

    public void isLoginSuccess(String username,String accountType,boolean failIfZeroBalance) throws ApplicationException {
        PageAccountDashboard pageAccountDashboard=new PageAccountDashboard();
        pageAccountDashboard.isOk(username);
        pageAccountDashboard.displayMyAccountBalance(accountType,failIfZeroBalance);
    }

    public void doesUserNameScreenContains(String pageTitle, String pageCaption, String usernameBoxText, String passwordResetLinkText, String nextButtonText, String signUpLinkText) throws ApplicationException {
        verify.elementIsPresent(keyBtnBack);
        keyboard.hideIfAndroid();
        verify.elementIsPresent(xpathOf.textView(Matching.youDecide(pageTitle)));
        verify.elementTextMatching(keyLblPageCaption,pageCaption);
        verify.elementTextMatching(keyTxtEmailAddress,usernameBoxText);
        if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.ANDROID)){
            verify.elementIsPresent(xpathOf.textView(Matching.text(passwordResetLinkText)));
            verify.elementIsPresent(xpathOf.textView(Matching.youDecide(signUpLinkText)));
        }else if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.iOS)){
            verify.elementIsPresent(xpathOf.button(Matching.name(passwordResetLinkText)));
            verify.elementIsPresent(xpathOf.button(Matching.youDecide(signUpLinkText)));
        }
        verify.elementTextMatching(keyBtnNext,nextButtonText);
    }

    public void doesPasswordScreenContains(String pageTitle, String pageCaption, String passwordBoxText, String passwordResetLinkText, String loginButtonText) throws ApplicationException {
        verify.elementIsPresent(keyTogglePasswordVisibility);
        keyboard.hideIfAndroid();
        verify.elementIsPresent(keyBtnBack);
        verify.elementIsPresent(xpathOf.textView(Matching.youDecide(pageTitle)));
        verify.elementTextMatching(keyLblPageCaption,pageCaption);
        verify.elementTextMatching(keyTxtPassword,passwordBoxText);
        if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.ANDROID)){
            verify.elementIsPresent(xpathOf.textView(Matching.text(passwordResetLinkText)));
        }else if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.iOS)){
            verify.elementIsPresent(xpathOf.button(Matching.name(passwordResetLinkText)));
        }
        verify.elementTextMatching(keyBtnLogin,loginButtonText);
    }
}