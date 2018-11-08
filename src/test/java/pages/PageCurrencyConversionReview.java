package pages;

import base.Keywords;
import exceptions.ApplicationException;
import helper.Device;

public class PageCurrencyConversionReview extends Keywords {

    private String keyLblTransferFrom="Getgo.CurrencyConversionReview.LblTransferFrom";
    private String keyLblTransferFromcard="Getgo.CurrencyConversionReview.LblTransferFromCard";
    private String keyLblTransferAmount="Getgo.CurrencyConversionReview.LblConvertCurrencyFrom";
    private String keyLblConvertedAmount="Getgo.CurrencyConversionReview.LblConvertCurrencyTo";
    private String keyLblConversionRate="Getgo.CurrencyConversionReview.LblConversionExchangeRate";
    private String keyBtnConvert="Getgo.CurrencyConversionReview.BtnTransfer";


    private String keyLblPageTitle="Getgo.CurrencyConversionReview.LblPageTitle";
    private String keyBtnClose="Getgo.CurrencyConversionReview.BtnClose";
    private String keyBtnEdit="Getgo.CurrencyConversionReview.BtnEdit";
    private String keyLblPageHeaderContent="Getgo.CurrencyConversionReview.LblPageHeaderContent";
    private String keyLblConvertCurrencyFromVerbiage="Getgo.CurrencyConversionReview.LblConvertCurrencyFromVerbiage";
    private String keyLblConvertCurrencyToVerbiage="Getgo.CurrencyConversionReview.LblConvertCurrencyToVerbiage";
    private String keyLblConversionExchangeRateVerbiage="Getgo.CurrencyConversionReview.LblConversionExchangeRateVerbiage";

    public void transferFrom(String username, String userCard) throws ApplicationException {
        if(Device.isAndroid()) {
            verify.elementTextContains(keyLblTransferFrom, username);
            WAIT.forSeconds(2);
//            verify.elementTextContains(keyLblTransferFromcard, userCard);
        }
        else
        {
            verify.elementTextContains(keyLblTransferFrom, username);
            WAIT.forSeconds(2);
          //  verify.elementTextContains(keyLblTransferFromcard, userCard);
        }
    }

    public void transferAmount(String amount) throws ApplicationException {
        verify.elementTextMatching(keyLblTransferAmount,amount);
    }

    public void convertedAmount(String amount) throws ApplicationException {
        verify.elementTextMatching(keyLblConvertedAmount,amount);
    }

    public void conversionRate(String rate) throws ApplicationException {
        verify.elementTextMatching(keyLblConversionRate,rate);
    }

    public void clickConvert() throws ApplicationException {
        WAIT.forSeconds(2);
        click.elementBy(keyBtnConvert);
        WAIT.forSeconds(2);

    }
    public void verifyPageTitle(String ititle) throws ApplicationException {
        verify.elementTextMatching(keyLblPageTitle,ititle);
    }

    public void verifyCurrencyReviewPageContents() throws ApplicationException {
        verify.elementTextMatching(keyLblPageHeaderContent,"Always check and review your details to ensure that information is correct.");
        verify.elementIsPresent(keyBtnClose);
        verify.elementIsPresent(keyBtnEdit);
        verify.elementTextMatching(keyLblConvertCurrencyFromVerbiage,"Convert from:");
        verify.elementTextMatching(keyLblConvertCurrencyToVerbiage,"Convert to:");
        verify.elementTextMatching(keyLblConversionExchangeRateVerbiage,"Conversion:");
    }

}
