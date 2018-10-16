

# ================================================================================================================
# Author: Balabharathi Jayaraman
# Functionality : As a tester, I want to be able to login using my credentials so that I can see my card details.
# ================================================================================================================

@Login @RegressionPack1
Feature: New Customer Login Feature

  Background: Open Getgo mobile application
    Given I'm on Getgo landing page

    @Logintest
  Scenario Outline: As a tester, I want to be able to login using my credentials so that I can see my account(Virtual Card or Peso+) details
    Given I'm on Getgo login page
    When  I enter a "<username>" & click next
    And   I enter password "<password>"
    And   I click login
    Then  I should see my "<accountType>" account dashboard with my profile picture & my full name

    Examples: 
      | username         | password         | accountType |
      | Virtual_Username | Virtual_Password | Virtual     |
      | Peso_Username    | Peso_Password    | Peso        |


  Scenario: Invalid login (Invalid Email)
    Given I'm on Getgo login page
    When  I enter a "Invalid_Email" & click next
    Then System should through an invalid email error message

  Scenario: Invalid login (Invalid Password)
    Given I'm on Getgo login page with "Valid_Email"
    When  I enter a "Invalid_Password" and click next  
    Then System should through an invalid password message

  @blank
  Scenario: Invalid login (Blank spaces in Email)
    Given I'm on Getgo login page
    When  I enter a blank spaces in email field
    Then System should through an email error message as "Invalid email format"

  @blank
  Scenario: Invalid login (Blank spaces in password)
    Given I'm on Getgo login page with "Valid_Email"
    When  I enter a blank spaces in password field and click next
    Then System should through an invalid password message

  @numerical
  Scenario: Invalid login (Numerical values in Email)
    Given I'm on Getgo login page
    When  I enter a numerical values in email field
    Then System should through an email error message as "Invalid email format"
    