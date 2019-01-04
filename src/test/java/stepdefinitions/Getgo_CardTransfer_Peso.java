package stepdefinitions;

import actions.Swipe;
import base.Test;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import exceptions.ApplicationException;
import helper.Device;
import helper.PropertyReader;
import pages.*;
import projectconstants.MenuItem;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Getgo_CardTransfer_Peso {

    private String toCard, fakeUser, toUser, message, frequency,transaction_Description,endBalance,availabelBalance,Editedmessage;
    private double transferAmount, transferFees,EditedtransferAmount;
    private ArrayList<String> date;
    private String accountType;

    /*
        Pages ~
     */

    private static PageAccountDashboard dashboard = new PageAccountDashboard();
    private static PageCardTransfer transfer = new PageCardTransfer();
    private static PageCardTransferReview review = new PageCardTransferReview();
    private static PageCardTransferSuccess success = new PageCardTransferSuccess();
    private static PageActivities activities = new PageActivities();
    private static PageOTP otp = new PageOTP();
    private static PageCommonErrorPopUp errorPOPUP=new PageCommonErrorPopUp();

    public Getgo_CardTransfer_Peso() {
        toCard = PropertyReader.testDataOf("RecipientCardNumber");
        fakeUser = Test.faker.name().firstName() + " " + Test.faker.name().lastName();
        toUser = PropertyReader.testDataOf("RecipientCardNumber");
        message = "Automation Transaction!";
        transferAmount = 10.00;
        transferFees = 20.00;
        //frequency;
        transaction_Description = "Send Money";
        //endBalance
        EditedtransferAmount = 5.00;
        Editedmessage="Edited Automation Transaction";
    }

    @Given("^I'm on Getgo Fund transfer page of my \"([^\"]*)\" card account$")
    public void iMOnGetgoFundTransferPageOfMyCardAccount(String accountType) throws Throwable {
        this.accountType = accountType.trim();
        dashboard.clickMenu();
        if (Device.isAndroid()) {
            dashboard.navigateTo(MenuItem.CardTransfer());
        } else {
            dashboard.navigateTo("Send Money");
        }
        transfer.verifyPageTitle("Send Money");
    }

    @Given("^I'm on Getgo Fund transfer page$")
    public void iMOnGetgoFundTransferPage() throws Throwable {
        dashboard.clickMenu();
        if (Device.isAndroid()) {
            dashboard.navigateTo(MenuItem.CardTransfer());
        } else {
            dashboard.navigateTo("Send Money");
        }
        transfer.verifyPageTitle("Send Money");
    }

    @When("^I Enter card number, recipient name, amount, system date, frequency, and message - Add recipient from saved list by clicking on add button$")
    public void iEnterCardNumberRecipientNameAmountSystemDateFrequencyAndMessageAddRecipientFromSavedListByClickingOnAddButton() throws Throwable {
        date = Test.tools.getDate("today");
        transfer.verifyPageContentDetails();
        transfer.selectRecipientFromSavedList(toUser);
        transfer.enterAmount(transferAmount);
        // transfer.selectDate(date.get(0),date.get(1),date.get(2));
        //transfer.selectFrequency(frequency);
        transfer.enterMessage(message);
        availabelBalance=transfer.getAvailabelBalance();
        transfer.clickNext();
    }

    @And("^I review transfer instruction and click submit$")
    public void iReviewTransferInstructionAndClickSubmit() throws Throwable {
        review.verifyTitle("Review and Send Money");
        review.verifyPageContents();
        review.fromDetails(PropertyReader.testDataOf(accountType + "_CardNumber"), PropertyReader.testDataOf(accountType + "_FullName"));
        review.toDetails(toCard, toUser);
        review.transferAmount(transferAmount);
        review.verifyEndBalance(availabelBalance,transferAmount,transferFees);
        endBalance=review.getEndBalance();
//        review.transferFees(transferFees);
//        review.transferDate(date.get(0),date.get(1),date.get(2));
        review.verifyTransactionMessage(message);
        review.verifyTransactionDate();
        review.clickTransfer();
        otp.enterOTP();
    }

    @Then("^I should see the confirmation page$")
    public void iShouldSeeTheConfirmationPage() throws Throwable {
        success.isTransferCompleteSuccess();
        success.TransferCompletePageDetails(Test.tools.upto2Decimals(transferAmount),transaction_Description,endBalance,message);

       /* String irefno=activities.getTransactionReferenceNumber();
        String idescription=activities.reviewDescription("Send Money");
        String iendingbalanceamt;
        if(Device.isAndroid()) {
             iendingbalanceamt = activities.verifyEndingBalance(transferAmount+transferFees, transfer.getBeforeBalance());
        }
        else
        {
             iendingbalanceamt = activities.verifyEndingBalance(transferAmount, transfer.getBeforeBalance());

        }
        String idate=activities.reviewTransactionDate(date.get(0),date.get(1),date.get(2));
        String itransferamt=activities.verifyTransactionAmount(transferAmount);

        activities.closeActivityDetailedPage();
       dashboard.clickAvailableBalance();
       activities.verifyActivityPageTitle("Activities");
       activities.selectActivityByReferneceNo(irefno);
       activities.verifyFundTransferDetailsActivityPage(irefno,idate,idescription,itransferamt,iendingbalanceamt);
        activities.closeActivityDetailedPage();
        activities.closeActivityPage();
        */


    }

    @When("^I Enter card number, recipient name, amount, system date, frequency, and message$")
    public void iEnterCardNumberRecipientNameAmountSystemDateFrequencyAndMessage() throws Throwable {
        toUser = fakeUser;
        date = Test.tools.getDate("today");
        transfer.enterCardNumber(toCard);
//        transfer.enterRecipient(toUser);
        transfer.enterAmount(transferAmount);
//        transfer.selectDate(date.get(0),date.get(1),date.get(2));
        //   transfer.selectFrequency(frequency);
        availabelBalance=transfer.getAvailabelBalance();
        transfer.enterMessage(message);
        transfer.clickNext();
    }

  /*  @When("^I Enter card number, recipient name, amount, system date, frequency and message$")
    public void i_Enter_card_number_recipient_name_amount_system_date_frequency_and_message() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        toUser = fakeUser;
        date = Test.tools.getDate("today");
        transfer.enterCardNumber(toCard);
//        transfer.enterRecipient(toUser);
        transfer.enterAmount(transferAmount);
        transfer.SwitchRepeatToogleIndicator();
        transfer.chooseFrequency("Annually");
        transfer.chooseEndDate("Never");
        //   transfer.selectFrequency(frequency);
        transfer.enterMessage(message);
        transfer.clickNext();
    }
*/

    @Then("^I should see the confirmation page with scheduled fund transfer details$")
    public void iShouldSeeTheConfirmationPagewithscheduledfundtransferdetails() throws Throwable {
        success.isTransferCompleteSuccess();
        success.ScheduledTransferCompletePageDetails(Test.tools.upto2Decimals(transferAmount),frequency,message);

       /* String irefno=activities.getTransactionReferenceNumber();
        String idescription=activities.reviewDescription("Send Money");
        String iendingbalanceamt;
        if(Device.isAndroid()) {
             iendingbalanceamt = activities.verifyEndingBalance(transferAmount+transferFees, transfer.getBeforeBalance());
        }
        else
        {
             iendingbalanceamt = activities.verifyEndingBalance(transferAmount, transfer.getBeforeBalance());

        }
        String idate=activities.reviewTransactionDate(date.get(0),date.get(1),date.get(2));
        String itransferamt=activities.verifyTransactionAmount(transferAmount);

        activities.closeActivityDetailedPage();
       dashboard.clickAvailableBalance();
       activities.verifyActivityPageTitle("Activities");
       activities.selectActivityByReferneceNo(irefno);
       activities.verifyFundTransferDetailsActivityPage(irefno,idate,idescription,itransferamt,iendingbalanceamt);
        activities.closeActivityDetailedPage();
        activities.closeActivityPage();
        */


    }

    @When("^I Enter card number, recipient name, amount, system date, \"([^\"]*)\" and message$")
    public void i_Enter_card_number_recipient_name_amount_system_date_and_message(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // Write code here that turns the phrase above into concrete actions
        frequency=arg1;
        toUser = fakeUser;
        date = Test.tools.getDate("today");
        transfer.enterCardNumber(toCard);
//        transfer.enterRecipient(toUser);
        transfer.enterAmount(transferAmount);
        transfer.SwitchRepeatToogleIndicator();
        transfer.chooseFrequency(arg1);
        transfer.chooseEndDate("Never");
        //   transfer.selectFrequency(frequency);
        transfer.enterMessage(message);
        transfer.clickNext();
    }

    @When("^I Enter card number, recipient name, amount, future date, \"([^\"]*)\" and message$")
    public void i_Enter_card_number_recipient_name_amount_future_date_and_message(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        frequency=arg1;
        toUser = fakeUser;
        date = Test.tools.getDate("today");
        transfer.enterCardNumber(toCard);
//        transfer.enterRecipient(toUser);
        transfer.enterAmount(transferAmount);
        transfer.SwitchRepeatToogleIndicator();
        transfer.chooseFrequency(arg1);
        transfer.chooseEndDate("Select Date");
        transfer.chooseTransactionDate("2019","Dec","30");
        transfer.enterMessage(message);
        transfer.clickNext();
    }

    @And("^I review transfer instruction with scheduled details and click submit$")
    public void iReviewTransferInstructionwithscheduleddetailsAndClickSubmit() throws Throwable {
        review.verifyTitle("Review and Send Money");
        review.verifyPageContents();
        review.fromDetails(PropertyReader.testDataOf(accountType + "_CardNumber"), PropertyReader.testDataOf(accountType + "_FullName"));
        review.toDetails(toCard, toUser);
        review.transferAmount(transferAmount);
        //endBalance=review.toString();
//        review.transferFees(transferFees);
//        review.transferDate(date.get(0),date.get(1),date.get(2));
        review.verifyTransactionMessage(message);
        review.verifyTransactionDate();
        review.clickTransfer();
        otp.enterOTP();
    }


    @Then("^I should see the confirmation page and validate it in the Activity page$")
    public void iShouldSeeTheConfirmationPageandvalidateitintheActivitypage() throws Throwable {
        success.isTransferCompleteSuccess();
        success.TransferCompletePageDetails(Test.tools.upto2Decimals(transferAmount),transaction_Description,endBalance,message);

        String irefno=success.getTransactionReferenceNumber();
        String idate=success.getTransactionDate();
        success.ClickNewTransaction();
        transfer.clickActivitiesOption();

        activities.verifyActivityPageTitle("Activities");
        activities.selectActivityByReferneceNo(irefno);
        activities.verifyFundTransferDetailsActivityPage(irefno,idate,transaction_Description,Test.tools.pesoAmount(transferAmount),endBalance);
        activities.closeActivityDetailedPage();
        activities.closeActivityPage();


    }

    @Then("^I should see the confirmation page and validate it in the Activity page through Dashboard$")
    public void iShouldSeeTheConfirmationPageandvalidateitintheActivitypagethroughDashboard() throws Throwable {
        success.isTransferCompleteSuccess();
        success.TransferCompletePageDetails(Test.tools.upto2Decimals(transferAmount),transaction_Description,endBalance,message);

        String irefno=success.getTransactionReferenceNumber();
        String idate=success.getTransactionDate();
        success.ClickGoToDashboard();
        dashboard.clickAvailableBalance();

        activities.verifyActivityPageTitle("Activities");
        activities.selectActivityByReferneceNo(irefno);
        activities.verifyFundTransferDetailsActivityPage(irefno,idate,transaction_Description,Test.tools.pesoAmount(transferAmount),endBalance);
        activities.closeActivityDetailedPage();
        activities.closeActivityPage();


    }

    @And("^I review transfer instruction and click Edit button$")
    public void iReviewTransferInstructionAndclickEditbutton() throws Throwable {
        review.verifyTitle("Review and Send Money");
        review.verifyPageContents();
        review.fromDetails(PropertyReader.testDataOf(accountType + "_CardNumber"), PropertyReader.testDataOf(accountType + "_FullName"));
        review.toDetails(toCard, toUser);
        review.transferAmount(transferAmount);
        review.verifyEndBalance(availabelBalance,transferAmount,transferFees);
        endBalance=review.getEndBalance();
//        review.transferFees(transferFees);
//        review.transferDate(date.get(0),date.get(1),date.get(2));
        review.verifyTransactionMessage(message);
        review.verifyTransactionDate();
            review.clickEdit();

    }

    @And("^I edit the transaction amount, message & click Next button$")
    public void IeditthetransactionamountmessageclickNextbutton() throws Throwable {

        transfer.verifyPageContentDetails();
        transfer.enterAmount(EditedtransferAmount);
        transfer.enterMessage(Editedmessage);
        availabelBalance=transfer.getAvailabelBalance();
        transfer.clickNext();

    }
    @And("^I review transfer instruction with updated information and click submit$")
    public void Ireviewtransferinstructionwithupdatedinformationandclicksubmit() throws Throwable {
        review.verifyTitle("Review and Send Money");
        review.verifyPageContents();
        review.fromDetails(PropertyReader.testDataOf(accountType + "_CardNumber"), PropertyReader.testDataOf(accountType + "_FullName"));
        review.toDetails(toCard, toUser);
        review.transferAmount(EditedtransferAmount);
//        review.verifyEndBalance(availabelBalance,transferAmount,transferFees);
        endBalance=review.getEndBalance();
//        review.transferFees(transferFees);
//        review.transferDate(date.get(0),date.get(1),date.get(2));
        review.verifyTransactionMessage(Editedmessage);
        review.verifyTransactionDate();
        review.clickTransfer();
        otp.enterOTP();
    }

    @Then("^I should see the confirmation page with updated details and validate it in the Activity page$")
    public void IshouldseetheconfirmationpagewithupdateddetailsandvalidateitintheActivitypage() throws Throwable {
        success.isTransferCompleteSuccess();
        success.TransferCompletePageDetails(Test.tools.upto2Decimals(EditedtransferAmount),transaction_Description,endBalance,Editedmessage);

        String irefno=success.getTransactionReferenceNumber();
        String idate=success.getTransactionDate();
        success.ClickGoToDashboard();
        dashboard.clickAvailableBalance();

        activities.verifyActivityPageTitle("Activities");
        activities.selectActivityByReferneceNo(irefno);
        activities.verifyFundTransferDetailsActivityPage(irefno,idate,transaction_Description,Test.tools.pesoAmount(EditedtransferAmount),endBalance);
        activities.closeActivityDetailedPage();
        activities.closeActivityPage();


    }

    @And("^I review transfer instruction with the provided details and click submit$")
    public void Ireviewtransferinstructionwiththeprovideddetailsandclicksubmit() throws Throwable {
        review.verifyTitle("Review and Send Money");
        review.verifyPageContents();
        review.fromDetails(PropertyReader.testDataOf(accountType + "_CardNumber"), PropertyReader.testDataOf(accountType + "_FullName"));
        review.toDetails(toCard, toUser);
        review.transferAmount(transferAmount);
        review.verifyEndBalance(availabelBalance,transferAmount,transferFees);
        endBalance=review.getEndBalance();
//        review.transferFees(transferFees);
//        review.transferDate(date.get(0),date.get(1),date.get(2));
        review.verifyTransactionMessage(message);
        review.verifyTransactionDate();
        review.clickTransfer();
       // otp.enterOTP();
    }

    @Then("^I should see OTP page$")
    public void IshouldseeOTPpage() throws Throwable {
        otp.verifyOTPPageContents();

    }

    @When("^I review transfer instruction with the provided details and submit with invalid OTP$")
    public void i_review_transfer_instruction_with_the_provided_details_and_submit_with_invalid_OTP() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        review.verifyTitle("Review and Send Money");
        review.verifyPageContents();
        review.fromDetails(PropertyReader.testDataOf(accountType + "_CardNumber"), PropertyReader.testDataOf(accountType + "_FullName"));
        review.toDetails(toCard, toUser);
        review.transferAmount(transferAmount);
        review.verifyEndBalance(availabelBalance,transferAmount,transferFees);
        endBalance=review.getEndBalance();
//        review.transferFees(transferFees);
//        review.transferDate(date.get(0),date.get(1),date.get(2));
        review.verifyTransactionMessage(message);
        review.verifyTransactionDate();
        review.clickTransfer();
        otp.enterInvalidOTP();
    }

    @Then("^I should see an error message pop up with content \"([^\"]*)\"$")
    public void i_should_see_an_error_message_pop_up_with_content(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        errorPOPUP.CheckErrorMessageDetails("Error",arg1);
        errorPOPUP.ClickOk();
    }

    @Then("^I  should see the review transfer page with fund transfer details$")
    public void i_should_see_the_review_transfer_page_with_fund_transfer_details() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        review.verifyTitle("Review and Send Money");
        review.verifyFundTransferReviewPageContents();
        review.fromDetails(PropertyReader.testDataOf(accountType + "_CardNumber"), PropertyReader.testDataOf(accountType + "_FullName"));
        review.toDetails(toCard, toUser);
        review.transferAmount(transferAmount);
        review.verifyEndBalance(availabelBalance,transferAmount,transferFees);
        endBalance=review.getEndBalance();
//        review.transferFees(transferFees);
//        review.transferDate(date.get(0),date.get(1),date.get(2));
        review.verifyTransactionMessage(message);
        review.verifyTransactionDate();
    }

    @Then("^I  should see the review transfer page with Scheduled fund transfer details$")
    public void i_should_see_the_review_transfer_page_with_Scheduled_fund_transfer_details() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        review.verifyTitle("Review and Send Money");
        review.verifyScheduledFundTransferReviewPageContents();
    }



}