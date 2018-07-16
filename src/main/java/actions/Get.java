package actions;

import base.Keywords;
import exceptions.ApplicationException;
import helper.PropertyReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Get extends Keywords{

    private static Logger log=Logger.getLogger(Get.class);
    private static List<WebElement> testObj=null;
    private static WebElement singleTestObj=null;

    public WebElement elementBy(String locatorKey) throws ApplicationException {
        try{
            singleTestObj=wait.until(ExpectedConditions.presenceOfElementLocated(PropertyReader.locatorOf(locatorKey)));
        }catch(TimeoutException ex) {
            log.error("Element ["+locatorKey+"] not found!");
            throw new ApplicationException("Element ["+locatorKey+"] not found!");
        }
        return singleTestObj;
    }

    public WebElement elementBy(By locator) throws ApplicationException {
        try{
            singleTestObj=wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }catch(TimeoutException ex) {
            log.error("Element ["+locator+"] not found!");
            throw new ApplicationException("Element ["+locator+"] not found!");
        }
        return singleTestObj;
    }
}