Feature: User logs in

  Background:
    Given User has an account


  Scenario: User can log in using mail and password
    Given User is on Login page
    When he enters correct mail and password
    Then he is logged in

  Scenario: User can create a project
    Given User is on Main page
    When he creates a new project
    Then the project is created