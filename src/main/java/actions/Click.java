package actions;

import base.Keywords;
import exceptions.ApplicationException;
import io.appium.java_client.MobileBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class Click extends Keywords{

    private static Logger log=Logger.getLogger(Click.class);

    public void elementBy(String locatorKey) throws ApplicationException {
        log.info("Click element ["+locatorKey+"]");
        get.elementBy(locatorKey).get(0).click();
        log.info("Clicked!");
    }

    public void elementBy(By locator) throws ApplicationException {
        log.info("Click element ["+locator+"]");
        get.elementBy(locator).get(0).click();
        log.info("Clicked!");
    }
}
