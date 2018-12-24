package pages;

import base.Keywords;
import base.Test;
import com.cucumber.listener.Reporter;
import constants.Keys;
import constants.OS;
import exceptions.ApplicationException;

public class PageCardTransferSuccess extends Keywords {

    /*private String keyImgGetgoLogo="Getgo.CardTransferSuccess.ImgGetgoLogo";
    private String keyLblCongrats="Getgo.CardTransferSuccess.LblCongrats";
    private String keyLblMessage="Getgo.CardTransferSuccess.LblMessage";
    private String keyBtnViewDetails="Getgo.CardTransferSuccess.BtnViewDetails";
    private String keyBtnDashboard="Getgo.CardTransferSuccess.BtnDashboard";
    */


    private String keyLblSTPageTitle="Getgo.CardTransferSuccess.LblSTPageTitle";
    private String keyLblSTPageSCID="Getgo.CardTransferSuccess.LblSTPageSCID";
    private String keyLblSTPageRefNo="Getgo.CardTransferSuccess.LblSTPageRefNo";
    private String keyLblSTPageTransferDate="Getgo.CardTransferSuccess.LblSTPageTransferDate";
    private String keyLblSTPageTransferTo="Getgo.CardTransferSuccess.LblSTPageTransferTo";
    private String keyLblSTPageAmount="Getgo.CardTransferSuccess.LblSTPageAmount";
    private String keyLblSTPageTransactionNote="Getgo.CardTransferSuccess.LblSTPageTransactionNote";
    private String keyLblSTPageStartDate="Getgo.CardTransferSuccess.LblSTPageStartDate";
    private String keyLblSTPageFrequency="Getgo.CardTransferSuccess.LblSTPageFrequency";
    private String keyLblSTPageEndDate="Getgo.CardTransferSuccess.LblSTPageEndDate";
    private String keyLblSTPageMessage="Getgo.CardTransferSuccess.LblSTPageMessage";
    private String keyBtnSTPageNewTransaction="Getgo.CardTransferSuccess.BtnSTPageNewTransaction";
    private String keyBtnSTPageDashboard="Getgo.CardTransferSuccess.BtnSTPageDashboard";
    private String keyBtnSTPageBack="Getgo.CardTransferSuccess.BtnSTPageBack";
    private String keyLblSTPageDescription="Getgo.CardTransferSuccess.LblSTPageDescription";
    private String keyLblSTPageEndBalance="Getgo.CardTransferSuccess.LblSTPageEndBalance";

    private String keySTTitleScheduledID="Getgo.CardTransferReview.STTitleScheduledID";
    private String keySTTitleReferenceNo="Getgo.CardTransferReview.STTitleReferenceNo";
    private String keySTTitleTransactionDate="Getgo.CardTransferReview.STTitleTransactionDate";
    private String keySTitleDescription="Getgo.CardTransferReview.STitleDescription";
    private String keySTTitleTransferTo="Getgo.CardTransferReview.STTitleTransferTo";
    private String keySTTitleAmount="Getgo.CardTransferReview.STTitleAmount";
    private String keySTTitleMessage="Getgo.CardTransferReview.STTitleMessage";
    private String keySTitleEndBalance="Getgo.CardTransferReview.STitleEndBalance";
    private String keySTitleStartDate="Getgo.CardTransferReview.STitleStartDate";
    private String keySTitleFrequency="Getgo.CardTransferReview.STitleFrequency";
    private String keySTitleEndDate="Getgo.CardTransferReview.STitleEndDate";

   /* public void isTransferSuccess() throws ApplicationException {
        verify.elementIsPresent(keyImgGetgoLogo);
        if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.ANDROID))
        {
            WAIT.forSeconds(6);
            verify.elementTextContains(keyLblCongrats,"You did it!");
            verify.elementTextContains(keyLblMessage,"You just sent money!");
        }else if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.iOS))
        {
            WAIT.forSeconds(5);
            verify.elementIsPresent(keyLblCongrats);
            verify.elementIsPresent(keyLblMessage);
            WAIT.forSeconds(2);
        }
    }

    public void viewDetails() throws ApplicationException {
        click.elementBy(keyBtnViewDetails);
        WAIT.forSeconds(10);
    }

    public void gotoDashboard() throws ApplicationException {
        click.elementBy(keyBtnDashboard);
        WAIT.forSeconds(5);
    }*/

    public void isTransferCompleteSuccess() throws ApplicationException {
        WAIT.forSeconds(10);
        verify.elementTextMatching(keyLblSTPageTitle,"Transaction Complete");

    }



    public void TransferCompletePageDetails(String iamount,String iDescription,String iendbalance,String iMessage) throws ApplicationException {
        WAIT.forSeconds(2);

        verify.elementTextMatching(keySTTitleReferenceNo,"Transaction Reference No.:");
        verify.elementTextMatching(keySTTitleTransactionDate,"Transaction Date:");
        verify.elementTextMatching(keySTitleDescription,"Description:");
        verify.elementTextMatching(keySTTitleTransferTo,"Send Money To:");
        verify.elementTextMatching(keySTTitleAmount,"Transaction Amount:");
        verify.elementTextMatching(keySTTitleMessage,"Message:");
        verify.elementTextMatching(keySTitleEndBalance,"End Balance:");

        verify.elementIsPresent(keyBtnSTPageBack);
        verify.elementIsPresent(keyLblSTPageRefNo);
        verify.elementIsPresent(keyLblSTPageTransferDate);
        verify.elementTextMatching(keyLblSTPageDescription,iDescription);
        verify.elementIsPresent(keyLblSTPageTransferTo);
        verify.elementTextMatching(keyLblSTPageAmount,iamount);
        verify.elementTextMatching(keyLblSTPageTransactionNote,"A PHP 20.00 transaction fee was charged on top of this transaction.");
        verify.elementTextMatching(keyLblSTPageMessage,iMessage);
        verify.elementTextMatching(keyLblSTPageEndBalance,iendbalance);
        swipe.vertical(2,0.8,0.4,5);
        verify.elementIsPresent(keyBtnSTPageNewTransaction);
        verify.elementTextMatching(keyBtnSTPageNewTransaction,"NEW TRANSACTION");
        verify.elementIsPresent(keyBtnSTPageDashboard);
        verify.elementTextMatching(keyBtnSTPageDashboard,"GO TO DASHBOARD");
        swipe.vertical(2,0.4,0.8,5);

    }

    public void ScheduledTransferCompletePageDetails(String iamount,String irepeat,String iMessage) throws ApplicationException {
        WAIT.forSeconds(2);

        verify.elementTextMatching(keySTTitleScheduledID,"Schedule Id:");
        verify.elementTextMatching(keySTTitleReferenceNo,"Transaction Reference No.:");
        verify.elementTextMatching(keySTTitleTransactionDate,"Transaction Date:");
        //verify.elementTextMatching(keySTitleDescription,"Description:");
        verify.elementTextMatching(keySTTitleTransferTo,"Send Money To:");
        verify.elementTextMatching(keySTTitleAmount,"Transaction Amount:");
        //verify.elementTextMatching(keySTitleEndBalance,"End Balance:");
        swipe.vertical(2,0.8,0.4,5);
        verify.elementTextMatching(keySTitleStartDate,"Start Date:");
        verify.elementTextMatching(keySTitleFrequency,"Repeat:");
        verify.elementTextMatching(keySTitleEndDate,"End Date:");
        verify.elementTextMatching(keySTTitleMessage,"Message:");
        swipe.vertical(2,0.4,0.8,5);


        verify.elementIsPresent(keyBtnSTPageBack);
        verify.elementIsPresent(keyLblSTPageSCID);
        verify.elementIsPresent(keyLblSTPageRefNo);
        verify.elementIsPresent(keyLblSTPageTransferDate);
        verify.elementIsPresent(keyLblSTPageTransferTo);
        verify.elementTextMatching(keyLblSTPageAmount,iamount);
        verify.elementIsPresent(keyLblSTPageTransactionNote);
        verify.elementIsPresent(keyLblSTPageStartDate);
        swipe.vertical(2,0.8,0.4,5);
        verify.elementTextMatching(keyLblSTPageFrequency,irepeat);
        verify.elementIsPresent(keyLblSTPageEndDate);
        verify.elementTextMatching(keyLblSTPageMessage,iMessage);
        verify.elementIsPresent(keyBtnSTPageNewTransaction);
       verify.elementTextMatching(keyBtnSTPageNewTransaction,"NEW TRANSACTION");
        verify.elementIsPresent(keyBtnSTPageDashboard);
        verify.elementTextMatching(keyBtnSTPageDashboard,"GO TO DASHBOARD");
        swipe.vertical(2,0.4,0.8,5);
        // verify.elementIsPresent(keyLblSTPageDescription);
       // verify.elementIsPresent(keyLblSTPageEndBalance);

    }

    public void ClickNewTransaction() throws ApplicationException {
        swipe.vertical(2,0.8,0.4,5);
        click.elementBy(keyBtnSTPageNewTransaction);
        WAIT.forSeconds(2);
    }

    public void ClickGoToDashboard() throws ApplicationException {
        swipe.vertical(2,0.8,0.4,5);
        click.elementBy(keyBtnSTPageDashboard);
        WAIT.forSeconds(2);
    }


 public String getTransactionReferenceNumber() throws ApplicationException {
     String referencenumber = get.elementText(keyLblSTPageRefNo);

     Reporter.addStepLog("Transaction Reference Number is --> " + referencenumber);

     return referencenumber;
 }
    public String getScheduledReferenceID() throws ApplicationException {
        String ScheduledReferenceID = get.elementText(keyLblSTPageSCID);

        Reporter.addStepLog("Scheduled ID is --> "+ScheduledReferenceID);

        return ScheduledReferenceID;
    }

    public String getTransactionDate() throws ApplicationException {
        String TransactionDate = get.elementText(keyLblSTPageTransferDate);

        Reporter.addStepLog("Transaction Date is --> "+TransactionDate);

        return TransactionDate;
    }
}
