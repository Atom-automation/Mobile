package stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.PropertyReader;
import pages.PageEditProfile;
import pages.PageOTP;
import pages.PageSettings;

public class Getgo_ManageMySettings {

    private static PageSettings settings =new PageSettings();

    @Then("^I should see \"([^\"]*)\" page with Options Profile,Notifications,Password,Manage one Time password and Login using Fingerprint$")
    public void i_should_see_page_with_Options_Profile_Notifications_Password_Manage_one_Time_password_and_Login_using_Fingerprint(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
      settings.verifyPageTitle(arg1);
      settings.verifyPageContents();
    }

}
