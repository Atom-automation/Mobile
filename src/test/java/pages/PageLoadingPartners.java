package pages;

import base.Keywords;
import exceptions.ApplicationException;
import exceptions.EnvironmentException;
import helper.Device;
import org.openqa.selenium.By;
import xpath.Matching;

import java.util.Set;

public class PageLoadingPartners extends Keywords {

    String alreadyLoginEmail;

    private String keyBtnLogin="Getgo.Welcome.BtnLogin";
    private String keyBtnSignUp="Getgo.Welcome.BtnSignUp";




    public void clickfirstelement() throws EnvironmentException, ApplicationException {
        if(Device.isAndroid()) {
            WAIT.forSeconds(4);
            click.elementBy(By.id("com.unionbankph.getgopay.qat:id/tvLocationAddress"));
            WAIT.forSeconds(3);
            verify.elementIsPresent(By.id("com.google.android.apps.maps:id/directions_startpoint_textbox"));
        }
        else
        {
            WAIT.forSeconds(4);
            click.elementBy(By.xpath("//XCUIElementTypeStaticText[@name=\"Robinsons Place, M. Adriatico St., Ermita, Manila 1000\"]"));

            Set<String> availableContexts = driver.getContextHandles();
            for (String context : availableContexts) {
                if (context.contains("WEBVIEW")) {

                    driver.context(context);
                    WAIT.forSeconds(3);
                    verify.elementIsPresent(By.xpath("//XCUIElementTypeStaticText[@name=\"Safari cannot open the page because the network connection was lost.\"]\n"));
                    break;
                }
            }

            WAIT.forSeconds(3);
            verify.elementIsPresent(By.xpath("//XCUIElementTypeStaticText[@name=\"Safari cannot open the page because the network connection was lost.\"]\n"));

            driver.context("WEBVIEW_1");
            WAIT.forSeconds(3);
            verify.elementIsPresent(By.xpath("//XCUIElementTypeStaticText[@name=\"Safari cannot open the page because the network connection was lost.\"]\n"));



        }

    }




}
