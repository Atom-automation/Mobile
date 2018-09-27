package stepdefinitions;

import base.Test;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.Device;
import helper.PropertyReader;
import pages.*;

public class Dummy {

    private static PageAccountDashboard dashboard=new PageAccountDashboard();
    private static PageLoadingPartners loadpartners=new PageLoadingPartners();

    @When("^I choose Loading partners option from the menu$")
    public void i_choose_Loading_partners_option_from_the_menu() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        dashboard.clickMenu();
        dashboard.navigateTo("Load Partners");

    }

    @Then("^click on the losf psrtners list$")
    public void click_on_the_losf_psrtners_list() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loadpartners.clickfirstelement();
    }

}
