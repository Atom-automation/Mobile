package pages;

import base.Keywords;
import base.Test;
import constants.Keys;
import constants.OS;
import exceptions.ApplicationException;
import helper.Device;
import io.appium.java_client.MobileBy;
import xpath.Matching;

import java.text.DecimalFormat;

public class PageCardTransfer extends Keywords
{
    private String keyTxtRecipientCard="Getgo.CardTransfer.TxtCard";
    private String keyTxtRecipientName="Getgo.CardTransfer.TxtRecipientName";
    private String keyTxtAmount="Getgo.CardTransfer.TxtAmount";
    private String keyBtnCalendar="Getgo.CardTransfer.BtnCalendar";
    private String keyBtnFrequencyDropdown="Getgo.CardTransfer.BtnFrequencyDropdown";
    private String keyTxtMessage="Getgo.CardTransfer.TxtMessage";
    private String keyBtnNext="Getgo.CardTransfer.BtnNext";
    private String keyLblAvailableBalance="Getgo.CardTransfer.LblAvailableBalance";
    private String keyBtnAddRecipient="Getgo.CardTransfer.BtnAddRecipient";
    private String keyBtnManageRecipientBottom="Getgo.CardTransfer.BtnManageRecipientBottom";
    private String keyLblPageTitle="Getgo.CardTransfer.LblPageTitle";
    private String keyBtnActivitiesBottom="Getgo.CardTransfer.BtnActivitiesBottom";

    private String keyLblPageHeader="Getgo.CardTransfer.LblPageHeader";
    private String keyLblPageDescriptionBottom="Getgo.CardTransfer.LblPageDescriptionBottom";
    private String keyLblCurrencyTranferFrom="Getgo.CardTransfer.LblCurrencyTranferFrom";
    private String keyLblCurrencyLogo="Getgo.CardTransfer.LblCurrencyLogo";
    private String keyLblCurrencyverbiage="Getgo.CardTransfer.LblCurrencyverbiage";
    private String keyLblAvailableBalanceText="Getgo.CardTransfer.LblAvailableBalanceText";

    private String keyLblRepeatText="Getgo.CardTransfer.LblRepeatText";
    private String keyToogleSwitch="Getgo.CardTransfer.ToogleSwitch";
    private String keyBtnEndDateDropdown="Getgo.CardTransfer.BtnEndDateDropdown";
    private String keyBtnScheduledActivitiesBottom="Getgo.CardTransfer.BtnScheduledActivitiesBottom";

    DecimalFormat df = new DecimalFormat("###.##");
    private double beforeBalance;


    public void enterCardNumber(String cardNumber) throws ApplicationException {
        type.data(keyTxtRecipientCard,cardNumber);
    }

    public void enterRecipient(String recipient) throws ApplicationException {
        type.data(keyTxtRecipientName,recipient);
    }

    public void selectRecipientFromSavedList(String recipient) throws ApplicationException {
        click.elementBy(keyBtnAddRecipient);
        WAIT.forSeconds(3);
        swipe.scrollDownToText(recipient);
        if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.ANDROID))
        {
            click.elementBy(xpathOf.textView(Matching.text(recipient)));
        }else if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.iOS))
        {
            click.elementBy(MobileBy.AccessibilityId(recipient));
        }
    }

    public void enterAmount(double amount) throws ApplicationException {
        type.data(keyTxtAmount,Integer.toString((int) amount));
    }

    public void selectDate(String day,String month,String year) throws ApplicationException {
        click.elementBy(keyBtnCalendar);
        if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.ANDROID))
        {
            // Code to select a specific date needs to be added for android
            click.elementBy("Getgo.CardTransfer.BtnAndroidDatePickerOk");
        }else if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.iOS))
        {
            ios.datePicker(day,month,year);
        }
    }

    public void selectFrequency(String frequency) throws ApplicationException {
        click.elementBy(keyBtnFrequencyDropdown);
        if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.ANDROID))
        {
            click.elementBy(xpathOf.textView(Matching.youDecide(frequency)));
        }else if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.iOS))
        {
            ios.selectPicker(frequency);
        }
    }

    public void enterMessage(String message) throws ApplicationException {
        type.data(keyTxtMessage,message);
    }

    public void clickNext() throws ApplicationException {
        WAIT.forSeconds(10);
        beforeBalance= Double.parseDouble(get.elementText(keyLblAvailableBalance).replaceAll("\\u00A0","").replaceAll(",",""));
        click.elementBy(keyBtnNext);
    }

    public void clickAddRecipient() throws ApplicationException {
        WAIT.forSeconds(3);
        swipe.vertical(2,0.9,0.4,5);
        click.elementBy(keyBtnManageRecipientBottom);
    }


    public double getBeforeBalance()
    {
        df.format(beforeBalance);
        return beforeBalance;
    }

    public void verifyPageTitle(String ititle) throws ApplicationException {
        WAIT.forSeconds(3);
        verify.elementTextMatching(keyLblPageTitle,ititle);
    }

    public void clickActivitiesOption() throws ApplicationException {
        swipe.vertical(2,0.8,0.5,3);
        click.elementBy(keyBtnActivitiesBottom);
        WAIT.forSeconds(5);
    }
    public void verifyPageContentDetails() throws ApplicationException {
    verify.elementIsPresent(keyTxtRecipientCard);
    //verify.elementIsPresent(keyTxtRecipientName);
    verify.elementIsPresent(keyTxtAmount);
    verify.elementIsPresent(keyBtnCalendar);
    verify.elementIsPresent(keyTxtMessage);
    verify.elementIsPresent(keyBtnNext);
    verify.elementIsPresent(keyLblAvailableBalance);
    verify.elementTextMatching(keyLblPageHeader,"TRANSFER TO:");
    verify.elementTextContains(keyLblPageDescriptionBottom,"Don't forget to double-check the amount and card number you entered. Everything you do here is real time and money will be sent immediately.");
    verify.elementTextMatching(keyLblCurrencyTranferFrom,"Transfer From:");
    verify.elementIsPresent(keyLblCurrencyLogo);
    verify.elementIsPresent(keyLblCurrencyverbiage);
    verify.elementTextMatching(keyLblRepeatText,"REPEAT");
    if(Device.isAndroid()) {
        verify.elementTextMatching(keyLblAvailableBalanceText, "Available Balance");
    }
    else
    {
        verify.elementIsPresent(keyLblAvailableBalanceText);
    }

}

    public void SwitchRepeatToogleIndicator() throws ApplicationException {
        click.elementBy(keyToogleSwitch);
        WAIT.forSeconds(1);
        verify.elementIsPresent(keyBtnFrequencyDropdown);
        verify.elementIsPresent(keyBtnEndDateDropdown);
    }

    public void chooseFrequency(String frequencyvalue) throws ApplicationException
    {
        click.elementBy(keyBtnFrequencyDropdown);
        swipe.scrollDownToTextandClick(frequencyvalue);
        WAIT.forSeconds(1);
    }

    public void chooseEndDate(String endDatevalue) throws ApplicationException
    {
        click.elementBy(keyBtnEndDateDropdown);
        swipe.scrollDownToTextandClick(endDatevalue);
        WAIT.forSeconds(1);
    }

    public void chooseTransactionDate(String year, String month,String date) throws ApplicationException
    {
        click.chooseTransactionDate(year,month,date);
        WAIT.forSeconds(1);
    }

    public String getAvailabelBalance() throws ApplicationException
    {
        return get.elementText(keyLblAvailableBalance);
    }

    public void clickManageScheduledActivitiesOption() throws ApplicationException {
        swipe.vertical(2,0.8,0.5,3);
        click.elementBy(keyBtnScheduledActivitiesBottom);
        WAIT.forSeconds(5);
    }

}
