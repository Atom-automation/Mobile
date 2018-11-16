package pages;

import base.Keywords;
import base.Test;
import com.cucumber.listener.Reporter;
import exceptions.ApplicationException;
import helper.Device;
import helper.Tools;
import xpath.Matching;

import java.text.DecimalFormat;

public class PageCurrencyConversion extends Keywords {

    private String keyLblPageTitle="Getgo.CurrencyConverter.LblTitle";
    private String keyLblAvailableBalance="Getgo.CurrencyConverter.LblAvailableBalance";
    private String keyBtnFromCurrencyDropdown="Getgo.CurrencyConverter.BtnFromCurrencyDropdown";
    private String keyBtnToCurrencyDropdown="Getgo.CurrencyConverter.BtnToCurrencyDropdown";
    private String keyTxtFromCurrency="Getgo.CurrencyConverter.TxtFromCurrency";
    private String keyTxtToCurrency="Getgo.CurrencyConverter.TxtToCurrency";
    private String keyLblExchangeRate="Getgo.CurrencyConverter.LblExchangeRate";
    private String keyBtnNext="Getgo.CurrencyConverter.BtnNext";

    private String keyBtnMenu="Getgo.CurrencyConverter.BtnMenu";
    private String keyLblTransferFrom="Getgo.CurrencyConverter.LblTransferFrom";
    private String keyIMGCurrencyFlag=" Getgo.CurrencyConverter.IMGCurrencyFlag";
    private String keyLblCurrencyIndicator="Getgo.CurrencyConverter.LblCurrencyIndicator";
    private String keyLblAvailabelBalanceVerbiage="Getgo.CurrencyConverter.LblAvailabelBalanceVerbiage";
    private String keyLblConverFrom="Getgo.CurrencyConverter.LblConverFrom";
    private String keyLblConverTo="Getgo.CurrencyConverter.LblConverTo";
    private String keyLblFirstCurrencyexchangerate="Getgo.CurrencyConverter.LblFirstCurrencyexchangerate";
    private String keyLblCurrencyNotes="Getgo.CurrencyConverter.LblCurrencyNotes";


    private double balanceBeforeConversion=0.00;
    private String exchangeRate=null;
    private double amount=0.00;
    private double toAmount=0.00;

    public void isPageLoaded() throws ApplicationException {
        WAIT.forSeconds(15);
        verify.elementTextMatching(keyLblPageTitle,"Convert to Other Currencies");
        balanceBeforeConversion=Double.parseDouble(Test.tools.nbspRemove(get.elementText(keyLblAvailableBalance).replaceAll(",","")));
        keyboard.hideIfAndroid();
        Reporter.addStepLog("Balance before conversion is "+balanceBeforeConversion);
    }

    public void selectFromCurrency(String fromCurrency) throws ApplicationException {
        if(Device.isAndroid())
        {
        click.elementBy(keyBtnFromCurrencyDropdown);
        click.elementBy(xpathOf.textView(Matching.youDecide(fromCurrency.trim())));
        }
        else
        {
            click.elementBy(keyBtnFromCurrencyDropdown);
            WAIT.forSeconds(2);
            ios.selectPicker(fromCurrency.trim());
            //swipe.scrollDownToText(fromCurrency.trim());
            //click.elementBy(xpathOf.textView(Matching.youDecide(fromCurrency.trim())));
        }
        WAIT.forSeconds(1);
    }

    public void selectToCurrency(String toCurrency) throws ApplicationException {
        if(Device.isAndroid()) {
            click.elementBy(keyBtnToCurrencyDropdown);
            WAIT.forSeconds(1);
            try {
                driver.findElement(xpathOf.textView(Matching.youDecide(toCurrency.trim()))).click();
            } catch (Exception ex) {
                swipe.vertical(4, 0.7, 0.4, 1);
                click.elementBy(xpathOf.textView(Matching.youDecide(toCurrency.trim())));
            }
        }
        else
        {
            click.elementBy(keyBtnToCurrencyDropdown);
            WAIT.forSeconds(2);
            ios.selectPicker(toCurrency.trim());
            //swipe.scrollDownToText(toCurrency.trim());
        }
        WAIT.forSeconds(1);
    }

    public void enterAmount(String amount) throws ApplicationException {
        this.amount=Double.parseDouble(amount);
        type.data(keyTxtFromCurrency,amount);
        WAIT.forSeconds(2);
    }

    public void verifyIfToAmountIsAutoPopulatedBasedonExchangeRate() throws ApplicationException {
        WAIT.forSeconds(3);
        exchangeRate=get.elementText(keyLblExchangeRate);

        String calcAmountInString=String.valueOf(Double.parseDouble(exchangeRate.split(" ")[0].trim()) * amount);
        String[] i=calcAmountInString.split("[.]");
        if(i.length<2){
            calcAmountInString="0"+calcAmountInString;
        }

        double expectedAmount=Double.parseDouble(new DecimalFormat("#0.00").format(Float.parseFloat(calcAmountInString)));
        double actualAmount=Double.parseDouble(get.elementText(keyTxtToCurrency).replaceAll(",",""));
        verify.isMatching(expectedAmount,actualAmount);
        toAmount=expectedAmount;
    }

    public void clickNext() throws ApplicationException {
        click.elementBy(keyBtnNext);
        WAIT.forSeconds(1);
    }

    public double getBalanceBeforeConversion() {
        return balanceBeforeConversion;
    }

    public String getExchangeRate() {
        return exchangeRate;
    }

    public String getAmount() {
        return new DecimalFormat("#0.00").format(amount);
    }

    public String getToAmount() {
        return new DecimalFormat("#0.00").format(toAmount);
    }

    public void verifyPageContents() throws ApplicationException {

        if(Device.isAndroid()) {
            verify.elementIsPresent(keyLblAvailableBalance);
            verify.elementIsPresent(keyBtnFromCurrencyDropdown);
            verify.elementIsPresent(keyBtnToCurrencyDropdown);
            verify.elementIsPresent(keyTxtFromCurrency);
            verify.elementIsPresent(keyTxtToCurrency);
            verify.elementIsPresent(keyLblExchangeRate);
            verify.elementIsPresent(keyBtnNext);

            verify.elementIsPresent(keyBtnMenu);
            verify.elementTextMatching(keyLblTransferFrom, "Transfer From:");
            verify.elementIsPresent(keyIMGCurrencyFlag);
            verify.elementIsPresent(keyLblCurrencyIndicator);
            verify.elementTextMatching(keyLblAvailabelBalanceVerbiage, "Available Balance");
            verify.elementTextMatching(keyLblConverFrom, "CONVERT FROM:");
            verify.elementTextMatching(keyLblConverTo, "CONVERT TO:");
            verify.elementIsPresent(keyLblFirstCurrencyexchangerate);
            verify.elementTextMatching(keyLblCurrencyNotes, "Conveniently lock in your exchange rates and easily convert to other currencies so you're travel-ready anytime.");
        }
        else
        {
            verify.elementIsPresent(keyLblAvailableBalance);
            verify.elementIsPresent(keyBtnFromCurrencyDropdown);
            verify.elementIsPresent(keyBtnToCurrencyDropdown);
            verify.elementIsPresent(keyTxtFromCurrency);
            verify.elementIsPresent(keyTxtToCurrency);
            verify.elementIsPresent(keyLblExchangeRate);
            verify.elementIsPresent(keyBtnNext);

            verify.elementIsPresent(keyBtnMenu);
           // verify.elementTextMatching(keyLblTransferFrom, "Transfer From:");
            verify.elementIsPresent(keyIMGCurrencyFlag);
            verify.elementIsPresent(keyLblCurrencyIndicator);
            verify.elementIsPresent(keyLblAvailabelBalanceVerbiage);
            verify.elementTextMatching(keyLblConverFrom, "CONVERT FROM:");
            verify.elementTextMatching(keyLblConverTo, "CONVERT TO:");
            verify.elementIsPresent(keyLblFirstCurrencyexchangerate);
           // verify.elementIsPresent(keyLblCurrencyNotes, "Conveniently lock in your exchange rates and easily convert to other currencies so you're travel-ready anytime.");
            verify.elementIsPresent(keyLblCurrencyNotes);
        }

    }
}
