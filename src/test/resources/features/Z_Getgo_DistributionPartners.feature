# ========================================================================================================================================
# Author: Gopinath Rajaram
# Functionality : As a tester, I want see Distribution partner page on choosing Find Where to Distribution option from the Left Hand Menu
# ========================================================================================================================================

@DistributionPartners @RegressionPack
Feature: DistributionPartners

  Background: Login into account
    Given I'm on Getgo landing page

  Scenario Outline: As a tester, I want see Distribution Partners page on choosing Find Distribution Partners option from the Left Hand Menu
    Given I'm on "Dashboard" page of GetGo pay with valid "<username>" and "<password>"
    When  I choose Find Distribution Partners option from the menu
    Then  I should see "Find Distribution Partners" page with "Search distribution partners" textbox and list of partners

  Examples:
    | username      | password      |
    | Peso_Username | Peso_Password |
    | Virtual_Username | Virtual_Password |

@testnoedemo
  Scenario Outline: As a tester, I want see Distribution Partners page on choosing Find Distribution Partners option from the Left Hand Menu
    Given I'm on "Dashboard" page of GetGo pay with valid "<username>" and "<password>"
    When  I choose Find Distribution Partners option from the menu
    Then  I should see "Find Distribution Partners" page and able to search the partners with their location
  Examples:
   | username      | password      |
   | Peso_Username | Peso_Password |
   | Virtual_Username | Virtual_Password |
