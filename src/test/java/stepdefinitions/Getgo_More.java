package stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.PageAccountDashboard;
import pages.PageMore;
import pages.PageSettings;

public class Getgo_More {

    private static PageAccountDashboard dashboard =new PageAccountDashboard();
    private static PageMore more =new PageMore();

    @When("^I choose More option from the menu$")
    public void i_choose_More_option_from_the_menu() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        dashboard.clickMenu();
        dashboard.navigateTo("More");
    }

    @Then("^I should see \"([^\"]*)\" page with options About the cards,FAQ, Contact Us,Terms and conditions and Privacy$")
    public void i_should_see_page_with_options_About_the_cards_FAQ_Contact_Us_Terms_and_conditions_and_Privacy(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        more.verifyPageTitle("More");
        more.verifyMorePageContents();
    }

}
