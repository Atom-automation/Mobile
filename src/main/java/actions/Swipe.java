package actions;

import base.Keywords;
import base.Test;
import constants.Keys;
import constants.OS;
import exceptions.ApplicationException;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebDriverException;

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
            try{
            }catch (Throwable ex){
                throw new ApplicationException("Element not found!");
            }
        }
    }
}
