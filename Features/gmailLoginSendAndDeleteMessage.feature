Feature: Send message

  Scenario: Successful Login and Write a letter
    Given User is on Home Page
    When User enters email and password
    And User sent a letter
    And User open the sent letter
    Then User successfully open the same letter