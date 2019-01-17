


# ===============================================================================================================================
# Author: Balabharathi Jayaraman
# Functionality : As a tester, I want to complete a funds transfer transaction so that I can pass on funds to another cardholder.
# ===============================================================================================================================

@FundTransferphysical @RegressionPack
Feature: Fund Transfer from Peso+ card to another card

  Background: Open Getgo mobile application
  	Given I'm on Getgo landing page

@running
  Scenario Outline: As a tester, I want to complete a funds transfer transaction from my Peso card account so that I can pass on funds to another cardholder - Add recipient from saved list
    Given I'm login into my "<accountType>" account with my "<username>" and "<password>"
    Given I'm on Getgo Fund transfer page of my "<accountType>" card account
    When  I Enter card number, recipient name, amount, system date, frequency, and message - Add recipient from saved list by clicking on add button
    And   I review transfer instruction and click submit
    Then  I should see the confirmation page

  Examples:
    | accountType | username      | password      |
    | Peso        | Peso_Username | Peso_Password |

@failedrun1
  Scenario Outline: As a tester, I want to complete a funds transfer transaction from my Peso card account so that I can pass on funds to another cardholder
    Given I'm login into my "<accountType>" account with my "<username>" and "<password>"
    Given I'm on Getgo Fund transfer page of my "<accountType>" card account
    When  I Enter card number, recipient name, amount, system date, frequency, and message
    And   I review transfer instruction and click submit
    Then  I should see the confirmation page

  Examples:
    | accountType | username      | password      |
    | Peso        | Peso_Username | Peso_Password |


  Scenario Outline: As a tester, I want to complete a scheduled funds transfer transaction from my Peso card account so that I can pass on funds to another cardholder
    Given I'm login into my "<accountType>" account with my "<username>" and "<password>"
    Given I'm on Getgo Fund transfer page of my "<accountType>" card account
    When  I Enter card number, recipient name, amount, system date, "<frequency>" and message
    And   I review transfer instruction with scheduled details and click submit
    Then  I should see the confirmation page with scheduled fund transfer details

    Examples:
      | accountType | username      | password      |frequency      |
      | Peso        | Peso_Username | Peso_Password |Weekly         |
      | Peso        | Peso_Username | Peso_Password |Annually       |

@runtesting
  Scenario Outline: As a tester, I want to complete a scheduled funds transfer transaction with future date from my Peso card account so that I can pass on funds to another cardholder
    Given I'm login into my "<accountType>" account with my "<username>" and "<password>"
    Given I'm on Getgo Fund transfer page of my "<accountType>" card account
    When  I Enter card number, recipient name, amount, future date, "<frequency>" and message
    And   I review transfer instruction with scheduled details and click submit
    Then  I should see the confirmation page with scheduled fund transfer details

    Examples:
      | accountType | username      | password      |frequency      |
      | Peso        | Peso_Username | Peso_Password |Quarterly      |


  Scenario Outline: As a tester, I want to complete a funds transfer transaction from my Peso card account so that I can pass on funds to another cardholder and validating the completed transaction in activity page - Fund Transfer Page
    Given I'm login into my "<accountType>" account with my "<username>" and "<password>"
    Given I'm on Getgo Fund transfer page of my "<accountType>" card account
    When  I Enter card number, recipient name, amount, system date, frequency, and message
    And   I review transfer instruction and click submit
    Then  I should see the confirmation page and validate it in the Activity page

    Examples:
      | accountType | username      | password      |
      | Peso        | Peso_Username | Peso_Password |


  Scenario Outline: As a tester, I want to complete a funds transfer transaction from my Peso card account so that I can pass on funds to another cardholder and validating the completed transaction in activity page - From Dashboard page
    Given I'm login into my "<accountType>" account with my "<username>" and "<password>"
    Given I'm on Getgo Fund transfer page of my "<accountType>" card account
    When  I Enter card number, recipient name, amount, system date, frequency, and message
    And   I review transfer instruction and click submit
    Then  I should see the confirmation page and validate it in the Activity page through Dashboard

    Examples:
      | accountType | username      | password      |
      | Peso        | Peso_Username | Peso_Password |


  Scenario Outline: Validation of Edit button in the Send Money Review page
    Given I'm login into my "<accountType>" account with my "<username>" and "<password>"
    Given I'm on Getgo Fund transfer page of my "<accountType>" card account
    When  I Enter card number, recipient name, amount, system date, frequency, and message
    And   I review transfer instruction and click Edit button
    And   I edit the transaction amount, message & click Next button
    And   I review transfer instruction with updated information and click submit
    Then  I should see the confirmation page with updated details and validate it in the Activity page

    Examples:
      | accountType | username      | password      |
      | Peso        | Peso_Username | Peso_Password |


  Scenario Outline: Validation of Send Money flow OTP page
    Given I'm login into my "<accountType>" account with my "<username>" and "<password>"
    Given I'm on Getgo Fund transfer page of my "<accountType>" card account
    When  I Enter card number, recipient name, amount, system date, frequency, and message - Add recipient from saved list by clicking on add button
    And   I review transfer instruction with the provided details and click submit
    Then  I should see OTP page

    Examples:
      | accountType | username      | password      |
      | Peso        | Peso_Username | Peso_Password |


  Scenario Outline: Validation of Send Money flow with invalid OTP details
    Given I'm login into my "<accountType>" account with my "<username>" and "<password>"
    Given I'm on Getgo Fund transfer page of my "<accountType>" card account
    When  I Enter card number, recipient name, amount, system date, frequency, and message - Add recipient from saved list by clicking on add button
    And   I review transfer instruction with the provided details and submit with invalid OTP
    Then  I should see an error message pop up with content "Something went wrong. Please try again later. Ref: OTP002"

    Examples:
      | accountType | username      | password      |
      | Peso        | Peso_Username | Peso_Password |


  Scenario Outline: Validation of Send Money Review page
    Given I'm login into my "<accountType>" account with my "<username>" and "<password>"
    Given I'm on Getgo Fund transfer page of my "<accountType>" card account
    When  I Enter card number, recipient name, amount, system date, frequency, and message - Add recipient from saved list by clicking on add button
    Then  I  should see the review transfer page with fund transfer details

    Examples:
      | accountType | username      | password      |
      | Peso        | Peso_Username | Peso_Password |


  Scenario Outline: Validation of Send Money Review page -  Scheduled Transfer
    Given I'm login into my "<accountType>" account with my "<username>" and "<password>"
    Given I'm on Getgo Fund transfer page of my "<accountType>" card account
      When  I Enter card number, recipient name, amount, system date, "<frequency>" and message
    Then  I  should see the review transfer page with Scheduled fund transfer details

    Examples:
      | accountType | username      | password      |frequency      |
      | Peso        | Peso_Username | Peso_Password |Weekly         |


