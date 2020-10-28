Feature: This is a feature file

  Scenario: Calculating with arithmetic operations
    Given I use the calculator
    #  2 + 3 = 5
    When I enter "2" into the calculator
    And I add "3"
    Then the calculated result is "5"
    #  10 - 2 = 8
    When I enter "10" into the calculator
    And I subtract "2"
    Then the calculated result is "8"
    #  (10 - 2) * 2 != 20
    Given I enter "(" into the calculator
    And  I enter "10" into the calculator
    And I subtract "2"
    And I enter ")" into the calculator
    And I multiply by "2" factorial
    Then the calculated result is "20"
    #  sin(30) = 0.5
    When I enter "30" into the calculator
    And  I enter "sin" into the calculator
    Then the calculated result is "0.5"
    And There are 4 formulas in the calculator history