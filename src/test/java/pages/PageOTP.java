package pages;

import base.Keywords;
import base.Test;
import constants.Keys;
import constants.OS;
import exceptions.ApplicationException;
import helper.Device;
import helper.PropertyReader;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class PageOTP extends Keywords {


    private String keyLblPageTitle = "Getgo.OTP.LblPageTitle";
    private String keyLblPageContent1 = "Getgo.OTP.LblPageContent1";
    private String keyLblPageContent2 = "Getgo.OTP.LblPageContent2";
    private String keyLblPageContent3 = "Getgo.OTP.LblPageContent3";
    private String keyBtnCLose = "Getgo.OTP.BtnCLose";
    private String keyBlock1 = "Getgo.OTP.Block1";
    private String keyBlock2 = "Getgo.OTP.Block2";
    private String keyBlock3 = "Getgo.OTP.Block3";
    private String keyBlock4 = "Getgo.OTP.Block4";
    private String keyBlock5 = "Getgo.OTP.Block5";
    private String keyBlock6 = "Getgo.OTP.Block6";
    private String keyLblResetCountDown = "Getgo.OTP.LblResetCountDown";
    private String keyBtnResend = "Getgo.OTP.BtnResend";


    public void enterOTP() throws ApplicationException {
        if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.ANDROID)){
            try {
                if (get.elementBy(By.id("com.unionbankph.getgopay.qat:id/ivCircle1")).isDisplayed()) {
                    AndroidDriver aDriver = (AndroidDriver) driver;
                    aDriver.pressKeyCode(7);
                    aDriver.pressKeyCode(7);
                    aDriver.pressKeyCode(7);
                    aDriver.pressKeyCode(7);
                    aDriver.pressKeyCode(7);
                    aDriver.pressKeyCode(7);
                }
            }
                catch(Exception ex)
                {
                    AndroidDriver aDriver = (AndroidDriver) driver;
                    aDriver.pressKeyCode(7);
                    aDriver.pressKeyCode(7);
                    aDriver.pressKeyCode(7);
                    aDriver.pressKeyCode(7);
                    aDriver.pressKeyCode(7);
                    aDriver.pressKeyCode(7);
                }
            }

        else if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.iOS)){

            type.OTPdata(MobileBy.id("otp-input"),PropertyReader.testDataOf("OTP"));

        }


    }

    public void verifyOTPPageContents() throws ApplicationException {
        WAIT.forSeconds(5);
        if(Device.isAndroid()) {
            verify.elementTextMatching(keyLblPageTitle, "Verify");
            verify.elementIsPresent(keyBtnCLose);
            verify.elementTextMatching(keyLblPageContent1, "You will receive a One-Time Password (OTP) on");
            verify.elementTextMatching(keyLblPageContent2, "your registered mobile number ending");
            verify.elementIsPresent(keyLblPageContent3);
            verify.elementIsPresent(keyBlock1);
            verify.elementIsPresent(keyBlock2);
            verify.elementIsPresent(keyBlock3);
            verify.elementIsPresent(keyBlock4);
            verify.elementIsPresent(keyBlock5);
            verify.elementIsPresent(keyBlock6);
            verify.elementIsPresent(keyLblResetCountDown);
//        verify.elementIsPresent(keyBtnResend);
        }
        else
        {
            verify.elementTextMatching(keyLblPageTitle, "Verify");
            verify.elementIsPresent(keyBtnCLose);
            verify.elementTextContains(keyLblPageContent1, "You will receive a One-Time Password (OTP) on your registered mobile number ending");
            //verify.elementTextMatching(keyLblPageContent2, "your registered mobile number ending");
            //verify.elementIsPresent(keyLblPageContent3);
            verify.elementIsPresent(keyBlock1);
            //verify.elementIsPresent(keyBlock2);
            //verify.elementIsPresent(keyBlock3);
            //verify.elementIsPresent(keyBlock4);
            //verify.elementIsPresent(keyBlock5);
            //verify.elementIsPresent(keyBlock6);
            verify.elementIsPresent(keyLblResetCountDown);
//        verify.elementIsPresent(keyBtnResend);
        }

    }

    public void enterInvalidOTP() throws ApplicationException {
        if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.ANDROID)){
            if(get.elementBy(By.id("com.unionbankph.getgopay.qat:id/ivCircle1")).isDisplayed()){
                AndroidDriver aDriver= (AndroidDriver) driver;
                aDriver.pressKeyCode(7);
                aDriver.pressKeyCode(7);
                aDriver.pressKeyCode(8);
                aDriver.pressKeyCode(9);
                aDriver.pressKeyCode(8);
                aDriver.pressKeyCode(7);
            }
        }else if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.iOS)){
            try {
                if (get.elementBy(By.xpath("//XCUIElementTypeStaticText[contains(@name,'OTP')]/parent::*/XCUIElementTypeOther")).isDisplayed()) {
                    type.OTPdata(By.xpath("//XCUIElementTypeStaticText[contains(@name,'OTP')]/parent::*/XCUIElementTypeOther"), PropertyReader.testDataOf("InvalidOTP"));
                }
                else
                {
                    type.OTPdata(By.xpath("(//XCUIElementTypeStaticText[@name=\"You will receive a One-Time-Password (OTP) on your registered mobile number ending 0000\"])[2]/parent::*/XCUIElementTypeOther"), PropertyReader.testDataOf("InvalidOTP"));
                }

            }
            catch (Exception e)
            {
                if (get.elementBy(By.xpath("//XCUIElementTypeStaticText[@name='We’ll be sending you a 6 digit password to your mobile number ending in 0000. Please enter the code below.']/parent::*/XCUIElementTypeOther")).isDisplayed()) {
                    type.OTPdata(By.xpath("//XCUIElementTypeStaticText[@name='We’ll be sending you a 6 digit password to your mobile number ending in 0000. Please enter the code below.']/parent::*/XCUIElementTypeOther"), PropertyReader.testDataOf("InvalidOTP"));
                }

            }

        }
    }

}
