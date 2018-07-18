package pages;

import base.Keywords;
import com.cucumber.listener.Reporter;
import exceptions.ApplicationException;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriverException;

import java.time.Duration;

public class PageCurrencyConversion extends Keywords {

    private String keyLblPageTitle="Getgo.CurrencyConverter.LblTitle";
    private String keyLblAvailableBalance="Getgo.CurrencyConverter.LblAvailableBalance";
    private String keyBtnFromCurrencyDropdown="Getgo.CurrencyConverter.BtnFromCurrencyDropdown";
    private String keyBtnToCurrencyDropdown="Getgo.CurrencyConverter.BtnToCurrencyDropdown";
    private String keyTxtFromCurrency="Getgo.CurrencyConverter.TxtFromCurrency";
    private String keyTxtToCurrency="Getgo.CurrencyConverter.TxtToCurrency";
    private String keyLblExchangeRate="Getgo.CurrencyConverter.LblExchangeRate";
    private String keyBtnNext="Getgo.CurrencyConverter.BtnNext";

    private double balanceBeforeConversion=0.00;

    public void isPageLoaded() throws ApplicationException {
        WAIT.forSeconds(10);
        verify.elementTextMatching(keyLblPageTitle,"Currency Converter");
        balanceBeforeConversion=Double.parseDouble(get.elementText(keyLblAvailableBalance).replaceAll(",",""));
        keyboard.hideIfAndroid();
        Reporter.addStepLog("Balance before conversion is "+balanceBeforeConversion);
    }

    public void selectFromCurrency(String fromCurrency) throws ApplicationException {
        
    }

    public void selectToCurrency(String toCurrency) throws ApplicationException {
        click.elementBy(keyBtnToCurrencyDropdown);
    }

    public void enterAmount(String amount) throws ApplicationException {
        type.data(keyTxtToCurrency,amount);
    }

    public void verifyIfToAmountIsAutoPopulatedBasedonExchangeRate(){

    }

    public void clickNext() throws ApplicationException {
        click.elementBy(keyBtnNext);
    }
}
