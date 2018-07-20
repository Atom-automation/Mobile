# Author: Balabharathi Jayaraman
# Jira : GGP-520
# Jira URL : https://tms-jira.unionbankph.com/browse/GGP-520
# Functionality : As a tester, I want to complete a funds transfer transaction so that I can pass on funds to another cardholder.
# Sub-tasks : GGP-555 - Automation Script Preparation [Android]
# Sub-tasks : GGP-549 - Automation Script Preparation [IOS]

@FundTransfer @Virtual
Feature: Card transfer Feature Using Virtual Account

  Background: Open Getgo mobile application
  	Given I'm on Getgo landing page
    And   I'm on Getgo login page
    When  I enter a "Virtual_Username" & click next
    And   I enter password "Virtual_Password"
    And   I click login

  Scenario: As a tester, I want to complete a funds transfer transaction from my virtual card account so that I can pass on funds to another cardholder (Add recipient from saved list).
    Given I'm on Getgo Fund transfer page of my "Virtual" card account
    When  I Enter card number, recipient name, amount, system date, frequency, and message - Add recipient from saved list by clicking on add button
    And   I review transfer instruction and click submit
    Then  I should see the confirmation page

  Scenario: As a tester, I want to complete a funds transfer transaction from my virtual card account so that I can pass on funds to another cardholder.
    Given I'm on Getgo Fund transfer page of my "Virtual" card account
    When  I Enter card number, recipient name, amount, system date, frequency, and message
    And   I review transfer instruction and click submit
    Then  I should see the confirmation page