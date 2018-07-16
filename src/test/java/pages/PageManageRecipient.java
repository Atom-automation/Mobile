package pages;

import base.Keywords;
import base.Test;
import constants.Keys;
import constants.OS;
import constants.ObjectClass;
import exceptions.ApplicationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import xpath.Matching;

public class PageManageRecipient extends Keywords
{
    private String keyBtnAddNewRecipient="Getgo.ManageRecipient.BtnAdd.ID";
    private String keyTxtRecipientCardNumber="Getgo.ManageRecipient.TxtCard.ID";
    private String keyTxtRecipientName="Getgo.ManageRecipient.TxtRecipientName.ID";
    private String keyBtnSave="Getgo.ManageRecipient.BtnSave.ID";
    private String keyBtnBack="Getgo.ManageRecipient.BtnBack.XPATH";

    private String newlyAddedRecipient= Test.faker.name().firstName()+" "+ Test.faker.name().lastName();
    private String newlyAddedRecipientCard=

            String.valueOf(Test.faker.number().randomNumber(3,true))+
            String.valueOf(Test.faker.number().randomNumber(10,true))+
            String.valueOf(Test.faker.number().randomNumber(3,true));

    public void addNewRecipient() throws ApplicationException {
        click.elementBy(keyBtnAddNewRecipient);
        type.data(keyTxtRecipientCardNumber,newlyAddedRecipientCard);
        type.data(keyTxtRecipientName,newlyAddedRecipient);
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

        }
    }

    public void isRecipientAvailableInFavourites(String recipientCard) throws ApplicationException {
        verify.elementIsPresent(xpathOf.textView(Matching.youDecide(recipientCard)));
    }

    public void goBack() throws ApplicationException {
        click.elementBy(keyBtnBack);
    }

    public String getNewlyAddedRecipientCard()
    {
        return newlyAddedRecipientCard;
    }
}