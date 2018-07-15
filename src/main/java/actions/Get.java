package actions;

import base.Keywords;
import exceptions.ApplicationException;
import helper.PropertyReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.function.Function;

public class Get extends Keywords{

    private static Logger log=Logger.getLogger(Get.class);
    private static List<WebElement> testObj=null;

    public List<WebElement> elementBy(String locatorKey) throws ApplicationException {
        try{
            testObj=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(PropertyReader.locatorOf(locatorKey)));
        }catch(TimeoutException ex) {
            log.error("Element ["+locatorKey+"] not found!");
            throw new ApplicationException("Element ["+locatorKey+"] not found!");
        }
        return testObj;
    }

    public List<WebElement> elementBy(By locator) throws ApplicationException {
        try{
            testObj=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        }catch(TimeoutException ex) {
            log.error("Element ["+locator+"] not found!");
            throw new ApplicationException("Element ["+locator+"] not found!");
        }
        return testObj;
    }
}