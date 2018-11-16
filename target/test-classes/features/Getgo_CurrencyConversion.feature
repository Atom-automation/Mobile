
# ========================================================================================================================================
# Author: Balabharathi Jayaraman
# Functionality : As a tester, I want to be able to complete a currency conversion transaction so that I can transact in another currency.
# ========================================================================================================================================

@CurrencyConversion @RegressionPack2 @RegressionPack
Feature: Currency Conversion

  Background: Login into account
    Given I'm on Getgo landing page

  Scenario Outline: As a tester, I want to be able to complete a currency conversion transaction so that I can transact in another currency.
    Given I'm login into my "Peso" account with my "Peso_Username" and "Peso_Password"
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

  Scenario: As a tester, I want to see currency conersion page when i choose conver currency menu option
    Given I'm login into my "Peso" account with my "Peso_Username" and "Peso_Password"
    When I choose "Convert to Other Currencies" option from Left Hand Menu
    Then "Convert to Other Currencies" page should be displayed with currency conversion details

  Scenario: As a tester, I want to see review page of currency conersion page when i enter valid Currency conversion details
    Given I'm login into my "Peso" account with my "Peso_Username" and "Peso_Password"
    When I choose "Convert to Other Currencies" option from Left Hand Menu
    Then "Convert to Other Currencies" page should be displayed with currency conversion details
    When  I choose "PHP" currency and "SGD" currency
    And   I enter the conversion amount "66.45" and click Next
    Then "Review and Convert" currency conversion page should be displayed

  Scenario: As a tester, I want to see OTP page After entering valid Currency conversion details
    Given I'm login into my "Peso" account with my "Peso_Username" and "Peso_Password"
    Given I'm on Currency conversion screen after noting down the balance of "USD" currency
    When  I choose "PHP" currency and "USD" currency
    And   I enter the conversion amount "21.34"
    Then  Conversion amount will be automatically populated under To Amount field
    When  I review conversion details and click submit
    Then Enter OTP Page should be displayed

  Scenario: As a tester, I want to see an error message in OTP page After entering invalid OTP for the Currency conversion details
    Given I'm login into my "Peso" account with my "Peso_Username" and "Peso_Password"
    Given I'm on Currency conversion screen after noting down the balance of "USD" currency
    When  I choose "PHP" currency and "USD" currency
    And   I enter the conversion amount "22.32"
    Then  Conversion amount will be automatically populated under To Amount field
    When  I review conversion details and click submit
    Then Enter OTP Page should be displayed
    When I enter Invalid OTP
    Then An error message should be displayed


  Scenario: As a Virtual User, I will no see the currency conversion menu option in Left Hand Side
    Given I'm login into my "virtual" account with my "Virtual_Username" and "Virtual_Password"
    When I Click on Menu option in the Dashboard page
    Then I should not see the "Convert to Other Currencies" Menu option

@iosfailed @failured
  Scenario: As a tester, I want to complete a currency conversion transaction so that I can transact in another currency
    Given I'm login into my "Peso" account with my "Peso_Username" and "Peso_Password"
    Given I'm on Currency conversion screen after noting down the balance of "USD" currency
    When  I choose "PHP" currency and "USD" currency
    And   I enter the conversion amount "39.34"
    Then  Conversion amount will be automatically populated under To Amount field
    When  I review conversion details and submit
    Then  Amount should be converted sucessfully
    And Verify the above transaction in the Transaction Activity page