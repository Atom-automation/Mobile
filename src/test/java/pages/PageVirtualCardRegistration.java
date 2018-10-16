package pages;

import base.Keywords;
import exceptions.ApplicationException;
import helper.Device;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import xpath.Matching;

import java.util.List;

public class PageVirtualCardRegistration extends Keywords {

    private String keyLblPageTitle="Getgo.CreateVirtualCard.LblPageTitle";
    private String keyTxtMobileNumber="Getgo.CreateVirtualCard.TxtMobileNumber";
    private String keyTxtEmailAddress="Getgo.CreateVirtualCard.TxtEmailAddress";
    private String keyTxtNominatePassword="Getgo.CreateVirtualCard.TxtNominatePassword";
    private String keyTxtConfirmPassword="Getgo.CreateVirtualCard.TxtConfirmPassword";
    private String keyNext="Getgo.CreateVirtualCard.BtnNext";

    private String keyTxtFirstName="Getgo.CreateVirtualCard.TxtFirstName";
    private String keyTxtMiddleName="Getgo.CreateVirtualCard.TxtMiddleName";
    private String keyTxtLastName="Getgo.CreateVirtualCard.TxtLastName";
    private String keyBtnCalendar="Getgo.CreateVirtualCard.BtnCalendar";
    private String keyBtnNationality="Getgo.CreateVirtualCard.BtnNationalityDropdown";
    private String keyRadioGender_Male="Getgo.CreateVirtualCard.BtnGender.Male";
    private String keyRadionGender_Female="Getgo.CreateVirtualCard.BtnGender.Female";
    private String keyTxtDOB="Getgo.CreateVirtualCard.TxtDOB";
    private String keyBtnSourceofFunds="Getgo.CreateVirtualCard.BtnSourceofFunds";

    private String keyLblStepNumber="Getgo.CreateVirtualCard.LblStepNumber";
    private String keyLblStepHeader="Getgo.CreateVirtualCard.LblStepHeader";
    private String keyLblStepIndicator="Getgo.CreateVirtualCard.LblStepIndicator";

    private String keyLblNoteAddressDetailsPage="Getgo.CreateVirtualCard.LblNoteAddressDetailsPage";
    private String keyLblPresentAddressVerbiage="Getgo.CreateVirtualCard.LblPresentAddressVerbiage";
    private String keyLblPermanentAddressVerbiage="Getgo.CreateVirtualCard.LblPermanentAddressVerbiage";
    private String keyBtnPresentCountry="Getgo.CreateVirtualCard.BtnPresentCountry";
    private String keyBtnPresentState="Getgo.CreateVirtualCard.BtnPresentState";
    private String keyBtnPresentCity="Getgo.CreateVirtualCard.BtnPresentCity";
    private String keyTxtPresentAddress="Getgo.CreateVirtualCard.TxtPresentAddress";
    private String keyCheckBoxSameAddress="Getgo.CreateVirtualCard.CheckBoxSameAddress";
    private String keyLblSameAddressVerbiage="Getgo.CreateVirtualCard.LblSameAddressVerbiage";
    private String keyBtnNextAddressPage="Getgo.CreateVirtualCard.BtnNextAddressPage";

    private String keyBtnPermanentCountry="Getgo.CreateVirtualCard.BtnPermanentCountry";
    private String keyBtnPermanentState="Getgo.CreateVirtualCard.BtnPermanentState";
    private String keyBtnPermanentCity="Getgo.CreateVirtualCard.BtnPermanentCity";
    private String keyTxtPermanentAddress="Getgo.CreateVirtualCard.TxtPermanentAddress";

    private String keyTxtPresentCountry="Getgo.CreateVirtualCard.TxtPresentCountry";


    private String dob;

    public void verifyPageTitle(String ititle) throws ApplicationException {
        if(Device.isAndroid()) {
            verify.elementTextMatching(keyLblPageTitle, ititle);
        }
        else
        {
            verify.elementTextMatching(keyLblPageTitle, "CEB GetGo Prepaid Virtual");
        }
    }

    public void enterBasicDetails(String mobileNumber, String emailID, String password) throws ApplicationException {
        type.data(keyTxtMobileNumber,mobileNumber);
        //need to check it
       // type.data(keyTxtEmailAddress,emailID);
        verify.elementIsPresent(keyTxtEmailAddress);
        verify.elementTextMatching(keyTxtEmailAddress,emailID);
        type.sensitiveData(keyTxtNominatePassword,password);
        type.sensitiveData(keyTxtConfirmPassword,password);
    }

    public void clickNext() throws ApplicationException {
        click.elementBy(keyNext);
    }

    public void enterPersonalDetails(String firstName,String middleName,String lastName,String nationality, String gender,String sourceoffunds) throws ApplicationException {
        if(Device.isAndroid()) {
            type.data(keyTxtFirstName, firstName);
            type.data(keyTxtMiddleName, middleName);
            type.data(keyTxtLastName, lastName);
            selectDOB("23", "July", "1992");
            selectNationality(nationality);
            selectGender(gender);
            WAIT.forSeconds(3);
            selectSourceofFunds(sourceoffunds);
        }
        else
        {
            type.data(keyTxtFirstName, firstName);
            type.data(keyTxtMiddleName, middleName);
            type.data(keyTxtLastName, lastName);

            click.elementBy(keyBtnCalendar);
            WAIT.forSeconds(4);
            ios.selectPickerByIndex("12",1);
            ios.selectPickerByIndex("July",2);
           ios.selectPickerByIndex("1992",3);
            get.elementBy(xpathOf.button(Matching.name("Done"))).click();
            //selectDOB("23", "July", "1992");

            click.elementBy(keyBtnNationality);
            WAIT.forSeconds(5);
            ios.selectPicker(nationality);
            selectGender(gender);
            click.elementBy(keyBtnSourceofFunds);
            WAIT.forSeconds(3);
            ios.selectPicker(sourceoffunds);
        }
    }

    public void selectNationality(String nationality) throws ApplicationException {
        click.elementBy(keyBtnNationality);
        //swipe.scrollDownToText(nationality);
        //click.elementBy(xpathOf.textView(Matching.youDecide(nationality)));
    }
    public void selectSourceofFunds(String sourcefunds) throws ApplicationException {
        click.elementBy(keyBtnSourceofFunds);
        WAIT.forSeconds(1);
        swipe.scrollDownToText(sourcefunds);
        click.elementBy(xpathOf.textView(Matching.youDecide(sourcefunds)));
    }


    public void selectGender(String gender) throws ApplicationException {
        if(gender.equalsIgnoreCase("male")){
            click.elementBy(keyRadioGender_Male);
        }else{
            click.elementBy(keyRadionGender_Female);
        }
    }

    public void selectDOB(String day,String month, String year) throws ApplicationException {
        click.elementBy(keyBtnCalendar);
        int systemYear=Integer.parseInt(get.elementText(By.id("android:id/date_picker_header_year")));
        int maximumLoopTime=(systemYear-Integer.parseInt(year.trim()))/5;
        boolean clickedYear=false;
        get.elementBy(By.id("android:id/date_picker_header_year")).click();

        for(int i=0;i<=maximumLoopTime;i++) {

                List<WebElement> el = driver.findElements(By.id("android:id/text1"));
                try {
                    for (int j = 0; j < el.size(); j++) {
                        if (el.get(j).getText().toString().contentEquals(year.toLowerCase().trim())) {
                            el.get(j).click();
                            WAIT.forSeconds(2);
                            get.elementBy(By.id("android:id/button1")).click();
                            clickedYear = true;
                            break;
                        }
                    }

                    if (clickedYear == false) {
                        swipe.vertical(2, 0.4, 0.9, 2);

                    }
                    else
                    {
                       break;
                    }

                } catch (Throwable ex) {
                    swipe.vertical(2, 0.4, 0.9, 2);
                    WAIT.forSeconds(2);
                }
            }

        if(!clickedYear){
            throw new ApplicationException("Failed to select the date of birth");
        }else{
            dob=get.elementText(keyBtnCalendar);
        }
    }

    public String getDob() {
        return dob;
    }
    public String getDobvalue() throws ApplicationException {
        dob=get.elementText(keyBtnCalendar);
        return dob;
    }

    public void selectState(String state) throws ApplicationException {
        click.elementBy(keyBtnPresentState);
        WAIT.forSeconds(3);
        swipe.scrollDownToText(state);
        click.elementBy(xpathOf.textView(Matching.youDecide(state)));
    }

    public void selectCity(String city) throws ApplicationException {
        click.elementBy(keyBtnPresentCity);
        WAIT.forSeconds(3);
        swipe.scrollDownToText(city);
        click.elementBy(xpathOf.textView(Matching.youDecide(city)));
    }


    public void enterPresentAddressDetails(String country,String state,String city,String address) throws ApplicationException {

            if(Device.isAndroid()) {
                WAIT.forSeconds(3);
                verify.elementTextMatching(keyTxtPresentCountry,country);
                selectState(state);
                WAIT.forSeconds(3);
                selectCity(city);
                WAIT.forSeconds(2);
                type.data(keyTxtPresentAddress, address);
            }

            else
            {
                WAIT.forSeconds(1);
                verify.elementTextMatching(keyTxtPresentCountry,country);
                click.elementBy(keyBtnPresentState);
                WAIT.forSeconds(2);
                ios.selectPicker(state);
                WAIT.forSeconds(1);
                click.elementBy(keyBtnPresentCity);
                WAIT.forSeconds(2);
                ios.selectPicker(city);
                WAIT.forSeconds(2);
                type.data(keyTxtPresentAddress, address);
            }

    }

    public void clickNextBtnAddressPage() throws ApplicationException {
        click.elementBy(keyBtnNextAddressPage);
    }

}
