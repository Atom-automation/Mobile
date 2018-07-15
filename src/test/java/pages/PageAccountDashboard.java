package pages;

import base.Keywords;
import base.Test;
import com.cucumber.listener.Reporter;
import constants.Keys;
import constants.OS;
import exceptions.ApplicationException;
import xpath.Matching;

public class PageAccountDashboard extends Keywords {

    private String keyImgProfilePicture="Getgo.Dashboard.ImgProfilePicture.ID";
    private String keyLblUserName="Getgo.Dashboard.LblUsername.ID";
    private String keyBtnMenu="Getgo.Dashboard.BtnMenu.ID";
    private String keyLblAvailableBalancePeso="Getgo.Peso+Dashboard.LblAvailableBalance.XPATH";
    private String keyLblAvailableBalanceVirtualCard="Getgo.VirtualDashboard.LblAvailableBalance.XPATH";
    private String keyLogout="Getgo.Dashboard.LinkLogout.XPATH";

    private double myAccountBalance=0.00;

    public void isOk(String userName) throws ApplicationException {
        verify.elementIsPresent(keyImgProfilePicture);
        verify.elementTextMatching(keyLblUserName,userName);
    }

    public void displayMyAccountBalance(String accountType) throws ApplicationException {
        double actualBalance;
        switch (accountType.trim().toUpperCase()){
            case "VIRTUAL":
                for(int i=1;i<=3;i++)
                {
                   try{
                       actualBalance=Double.parseDouble(get.elementBy(keyLblAvailableBalanceVirtualCard).get(0).getText().trim());
                   }catch (NumberFormatException e){
                       actualBalance=0.00;
                   }
                   if(actualBalance!=0.00){
                        myAccountBalance=actualBalance;
                        break;
                   }
                   WAIT.forSeconds(2);
                }
                break;
            case "PESO":
                for(int i=1;i<=3;i++)
                {
                    try{
                        actualBalance=Double.parseDouble(get.elementBy(keyLblAvailableBalancePeso).get(0).getText().trim());
                    }catch (NumberFormatException e){
                        actualBalance=0.00;
                    }
                    if(actualBalance!=0.00){
                        myAccountBalance=actualBalance;
                        break;
                    }
                    WAIT.forSeconds(2);
                }
                break;
        }
        if(myAccountBalance!=0.00)
        {
            Reporter.addStepLog("My Account Balance is --> "+myAccountBalance);
        }else
        {
            throw new ApplicationException("Your account balance is "+myAccountBalance+" we can't proceed testing with this balance");
        }
    }

    public double accountBalance() {
        return myAccountBalance;
    }

    public void clickMenu() throws ApplicationException {
        click.elementBy(keyBtnMenu);
    }

    public void navigateTo(String where) throws ApplicationException {
        if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.ANDROID))
        {
            click.elementBy(xpathOf.checkedTextView(Matching.text(where)));
        }else
        {

        }
    }

    public void logout() throws ApplicationException {
        click.elementBy(keyLogout);
    }
}