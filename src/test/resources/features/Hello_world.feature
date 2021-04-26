Feature: Hello world

  Scenario: First scenario

    When I'm Jakub!
    Then Hello World!

  Scenario: Variables

    Given I can have a "string value"
    Given I can have a "another string value"
    And I can have and 3 number
    And I know the pi value 3.14
    But any word can be a value
    But any word cannot be a number

    When simple string list
      | value 1 |
      | value 2 |
      | value 3 |

    When another table
      | header 1    | header 2    | header 3    |
      | value 1 - 1 | value 2 -1  | value 3 - 1 |
      | value 1 - 2 | value 2 - 2 | value 3 - 2 |

    And one more table
      | header 1 | val 1 - 1 | val 1 - 2 |
      | header 2 | val 2 - 1 | val 2 - 2 |
      | header 3 | val 3 - 1 | val 3 - 2 |

    And simple table
      | v 1 - 1 | v 1 - 2 |
      | v 2 - 1 | v 2 - 2 |

    Then magic multiline string
      """
      this is sample
      multi line string
      with some meaning
      """