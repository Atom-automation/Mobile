package pages;

import base.Keywords;
import exceptions.ApplicationException;
import xpath.Matching;

public class PageTermsandConditions extends Keywords {

    private String keyLblPageTitle = "Getgo.TAC.LblPageTitle";
    private String keyBtnClose = "Getgo.TAC.BtnClose";
    private String keyLbllastelement = "Getgo.TAC.Lbllastelement";

    private String keyLblPrivacyPolicyfirstblock = "Getgo.TAC.LblPrivacyPolicyfirstblock";
    private String keyLblPrivacyPolicysecondblock = "Getgo.TAC.LblPrivacyPolicysecondblock";
    private String keyLblPrivacyPolicythirdblock = "Getgo.TAC.LblPrivacyPolicythirdblock";

    public void verifyPageTitle(String ititle) throws ApplicationException {
        WAIT.forSeconds(5);
            verify.elementTextContains(keyLblPageTitle, ititle);

    }

    public void verifyPageContents() throws ApplicationException {
        WAIT.forSeconds(8);

        verify.elementIsPresent(xpathOf.textView(Matching.youDecide("TERMS & CONDITIONS")));
        verify.elementIsPresent(xpathOf.textView(Matching.youDecide("PRIVACY POLICY")));
        verify.elementIsPresent(keyBtnClose );
    }

    public void Movetosection(String section) throws ApplicationException {
        click.elementBy(xpathOf.textView(Matching.youDecide(section)));
    }

    public void verifyPageTermsandConditionsLastelement(String icontent) throws ApplicationException {
       for (int i=0;i<35;i++)
        {
            swipe.vertical(2, 0.9, 0.3, 1);
        }
        verify.elementTextMatching(keyLbllastelement,icontent);
    }

    public void verifyPagePrivacyPolicysectionelement(String icontent1,String icontent2,String icontent3) throws ApplicationException {
        verify.elementTextMatching(keyLblPrivacyPolicyfirstblock,icontent1);
        verify.elementTextMatching(keyLblPrivacyPolicysecondblock,icontent2);
        verify.elementTextMatching(keyLblPrivacyPolicythirdblock,icontent3);
    }


}


