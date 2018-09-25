
# ========================================================================================================================================
# Author: Gopinath Rajaram
# Functionality : As a tester, I want to be see the Contact Us page of the GetoPay app so that i am able to see Contact Us details
# ========================================================================================================================================

@ContactUs
Feature: Contact Us

  Background: Login into account
    Given I'm on Getgo landing page

  Scenario: As a tester, I want to be see the Contact Us page of the GetoPay app so that i am able to see Contact Us details
    Given I'm login into my "Peso" account with my "Peso_Username" and "Peso_Password"
    When I choose More menu options from the GetGopay dashboard page
    Then More page should be displayed with the options "About the Cards", "Contact Us","Frequently Asked Questions" & "Terms & Conditions"
    When I click on "Contact Us" option
    Then Contact Us page should be displayed with contact us information details




