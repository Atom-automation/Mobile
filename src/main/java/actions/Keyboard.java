package actions;

import base.Keywords;
import base.Test;
import constants.Keys;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

import java.util.List;

public class Keyboard extends Keywords {

    public void hideAndroid(){
        try{
            driver.hideKeyboard();
        }catch (Throwable ex){

        }
    }

    public void hideIOS(){
        try {
            List<MobileElement> el=get.elementBy((MobileBy) MobileBy.className("XCUIElementTypeKeyboard")).get(0).findElements(MobileBy.className("XCUIElementTypeButton"));
            if(el.size() > 2) {
                el.get(0).click();
            }else if (el.size() == 0){
                get.elementBy((MobileBy) MobileBy.xpath("//XCUIElementTypeButton[@name='Toolbar Done Button']")).get(0).click();
            }else {
                el.get(el.size() - 1).click();
            }
        } catch (Throwable e) {

        }
    }

    public void hideIfAndroid(){
        if(Test.attributes.get(Keys.OS).equalsIgnoreCase("Android")){
            hideAndroid();
        }
    }

    public void hideIfIOS(){
        if(Test.attributes.get(Keys.OS).equalsIgnoreCase("IOS")){
            hideIOS();
        }
    }

    public void hide(){
        if(Test.attributes.get(Keys.OS).equalsIgnoreCase("Android")){
            hideAndroid();
        }else if(Test.attributes.get(Keys.OS).equalsIgnoreCase("IOS")){
            hideIOS();
        }
    }
}
