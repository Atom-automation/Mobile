
# ========================================================================================================================================
# Author: Gopinath Rajaram
# Functionality : As a tester, I want to be see the About The Cards page of the GetoPay app so that i am able to see details about the cards
# ========================================================================================================================================

@AboutTheCards @RegressionPack
Feature: About The Cards

  Background: Login into account
    Given I'm on Getgo landing page

  Scenario: As a tester, I want to be see the About The Cards page of the GetoPay app so that i am able to see details about the cards
    Given I'm login into my "Peso" account with my "Peso_Username" and "Peso_Password"
    When I choose More menu options from the GetGopay dashboard page
    Then More page should be displayed with the options "About the Cards", "Contact Us","Frequently Asked Questions" & "Terms & Conditions"
    When I click on "About the Cards" option
    Then About the Cards page should be displayed with details about the cards




