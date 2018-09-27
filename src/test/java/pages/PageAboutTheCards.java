package pages;

import base.Keywords;
import exceptions.ApplicationException;
import helper.Device;
import xpath.Matching;

public class PageAboutTheCards extends Keywords {


    private String keyLblPageTitle = "Getgo.AboutTheCards.LblPageTitle";
    private String keyBtnClose = "Getgo.AboutTheCards.BtnClose";
    private String keyIMGVirtualcard = "Getgo.AboutTheCards.IMGVirtualcard";
    private String keyIMGPhysicalcard = "Getgo.AboutTheCards.IMGPhysicalcard";
    private String keyLblVirtualcard = "Getgo.AboutTheCards.LblVirtualcard";
    private String keyLblPhysicalcard = "Getgo.AboutTheCards.LblPhysicalcard";
    private String keyLblVirtualcardContent = "Getgo.AboutTheCards.LblVirtualcardContent";
    private String keyLblPhysicalcardContent = "Getgo.AboutTheCards.LblPhysicalcardContent";

    private String keyLblOneTimeFeeSubTitle = "Getgo.AboutTheCards.LblOneTimeFeeSubTitle";
    private String keyLblOneTimeFeeDetails = "Getgo.AboutTheCards.LblOneTimeFeeDetails";
    private String keyLblOneTimeFeeAmt = "Getgo.AboutTheCards.LblOneTimeFeeAmt";

    private String keyLblRewardsSubTitle = "Getgo.AboutTheCards.LblRewardsSubTitle";
    private String keyLblRewardsMembership = "Getgo.AboutTheCards.LblRewardsMembership";
    private String keyLblRewardsIndicatorVirtual = "Getgo.AboutTheCards.LblRewardsIndicatorVirtual";
    private String keyLblRewardsIndicatorPhysical = "Getgo.AboutTheCards.LblRewardsIndicatorPhysical";
    private String keyLblRewardsEarnPointsDetails = "Getgo.AboutTheCards.LblRewardsEarnPointsDetails";
    private String keyLblRewardsEarnPointsVirtual = " Getgo.AboutTheCards.LblRewardsEarnPointsVirtual";
    private String keyLblRewardsEarnPointsPhysical = "Getgo.AboutTheCards.LblRewardsEarnPointsPhysical";
    private String keyLblRewardsEarnPointsMonthlyDetails = "Getgo.AboutTheCards.LblRewardsEarnPointsMonthlyDetails";
    private String keyLblRewardsEarnPointsMonthlyVirtual = "Getgo.AboutTheCards.LblRewardsEarnPointsMonthlyVirtual";
    private String keyLblRewardsEarnPointsMonthlyPhysical = "Getgo.AboutTheCards.LblRewardsEarnPointsMonthlyPhysical";
    private String keyLblRewardsEarnPointsGetGoPartnersDetails = "Getgo.AboutTheCards.LblRewardsEarnPointsGetGoPartnersDetails";
    private String keyLblRewardsEarnPointsGetGoPartnersVirtual = "Getgo.AboutTheCards.LblRewardsEarnPointsGetGoPartnersVirtual";
    private String keyLblRewardsEarnPointsGetGoPartnersPhysical = "Getgo.AboutTheCards.LblRewardsEarnPointsGetGoPartnersPhysical";
    private String keyLblConvenienceSubTitle = "Getgo.AboutTheCards.LblConvenienceSubTitle";
    private String keyLblConvenienceDetails = "Getgo.AboutTheCards.LblConvenienceDetails";
    private String keyLblConvenienceIndicatorVirtual = "Getgo.AboutTheCards.LblConvenienceIndicatorVirtual";
    private String keyLblConvenienceIndicatorPhysical = "Getgo.AboutTheCards.LblConvenienceIndicatorPhysical";
    private String keyLblConvenienceWithdrawalDetails = "Getgo.AboutTheCards.LblConvenienceWithdrawalDetails";
    private String keyLblConvenienceWithdrawalIndicatorVirtual = "Getgo.AboutTheCards.LblConvenienceWithdrawalIndicatorVirtual";
    private String keyLblConvenienceWithdrawalIndicatorPhysical = "Getgo.AboutTheCards.LblConvenienceWithdrawalIndicatorPhysical";
    private String keyLblPrivilegesSubTitle = "Getgo.AboutTheCards.LblPrivilegesSubTitle";
    private String keyLblPrivilegesDiscountDetails = "Getgo.AboutTheCards.LblPrivilegesDiscountDetails";
    private String keyLblPrivilegesDiscountIndicatorVirtual = "Getgo.AboutTheCards.LblPrivilegesDiscountIndicatorVirtual";
    private String keyLblPrivilegesDiscountIndicatorPhysical = "Getgo.AboutTheCards.LblPrivilegesDiscountIndicatorPhysical";
    private String keyLblPrivilegesExclusiveDetails = "Getgo.AboutTheCards.LblPrivilegesExclusiveDetails";
    private String keyLblPrivilegesExclusiveIndicatorVirtual = "Getgo.AboutTheCards.LblPrivilegesExclusiveIndicatorVirtual";
    private String keyLblPrivilegesExclusiveIndicatorPhysical = "Getgo.AboutTheCards.LblPrivilegesExclusiveIndicatorPhysical";
    private String keyLblPrivilegesSaleAlertDetails = "Getgo.AboutTheCards.LblPrivilegesSaleAlertDetails";
    private String keyLblPrivilegesSaleAlertIndicatorVirtual = "Getgo.AboutTheCards.LblPrivilegesSaleAlertIndicatorVirtual";
    private String keyLblPrivilegesSaleAlertIndicatorPhysical = "Getgo.AboutTheCards.LblPrivilegesSaleAlertIndicatorPhysical";
    private String keyLblAboutBottonIndicator = "Getgo.AboutTheCards.LblAboutBottonIndicator";




    public void verifyPageTitle(String ititle) throws ApplicationException {
        WAIT.forSeconds(5);
        //need to check it or modify
        if(Device.isAndroid()) {
            verify.elementTextMatching(keyLblPageTitle, ititle);
        }
        else
        {
            verify.elementTextMatching(keyLblPageTitle,"About");
        }

    }

    public void verifyPageContents() throws ApplicationException {
        WAIT.forSeconds(10);
        if(Device.isAndroid()) {
            //unionbank section
            verify.elementIsPresent(keyBtnClose);
            verify.elementIsPresent(keyIMGVirtualcard);
            verify.elementIsPresent(keyIMGPhysicalcard);
            verify.elementTextMatching(keyLblVirtualcard,"GETGO VIRTUAL CARD");
            verify.elementTextMatching(keyLblPhysicalcard,"GETGO PHYSICAL CARD");
            verify.elementTextMatching(keyLblVirtualcardContent,"Shop online with a virtual prepaid card that earns GetGo Points. Get the card instantly upon signup.");
            verify.elementTextMatching(keyLblPhysicalcardContent,"Shop, dine and travel with a multi-currency card that earns GetGo Points.");

            verify.elementTextMatching(keyLblOneTimeFeeSubTitle,"One-time Card Fee");
            verify.elementTextMatching(keyLblOneTimeFeeDetails,"FREE");
            verify.elementTextMatching(keyLblOneTimeFeeAmt,"PHP 150");

            swipe.vertical(2,0.9,0.3,5);

            verify.elementTextMatching(keyLblRewardsSubTitle,"Rewards");
            verify.elementTextMatching(keyLblRewardsMembership,"Free GetGo Membership");
            verify.elementTextMatching(keyLblRewardsIndicatorVirtual,"YES");
            verify.elementTextMatching(keyLblRewardsIndicatorPhysical,"YES");
            verify.elementTextMatching(keyLblRewardsEarnPointsDetails,"Earn GetGo Points");
            verify.elementTextMatching(keyLblRewardsEarnPointsVirtual,"1 GetGo Point - Php 100 spend through Visa");
            verify.elementTextMatching(keyLblRewardsEarnPointsPhysical,"1 GetGo Point - Php 88 spend through Visa");
            verify.elementTextMatching(keyLblRewardsEarnPointsMonthlyDetails,"Monthly Transfer of Points to your GetGo Account");
            verify.elementTextMatching(keyLblRewardsEarnPointsMonthlyVirtual,"YES");
            verify.elementTextMatching(keyLblRewardsEarnPointsMonthlyPhysical,"YES");
            verify.elementTextMatching(keyLblRewardsEarnPointsGetGoPartnersDetails,"Earn Points from GetGo Partners\n");
            verify.elementTextMatching(keyLblRewardsEarnPointsGetGoPartnersVirtual,"YES");
            verify.elementTextMatching(keyLblRewardsEarnPointsGetGoPartnersPhysical,"YES");
            swipe.vertical(2,0.9,0.3,5);
            verify.elementTextMatching(keyLblConvenienceSubTitle,"Convenience");
            verify.elementTextMatching(keyLblConvenienceDetails,"Pay with Visa");
            verify.elementTextMatching(keyLblConvenienceIndicatorVirtual,"ONLINE");
            verify.elementTextMatching(keyLblConvenienceIndicatorPhysical,"ONLINE AND ALL VISA AFFILIATED STORES WORLDWIDE");
            verify.elementTextMatching(keyLblConvenienceWithdrawalDetails,"Withdraw Money through Bancnet and Visa ATMs");
            verify.elementTextMatching(keyLblConvenienceWithdrawalIndicatorVirtual,"NOT APPLICABLE");
            verify.elementTextMatching(keyLblConvenienceWithdrawalIndicatorPhysical,"YES");
            verify.elementTextMatching(keyLblPrivilegesSubTitle,"Privileges");
            verify.elementTextMatching(keyLblPrivilegesDiscountDetails,"10% Discount on Redemption for Cebu Pacific flights");
            verify.elementTextMatching(keyLblPrivilegesDiscountIndicatorVirtual,"YES");
            verify.elementTextMatching(keyLblPrivilegesDiscountIndicatorPhysical,"YES");

            swipe.vertical(2,0.9,0.3,5);
            verify.elementTextMatching(keyLblPrivilegesExclusiveDetails,"Cebu Pacific Exclusive Seat Sale");
            verify.elementTextMatching(keyLblPrivilegesExclusiveIndicatorVirtual,"YES");
            verify.elementTextMatching(keyLblPrivilegesExclusiveIndicatorPhysical,"YES");
            verify.elementTextMatching(keyLblPrivilegesSaleAlertDetails,"Cebu Pacific Early Seat Sale Alerts");
            verify.elementTextMatching(keyLblPrivilegesSaleAlertIndicatorVirtual,"YES");
            verify.elementTextMatching(keyLblPrivilegesSaleAlertIndicatorPhysical,"YES");
            verify.elementTextMatching(keyLblAboutBottonIndicator,"* Fees and charges will apply. See FAQs for details.");

        }
        else
        {
            /*
            verify.elementIsPresent(keyBtnClose);

            verify.elementIsPresent(keyIMGVirtualcard);
            verify.elementIsPresent(keyIMGPhysicalcard);
            verify.elementTextMatching(keyLblVirtualcard,"GETGO VIRTUAL CARD");
            verify.elementTextMatching(keyLblPhysicalcard,"GETGO PHYSICAL CARD");
            verify.elementTextMatching(keyLblVirtualcardContent,"Shop online with a virtual prepaid card that earns GetGo Points. Get the card instantly upon signup.");
            verify.elementTextMatching(keyLblPhysicalcardContent,"Shop, dine and travel with a multi-currency card that earns GetGo Points.");

            verify.elementTextMatching(keyLblOneTimeFeeSubTitle,"One-time Card Fee");
            verify.elementTextMatching(keyLblOneTimeFeeDetails,"FREE");
            verify.elementTextMatching(keyLblOneTimeFeeAmt,"PHP 150");

            swipe.vertical(2,0.9,0.3,5);

            verify.elementTextMatching(keyLblRewardsSubTitle,"Rewards");
            verify.elementTextMatching(keyLblRewardsMembership,"Free GetGo Membership");
            verify.elementTextMatching(keyLblRewardsIndicatorVirtual,"YES");
            verify.elementTextMatching(keyLblRewardsIndicatorPhysical,"YES");
            verify.elementTextMatching(keyLblRewardsEarnPointsDetails,"Earn GetGo Points");
            verify.elementTextMatching(keyLblRewardsEarnPointsVirtual,"1 GetGo Point - Php 100 spend through Visa");
            verify.elementTextMatching(keyLblRewardsEarnPointsPhysical,"1 GetGo Point - Php 88 spend through Visa");
            verify.elementTextMatching(keyLblRewardsEarnPointsMonthlyDetails,"Monthly Transfer of Points to your GetGo Account");
            verify.elementTextMatching(keyLblRewardsEarnPointsMonthlyVirtual,"YES");
            verify.elementTextMatching(keyLblRewardsEarnPointsMonthlyPhysical,"YES");
            verify.elementTextMatching(keyLblRewardsEarnPointsGetGoPartnersDetails,"Earn Points from GetGo Partners\n");
            verify.elementTextMatching(keyLblRewardsEarnPointsGetGoPartnersVirtual,"YES");
            verify.elementTextMatching(keyLblRewardsEarnPointsGetGoPartnersPhysical,"YES");
            swipe.vertical(2,0.9,0.3,5);
            verify.elementTextMatching(keyLblConvenienceSubTitle,"Convenience");
            verify.elementTextMatching(keyLblConvenienceDetails,"Pay with Visa");
            verify.elementTextMatching(keyLblConvenienceIndicatorVirtual,"ONLINE");
            verify.elementTextMatching(keyLblConvenienceIndicatorPhysical,"ONLINE AND ALL VISA AFFILIATED STORES WORLDWIDE");
            verify.elementTextMatching(keyLblConvenienceWithdrawalDetails,"Withdraw Money through Bancnet and Visa ATMs");
            verify.elementTextMatching(keyLblConvenienceWithdrawalIndicatorVirtual,"NOT APPLICABLE");
            verify.elementTextMatching(keyLblConvenienceWithdrawalIndicatorPhysical,"YES");
            verify.elementTextMatching(keyLblPrivilegesSubTitle,"Privileges");
            verify.elementTextMatching(keyLblPrivilegesDiscountDetails,"10% Discount on Redemption for Cebu Pacific flights");
            verify.elementTextMatching(keyLblPrivilegesDiscountIndicatorVirtual,"YES");
            verify.elementTextMatching(keyLblPrivilegesDiscountIndicatorPhysical,"YES");

            swipe.vertical(2,0.9,0.3,5);
            verify.elementTextMatching(keyLblPrivilegesExclusiveDetails,"Cebu Pacific Exclusive Seat Sale");
            verify.elementTextMatching(keyLblPrivilegesExclusiveIndicatorVirtual,"YES");
            verify.elementTextMatching(keyLblPrivilegesExclusiveIndicatorPhysical,"YES");
            verify.elementTextMatching(keyLblPrivilegesSaleAlertDetails,"Cebu Pacific Early Seat Sale Alerts");
            verify.elementTextMatching(keyLblPrivilegesSaleAlertIndicatorVirtual,"YES");
            verify.elementTextMatching(keyLblPrivilegesSaleAlertIndicatorPhysical,"YES");
            verify.elementTextMatching(keyLblAboutBottonIndicator,"* Fees and charges will apply. See FAQs for details.");

            */
            verify.elementIsPresent(keyBtnClose);
            verify.elementIsPresent(keyIMGVirtualcard);
            verify.elementIsPresent(keyIMGPhysicalcard);
            verify.elementIsPresent(keyLblVirtualcard);
            verify.elementIsPresent(keyLblPhysicalcard);
            verify.elementIsPresent(keyLblVirtualcardContent);
            verify.elementIsPresent(keyLblPhysicalcardContent);

            swipe.vertical(2,0.8,0.5,5);

            verify.elementIsPresent(keyLblOneTimeFeeSubTitle);
            verify.elementIsPresent(keyLblOneTimeFeeDetails);
            verify.elementIsPresent(keyLblOneTimeFeeAmt);

            verify.elementIsPresent(keyLblRewardsSubTitle);
            verify.elementIsPresent(keyLblRewardsMembership);
            verify.elementIsPresent(keyLblRewardsIndicatorVirtual);
            verify.elementIsPresent(keyLblRewardsIndicatorPhysical);

            swipe.vertical(2,0.8,0.5,5);

            verify.elementIsPresent(keyLblRewardsEarnPointsDetails);
            verify.elementIsPresent(keyLblRewardsEarnPointsVirtual);
            verify.elementIsPresent(keyLblRewardsEarnPointsPhysical);
            verify.elementIsPresent(keyLblRewardsEarnPointsMonthlyDetails);
            verify.elementIsPresent(keyLblRewardsEarnPointsMonthlyVirtual);
            verify.elementIsPresent(keyLblRewardsEarnPointsMonthlyPhysical);

            swipe.vertical(2,0.8,0.5,5);

            verify.elementIsPresent(keyLblRewardsEarnPointsGetGoPartnersDetails);
            verify.elementIsPresent(keyLblRewardsEarnPointsGetGoPartnersVirtual);
            verify.elementIsPresent(keyLblRewardsEarnPointsGetGoPartnersPhysical);
            verify.elementIsPresent(keyLblConvenienceSubTitle);
            verify.elementIsPresent(keyLblConvenienceDetails);
            verify.elementIsPresent(keyLblConvenienceIndicatorVirtual);
            verify.elementIsPresent(keyLblConvenienceIndicatorPhysical);
            swipe.vertical(2,0.8,0.5,5);

            verify.elementIsPresent(keyLblConvenienceWithdrawalDetails);
            verify.elementIsPresent(keyLblConvenienceWithdrawalIndicatorVirtual);
            verify.elementIsPresent(keyLblConvenienceWithdrawalIndicatorPhysical);
            verify.elementIsPresent(keyLblPrivilegesSubTitle);
            verify.elementIsPresent(keyLblPrivilegesDiscountDetails);
            verify.elementIsPresent(keyLblPrivilegesDiscountIndicatorVirtual);
            verify.elementIsPresent(keyLblPrivilegesDiscountIndicatorPhysical);
            verify.elementIsPresent(keyLblPrivilegesExclusiveDetails);

            swipe.vertical(2,0.8,0.5,5);
            verify.elementIsPresent(keyLblPrivilegesExclusiveIndicatorVirtual);
            verify.elementIsPresent(keyLblPrivilegesExclusiveIndicatorPhysical);
            verify.elementIsPresent(keyLblPrivilegesSaleAlertDetails);
            verify.elementIsPresent(keyLblPrivilegesSaleAlertIndicatorVirtual);
            verify.elementIsPresent(keyLblPrivilegesSaleAlertIndicatorPhysical);
            verify.elementIsPresent(keyLblAboutBottonIndicator);


        }

    }

    public void clickBackBtn() throws ApplicationException {
        click.elementBy(keyBtnClose);
        WAIT.forSeconds(2);
    }


}


