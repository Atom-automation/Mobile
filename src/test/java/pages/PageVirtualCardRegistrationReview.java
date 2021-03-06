package pages;

import base.Keywords;
import exceptions.ApplicationException;
import helper.Device;

public class PageVirtualCardRegistrationReview extends Keywords {

    private String keyLblEmailAddress="Getgo.CreateVirtualCardReview.LblEmailAddress";
    private String keyLblFullName="Getgo.CreateVirtualCardReview.LblFullName";
    private String keyLblDOB="Getgo.CreateVirtualCardReview.LblDOB";
    private String keyLblNationality="Getgo.CreateVirtualCardReview.LblNationality";
    private String keyLblGender="Getgo.CreateVirtualCardReview.LblGender";
    private String keyLblMobile="Getgo.CreateVirtualCardReview.LblMobile";
    private String keyBtnSubmit="Getgo.CreateVirtualCardReview.BtnSubmit";

    private String keyLblSourceofFunds="Getgo.CreateVirtualCardReview.LblSourceofFunds";
    private String keyLblPresentAddress="Getgo.CreateVirtualCardReview.LblPresentAddress";
    private String keyLblPremanentAddress="Getgo.CreateVirtualCardReview.LblPremanentAddress";
    private String keyCheckBoxTermsandCondition="Getgo.CreateVirtualCardReview.CheckBoxTermsandCondition";
    private String keyCheckBoxPrivacyPolicy="Getgo.CreateVirtualCardReview.CheckBoxPrivacyPolicy";


    public void reviewDetails(String emailID,String fullName,String dob, String mobile, String nationality, String gender,String sourceoffunds,String fulladdressdetails) throws ApplicationException {
        if(Device.isAndroid()) {
             String street="123 main street";
             String state="Metro Manila (NCR)";
             String city="Manila";
             String fulladdress1=street+", "+city+", "+state+", "+nationality;
            verify.elementTextMatching(keyLblEmailAddress, emailID);
            verify.elementTextMatching(keyLblFullName, fullName);
            verify.elementTextMatching(keyLblDOB, dob);
            verify.elementTextMatching(keyLblMobile, mobile);
            verify.elementTextMatching(keyLblNationality, nationality);
            verify.elementTextMatching(keyLblGender, gender);
            verify.elementTextMatching(keyLblSourceofFunds, sourceoffunds);
            swipe.vertical(2, 0.9, 0.2,3);
            verify.elementTextMatching(keyLblPresentAddress,"Present Address: "+ fulladdress1);
            verify.elementTextMatching(keyLblPremanentAddress, "Permanent Address: "+fulladdress1);

        }
        else
        {
            verify.elementTextMatching(keyLblEmailAddress,emailID);
            verify.elementTextMatching(keyLblFullName,fullName);
            swipe.vertical(2,0.9,0.2,3);
            ////need to check the dob review
            //String idob=verify.verifyDOBinreviewpage(dob);
            //need to check this logical flow verbiage DOB
           // verify.elementTextMatching(keyLblDOB,dob);

            verify.elementTextMatching(keyLblMobile,"+63 "+mobile);
            verify.elementTextMatching(keyLblNationality,nationality);
            //verify.elementTextMatching(keyLblGender,gender);
            verify.elementTextMatching(keyLblSourceofFunds, sourceoffunds);
            verify.elementTextMatching(keyLblPresentAddress,"Present Address: "+ fulladdressdetails);
            verify.elementTextMatching(keyLblPremanentAddress, "Permanent Address: "+fulladdressdetails);
        }
    }

    public void clickSubmit() throws ApplicationException {
        swipe.vertical(2, 0.9, 0.2,3);
        click.elementBy(keyBtnSubmit);
        WAIT.forSeconds(6);
    }

    public void clickTermsandConditionCheckBox() throws ApplicationException {
        click.elementBy(keyCheckBoxTermsandCondition);
        WAIT.forSeconds(1);
    }
    public void clickPrivacyPolicyCheckBox() throws ApplicationException {
        click.elementBy(keyCheckBoxPrivacyPolicy);
        WAIT.forSeconds(2);
    }
}
