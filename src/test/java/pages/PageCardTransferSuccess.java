package pages;

import base.Keywords;
import exceptions.ApplicationException;
import xpath.Matching;;

public class PageCardTransferSuccess extends Keywords {

    private String keyBtnViewDetails="Getgo.CardTransferSuccess.BtnViewDetails.XPATH";
    private String keyBtnDashboard="Getgo.CardTransferSuccess.BtnDashboard.XPATH";

    public void isTransferSuccess() throws ApplicationException {
        verify.elementIsPresent(xpathOf.textView(Matching.youDecide("Congratulations!")));
        verify.elementIsPresent(xpathOf.textView(Matching.youDecide("You have successfully transfer fund.")));
    }

    public void viewDetails() throws ApplicationException {
        click.elementBy(keyBtnViewDetails);
        WAIT.forSeconds(5);
    }

    public void gotoDashboard() throws ApplicationException {
        click.elementBy(keyBtnDashboard);
    }
}
