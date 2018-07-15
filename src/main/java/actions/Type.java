package actions;

import base.Keywords;
import exceptions.ApplicationException;
import io.appium.java_client.MobileElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class Type extends Keywords{

    private static Logger log=Logger.getLogger(Type.class);

    public void data(String locatorKey,String value) throws ApplicationException {
        log.info("Type the value ["+value+"] into element ["+locatorKey+"]");
        MobileElement ele= (MobileElement) get.elementBy(locatorKey).get(0);
        ele.setValue(value);
        keyboard.hideIOS();
        log.info("Type Successful!");
    }

    public void sensitiveData(String locatorKey,String value) throws ApplicationException {
        log.info("Type the value ["+value.substring(0,2)+"*****] into element ["+locatorKey+"]");
        MobileElement ele= (MobileElement) get.elementBy(locatorKey).get(0);
        ele.setValue(value);
        keyboard.hideIOS();
        log.info("Type Successful!");
    }

    public void data(By locator, String value) throws ApplicationException {
        log.info("Type the value ["+value+"] into element ["+locator+"]");
        MobileElement ele= (MobileElement) get.elementBy(locator).get(0);
        ele.setValue(value);
        keyboard.hideIOS();
        log.info("Type Successful!");
    }

    public void sensitiveData(By locator,String value) throws ApplicationException {
        log.info("Type the value ["+value.substring(0,2)+"*****] into element ["+locator+"]");
        MobileElement ele= (MobileElement) get.elementBy(locator).get(0);
        ele.setValue(value);
        keyboard.hideIOS();
        log.info("Type Successful!");
    }

    public void data(String locatorKey,String value,boolean hideKeyboard) throws ApplicationException {
        log.info("Type the value ["+value+"] into element ["+locatorKey+"]");
        get.elementBy(locatorKey).get(0).sendKeys(value.trim());
        if(hideKeyboard){
            keyboard.hide();
        }
        log.info("Type Successful!");
    }

    public void sensitiveData(String locatorKey,String value,boolean hideKeyboard) throws ApplicationException {
        log.info("Type the value ["+value.substring(0,2)+"*****] into element ["+locatorKey+"]");
        get.elementBy(locatorKey).get(0).sendKeys(value.trim());
        if(hideKeyboard){
            keyboard.hide();
        }
        log.info("Type Successful!");
    }

    public void data(By locator, String value,boolean hideKeyboard) throws ApplicationException {
        log.info("Type the value ["+value+"] into element ["+locator+"]");
        get.elementBy(locator).get(0).sendKeys(value.trim());
        if(hideKeyboard){
            keyboard.hide();
        }
        log.info("Type Successful!");
    }

    public void sensitiveData(By locator,String value,boolean hideKeyboard) throws ApplicationException {
        log.info("Type the value ["+value.substring(0,2)+"*****] into element ["+locator+"]");
        get.elementBy(locator).get(0).sendKeys(value.trim());
        if(hideKeyboard){
            keyboard.hide();
        }
        log.info("Type Successful!");
    }
}