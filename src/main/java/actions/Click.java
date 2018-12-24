package actions;

import base.Keywords;
import exceptions.ApplicationException;
import helper.PropertyReader;
import io.appium.java_client.MobileElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Click extends Keywords{

    private static Logger log=Logger.getLogger(Click.class);

    public void elementBy(String locatorKey) throws ApplicationException {
        screenshot.attachScreenshot("Screenshot for the locator "+locatorKey.replaceAll(" ","").replaceAll("//","_").replaceAll("/","-"));
        log.info("Click element ["+locatorKey+"]");
        try{
            get.elementBy(locatorKey).click();
        }catch (StaleElementReferenceException ex){
            get.elementBy(locatorKey).click();
        }
        log.info("Click Successful!");
    }

    public void elementBy(By locator) throws ApplicationException {
        screenshot.attachScreenshot("Screenshot for the locator "+locator.toString().replaceAll(" ","").replaceAll("//","_").replaceAll("/","-"));
        log.info("Click element ["+locator+"]");
        try{
            get.elementBy(locator).click();
        }catch (StaleElementReferenceException ex){
            get.elementBy(locator).click();
        }
        log.info("Click Successful!");
    }

    public void elementsValuesBy(String locatorKey,String ivalue) throws ApplicationException {
        boolean blogic=false;
        screenshot.attachScreenshot("Screenshot for the locator "+locatorKey.replaceAll(" ","").replaceAll("[//]","_").replaceAll("[/]","-"));
        log.info("Click elementsByValues ["+locatorKey+"]");
        try{
            //get.elementBy(locatorKey).click();
            List<WebElement> a=driver.findElements(PropertyReader.locatorOf(locatorKey));

            for (int i = 0; i <a.size(); i++) {
                if((a.get(i).getText().trim()).contentEquals(ivalue.trim()))
                {
                    a.get(i).click();
                    log.info("Clicked on the element " + locatorKey);
                    blogic=true;
                    break;
                }

            }
            if(blogic==true)
            {
                log.info("Click is Successful!");
            }
            else
            {
                throw new ApplicationException("cannot able to click the element in the list.Kindly check the input value");
            }

        }catch (StaleElementReferenceException ex){
            get.elementBy(locatorKey).click();
        }

    }
    public void chooseDOB(String tyear,String tmonth,String tday) throws ApplicationException {
        screenshot.attachScreenshot("chooseDOB");
        int year=Integer.parseInt(tyear);
        String month=tmonth.substring(0,3).trim();
        //int date=Integer.parseInt(tday);
        String formatdate=tday+" "+tmonth+" "+tyear;
        String imonth;
        //for loop iteration
        int loopcount=10;
        String iyear;
        iyear=driver.findElement(By.id("android:id/date_picker_header_year")).getText();
        if(year==Integer.parseInt(iyear.trim()))
        {

        }
        else
        {
            click.elementBy(By.id("android:id/date_picker_header_year"));

            for(int i=0;i<loopcount;i++)
            {
                try
                {
                    List<WebElement> el=driver.findElements(By.id("android:id/text1"));
                    for(int j=0;j<el.size();j++)
                    {
                        if(el.get(j).getText().toString().contentEquals(tyear.toLowerCase().trim()))
                        {
                            el.get(j).click();
                            break;
                        }
                        else
                        {
                            swipe.vertical(2,0.3,0.8,5);

                        }
                    }
                    click.elementBy(By.id("android:id/button1"));
                }
                catch(Exception ex)
                {
                    swipe.vertical(2,0.8,0.4,5);
                }

            }

        }
    }


    public void chooseTransactionDate(String tyear,String tmonth,String tday) throws ApplicationException {
        screenshot.attachScreenshot("chooseTransactionDate");
        int year=Integer.parseInt(tyear);
        String month=tmonth.substring(0,3).trim();
        //int date=Integer.parseInt(tday);
        String formatdate=tday+" "+tmonth+" "+tyear;
        String iyear;
        String imonth;
        //for loop iteration
        int loopcount=10;

        HashMap<String,String> imap=new LinkedHashMap<>();

        imap.put("Jan","01");
        imap.put("Feb","02");
        imap.put("Mar","03");
        imap.put("Apr","04");
        imap.put("May","05");
        imap.put("Jun","06");
        imap.put("Jul","07");
        imap.put("Aug","08");
        imap.put("Sep","09");
        imap.put("Oct","10");
        imap.put("Nov","11");
        imap.put("Dec","12");

        iyear=driver.findElement(By.id("android:id/date_picker_header_year")).getText();

        if(year==Integer.parseInt(iyear.trim()))
        {
            imonth = driver.findElement(By.id("android:id/date_picker_header_date")).getText();
            imonth=imonth.substring(imonth.length()-3);
            int ivalue=Integer.parseInt(imap.get(imonth));
            for(int i=ivalue;i<=12;i++) {
                if (imonth.contentEquals(month)) {
                    driver.findElement(By.xpath("//android.view.View[@text='" + tday + "']")).click();
                    break;
                } else {
                    driver.findElement(By.id("android:id/next")).click();
                }

            }

           // driver.findElement(By.id("android:id/button1")).click();

        }
        else
        {
            click.elementBy(By.id("android:id/date_picker_header_year"));

            for(int i=0;i<loopcount;i++)
            {
            try
            {
                List<WebElement> el=driver.findElements(By.id("android:id/text1"));
                for(int j=0;j<el.size();j++)
                {
                    if(el.get(j).getText().toString().contentEquals(tyear.toLowerCase().trim()))
                    {
                        el.get(j).click();
                        break;
                    }
                    else
                    {
                        swipe.vertical(2,0.3,0.8,5);

                    }
                }
                //click.elementBy(By.id("android:id/button1"));
            }
            catch(Exception ex)
            {
                swipe.vertical(2,0.8,0.4,5);
            }

        }

            imonth = driver.findElement(By.id("android:id/date_picker_header_date")).getText();
            imonth=imonth.substring(imonth.length()-3);
            int ivalue=Integer.parseInt(imap.get(imonth));
            for(int i=ivalue;i<=12;i++) {
                if (imonth.contentEquals(month)) {
                    driver.findElement(By.xpath("//android.view.View[@text='" + tday + "']")).click();
                    break;
                } else {
                    driver.findElement(By.id("android:id/next")).click();
                }

            }



        }

        driver.findElement(By.id("android:id/button1")).click();
    }

}
