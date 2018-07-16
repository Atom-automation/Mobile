package pages;

import base.Keywords;
import base.Test;
import constants.Keys;
import constants.OS;
import exceptions.ApplicationException;
import xpath.Contains;
import xpath.Matching;

import java.text.ParseException;

public class PageCardTransferReview extends Keywords {

    private String keyBtnTransfer="Getgo.CardTransferReview.BtnTransfer.XPATH";

    public void fromDetails(String fromCard,String fromUser) throws ApplicationException {
        verify.elementTextContains(xpathOf.textView(Contains.youDecide(fromUser.substring(0,4))),fromUser);
        verify.elementTextContains(xpathOf.textView(Contains.youDecide(fromCard.substring(0,4))),fromCard);
    }

    public void toDetails(String toCard,String toUser) throws ApplicationException {
        //verify.elementTextContains(xpathOf.textView(Contains.youDecide(toUser.substring(0,4))),toUser);
        verify.elementTextContains(xpathOf.textView(Contains.youDecide(toCard.substring(0,4))),toCard);
    }

    public void transferAmount(double transferAmount) throws ApplicationException {
        verify.isMatching(Test.tools.pesoAmount(transferAmount), Test.tools.fixAmountIssue(get.elementBy("Getgo.CardTransferReview.lblTransferAmount.XPATH").getText()));
    }

    public void transferDate(String day,String month,String year) throws ParseException, ApplicationException {
        String transferDate=null;
        if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.ANDROID))
        {
            transferDate = Test.tools.getDateInFormat(day,month,year,"MMMM dd, YYYY");
        }else if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.iOS))
        {
            transferDate = Test.tools.getDateInFormat(day,month,year,"MMM dd, YYYY");
        }
        verify.elementTextContains(xpathOf.textView(Matching.youDecide(transferDate)),transferDate);
    }

    public void transferFees(double transferFees) throws ApplicationException {
        verify.isMatching(Test.tools.pesoAmount(transferFees), Test.tools.fixAmountIssue(get.elementBy("Getgo.CardTransferReview.LblTransferFees.XPATH").getText()));
    }

    public void clickTransfer() throws ApplicationException {
        click.elementBy(keyBtnTransfer);
    }
}