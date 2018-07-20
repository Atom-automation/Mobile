
# ========================================================================================================================================
# Author: Balabharathi Jayaraman
# Functionality : As a tester, I want to be able to complete a currency conversion transaction so that I can transact in another currency.
# ========================================================================================================================================

@CurrencyConversion
Feature: Currency Conversion

  Background: Login into account
    Given I'm on Getgo landing page
    And   I'm on Getgo login page
    When  I enter a "Peso_Username" & click next
    And   I enter password "Peso_Password"
    And   I click login

  Scenario Outline: As a tester, I want to be able to complete a currency conversion transaction so that I can transact in another currency.
    Given I'm on Currency conversion screen after noting down the balance of "<to>" currency
    When  I choose "<from>" currency and "<to>" currency
    And   I enter the conversion amount "<conversion_amount>"
    Then  Conversion amount will be automatically populated under To Amount field
    When  I review conversion details and submit
    Then  Amount should be converted & displayed in the dashboard

    Examples:
      | from  | to    | conversion_amount |
      | PHP   | AUD   | 10                |
      | PHP   | CAD   | 10                |

