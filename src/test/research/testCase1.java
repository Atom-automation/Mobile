import base.Keywords;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class testCase1 extends Keywords {

    private static IOSDriver<MobileElement> app=null;

    public static void main(String[] args) throws MalformedURLException {

        openApp();
        gotoManageRecipientScreen();

    }

    private static void gotoManageRecipientScreen()
    {
        app.findElement(MobileBy.AccessibilityId("LOG IN")).click();
        app.findElement(MobileBy.xpath("//XCUIElementTypeTextField[@value='Email']")).sendKeys("john@does.com");
        keyboard.hideIOS();
        app.findElement(MobileBy.AccessibilityId("NEXT")).click();
        app.findElement(MobileBy.xpath("//XCUIElementTypeTextField[@value='Password']")).sendKeys("hello1234*");
        keyboard.hideIOS();
        app.findElement(MobileBy.AccessibilityId("LOGIN")).click();
        app.findElement(MobileBy.AccessibilityId("ic menu")).click();
        app.findElement(MobileBy.xpath("//XCUIElementTypeTextField[@value='Card Transfer']")).click();
        app.findElement(MobileBy.AccessibilityId("ic_add")).click();
    }

    private static void openApp() throws MalformedURLException {
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability("udid","b2d1f044ba24ce70691a5aca73b919681c869649");
        cap.setCapability("deviceName","IPhoneX");
        cap.setCapability("platformName","iOS");
        cap.setCapability("platformVersion","11.3");
        cap.setCapability("bundleId","com.unionbankph.getgopay-QAT");
        app=new IOSDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
        app.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }
}
