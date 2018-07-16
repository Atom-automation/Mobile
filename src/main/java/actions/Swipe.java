package actions;

import base.Keywords;
import base.Test;
import constants.Keys;
import constants.OS;
import exceptions.ApplicationException;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import sun.plugin2.os.windows.SECURITY_ATTRIBUTES;
import xpath.Matching;

import java.util.HashMap;

public class Swipe extends Keywords {


    public void scrollDownToText(String searchText) throws ApplicationException {
        if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.ANDROID)) {
            try{
                driver.findElement(MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\""+searchText+"\"));"
                ));
            }catch (WebDriverException e) {
                driver.findElement(MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\""+searchText+"\"));"
                ));
            }catch (Throwable e) {
                throw new ApplicationException("Element not found!");
            }
        }else {


            IOSDriver iosDriver= (IOSDriver) driver;
            try{
                /*
                String uiautoFind = "UIATarget.localTarget().frontMostApp().mainWindow()" +
                        ".scrollViews()[0].cells().firstWithPredicate(\"name matches '"+searchText +"'\")";
                iosDriver.findElementByIosUIAutomation(uiautoFind);
                iosDriver.executeScript(uiautoFind + ".scrollToVisible();");
                System.out.println("hello");
                */
                JavascriptExecutor js = iosDriver;
                HashMap scrollObject = new HashMap<>();
                scrollObject.put("predicateString", "name == '" + searchText + "'");
                scrollObject.put("direction", "down");
                js.executeScript("mobile: scroll", scrollObject);
                System.out.println("");
            }catch (Throwable ex){
                throw new ApplicationException("Element not found!");
            }
        }
    }
}
