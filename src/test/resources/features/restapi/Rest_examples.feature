Feature: Rest examples

  Scenario: User creates project using rest

    Given User has a token
    When User creates new project using rest
    Then project is created by rest


  Scenario: User can add task to the project

    Given User has a token
    And User has a project created using rest

    When he adds a task to the project using rest
    Then task is created by rest


#