
# Author: Balabharathi Jayaraman
# Jira : GGP-520
# Jira URL : https://tms-jira.unionbankph.com/browse/GGP-520
# Functionality : As a tester, I want to complete a funds transfer transaction so that I can pass on funds to another cardholder.
# Sub-tasks : GGP-555 - Automation Script Preparation [Android]
# Sub-tasks : GGP-549 - Automation Script Preparation [IOS]

@FundTransfer @Peso+ @dryRun
Feature: Manage Recipients Feature

  Background: Open Getgo mobile application
  	Given I'm on Getgo landing page
    And   I'm on Getgo login page
    When  I enter a "Peso_Username" & click next
    And   I enter password "Peso_Password"
    And   I click login

  Scenario: As a tester, I want to add new recipients and tag some of them as favorites so that I can keep a list of recipients (From Card transfer page)
    Given I'm on Getgo Fund transfer page
    When  I Choose Manage Recipients option
    And   Add a recipient and tag it as a favorite
    When  I Choose Manage Recipients option again
    Then  Recipient should be displayed in my favourites

  Scenario: As a tester, I want to add new recipients and tag some of them as favorites so that I can keep a list of recipients (From Beneficiaries page)
    Given I'm on Beneficiaries page
    When  I add a recipient and tag it as a favorite
    When  I open Beneficiaries page again
    Then  Recipient should be displayed in my favourites