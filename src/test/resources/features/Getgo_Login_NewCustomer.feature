# Author: Balabharathi Jayaraman
# Jira : GGP-515 & GGP-516
# Jira URL : https://tms-jira.unionbankph.com/browse/GGP-515 & https://tms-jira.unionbankph.com/browse/GGP-516
# Functionality : As a tester, I want to be able to login using my credentials so that I can see my card details.
# Sub-tasks : GGP-547 - Automation Script Preparation [Android]
# Sub-tasks : GGP-549 - Automation Script Preparation [IOS]

@Login
Feature: New Customer Login Feature

  Background: Open Getgo mobile application
    Given I'm on Getgo landing page

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