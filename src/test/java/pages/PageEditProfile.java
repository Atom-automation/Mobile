package pages;

import base.Keywords;
import exceptions.ApplicationException;
import gherkin.lexer.De;
import helper.Device;
import org.openqa.selenium.By;
import xpath.Contains;
import xpath.Matching;

public class PageEditProfile extends Keywords {

    private String keyEditLinkPersonaldetails = "Getgo.EditProfile.LinkPersonaldetailsEdit";
    private String keyEditLinkAddressdetails = "Getgo.EditProfile.LinkAddressdetailsEdit";
    private String keyEditLinkOtherdetails = "Getgo.EditProfile.LinkOtherdetailsEdit";
    private String keytxtboxupdatemobileno ="Getgo.EditProfile.TXTUpdateMobileNumber";
    private String keybtnboxupdateclose ="Getgo.EditProfile.BtnClose";
    private String keybtnupdatemobilenext ="Getgo.EditProfile.BtnNext";
    private String keybtnboxupdatemobilesave ="Getgo.EditProfile.BtnSave";
    private String keylblboxupdatemobileverbiage="Getgo.EditProfile.Lblverbiagetext";
    private String keyTXTPrefixMobileNumber="Getgo.EditProfile.TXTPrefixMobileNumber";


    private String keyLblmobilenumberValue ="Getgo.EditProfile.LblmobilenumberValue";
    private String keyLblPresentAddressValue ="Getgo.EditProfile.LblPresentAddressValue";
    private String keyLblPermanentAddressValue ="Getgo.EditProfile.LblPermanentAddressValue";
    private String keyLblIdDetails ="Getgo.EditProfile.LblIdDetails";
    private String keyLblIdValues ="Getgo.EditProfile.LblIdValues";
    private String keyLblSourceofFundsValue ="Getgo.EditProfile.LblSourceofFundsValue";
    private String keyLblIndustryValue ="Getgo.EditProfile.LblIndustryValue";
    private String keyLblEmployerNameValue ="Getgo.EditProfile.LblEmployerNameValue";

    private String keylblSuccessfullupdatetitle="Getgo.EditProfile.LblSuccessfullupdatetitle";
    private String keylblSuccessfullupdatemessage="Getgo.EditProfile.LblSuccessfullupdatemessage";
    private String keylblSuccessfullupdatetxtcontent="Getgo.EditProfile.LblSuccessfullupdatetxtcontent";

    private String keyLblTitleUpdateAddressPage="Getgo.EditProfile.LblTitleUpdateAddressPage";
    private String keyBtnCloseUpdateAddressPage="Getgo.EditProfile.BtnCloseUpdateAddressPage";
    private String keyBtnSaveTopUpdateAddressPage="Getgo.EditProfile.BtnSaveTopUpdateAddressPage";
    private String keyBtnSaveBottomUpdateAddressPage="Getgo.EditProfile.BtnSaveBottomUpdateAddressPage";
    private String keyLblContenttxtUpdateAddressPage="Getgo.EditProfile.LblContenttxtUpdateAddressPage";
    private String keyTXTCountyUpdateAddressPage="Getgo.EditProfile.TXTCountyUpdateAddressPage";
    private String keyTXTStateUpdateAddressPage="Getgo.EditProfile.TXTStateUpdateAddressPage";
    private String keyTXTCityUpdateAddressPage="Getgo.EditProfile.TXTCityUpdateAddressPage";

    private String keyTXTPresentStreetUpdateAddressPage="Getgo.EditProfile.TXTPresentStreetUpdateAddressPage";
    private String keyBTNPresentCountyUpdateAddressPage="Getgo.EditProfile.BTNPresentCountyUpdateAddressPage";
    private String keyBTNPresentStateUpdateAddressPage="Getgo.EditProfile.BTNPresentStateUpdateAddressPage";
    private String keyBTNPresentCityUpdateAddressPage="Getgo.EditProfile.BTNPresentCityUpdateAddressPage";


    private String keyTXTPermanentStreetUpdateAddressPage="Getgo.EditProfile.TXTPermanentStreetUpdateAddressPage";
    private String keyBTNPermanentCountyUpdateAddressPage="Getgo.EditProfile.BTNPermanentCountyUpdateAddressPage";
    private String keyBTNPermanentStateUpdateAddressPage="Getgo.EditProfile.BTNPermanentStateUpdateAddressPage";
    private String keyBTNPermanentCityUpdateAddressPage="Getgo.EditProfile.BTNPermanentCityUpdateAddressPage";
    private String keyLblPermanentAddress="Getgo.EditProfile.LblPermanentAddress";
    private String keyLblSameWithPresentAddressVerbiage="Getgo.EditProfile.LblSameWithPresentAddressVerbiage";
    private String keyCheckBoxSameAddess="Getgo.EditProfile.CheckBoxSameAddess";
    private String keyLblPresentAddress="Getgo.EditProfile.LblPresentAddress";


    private String keyBtnCloseOtherDetailsPage="Getgo.EditProfile.BtnCloseOtherDetailsPage";
    private String keyBtnSaveTopOtherDetailsPage="Getgo.EditProfile.BtnSaveTopOtherDetailsPage";
    private String keyBtnSaveBottomOtherDetailsPage="Getgo.EditProfile.BtnSaveBottomOtherDetailsPage";
    private String keyLblContenttxtOtherDetailsPage="Getgo.EditProfile.LblContenttxtOtherDetailsPage";
    private String keyTXTChooseIdentityOtherDetailsPage="Getgo.EditProfile.TXTChooseIdentityOtherDetailsPage";
    private String keyTXTEnterIdentityOtherDetailsPage="Getgo.EditProfile.TXTEnterIdentityOtherDetailsPage";
    private String keyTXTChooseSourceofFundsOtherDetailsPage="Getgo.EditProfile.TXTChooseSourceofFundsOtherDetailsPage";
    private String keyTXTChooseEmployerOtherDetailsPage="Getgo.EditProfile.TXTChooseEmployerOtherDetailsPage";
    private String keyTXTChooseEmployerDivisionOtherDetailsPage="Getgo.EditProfile.TXTChooseEmployerDivisionOtherDetailsPage";
    private String keyBtnChooseIdentityOtherDetailsPage="Getgo.EditProfile.BtnChooseIdentityOtherDetailsPage";
    private String keyBtnChooseSourceofFundsOtherDetailsPage="Getgo.EditProfile.BtnChooseSourceofFundsOtherDetailsPage";
    private String keyBtnChooseEmployerOtherDetailsPage="Getgo.EditProfile.BtnChooseEmployerOtherDetailsPage";
    private String keyBtnChooseEmployerDivisionOtherDetailsPage="Getgo.EditProfile.BtnChooseEmployerDivisionOtherDetailsPage";

    private String keyComboBoxIDType="Getgo.EditProfile.ComboBoxIDType";

    private String keyLblVerifyAccountPagetitle="Getgo.EditProfile.LblVerifyAccountPagetitle";
    private String keyTXTEnterPassword="Getgo.EditProfile.TXTEnterPassword";
    private String keyBTNProceed="Getgo.EditProfile.BTNProceed";
    private String keyLINKForgotPassword="Getgo.EditProfile.LINKForgotPassword";
    private String keyBTNBackfromVerifyAccount="Getgo.EditProfile.BTNBackfromVerifyAccount";
    private String keyLblVerifyAccountPageContent="Getgo.EditProfile.LblVerifyAccountPageContent";
    private String keyVerifyAccountTogglePasswordVisibility="Getgo.EditProfile.VerifyAccountTogglePasswordVisibility";

    String mobilenovalue;

    public void verifyManageProfilePageTitle(String ititle) throws ApplicationException {

            verify.elementTextContains(xpathOf.textView(Matching.youDecide("Manage Profile")), ititle);
        mobilenovalue=get.elementText(keyLblmobilenumberValue);

    }

    public void verifyPagefields(String personaldetailslbl,String addresslbl,String otherdetailslbl) throws ApplicationException {

        if(Device.isAndroid())
        {
            verify.elementTextContains(xpathOf.textView(Matching.youDecide("PERSONAL DETAILS")), personaldetailslbl);
            verify.elementIsPresent(xpathOf.textView(Matching.youDecide("Full Name")));
            verify.elementIsPresent(xpathOf.textView(Matching.youDecide("Date of Birth")));
            verify.elementIsPresent(xpathOf.textView(Matching.youDecide("Nationalities")));
            verify.elementIsPresent(xpathOf.textView(Matching.youDecide("Gender")));
            verify.elementIsPresent(xpathOf.textView(Matching.youDecide("Mobile Number")));
            verify.elementIsPresent(keyEditLinkPersonaldetails);

            swipe.vertical(2,0.9,0.2,5);

            verify.elementTextContains(xpathOf.textView(Matching.youDecide("ADDRESS")), addresslbl);
            verify.elementIsPresent(keyEditLinkAddressdetails);


            verify.elementTextContains(xpathOf.textView(Matching.youDecide("OTHER DETAILS")), otherdetailslbl);
            verify.elementIsPresent(xpathOf.textView(Matching.youDecide("Source of Funds")));
            verify.elementIsPresent(xpathOf.textView(Matching.youDecide("Industry")));
            verify.elementIsPresent(xpathOf.textView(Contains.youDecide("Name of Employer")));

            verify.elementIsPresent(keyEditLinkOtherdetails);
            swipe.vertical(2,0.2,0.9,5);

        }
        else {
            verify.elementTextContains(xpathOf.textView(Matching.youDecide("PERSONAL DETAILS")), personaldetailslbl);
            verify.elementIsPresent(xpathOf.textView(Matching.youDecide("Full Name")));
            verify.elementIsPresent(xpathOf.textView(Matching.youDecide("Date of Birth")));
            verify.elementIsPresent(xpathOf.textView(Matching.youDecide("Nationalities")));
            verify.elementIsPresent(xpathOf.textView(Matching.youDecide("Gender")));
            verify.elementIsPresent(xpathOf.textView(Matching.youDecide("Mobile Number")));
            verify.elementIsPresent(keyEditLinkPersonaldetails);

            verify.elementTextContains(xpathOf.textView(Matching.youDecide("ADDRESS")), addresslbl);
            verify.elementIsPresent(keyEditLinkAddressdetails);
            swipe.vertical(2,0.9,0.7,5);


            verify.elementTextContains(xpathOf.textView(Matching.youDecide("OTHER DETAILS")), otherdetailslbl);
            verify.elementIsPresent(xpathOf.textView(Matching.youDecide("Source of Funds")));
            verify.elementIsPresent(xpathOf.textView(Matching.youDecide("Industry")));
            verify.elementIsPresent(xpathOf.textView(Matching.youDecide("Name of Employer/Business")));

            verify.elementIsPresent(keyEditLinkOtherdetails);
            swipe.vertical(2,0.2,0.9,5);

        }

    }




    public void clickEditLink(String ilogic) throws ApplicationException {
        if(Device.isAndroid()) {
            swipe.vertical(2,0.9,0.7,5);

            switch (ilogic) {
                case "Mobile Number":
                    click.elementBy(keyEditLinkPersonaldetails);
                    break;
                case "Address":
                    click.elementBy(keyEditLinkAddressdetails);
                    break;
                case "Other details":
                    click.elementBy(keyEditLinkOtherdetails);
                    break;
                default:
                    System.out.println("cannot able to locate edit link section");
                    break;
            }
        }
        else
        {
            switch (ilogic) {
                case "Mobile Number":
                    click.elementBy(keyEditLinkPersonaldetails);
                    break;
                case "Address":
                    click.elementBy(keyEditLinkAddressdetails);
                    break;
                case "Other details":
                    click.elementBy(keyEditLinkOtherdetails);
                    break;
                default:
                    System.out.println("cannot able to locate edit link section");
                    break;
            }
        }

        WAIT.forSeconds(5);
    }
        public void verifyUpdateMobilePageTitle(String ititle) throws ApplicationException {

            verify.elementTextContains(xpathOf.textView(Matching.youDecide("Update Mobile Number")), ititle);

        }

    public void verifyUpdateMobilePageElements() throws ApplicationException {
        if(Device.isAndroid()) {
            verify.elementIsPresent(keytxtboxupdatemobileno);
            verify.elementIsPresent(keybtnboxupdateclose);
            verify.elementIsPresent(keybtnboxupdatemobilesave);
            verify.elementIsPresent(keyTXTPrefixMobileNumber);
            verify.elementIsPresent(keylblboxupdatemobileverbiage);
        }

        else
        {
            verify.elementIsPresent(keytxtboxupdatemobileno);
            verify.elementIsPresent(keybtnboxupdateclose);
            verify.elementIsPresent(keybtnupdatemobilenext);
            verify.elementIsPresent(keybtnboxupdatemobilesave);
            verify.elementIsPresent(keylblboxupdatemobileverbiage);
        }
    }
    public void enterUpdateMobilenumber(String ivalue) throws ApplicationException {
        //click.elementBy(keytxtboxupdatemobileno);
       //String mobilenocheck= get.elementText(keytxtboxupdatemobileno);
       if(mobilenovalue.contains("0000000000"))
       {
           type.data(keytxtboxupdatemobileno, "9999999999");
       }
       else if(mobilenovalue.contains("9999999999")){
           type.data(keytxtboxupdatemobileno, "0000000000");
       }
    }

    public void clickNextBtn() throws ApplicationException {
        click.elementBy(keybtnupdatemobilenext);
    }

    public void verifySuccessfullProfileUpdate1() throws ApplicationException {
        WAIT.forSeconds(7);
        verify.elementIsPresent(keylblSuccessfullupdatetitle);
        verify.elementIsPresent(keylblSuccessfullupdatemessage);
        verify.elementIsPresent(keylblSuccessfullupdatetxtcontent);
       // verify.elementIsPresent(xpathOf.button(Contains.youDecide("PROFILE")));

    }
    public void clickGoToProfileBtn1() throws ApplicationException {
        if(Device.isAndroid()) {
            click.elementBy(keylblSuccessfullupdatetxtcontent);
        }
        else {
            click.elementBy(xpathOf.button(Contains.youDecide("PROFILE")));
        }
        WAIT.forSeconds(2);
    }

    public void verifyUpdateAddressPageTitle(String ititle) throws ApplicationException {

        WAIT.forSeconds(3);
        verify.elementTextContains(keyLblTitleUpdateAddressPage, ititle);

    }

    public void verifyUpdateAddressPageElements() throws ApplicationException {

        if(Device.isAndroid()) {
                verify.elementIsPresent(keyBtnCloseUpdateAddressPage);
                verify.elementIsPresent(keyBtnSaveTopUpdateAddressPage);
                //verify.elementIsPresent(keyBtnSaveBottomUpdateAddressPage);
                verify.elementTextMatching(keyLblContenttxtUpdateAddressPage,"Be reminded that all fields are required.");
                //verify.elementIsPresent(keyTXTCountyUpdateAddressPage);
                //verify.elementIsPresent(keyTXTStateUpdateAddressPage);
                //verify.elementIsPresent(keyTXTCityUpdateAddressPage);
               verify.elementIsPresent(keyTXTPresentStreetUpdateAddressPage);
                verify.elementIsPresent(keyBTNPresentCountyUpdateAddressPage);
                verify.elementIsPresent(keyBTNPresentStateUpdateAddressPage);
                verify.elementIsPresent(keyBTNPresentCityUpdateAddressPage);

                verify.elementTextMatching(keyLblPresentAddress,"PRESENT ADDRESS");
            verify.elementTextMatching(keyLblPermanentAddress,"PERMANENT ADDRESS");
            verify.elementTextMatching(keyLblSameWithPresentAddressVerbiage,"Same with Present Address");
            verify.elementIsPresent(keyCheckBoxSameAddess);
            swipe.vertical(2,0.7,0.2);
            verify.elementIsPresent(keyTXTPermanentStreetUpdateAddressPage);
            verify.elementIsPresent(keyBTNPermanentCountyUpdateAddressPage);
            verify.elementIsPresent(keyBTNPermanentStateUpdateAddressPage);
            verify.elementIsPresent(keyBTNPermanentCityUpdateAddressPage);
            swipe.vertical(2,0.2,0.7);

            }
            else
            {
                verify.elementIsPresent(keyBtnCloseUpdateAddressPage);
                verify.elementIsPresent(keyBtnSaveTopUpdateAddressPage);
                verify.elementIsPresent(keyBtnSaveBottomUpdateAddressPage);
                verify.elementTextMatching(keyLblContenttxtUpdateAddressPage,"Be reminded that all fields are required.");
                verify.elementIsPresent(keyTXTCountyUpdateAddressPage);
                verify.elementIsPresent(keyTXTStateUpdateAddressPage);
                verify.elementIsPresent(keyTXTCityUpdateAddressPage);
                verify.elementIsPresent(keyTXTPresentStreetUpdateAddressPage);
                verify.elementIsPresent(keyBTNPresentCountyUpdateAddressPage);
                verify.elementIsPresent(keyBTNPresentStateUpdateAddressPage);
                verify.elementIsPresent(keyBTNPresentCityUpdateAddressPage);

                verify.elementTextMatching(keyLblPresentAddress,"PRESENT ADDRESS");
                verify.elementTextMatching(keyLblPermanentAddress,"PERMANENT ADDRESS");
                verify.elementTextMatching(keyLblSameWithPresentAddressVerbiage,"Same with Present Address");
                verify.elementIsPresent(keyCheckBoxSameAddess);
                swipe.vertical(2,0.8,0.2,5);
                verify.elementIsPresent(keyTXTPermanentStreetUpdateAddressPage);
                verify.elementIsPresent(keyBTNPermanentCountyUpdateAddressPage);
                verify.elementIsPresent(keyBTNPermanentStateUpdateAddressPage);
                verify.elementIsPresent(keyBTNPermanentCityUpdateAddressPage);
                swipe.vertical(2,0.2,0.8,5);
            }

    }

    public void chooseNewCountry(String country) throws ApplicationException {

        if(Device.isAndroid())
        {
            //click.elementBy(keyBTNCountyUpdateAddressPage);
            //WAIT.forSeconds(5);
            //swipe.scrollDownToText(country);
            //click.elementBy(xpathOf.textView(Matching.youDecide(country)));
           // click.elementsValuesBy("",country);
        }
        else {
           // click.elementBy(keyBTNPresentCountyUpdateAddressPage);
          //  WAIT.forSeconds(10);
            //swipe.scrollDownToText(country);
            //click.elementBy(xpathOf.textView(Matching.youDecide(country)));
         //ios.selectPicker(country);
        }

    }
    public void chooseNewState(String state) throws ApplicationException {
        if(Device.isAndroid())
        {click.elementBy(keyBTNPresentStateUpdateAddressPage);
            WAIT.forSeconds(3);
           // click.elementsValuesBy(keyComboBoxIDType,state);
            swipe.scrollDownToTextandClick(state);
        }
        else {
            click.elementBy(keyBTNPresentStateUpdateAddressPage);
            WAIT.forSeconds(2);
            //swipe.scrollDownToText(keyBTNStateUpdateAddressPage);
            //click.elementBy(xpathOf.textView(Matching.youDecide(state)));
            ios.selectPicker(state);
        }

    }

    public void chooseNewCity(String city) throws ApplicationException {
        if(Device.isAndroid())
        {
            click.elementBy(keyBTNPresentCityUpdateAddressPage);
            WAIT.forSeconds(3);
            swipe.scrollDownToTextandClick(city);
            //click.elementsValuesBy(keyComboBoxIDType,city);
        }
        else {
            click.elementBy(keyBTNPresentCityUpdateAddressPage);
            WAIT.forSeconds(2);
            //swipe.scrollDownToText(city);
            //click.elementBy(xpathOf.textView(Matching.youDecide(city)));
            ios.selectPicker(city);
        }

    }

    public void enterStreetDetails(String idata) throws ApplicationException {

        type.data(keyTXTPresentStreetUpdateAddressPage,idata);

    }

    public void clickSavebtnUpdateAddress() throws ApplicationException {

        swipe.vertical(2,0.7,0.2);
       click.elementBy(keyBtnSaveTopUpdateAddressPage);

    }

    public void verifyUpdateOtherDetailsPageTitle(String ititle) throws ApplicationException {

        verify.elementTextContains(xpathOf.textView(Matching.youDecide("Update Other Details")), ititle);

    }

    public void verifyUpdateOtherDetailsPageElements() throws ApplicationException {

        if(Device.isAndroid()) {

            verify.elementIsPresent(keyBtnCloseOtherDetailsPage);
            verify.elementIsPresent(keyBtnSaveTopOtherDetailsPage);
            //verify.elementIsPresent(keyBtnSaveBottomOtherDetailsPage);
            verify.elementIsPresent(keyLblContenttxtOtherDetailsPage);
            //verify.elementIsPresent(keyTXTChooseIdentityOtherDetailsPage);
           // verify.elementIsPresent(keyTXTEnterIdentityOtherDetailsPage);
            //verify.elementIsPresent(keyTXTChooseSourceofFundsOtherDetailsPage);
            //verify.elementIsPresent(keyTXTChooseEmployerOtherDetailsPage);
            //verify.elementIsPresent(keyTXTChooseEmployerDivisionOtherDetailsPage);
            verify.elementIsPresent(keyBtnChooseIdentityOtherDetailsPage);
            verify.elementIsPresent(keyBtnChooseSourceofFundsOtherDetailsPage);
            verify.elementIsPresent(keyBtnChooseEmployerOtherDetailsPage);
           // verify.elementIsPresent(keyBtnChooseEmployerDivisionOtherDetailsPage);
        }
        else
        {
            verify.elementIsPresent(keyBtnCloseOtherDetailsPage);
            verify.elementIsPresent(keyBtnSaveTopOtherDetailsPage);
            verify.elementIsPresent(keyBtnSaveBottomOtherDetailsPage);
            verify.elementIsPresent(keyLblContenttxtOtherDetailsPage);
            verify.elementIsPresent(keyTXTChooseIdentityOtherDetailsPage);
            verify.elementIsPresent(keyTXTEnterIdentityOtherDetailsPage);
            verify.elementIsPresent(keyTXTChooseSourceofFundsOtherDetailsPage);
            verify.elementIsPresent(keyTXTChooseEmployerOtherDetailsPage);
            verify.elementIsPresent(keyTXTChooseEmployerDivisionOtherDetailsPage);
            verify.elementIsPresent(keyBtnChooseIdentityOtherDetailsPage);
            verify.elementIsPresent(keyBtnChooseSourceofFundsOtherDetailsPage);
            verify.elementIsPresent(keyBtnChooseEmployerOtherDetailsPage);
            verify.elementIsPresent(keyBtnChooseEmployerDivisionOtherDetailsPage);
        }

    }

    public void ChooseandEnterIdentitydetails(String idtype,String idvalue) throws ApplicationException {

        if(Device.isAndroid())
        {
            click.elementBy(keyBtnChooseIdentityOtherDetailsPage);
            WAIT.forSeconds(5);
            // swipe.scrollUpToText("Passport for non residents");
            //swipe.scrollDownToText(idtype);
            click.elementsValuesBy(keyComboBoxIDType,idtype);
            type.data(keyTXTEnterIdentityOtherDetailsPage,idvalue);
        }

        else {
            click.elementBy(keyBtnChooseIdentityOtherDetailsPage);
            WAIT.forSeconds(3);
            // swipe.scrollUpToText("Passport for non residents");
            //swipe.scrollDownToText(idtype);
            ios.selectPicker(idtype);
            type.data(keyTXTEnterIdentityOtherDetailsPage, idvalue);
        }
    }

    public void ChooseSourceoffunds(String sourceoffunds) throws ApplicationException {
        if(Device.isAndroid()) {
            click.elementBy(keyBtnChooseSourceofFundsOtherDetailsPage);
            WAIT.forSeconds(5);
            // swipe.scrollUpToText("Business Income");
            click.elementsValuesBy(keyComboBoxIDType,sourceoffunds);
        }
        else
        {
            click.elementBy(keyBtnChooseSourceofFundsOtherDetailsPage);
            WAIT.forSeconds(3);
            // swipe.scrollUpToText("Business Income");
            //swipe.scrollDownToText(sourceoffunds);
            ios.selectPicker(sourceoffunds);
        }

    }

    public void ChooseAndEnterEmployerdetails(String emptype,String empname) throws ApplicationException {
        if(Device.isAndroid()) {
            click.elementBy(keyBtnChooseEmployerOtherDetailsPage);
            WAIT.forSeconds(5);
            //swipe.scrollUpToText("Agriculture, Hunting, Forestry");
            //swipe.scrollDownToText(emptype);

            swipe.scrollDownToTextandClick(emptype);
            //click.elementsValuesBy(keyComboBoxIDType,emptype);
            type.data(keyTXTChooseEmployerDivisionOtherDetailsPage, empname);
        }
        else
        {
            click.elementBy(keyBtnChooseEmployerOtherDetailsPage);
            WAIT.forSeconds(3);
            //swipe.scrollUpToText("Agriculture, Hunting, Forestry");
            //swipe.scrollDownToText(emptype);
            ios.selectPicker(emptype);
            type.data(keyTXTChooseEmployerDivisionOtherDetailsPage, empname);
        }

    }
    public void ClickTopSaveBtnUpdateOtherDetailsPage() throws ApplicationException {

        click.elementBy(keyBtnSaveTopOtherDetailsPage);

    }

    public void verifyUpdatedValuesforEditPresentAddress(String iaddress) throws ApplicationException {
        WAIT.forSeconds(1);
        verify.elementTextContains(keyLblPresentAddressValue,iaddress);
    }


    public void verifyUpdatedValuesforEditPermanentAddress(String iaddress) throws ApplicationException {
        WAIT.forSeconds(1);
    verify.elementTextContains(keyLblPermanentAddressValue,iaddress);
    }


    public void verifyUpdatedValuesforEditMobilenumber(String imobileNum) throws ApplicationException {
        WAIT.forSeconds(3);
        try
            {
                verify.elementTextContains(keyLblmobilenumberValue,imobileNum);
             }
             catch(Exception ex)
             {
                 verify.elementTextContains(keyLblmobilenumberValue,"9999999999");
             }

    }
    public void verifyUpdatedValuesforEditOtherdetails(String idtype,String idvalue,String sourcefunds,String industry,String employer) throws ApplicationException {
        if(Device.isAndroid()) {
            WAIT.forSeconds(5);
            swipe.vertical(2,0.9,0.4,5);
            verify.elementTextMatching(keyLblIdDetails, idtype);
            verify.elementTextMatching(keyLblIdValues, idvalue);
            verify.elementTextMatching(keyLblSourceofFundsValue, sourcefunds);
            verify.elementTextMatching(keyLblIndustryValue, industry);
            verify.elementTextMatching(keyLblEmployerNameValue, employer);
        }
        else
        {
            verify.elementTextMatching(keyLblIdDetails, idtype);
            verify.elementTextMatching(keyLblIdValues, idvalue);
            verify.elementTextMatching(keyLblSourceofFundsValue, sourcefunds);
            verify.elementTextMatching(keyLblIndustryValue, industry);
            verify.elementTextMatching(keyLblEmployerNameValue, employer);
        }

    }

    public void verifyAccountLogicToConfirmtheUser(String password) throws ApplicationException {
        WAIT.forSeconds(4);
        verify.elementTextMatching(keyLblVerifyAccountPagetitle, "Verify Account");
        verify.elementIsPresent(keyTXTEnterPassword);
        verify.elementIsPresent(keyBTNProceed);
        verify.elementIsPresent(keyLINKForgotPassword);
        verify.elementIsPresent(keyBTNBackfromVerifyAccount);

        type.sensitiveData(keyTXTEnterPassword,password);
        click.elementBy(keyBTNProceed);
        WAIT.forSeconds(1);

    }

    public void verifyAccountPageContents() throws ApplicationException {
        WAIT.forSeconds(4);
        verify.elementTextMatching(keyLblVerifyAccountPagetitle, "Verify Account");
        verify.elementIsPresent(keyTXTEnterPassword);
        verify.elementIsPresent(keyBTNProceed);
        verify.elementIsPresent(keyLINKForgotPassword);
        verify.elementIsPresent(keyBTNBackfromVerifyAccount);
        verify.elementIsPresent(keyVerifyAccountTogglePasswordVisibility);
        verify.elementTextMatching(keyLblVerifyAccountPageContent, "Verify your account by entering your password.");
        verify.elementTextMatching(keyLINKForgotPassword, "Forgot Password?");
        if(Device.isAndroid()) {
            verify.elementAttributeMatching(keyTXTEnterPassword, "text", "Password");
        }
        else
        {
            verify.elementAttributeMatching(keyTXTEnterPassword, "value", "Password");

        }

    }

    public void chooseNewPermanentCountry(String country) throws ApplicationException {

        if(Device.isAndroid())
        {
            //click.elementBy(keyBTNCountyUpdateAddressPage);
            //WAIT.forSeconds(5);
            //swipe.scrollDownToText(country);
            //click.elementBy(xpathOf.textView(Matching.youDecide(country)));
            // click.elementsValuesBy("",country);
        }
        else {
            click.elementBy(keyBTNPermanentCountyUpdateAddressPage);
            WAIT.forSeconds(2);
            //swipe.scrollDownToText(country);
            //click.elementBy(xpathOf.textView(Matching.youDecide(country)));
            ios.selectPicker(country);
        }

    }
    public void chooseNewPermanentState(String state) throws ApplicationException {

        //swipe.vertical(2,0.7,0.2);

        if(Device.isAndroid())
        {
            click.elementBy(keyBTNPermanentStateUpdateAddressPage);
            WAIT.forSeconds(3);
            swipe.scrollDownToTextandClick(state);
           // click.elementsValuesBy(keyComboBoxIDType,state);
        }
        else {
            click.elementBy(keyBTNPermanentStateUpdateAddressPage);
            WAIT.forSeconds(2);
            //swipe.scrollDownToText(keyBTNStateUpdateAddressPage);
            //click.elementBy(xpathOf.textView(Matching.youDecide(state)));
            ios.selectPicker(state);
        }

    }

    public void chooseNewPermanentCity(String city) throws ApplicationException {
        if(Device.isAndroid())
        {
            click.elementBy(keyBTNPermanentCityUpdateAddressPage);
            WAIT.forSeconds(3);
            swipe.scrollDownToTextandClick(city);
           // click.elementsValuesBy(keyComboBoxIDType,city);
        }
        else {
            click.elementBy(keyBTNPermanentCityUpdateAddressPage);
            WAIT.forSeconds(2);
            //swipe.scrollDownToText(city);
            //click.elementBy(xpathOf.textView(Matching.youDecide(city)));
            ios.selectPicker(city);
        }

    }

    public void enterPermanentStreetDetails(String idata) throws ApplicationException {

        type.data(keyTXTPermanentStreetUpdateAddressPage,idata);

    }

}


