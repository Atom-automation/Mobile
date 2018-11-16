package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.Device;
import helper.PropertyReader;
import pages.*;
import projectconstants.MenuItem;

public class Getgo_CurrencyConversion {

    private String fromCurrency,toCurrency;
    private static PageOTP otp=new PageOTP();
    private static PageAccountDashboard dashboard=new PageAccountDashboard();
    private PageCurrencyConversion cc=new PageCurrencyConversion();
    private PageCurrencyConversionReview review=new PageCurrencyConversionReview();
    private PageCurrencyConversionSuccess success=new PageCurrencyConversionSuccess();
    private static PageActivities activities=new PageActivities();

    @Given("^I'm on Currency conversion screen after noting down the balance of \"([^\"]*)\" currency$")
    public void iMOnCurrencyConversionScreenAfterNotingDownTheBalanceOfCurrency(String toCurrency) throws Throwable {
        dashboard.displayBalanceOfCurrency(toCurrency);
        dashboard.clickMenu();
        if(Device.isAndroid()) {
            dashboard.navigateTo(MenuItem.CurrencyConverter());
        }
        else
        {
            dashboard.navigateTo("Convert to Other Currencies");
        }
    }

    @When("^I choose \"([^\"]*)\" currency and \"([^\"]*)\" currency$")
    public void iChooseCurrencyAndCurrency(String fromCurrency, String toCurrency) throws Throwable {
        this.fromCurrency=fromCurrency.trim().toUpperCase();
        this.toCurrency=toCurrency.trim().toUpperCase();
        cc.isPageLoaded();
        cc.selectFromCurrency(fromCurrency);
        cc.selectToCurrency(toCurrency);
    }

    @And("^I enter the conversion amount \"([^\"]*)\"$")
    public void iEnterTheConversionAmount(String amount) throws Throwable {
        cc.enterAmount(amount.trim());
    }

    @Then("^Conversion amount will be automatically populated under To Amount field$")
    public void conversionAmountWillBeAutomaticallyPopulatedUnderToAmountField() throws Throwable {
        cc.verifyIfToAmountIsAutoPopulatedBasedonExchangeRate();
        cc.clickNext();
    }

    @When("^I review conversion details and submit$")
    public void iReviewConversionDetailsAndSubmit() throws Throwable {
        //need to check
        review.verifyPageTitle("Review and Convert");
        review.verifyCurrencyReviewPageContents();
        //review.transferFrom(PropertyReader.testDataOf("Peso_FullName"),PropertyReader.testDataOf("Peso_CardNumber"));
        review.transferAmount(fromCurrency + " " + String.valueOf(cc.getAmount()));
        review.convertedAmount(toCurrency + " " + String.valueOf(cc.getToAmount()));
        if(Device.isAndroid()) {
            review.conversionRate("1 Philippine Peso equals " + cc.getExchangeRate());
        }
        else
        {
            review.conversionRate("1 Philippine Peso = " + cc.getExchangeRate());

        }
        review.clickConvert();
        otp.enterOTP();
    }

    @Then("^Amount should be converted & displayed in the dashboard$")
    public void amountShouldBeConvertedDisplayedInTheDashboard() throws Throwable {
        success.isConversionSuccess();
        success.gotoDashboard();
        double mainBalance=cc.getBalanceBeforeConversion()-Double.parseDouble(cc.getAmount());
        double currencyBalance=dashboard.getCurrencyBalance()+Double.parseDouble(cc.getToAmount());
        dashboard.verifyBalanceAfterConversionForCurrency("peso",mainBalance,toCurrency,currencyBalance);
    }

    @When("^I choose \"([^\"]*)\" option from Left Hand Menu$")
    public void i_choose_option_from_Left_Hand_Menu(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        dashboard.clickMenu();
        dashboard.navigateTo(MenuItem.CurrencyConverter());
    }

    @Then("^\"([^\"]*)\" page should be displayed with currency conversion details$")
    public void page_should_be_displayed_with_currency_conversion_details(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    cc.verifyPageContents();
    }

    @When("^I enter the conversion amount \"([^\"]*)\" and click Next$")
    public void i_enter_the_conversion_amount_and_click_Next(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        cc.enterAmount(arg1.trim());
        cc.clickNext();
    }

    @Then("^\"([^\"]*)\" currency conversion page should be displayed$")
    public void currency_conversion_page_should_be_displayed(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        review.verifyPageTitle(arg1);
        review.verifyCurrencyReviewPageContents();
    }

    @When("^I review conversion details and click submit$")
    public void i_review_conversion_details_and_click_submit() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        review.verifyCurrencyReviewPageContents();
        review.transferAmount(fromCurrency + " " + String.valueOf(cc.getAmount()));
        review.convertedAmount(toCurrency + " " + String.valueOf(cc.getToAmount()));
        if(Device.isAndroid()) {
            review.conversionRate("1 Philippine Peso equals " + cc.getExchangeRate());
        }
        else
        {
            review.conversionRate("1 Philippine Peso = " + cc.getExchangeRate());

        }
        review.clickConvert();

    }

    @When("^I Click on Menu option in the Dashboard page$")
    public void i_Click_on_Menu_option_in_the_Dashboard_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       dashboard.clickMenu();
    }

    @Then("^I should not see the \"([^\"]*)\" Menu option$")
    public void i_should_not_see_the_Menu_option(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        dashboard.verifyMenuOption(arg1);
    }

    @Then("^Verify the above transaction in the Transaction Activity page$")
    public void verify_the_above_transaction_in_the_Transaction_Activity_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        success.gotoDetails();
        activities.verifyActivityPageTitle("Account Activities");
        String iendingbalanceamt=activities.getTransactionEndingBalanceDirectlyfromActivityPage();

        String irefno=activities.getTransactionReferenceNumber();
        String idescription=activities.getTransactionDescriptionDirectlyfromActivityPage();

        String idate=activities.getTransactionDateDirectlyfromActivityPage();
        String itransferamt=activities.getTransactionAmountDirectlyfromActivityPage();

        activities.closeActivityDetailedPage();
        //issueeeeeeeee
        if(Device.isIOS()) {
            success.gotoDashboard();
        }
        dashboard.clickAvailableBalance();
        activities.verifyActivityPageTitle("Activities");
        activities.selectActivityByReferneceNo(irefno);
        activities.verifyFundTransferDetailsActivityPage(irefno,idate,idescription,itransferamt,iendingbalanceamt);
        activities.closeActivityDetailedPage();
        activities.closeActivityPage();
    }

    @When("^Amount should be converted sucessfully$")
    public void Amountshouldbeconvertedsucessfully() throws Throwable {
        //need to check
        success.isConversionSuccess();
        success.doesPageContains();

    }
}
