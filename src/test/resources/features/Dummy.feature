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

"""@run21
  Scenario: As a tester, I want to see an error message when i enter invalid data in the update mobile number text box of update profile page
    Given I'm on "Dashboard" page of GetGo pay with valid "edit_username" and "edit_password"
    When  I choose Settings option from the menu
    Then  I should see "Manage My Settings" page
    When  I choose "Profile" option from settings page
    Then  I should see "Manage Profile" page with "PERSONAL DETAILS" , "ADDRESS" and "OTHER DETAILS" sections
    When  I click on edit link in the "Mobile Number" section
    Then  "Update Mobile Number" page should be displayed with a edit mobile textbox, "SAVE" and "NEXT" button
    When  I enter invalid data in the  mobile number field
    And   click next button
    Then An error message should be displayed
    """