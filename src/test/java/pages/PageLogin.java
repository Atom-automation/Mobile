package pages;

import base.Keywords;
import base.Test;
import constants.Keys;
import constants.OS;
import exceptions.ApplicationException;
import helper.Device;
import helper.PropertyReader;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;
import xpath.Matching;

public class PageLogin extends Keywords {

    private String keyLblPageCaption="Getgo.Login.LblCaption";
    private String keyTxtEmailAddress="Getgo.Login.TxtEmailAddress";
    private String keyBtnNext="Getgo.Login.BtnNext";
    private String keyBtnBack="Getgo.Login.BtnBack";
    private String keyBtnLogin="Getgo.Login.BtnLogin";
    private String keyTogglePasswordVisibility="Getgo.Login.TogglePasswordVisibility";
    private String keyTxtPassword="Getgo.Login.TxtPassword";



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

    private void localLogin(String username,String password) throws ApplicationException {
        enterEmail(username);
        clickNext();
        enterPassword(password);
        clickLogin();
    }

    public void login(String accountType, String emailID, String password) throws ApplicationException {
        if(Device.isAndroid())
        {
            localLogin(emailID,password);
        }else if(Device.isIOS())
        {
            try{
                String loggedInUserName;
                WebElement usePassword=get.elementBy("Getgo.Welcome.BtnUsePassword");
                loggedInUserName=get.elementText("Getgo.Welcome.LblLoggedInEmailAddress");
                usePassword.click();
                if(!(loggedInUserName.equalsIgnoreCase(emailID))){
                    enterPassword(PropertyReader.testDataOf(loggedInUserName));
                    clickLogin();
                    PageAccountDashboard dashboard=new PageAccountDashboard();
                    dashboard.clickMenu();
                    dashboard.logout();
                    click.elementBy(MobileBy.AccessibilityId("YES"));
                    PageWelcome welcome=new PageWelcome();
                    welcome.clickLogin();
                    enterEmail(emailID);
                    clickNext();
                }
                enterPassword(password);
                clickLogin();
            }catch (Throwable ex){
                click.elementBy(keyBtnLogin);
                localLogin(emailID,password);
            }
        }
    }

    public void isLoginSuccess(String username) throws ApplicationException {
        PageAccountDashboard pageAccountDashboard=new PageAccountDashboard();
        pageAccountDashboard.isOk(username);
    }

    public void doesUserNameScreenContains(String pageTitle, String pageCaption, String usernameBoxText, String passwordResetLinkText, String nextButtonText, String signUpLinkText) throws ApplicationException
    {
        verify.elementIsPresent(keyBtnBack);
        keyboard.hideIfAndroid();
        verify.elementTextMatching(keyLblPageCaption,pageCaption);
        verify.elementTextMatching(keyTxtEmailAddress,usernameBoxText);
        verify.elementTextMatching(keyBtnNext,nextButtonText);

        if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.ANDROID))
        {
            verify.elementTextContains("Getgo.Login.LblTitle",pageTitle.trim());
            verify.elementTextContains("Getgo.Login.LnkForgotPassword",passwordResetLinkText.trim());
            verify.elementTextContains("Getgo.Login.LnkSignUp",signUpLinkText.trim());

        }
        else if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.iOS))
        {
            verify.elementIsPresent(xpathOf.textView(Matching.name(pageTitle)));
            verify.elementIsPresent(xpathOf.button(Matching.name(passwordResetLinkText)));
            verify.elementIsPresent(xpathOf.button(Matching.youDecide(signUpLinkText)));
        }
    }

    public void doesPasswordScreenContains(String pageTitle, String pageCaption, String passwordBoxText, String passwordResetLinkText, String loginButtonText) throws ApplicationException
    {
        verify.elementIsPresent(keyTogglePasswordVisibility);
        keyboard.hideIfAndroid();
        verify.elementIsPresent(keyBtnBack);
        verify.elementTextMatching(keyLblPageCaption,pageCaption);
        verify.elementTextMatching(keyTxtPassword,passwordBoxText);
        verify.elementTextMatching(keyBtnLogin,loginButtonText);

        if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.ANDROID))
        {
            verify.elementTextContains("Getgo.Login.LblTitle",pageTitle.trim());
            verify.elementTextContains("Getgo.Login.LnkHavingProblemsWithAccount",passwordResetLinkText.trim());
        }
        else if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.iOS))
        {
            verify.elementIsPresent(xpathOf.textView(Matching.name(pageTitle)));
            verify.elementIsPresent(xpathOf.button(Matching.name(passwordResetLinkText)));
        }
    }
}