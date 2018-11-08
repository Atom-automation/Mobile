# ========================================================================================================================================
# Author: Gopinath Rajaram
# Functionality : As a tester, I want see Manage My settings page on choosing Settings option from the Left Hand Menu
# ========================================================================================================================================

@Settings @RegressionPack2
Feature: Manage My Settings

  Background: Login into account
    Given I'm on Getgo landing page

  Scenario: As a tester, I want see Manage My settings page on choosing Settings option from the Left Hand Menu
    Given I'm on "Dashboard" page of GetGo pay with valid "edit_username" and "edit_password"
    When  I choose Settings option from the menu
    Then  I should see "Manage My Settings" page with Options Profile,Notifications,Password,Manage one Time password and Login using Fingerprint


