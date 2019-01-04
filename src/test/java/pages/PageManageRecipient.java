package pages;

import base.Keywords;
import base.Test;
import constants.Keys;
import constants.OS;
import constants.ObjectClass;
import exceptions.ApplicationException;
import helper.Device;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import xpath.Matching;

public class PageManageRecipient extends Keywords
{
    private String keyBtnAddNewRecipient="Getgo.ManageRecipient.BtnAdd";
    private String keyTxtRecipientCardNumber="Getgo.ManageRecipient.TxtCard";
    private String keyTxtRecipientName="Getgo.ManageRecipient.TxtRecipientName";
    private String keyBtnSave="Getgo.ManageRecipient.BtnSave";
    private String keyBtnAdd="Getgo.ManageRecipient.BtnAdd";
    private String keyBtnBack="Getgo.ManageRecipient.BtnBack";

    private String keyBtnTxtRecipientCardNumber_iOS="Getgo.ManageRecipient.TxtCard";
    private String keyBtnTxtRecipientName_iOS="Getgo.ManageRecipient.TxtRecipientName";

    private String keyLblTitle="Getgo.ManageRecipient.LblTitle";
    private String keyLblPageDescription="Getgo.ManageRecipient.LblPageDescription";
    private String keyLblAddAsFavouriteVerbiage="Getgo.ManageRecipient.LblAddAsFavouriteVerbiage";
    private String keyBtnToogleSwitchToMarkFavourtite="Getgo.ManageRecipient.BtnToogleSwitchToMarkFavourtite";
    private String keyLblErrorMsg="Getgo.ManageRecipient.LblErrorMsg";


    private String newlyAddedRecipient=null;
    private String newlyAddedRecipientCard=null;

    public void addNewRecipient() throws ApplicationException {

        newlyAddedRecipient= Test.faker.name().firstName()+" "+ Test.faker.name().lastName();
        newlyAddedRecipientCard=Test.tools.cardgenerator("441125",16);

        /*newlyAddedRecipientCard=
                        String.valueOf(Test.faker.number().randomNumber(3,true))+
                        String.valueOf(Test.faker.number().randomNumber(10,true))+
                        String.valueOf(Test.faker.number().randomNumber(3,true));*/
        WAIT.forSeconds(3);
        click.elementBy(keyBtnAddNewRecipient);
        if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.ANDROID)){
            type.data(keyTxtRecipientCardNumber,newlyAddedRecipientCard);
            type.data(keyTxtRecipientName,newlyAddedRecipient);
        }else if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.iOS)){
            type.data(keyBtnTxtRecipientCardNumber_iOS,newlyAddedRecipientCard);
            type.data(keyBtnTxtRecipientName_iOS,newlyAddedRecipient);
        }
        click.elementBy(keyBtnSave);
    }

    public void addToFavourites(String recipientCard) throws ApplicationException {
        WAIT.forSeconds(2);
        swipe.scrollDownToText(recipientCard);
        WebElement parentElement;
        if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.ANDROID))
        {
            parentElement=get.elementBy(By.xpath("//android.widget.TextView[@text='"+recipientCard+"']/parent::*"));
            parentElement.findElements(By.xpath("//"+ ObjectClass.AndroidImageButton)).get(0).click();
        }else if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.iOS))
        {
            parentElement=get.elementBy(By.xpath("//XCUIElementTypeStaticText[@value='"+recipientCard+"']/parent::*"));
            parentElement.findElements(By.xpath("//"+ ObjectClass.iOSButton)).get(0).click();
        }
    }

    public void isRecipientAvailableInFavourites(String recipientCard) throws ApplicationException {
        WAIT.forSeconds(2);
        try{
            get.elementBy(xpathOf.textView(Matching.youDecide(recipientCard))).isDisplayed();
        }catch (Throwable ex){
            swipe.scrollDownToText(recipientCard);
        }
        WebElement parentElement;
        if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.ANDROID))
        {
            parentElement=get.elementBy(By.xpath("//android.widget.TextView[@text='"+recipientCard+"']/parent::*"));
            String isSelected=parentElement.findElements(By.xpath("//"+ ObjectClass.AndroidImageButton)).get(0).getAttribute("selected").trim();
            Assert.assertEquals(isSelected,"true");
            //Assert.assertEquals(isSelected,"true","Recipient is not added to favourites");
        }else if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.iOS))
        {
            parentElement=get.elementBy(By.xpath("//XCUIElementTypeStaticText[@value='"+recipientCard+"']/parent::*"));
            String isSelected=parentElement.findElements(By.xpath("//"+ ObjectClass.iOSButton)).get(0).getAttribute("name").trim();
           // Assert.assertEquals(isSelected,"ic star filled","Recipient is not added to favourites");
            Assert.assertEquals(isSelected,"ic star filled");

        }
    }

    public void goBack() throws ApplicationException {
        click.elementBy(keyBtnBack);
        WAIT.forSeconds(2);
    }

    public String getNewlyAddedRecipientCard()
    {
        return newlyAddedRecipientCard;
    }

    public void verifyPageTitle(String ititle) throws ApplicationException {
        WAIT.forSeconds(1);
        verify.elementTextMatching(keyLblTitle,ititle);
    }

    public void verifyPageContentsAddRecipient() throws ApplicationException {
        if (Device.isAndroid()) {
            verify.elementTextMatching(keyLblPageDescription, "Save your favorite person's card details so you don't have to type it again (that's tiring!).");
            verify.elementIsPresent(keyTxtRecipientCardNumber);
            verify.elementIsPresent(keyTxtRecipientName);
            verify.elementAttributeMatching(keyTxtRecipientName, "text", "Recipient’s Name");
            verify.elementAttributeMatching(keyTxtRecipientCardNumber, "text", "Enter 16-digit card number");
            verify.elementIsPresent(keyBtnBack);
            verify.elementTextMatching(keyLblAddAsFavouriteVerbiage, "ADD AS FAVORITE");
            verify.elementIsPresent(keyBtnToogleSwitchToMarkFavourtite);

        } else {
//            verify.elementTextMatching(keyLblPageDescription, "Save your favorite person's card details so you don't have to type it again (that's tiring!).");
            verify.elementIsPresent(keyTxtRecipientCardNumber);
            verify.elementIsPresent(keyTxtRecipientName);
            verify.elementAttributeMatching(keyTxtRecipientName, "value", "Recipient’s Name");
            verify.elementAttributeMatching(keyTxtRecipientCardNumber, "value", "Enter 16-digit card number");
            verify.elementIsPresent(keyBtnBack);
            verify.elementTextMatching(keyLblAddAsFavouriteVerbiage, "ADD AS FAVORITE");
            verify.elementIsPresent(keyBtnToogleSwitchToMarkFavourtite);
        }
    }

        public void ClickAddToFavouriteToogleIndicator() throws ApplicationException {
            click.elementBy(keyBtnToogleSwitchToMarkFavourtite);
            WAIT.forSeconds(1);

        }

    public void ClickSaveBtn() throws ApplicationException {
        click.elementBy(keyBtnSave);
        WAIT.forSeconds(1);

    }
    public void ClickAddBtn() throws ApplicationException {
        click.elementBy(keyBtnAdd);
        WAIT.forSeconds(1);

    }

    public void addNewRecipientWithoutClickingSaveBtn() throws ApplicationException {

        newlyAddedRecipient= Test.faker.name().firstName()+" "+ Test.faker.name().lastName();
        newlyAddedRecipientCard=Test.tools.cardgenerator("441125",16);

        /*newlyAddedRecipientCard=
                        String.valueOf(Test.faker.number().randomNumber(3,true))+
                        String.valueOf(Test.faker.number().randomNumber(10,true))+
                        String.valueOf(Test.faker.number().randomNumber(3,true));*/
        WAIT.forSeconds(3);
        click.elementBy(keyBtnAddNewRecipient);
        if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.ANDROID)){
            type.data(keyTxtRecipientCardNumber,newlyAddedRecipientCard);
            type.data(keyTxtRecipientName,newlyAddedRecipient);
        }else if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.iOS)){
            type.data(keyBtnTxtRecipientCardNumber_iOS,newlyAddedRecipientCard);
            type.data(keyBtnTxtRecipientName_iOS,newlyAddedRecipient);
        }

    }

    public void EnterCardNumber(String icardnumber) throws ApplicationException {
        type.data(keyTxtRecipientCardNumber,icardnumber);

    }

    public void verifyErrorMessage(String ierror) throws ApplicationException {
        verify.elementTextMatching(keyLblErrorMsg,ierror);
        WAIT.forSeconds(1);

    }


}