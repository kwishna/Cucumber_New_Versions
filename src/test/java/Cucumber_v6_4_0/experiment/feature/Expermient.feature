Feature: Experiment Feature

@first
Scenario: First Scenario
Given he is my first scenario
    | name    | roll | class |
    | Krishna |  1   | aa    |
    | Kumar   |  2   | bb    |


@first
Scenario: Second Scenario
When she is my second scenario

@first
Scenario Outline: This Is The Third Scenario.
    Given My Name Is '<rowNum>' And Email Is email
            |email|
            |gfhgf1@dfdg.cpm |
            |gfhgf2@dfdg.cpm |
            |gfhgf3@dfdg.cpm |


Examples:
     |rowNum|
     |  1   |
     |  2   |
     |  3   |