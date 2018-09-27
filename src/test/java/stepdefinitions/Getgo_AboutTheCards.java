package stepdefinitions;

import cucumber.api.java.en.Then;
import pages.PageAboutTheCards;
import pages.PageContactUs;

public class Getgo_AboutTheCards {

    private static PageAboutTheCards aboutTheCards=new PageAboutTheCards();

    @Then("^About the Cards page should be displayed with details about the cards$")
    public void about_the_Cards_page_should_be_displayed_with_details_about_the_cards() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        aboutTheCards.verifyPageTitle("About the Cards");
        aboutTheCards.verifyPageContents();

    }


}
