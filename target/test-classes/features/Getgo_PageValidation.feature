# Author: Balabharathi Jayaraman
# Functionality : Validate the fields & texts displayed on the Getgo application screens

@PageValidation
Feature: Page Validation

  Background: Open Getgo mobile application
    Given I'm on Getgo landing page

  #=======================================================================================================================
  #                                               Welcome & SignUp Screen
  #=======================================================================================================================

  Scenario: Validate the fields & texts displayed on the Getgo Welcome & SignUp page
    Then  I should see two buttons "LOG IN" "SIGN UP", Getgo logo, a caption "Now made easier. As simple as Ready, GetGo."
    When  I'm on Getgo SignUp page
    Then  I should see two button "Yes" "No", Getgo card image, two messages "Do you have a GetGo Peso Plus Card?" & "Start shopping online by creating your GetGo Virtual Prepaid Card. Or register your Peso + Prepaid Card now."

  #=======================================================================================================================
  #                                               Login Screen
  #=======================================================================================================================

  @Android
  Scenario: Validate the fields & texts displayed on the Getgo Login page
    Given I'm on Getgo login page
    Then  I should see back arrow, page title as "Login", a caption "Enter your registered email address", a text box with inner text "Email address", a link "Forgot your password?", a "NEXT" button & a sign up link "Don’t have an account? SIGN UP NOW!"
    When  I enter a "Peso_Username" & click next
    Then  I should see back arrow, page title as "Login", a caption "Enter your password", a text box with inner text "Password", a link "Having problems with your account?", a "LOGIN" button & a password visibility toggle button

  @IOS
  Scenario: Validate the fields & texts displayed on the Getgo Login page
    Given I'm on Getgo login page
    Then  I should see back arrow, page title as "Login", a caption "Now made easier. As simple as Ready, GetGo.", a text box with inner text "Email", a link "Having problems with your account?", a "NEXT" button & a sign up link "Don’t have an account? SIGN UP NOW!"
    When  I enter a "Peso_Username" & click next
    Then  I should see back arrow, page title as "Login", a caption "Enter your password", a text box with inner text "Password", a link "Having problems with your account?", a "LOGIN" button & a password visibility toggle button