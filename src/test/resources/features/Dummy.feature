# ========================================================================================================================================
# Author: Gopinath Rajaram
# Functionality : As a tester, I want to be able to change my personal profile so that my details are updated.
# ========================================================================================================================================

@drydummy
Feature: Edit Profile

  Background: Login into account
    Given I'm on Getgo landing page

  Scenario: As a tester, I want to be able to change my personal profile so that my details are updated - Edit Mobile number
   # Given I'm on "Dashboard" page of GetGo pay with valid "edit_username" and "edit_password"
    When  I choose Loading partners option from the menu
    Then  click on the losf psrtners list

