package pages;

import base.Keywords;
import base.Test;
import constants.Keys;
import exceptions.ApplicationException;
import helper.Device;
import helper.PropertyReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.URL;

public class PageVerificationLink extends Keywords {

    AppiumDriver<WebElement> browser;
    WebDriverWait browserWait;

    public void openOutlook(String username, String password) throws ApplicationException{
       driver.quit();
        DesiredCapabilities cap=new DesiredCapabilities();
        if(Device.isAndroid()) {
            cap.setCapability("platformName", "Android");
            cap.setCapability("platformVersion", PropertyReader.valueOf("Device." + Test.attributes.get(Keys.Device) + ".Version"));
            cap.setCapability("deviceName", PropertyReader.valueOf("Device." + Test.attributes.get(Keys.Device) + ".Name"));
            cap.setCapability("udid", PropertyReader.valueOf("Device." + Test.attributes.get(Keys.Device) + ".ID"));
            cap.setCapability("newCommandTimeout", Integer.parseInt(PropertyReader.valueOf("Driver.Appium.CommandTimeout")));
            cap.setCapability("browserName", BrowserType.CHROME);
            try {
                browser = new AppiumDriver<>(new URL(PropertyReader.valueOf("Driver.ServerAddress")), cap);
            } catch (Throwable ex) {
                throw new ApplicationException("Failed to open chrome browser on the device");
            }
            browser.get("https://outlook.office.com");
            browserWait = new WebDriverWait(browser, 30);
            getWebElement(By.id("i0116")).sendKeys(username);
            keyboard.hideIfAndroid();
            getWebElement(By.id("idSIButton9")).click();
            WAIT.forSeconds(2);
            getWebElement(By.id("i0118")).sendKeys(password);
            keyboard.hideIfAndroid();
            getWebElement(By.id("idSIButton9")).click();
            WAIT.forSeconds(2);
            getWebElement(By.id("idBtn_Back")).click();
        }
        else
        {
            cap.setCapability("platformName", "ios");
            cap.setCapability("automationName", "XCUITest");
            cap.setCapability("platformVersion", PropertyReader.valueOf("Device." + Test.attributes.get(Keys.Device) + ".Version"));
            cap.setCapability("deviceName", PropertyReader.valueOf("Device." + Test.attributes.get(Keys.Device) + ".Name"));
            cap.setCapability("udid", PropertyReader.valueOf("Device." + Test.attributes.get(Keys.Device) + ".ID"));
            cap.setCapability("newCommandTimeout", Integer.parseInt(PropertyReader.valueOf("Driver.Appium.CommandTimeout")));
            cap.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");
            cap.setCapability("safariAllowPopups", "true");
            //cap.setCapability("safariOpenLinksInBackground", "true");
            try {
                browser = new IOSDriver<WebElement>(new URL(PropertyReader.valueOf("Driver.ServerAddress")), cap);
            } catch (Throwable ex) {
                throw new ApplicationException("Failed to open safari browser on the device");
            }
            browser.get("https://outlook.office.com");
            browserWait = new WebDriverWait(browser, 30);
            try {
                getWebElement(By.id("i0116")).sendKeys(username);
                keyboard.hideIfIOS();
                getWebElement(By.id("idSIButton9")).click();
                WAIT.forSeconds(2);
                getWebElement(By.id("i0118")).sendKeys(password);
                keyboard.hideIfIOS();
                getWebElement(By.id("idSIButton9")).click();
                WAIT.forSeconds(2);
                // getWebElement(By.id("idBtn_Back")).click();
            }
            catch(Exception ex)
            {
                getWebElement(By.xpath("(//div[@class='row tile'])[1]/div")).click();
                WAIT.forSeconds(2);
                getWebElement(By.id("i0118")).sendKeys(password);
                keyboard.hideIfIOS();
                getWebElement(By.id("idSIButton9")).click();
                WAIT.forSeconds(2);
            }
        }
    }

    public void openVerificationEmail(String fullName) throws ApplicationException, InterruptedException {
        //getWebElement(By.xpath("//span[contains(text(),'"+fullName+"')]")).click();
        Thread.sleep(2000);
        getWebElement(By.xpath("(//span[text()='Get started today: Verify your email now.'])[1]/parent::*/parent::*/parent::*/parent::*")).click();
        //String verificationLink=getWebElement(By.xpath("//a[contains(text(),'https://')]")).getText();
        //browser.get(verificationLink);
        Thread.sleep(2000);
        getWebElement(By.xpath("//a[text()='Verify Now ']")).click();

    }

    public void isVerificationSuccess() throws ApplicationException {
        String expectedValue="Email Verified";
        WAIT.forSeconds(2);
        String actualValue=getWebElement(By.xpath("//h1[text()='Email Verified']")).getText().trim();
        Assert.assertEquals(actualValue,expectedValue);
        browser.quit();
    }

    private WebElement getWebElement(By locator) throws ApplicationException {
        WebElement ele;
        try{
            ele=browserWait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }catch (WebDriverException ex){
            ele=browserWait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }catch (Throwable ex){
            throw new ApplicationException("Couldn't find the element --> "+locator);
        }
        return ele;
    }

    private boolean verifyElementValue(By locator,String iactual) throws ApplicationException {
        boolean breturn=false;
        try{
            String expectedString=getWebElement(locator).getText();
            Assert.assertEquals(expectedString,iactual);
            breturn=true;
        }catch (Throwable ex){
            breturn=false;
            throw new ApplicationException("Error in verifying the value" +ex.getMessage());
        }
        return breturn;
    }


    public void openResetPasswordVerificationEmail() throws ApplicationException, InterruptedException {
        //getWebElement(By.xpath("//span[text()='Other']")).click();
        Thread.sleep(2000);
        browser.navigate().refresh();
        Thread.sleep(5000);
        getWebElement(By.xpath("//span[text()='Password Reset']")).click();
        String verificationLink=getWebElement(By.xpath("//a[contains(text(),'https://qz1lx46m.ngrok.io/reset-password?passwordResetId=')]")).getText();
        browser.get(verificationLink);
    }

    public void verifyandEnterReset(String pwd,String confirmpwd) throws ApplicationException, InterruptedException {
       String expectedString=getWebElement(By.xpath("//h1[text()='Reset your Password']")).getText();
       Assert.assertEquals(expectedString,"Reset your Password");
       getWebElement(By.id("new_password")).isDisplayed();
        getWebElement(By.id("confirm_password")).isDisplayed();

        getWebElement(By.id("new_password")).sendKeys(pwd);
        getWebElement(By.id("confirm_password")).sendKeys(confirmpwd);
        Thread.sleep(3000);
         getWebElement(By.xpath("//button[@type='submit']")).click();

        String expectedmessage=getWebElement(By.xpath("//p[text()='Your password has been successfully changed']")).getText();
        Assert.assertEquals(expectedmessage,"Your password has been successfully changed");
        getWebElement(By.linkText("BACK TO LOGIN")).isDisplayed();
    }

    public void closebrowser()
    {
        browser.quit();
    }


}