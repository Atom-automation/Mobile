package pages;

import base.Keywords;
import base.Test;
import com.cucumber.listener.Reporter;
import constants.Keys;
import constants.OS;
import exceptions.ApplicationException;
import helper.Device;
import org.junit.Assert;
import org.openqa.selenium.By;
import xpath.Matching;

import java.text.ParseException;

public class PageSettings extends Keywords {

    private String keySettingsPageTitle="Getgo.Settings.LblTitle";
    //private String keyPasswordOption="Getgo.Settings.LblPassword";
    private String keyMenuBtn="Getgo.Settings.Menu";

    private String keyLblProfile="Getgo.Settings.LblProfile";
    private String keyLblProfileVerbiage="Getgo.Settings.LblProfileVerbiage";
    private String keyLblNotifications="Getgo.Settings.LblNotifications";
    private String keyLblNotificationsVerbiage="Getgo.Settings.LblNotificationsVerbiage";
    private String keyPasswordOption="Getgo.Settings.LblPassword";
    private String keyLblPasswordVerbiage="Getgo.Settings.LblPasswordVerbiage";
    private String keyLblManageOTP="Getgo.Settings.LblManageOTP";
    private String keyLblManageOTPVerbiage="Getgo.Settings.LblManageOTPVerbiage";
    private String keyLblFingerprint="Getgo.Settings.LblFingerprint";
    private String keyLblFingerPrintVerbiage="Getgo.Settings.LblFingerPrintVerbiage";
    private String keyLblChangePIN="Getgo.Settings.LblChangePIN";
    private String keyLblChangePINVerbiage="Getgo.Settings.LblChangePINVerbiage";



    public void verifyPageTitle(String ititle) throws ApplicationException {
        if(Device.isAndroid()) {
            verify.elementTextMatching(keySettingsPageTitle,ititle);
            //verify.elementTextMatching(xpathOf.textView(Matching.text("Manage my Settings")), ititle);
        }
        else
        {
            verify.elementTextMatching(xpathOf.textView(Matching.name("Manage my Settings")), ititle);
        }

        WAIT.forSeconds(3);
    }

    public void verifyPageContents() throws ApplicationException {
        if(Device.isAndroid()) {
            verify.elementIsPresent(keyMenuBtn);
            verify.elementTextMatching(keyLblProfile, "Profile");
            verify.elementTextMatching(keyLblProfileVerbiage, "Update your personal details");
            verify.elementTextMatching(keyLblNotifications, "Notifications");
            verify.elementTextMatching(keyLblNotificationsVerbiage, "Update your notification preferences");
            verify.elementTextMatching(keyPasswordOption, "Password");
            verify.elementTextMatching(keyLblPasswordVerbiage, "Update your password");
            verify.elementTextMatching(keyLblManageOTP, "Manage One- Time Password");
            verify.elementTextMatching(keyLblManageOTPVerbiage, "Manage the actions requiring a One-Time password (OTP)");
            verify.elementTextMatching(keyLblFingerprint, "Login using Fingerprint");
            verify.elementTextMatching(keyLblFingerPrintVerbiage, "Your finger print scan will be stored securely and exclusively on this device. We do not recommend this if you are using a shared device.");
            verify.elementTextMatching(keyLblChangePIN, "Card PIN");
            verify.elementTextMatching(keyLblChangePINVerbiage, "Update your card PIN");
        }
        else
        {
            verify.elementIsPresent(keyMenuBtn);
            verify.elementTextMatching(keyLblProfile,"Profile");
            verify.elementTextMatching(keyLblProfileVerbiage,"Update your personal details");
           // verify.elementTextMatching(keyLblNotifications,"Notifications");
           //verify.elementTextMatching(keyLblNotificationsVerbiage,"Update your notification preferences");
            verify.elementTextMatching(keyPasswordOption,"Password");
            verify.elementTextMatching(keyLblPasswordVerbiage,"Update your password");
            verify.elementTextMatching(keyLblManageOTP,"Manage One-Time Password");
            verify.elementTextMatching(keyLblManageOTPVerbiage,"Manage the actions requiring a One-Time password (OTP)");
            verify.elementTextMatching(keyLblFingerprint,"Log in using Fingerprint");
            verify.elementTextMatching(keyLblFingerPrintVerbiage,"Your finger print scan will be stored securely and exclusively on this device. We do not recommend this if you are using a shared device.");
            verify.elementTextMatching(keyLblChangePIN,"Card PIN");
            verify.elementTextMatching(keyLblChangePINVerbiage,"Update your card PIN");
        }
    }


    public void clickPasswordOption() throws ApplicationException {


        if(Device.isAndroid()) {
            click.elementBy(xpathOf.textView(Matching.text("Password")));
        }
        else
        {
            click.elementBy(xpathOf.textView(Matching.name("Password")));
        }
    }


    public void clickOption(String ioptions) throws ApplicationException {

        if(Device.isAndroid()) {
            click.elementBy(xpathOf.textView(Matching.youDecide(ioptions)));
        }
        else {
            click.elementBy(By.xpath("//XCUIElementTypeStaticText[@name='" + ioptions + "']/parent::*/parent::*/parent::*/XCUIElementTypeButton[1]"));
        }
    }

    public void clickMenu() throws ApplicationException {
      click.elementBy(keyMenuBtn);

    }

}