package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.PageAccountDashboard;
import pages.PageCurrencyConversion;
import projectconstants.MenuItem;

public class Getgo_CurrencyConversion {

    private static PageAccountDashboard dashboard=new PageAccountDashboard();
    private PageCurrencyConversion cc=new PageCurrencyConversion();

    @Given("^I'm on Currency conversion screen$")
    public void iMOnCurrencyConversionScreen() throws Throwable {
        dashboard.clickMenu();
        dashboard.navigateTo(MenuItem.CurrencyConverter());
    }

    @When("^I choose \"([^\"]*)\" currency and \"([^\"]*)\" currency$")
    public void iChooseCurrencyAndCurrency(String fromCurrency, String toCurrency) throws Throwable {
        cc.isPageLoaded();
        cc.selectFromCurrency(fromCurrency);
    }

    @And("^I enter the conversion amount \"([^\"]*)\"$")
    public void iEnterTheConversionAmount(String arg0) throws Throwable {
    }

    @Then("^Conversion amount will be automatically populated under To Amount field$")
    public void conversionAmountWillBeAutomaticallyPopulatedUnderToAmountField() throws Throwable {

    }

    @When("^I review conversion details and submit$")
    public void iReviewConversionDetailsAndSubmit() throws Throwable {

    }

    @Then("^Amount should be converted & displayed in the dashboard$")
    public void amountShouldBeConvertedDisplayedInTheDashboard() throws Throwable {

    }
}
