package stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.Device;
import pages.PageAccountDashboard;
import pages.PageLoadingPartner;
import pages.PageMore;
import projectconstants.MenuItem;

public class Getgo_LoadingPartners {

    private static PageAccountDashboard dashboard =new PageAccountDashboard();
    private static PageLoadingPartner loadingPartner =new PageLoadingPartner();

    @When("^I choose Find Where to Load option from the menu$")
    public void i_choose_Find_Where_to_Load_option_from_the_menu() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        dashboard.clickMenu();
        dashboard.navigateTo(MenuItem.LoadPartners());
    }

    @Then("^I should see \"([^\"]*)\" page with \"([^\"]*)\" textbox and list of partners$")
    public void i_should_see_page_with_textbox_and_list_of_partners(String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loadingPartner.verifyPageTitle(arg1);
        loadingPartner.verifyLoadingPartnersPageContents(arg2);
    }

    @Then("^I should see \"([^\"]*)\" page and able to search the partners with their location$")
    public void i_should_see_page_and_able_to_search_the_partners_with_their_location(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        if(Device.isAndroid()) {
            loadingPartner.verifyPageTitle(arg1);
            loadingPartner.searchLoadPartners("Robinsons Place Imus");
            loadingPartner.CheckIFGoogleMapIsOpened();
        }
        else
        {
            loadingPartner.verifyPageTitle(arg1);
            loadingPartner.searchLoadPartnersIOS("Robinsons Place Imus");

        }
    }


    @When("^I choose Find Distribution Partners option from the menu$")
    public void I_choose_Find_Distribution_Partners_option_from_the_menu() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        dashboard.clickMenu();
        dashboard.navigateTo(MenuItem.DistributionPartners());
    }


}
