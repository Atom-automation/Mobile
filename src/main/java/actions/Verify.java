package actions;

import base.Keywords;
import base.Test;
import exceptions.ApplicationException;
import io.appium.java_client.MobileBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Verify extends Keywords{

    private static Logger log=Logger.getLogger(Verify.class);

    public void elementIsPresent(String locatorKey) throws ApplicationException {
        log.info("Verify element ["+locatorKey+"] is present");
        get.elementBy(locatorKey);
        log.info("Element is present!");
    }

    public void elementIsPresent(By locator) throws ApplicationException {
        log.info("Verify element ["+locator+"] is present");
        get.elementBy(locator);
        log.info("Element is present!");
    }

    public void elementTextMatching(String locatorKey,String expectedValue) throws ApplicationException {
        log.info("Verify element ["+locatorKey+"] text is matching with ["+expectedValue+"]");
        String actualValue=Test.tools.REMOVE_MULTIPLE_SPACES_AND_NEW_LINES(get.elementBy(locatorKey).getText().trim());
        try{
            isMatching(expectedValue,actualValue);
        }catch (Exception ex){
            log.error(ex);
            throw new ApplicationException(ex.getMessage());
        }
        log.info("Condition verified!");
    }

    public void elementTextContains(String locatorKey,String expectedValue) throws ApplicationException {
        log.info("Verify element ["+locatorKey+"] text is matching with ["+expectedValue+"]");
        String actualValue=Test.tools.REMOVE_MULTIPLE_SPACES_AND_NEW_LINES(get.elementBy(locatorKey).getText().trim());
        try{
            Assert.assertTrue(actualValue.contains(expectedValue.trim()),"Condition failed!, actual value doesn't contains the expected value");
        }catch (Exception ex){
            log.error(ex);
            throw new ApplicationException(ex.getMessage());
        }
        log.info("Condition verified!");
    }

    public void elementTextMatching(By locator,String expectedValue) throws ApplicationException {
        log.info("Verify element ["+locator+"] text is matching with ["+expectedValue+"]");
        String actualValue=Test.tools.REMOVE_MULTIPLE_SPACES_AND_NEW_LINES(get.elementBy(locator).getText().trim());
        try{
            isMatching(expectedValue,actualValue);
        }catch (Exception ex){
            log.error(ex);
            throw new ApplicationException(ex.getMessage());
        }
        log.info("Condition verified!");
    }

    public void elementTextContains(By locator,String expectedValue) throws ApplicationException {
        log.info("Verify element ["+locator+"] text is matching with ["+expectedValue+"]");
        String actualValue=Test.tools.REMOVE_MULTIPLE_SPACES_AND_NEW_LINES(get.elementBy(locator).getText().trim());
        try{
            Assert.assertTrue(actualValue.contains(expectedValue.trim()),"Condition failed!, actual value doesn't contains the expected value");
        }catch (Exception ex){
            log.error(ex);
            throw new ApplicationException(ex.getMessage());
        }
        log.info("Condition verified!");
    }

    public void isMatching(String expected,String actual){
        Assert.assertTrue(actual.equalsIgnoreCase(expected.trim()),"Condition failed!, actual value doesn't match with expected value");
    }

    public void elementAttributeMatching(String locatorKey, String whichAttribute,String expectedValue) throws ApplicationException {
        log.info("Verify if the element ["+locatorKey+"] attribute ["+whichAttribute+"] is matching with the value ["+expectedValue+"]");
        try{
            Assert.assertEquals(get.elementAttribute(locatorKey,whichAttribute),expectedValue.trim());
        }catch (AssertionError ex){
            log.error(ex);
            throw new ApplicationException(ex.getMessage());
        }
    }

    public void elementAttributeMatching(By locator, String whichAttribute,String expectedValue) throws ApplicationException {
        log.info("Verify if the element ["+locator+"] attribute ["+whichAttribute+"] is matching with the value ["+expectedValue+"]");
        try{
            Assert.assertEquals(get.elementAttribute(locator,whichAttribute),expectedValue.trim());
        }catch (AssertionError ex){
            log.error(ex);
            throw new ApplicationException(ex.getMessage());
        }
    }
}