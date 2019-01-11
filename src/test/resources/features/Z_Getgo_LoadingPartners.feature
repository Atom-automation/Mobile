# ========================================================================================================================================
# Author: Gopinath Rajaram
# Functionality : As a tester, I want see Loading partner page on choosing Find Where to Load option from the Left Hand Menu
# ========================================================================================================================================

@LoadingPartners @RegressionPack
Feature: LoadingPartners

  Background: Login into account
    Given I'm on Getgo landing page

  Scenario: As a tester, I want see Loading Partners page on choosing Find Where to Load option from the Left Hand Menu
    Given I'm on "Dashboard" page of GetGo pay with valid "Peso_Username" and "Peso_Password"
    When  I choose Find Where to Load option from the menu
    Then  I should see "Find Where to Load" page with "Search load partners" textbox and list of partners

  @dummy1223
  Scenario: As a tester, I want see Loading Partners page on choosing Find Where to Load option from the Left Hand Menu
    Given I'm on "Dashboard" page of GetGo pay with valid "Peso_Username" and "Peso_Password"
    When  I choose Find Where to Load option from the menu
    Then  I should see "Find Where to Load" page and able to search the partners with their location

