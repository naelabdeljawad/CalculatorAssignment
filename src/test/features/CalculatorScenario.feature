Feature: This is a feature file

  Background:
    Given I use the calculator

  Scenario: Calculating with arithmetic operations
    #  2 + 3 = 5
    When I enter "2+3" into the calculator
    And I click on calculate button
    Then the calculated result is "5"
    #  10 - 2 = 8
    When I enter "10-2" into the calculator
    And I click on calculate button
    Then the calculated result is "8"
    #  (10 - 2) * 2 != 16
    Given I enter "(10-2)*2!" into the calculator
    And I click on calculate button
    Then the calculated result is "16"
    #  sin(30) = 0.5
    When I enter "sin(30)" into the calculator
    And I click on calculate button
    Then the calculated result is "0.5"
    And There are 4 formulas in the calculator history
    Given I close the calculator