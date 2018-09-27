package stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.PageAccountDashboard;
import pages.PageContactUs;
import pages.PageMore;
import pages.PageTermsandConditions;

public class Getgo_ContactUs {

    private static PageContactUs contactus=new PageContactUs();


    @Then("^Contact Us page should be displayed with contact us information details$")
    public void contact_Us_page_should_be_displayed_with_contact_us_information_details() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        contactus.verifyPageTitle("Contact Us");
        contactus.verifyPageContents();
    }

}
