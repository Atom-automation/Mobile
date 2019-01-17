package stepdefinitions;

import base.Test;
import constants.Keys;
import constants.OS;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.Device;
import pages.PageAccountDashboard;
import pages.PageCardTransfer;
import pages.PageManageRecipient;
import projectconstants.MenuItem;

public class Getgo_ManageRecipient
{
    private static PageAccountDashboard dashboard=new PageAccountDashboard();
    private static PageCardTransfer transfer=new PageCardTransfer();
    private static PageManageRecipient manageRecipient=new PageManageRecipient();

    @When("^I Choose Manage Recipients option$")
    public void iChooseManageRecipientsOption() throws Throwable
    {
        transfer.clickAddRecipient();
    }

    @And("^Add a recipient and tag it as a favorite$")
    public void addARecipientAndTagItAsAFavorite() throws Throwable
    {
        manageRecipient.verifyPageTitle("Manage Recipients");
       // manageRecipient.verifyPageContentsAddRecipient();
        manageRecipient.addNewRecipient();
        manageRecipient.addToFavourites(manageRecipient.getNewlyAddedRecipientCard());
//        manageRecipient.goBack();
     //   manageRecipient.goBack();

    }

    @Then("^Recipient should be displayed in my favourites$")
    public void recipientShouldBeDisplayedInMyFavourites() throws Throwable
    {
        manageRecipient.isRecipientAvailableInFavourites(manageRecipient.getNewlyAddedRecipientCard());
    }

    @Given("^I'm on Beneficiaries page$")
    public void iMOnBeneficiariesPage() throws Throwable
    {
        dashboard.clickMenu();
        dashboard.navigateTo(MenuItem.Beneficiaries());
    }

    @When("^I Choose Manage Recipients option again$")
    public void iChooseManageRecipientsOptionAgain() throws Throwable
    {
        manageRecipient.goBack();
        transfer.clickAddRecipient();
    }

    @When("^I open Beneficiaries page again$")
    public void iOpenBeneficiariesPageAgain() throws Throwable
    {
       // manageRecipient.goBack();
        dashboard.clickMenu();
        dashboard.navigateTo(MenuItem.Beneficiaries());
    }

    @When("^I add a recipient and tag it as a favorite$")
    public void iAddARecipientAndTagItAsAFavorite() throws Throwable {
        manageRecipient.addNewRecipient();
        manageRecipient.addToFavourites(manageRecipient.getNewlyAddedRecipientCard());
        manageRecipient.goBack();
    }

    @And("^Add a recipient and tag it as a favorite using ADD AS FAVORITE toogle button$")
    public void AddarecipientandtagitasafavoriteusingADDASFAVORITEtooglebutton() throws Throwable
    {
        manageRecipient.verifyPageTitle("Manage Recipients");
        manageRecipient.ClickAddBtn();
        manageRecipient.verifyPageTitle("Manage Recipients");
        manageRecipient.verifyPageContentsAddRecipient();
        manageRecipient.addNewRecipientWithoutClickingSaveBtn();
        manageRecipient.ClickAddToFavouriteToogleIndicator();
        manageRecipient.ClickSaveBtn();
        manageRecipient.goBack();
        manageRecipient.goBack();
        manageRecipient.goBack();

    }

    @When("^Add a recipient with invalid card number details$")
    public void add_a_recipient_with_invalid_card_number_details() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        manageRecipient.verifyPageTitle("Manage Recipients");
        manageRecipient.ClickAddBtn();
        manageRecipient.verifyPageTitle("Manage Recipients");
        manageRecipient.verifyPageContentsAddRecipient();
        manageRecipient.EnterCardNumber("441125");
    }

    @Then("^I should see an error message as \"([^\"]*)\"$")
    public void i_should_see_an_error_message_as(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       manageRecipient.verifyErrorMessage("Invalid card number");
    }
}
