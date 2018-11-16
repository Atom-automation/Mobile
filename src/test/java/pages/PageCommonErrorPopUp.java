package pages;

import base.Keywords;
import base.Test;
import constants.Keys;
import constants.OS;
import exceptions.ApplicationException;
import helper.Device;
import helper.PropertyReader;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import xpath.Matching;

public class PageCommonErrorPopUp extends Keywords {

    private String keyLblPageTitle = "Getgo.CommonErrorPopUp.LblPageTitle";
    private String keyLblErrorDescription = "Getgo.CommonErrorPopUp.LblErrorDescription";
    private String keyBtnOk = "Getgo.CommonErrorPopUp.BtnOk";


    public void CheckErrorMessageDetails(String PopUpHeading, String ErrorMessage) throws ApplicationException, InterruptedException {
        if(Device.isAndroid()) {
            WAIT.forSeconds(4);
            verify.elementTextMatching(keyLblPageTitle, PopUpHeading);
            verify.elementIsPresent(keyBtnOk);
            verify.elementTextMatching(keyLblErrorDescription, ErrorMessage);
            verify.elementAttributeMatching(keyBtnOk, "text", "OK");
        }
        else
        {
            verify.elementTextMatching(keyLblPageTitle, PopUpHeading);
            verify.elementIsPresent(keyBtnOk);
            verify.elementTextMatching(keyLblErrorDescription, ErrorMessage);
            verify.elementAttributeMatching(keyBtnOk, "name", "OK");
        }
    }

    public void ClickOk() throws ApplicationException {
        click.elementBy(keyBtnOk);
        WAIT.forSeconds(1);
    }

}