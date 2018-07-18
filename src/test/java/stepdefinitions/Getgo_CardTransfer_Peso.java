package stepdefinitions;

import base.Test;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.PropertyReader;
import pages.*;
import projectconstants.MenuItem;

import java.util.ArrayList;

public class Getgo_CardTransfer_Peso
{

    private String fromCard,fromUser,toCard,fakeUser,toUser,message,frequency;
    private double transferAmount,transferFees;
    private ArrayList<String> date;

    /*
        Pages ~
     */

    private static PageAccountDashboard dashboard=new PageAccountDashboard();
    private static PageCardTransfer transfer=new PageCardTransfer();
    private static PageCardTransferReview review=new PageCardTransferReview();
    private static PageCardTransferSuccess success=new PageCardTransferSuccess();
    private static PageActivities activities=new PageActivities();

    public Getgo_CardTransfer_Peso()
    {
       fromCard= PropertyReader.testDataOf("Peso_CardNumber");
       fromUser= PropertyReader.testDataOf("Peso_FullName");
       toCard= PropertyReader.testDataOf("GGP520_RecipientCardNumber");
       fakeUser= Test.faker.name().firstName()+" "+ Test.faker.name().lastName();
       toUser= PropertyReader.testDataOf("GGP520_RecipientName");
       message="Automation Transaction!";
       transferAmount=5.00;
       transferFees=20.00;
       frequency="One Time Only";
    }

    @Given("^I'm on Getgo Fund transfer page$")
    public void iMOnGetgoFundTransferPage() throws Throwable
    {
        dashboard.clickMenu();
        dashboard.navigateTo(MenuItem.CardTransfer());
    }

    @When("^I Enter card number, recipient name, amount, system date, frequency, and message - Add recipient from saved list by clicking on add button$")
    public void iEnterCardNumberRecipientNameAmountSystemDateFrequencyAndMessageAddRecipientFromSavedListByClickingOnAddButton() throws Throwable
    {
        date= Test.tools.getDate("today");
        transfer.selectRecipientFromSavedList(toUser);
        transfer.enterAmount(transferAmount);
        transfer.selectDate(date.get(0),date.get(1),date.get(2));
        transfer.selectFrequency(frequency);
        transfer.enterMessage(message);
        transfer.clickNext();
    }

    @And("^I review transfer instruction and click submit$")
    public void iReviewTransferInstructionAndClickSubmit() throws Throwable
    {
        review.fromDetails(fromCard,fromUser);
        review.toDetails(toCard,toUser);
        review.transferAmount(transferAmount);
        review.transferFees(transferFees);
        review.transferDate(date.get(0),date.get(1),date.get(2));
        review.clickTransfer();
    }

    @Then("^I should see the confirmation page$")
    public void iShouldSeeTheConfirmationPage() throws Throwable
    {
        success.isTransferSuccess();
        success.viewDetails();
        activities.getTransactionReferenceNumber();
        activities.reviewDescription("Funds Transfer to Card");
        activities.verifyEndingBalance(transferAmount,transfer.getBeforeBalance());
        activities.reviewTransactionDate(date.get(0),date.get(1),date.get(2));
        activities.verifyTransactionAmount(transferAmount);
    }

    @When("^I Enter card number, recipient name, amount, system date, frequency, and message$")
    public void iEnterCardNumberRecipientNameAmountSystemDateFrequencyAndMessage() throws Throwable
    {
        toUser=fakeUser;
        date= Test.tools.getDate("today");
        transfer.enterCardNumber(toCard);
        transfer.enterRecipient(toUser);
        transfer.enterAmount(transferAmount);
        transfer.selectDate(date.get(0),date.get(1),date.get(2));
        transfer.selectFrequency(frequency);
        transfer.enterMessage(message);
        transfer.clickNext();
    }
}