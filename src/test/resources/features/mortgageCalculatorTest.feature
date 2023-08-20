Feature: Mortgage Calculator Test

  Scenario: Buying a townhouse
    Given I go to mortgag calculator website
    When I enter mortgage amount "400000"
    And I enter interest rate "7"
    And I enter amortization year "29" and month "11"
    And I select start year "2024" and month "10"
    And I enter interest term year "30" and month "6"
    And I select payment period "Semi-Monthly"
    And I select interest type "Fixed"
    And I click clculate button
    Then I verify monthly payment results "$2663.31"
    Then I closed the chrome browser