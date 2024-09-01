Feature: Login functionality

  Scenario: Successful login
    Given I am on the login page
    When I enter valid username and password
    And I click the login button
    Then I should be redirected to the main page

  Scenario: Unsuccessful login with invalid username
    Given I am on the login page
    When I enter invalid username and valid password
    And I click the login button
    Then I should see an error message

  Scenario: Unsuccessful login with invalid password
    Given I am on the login page
    When I enter valid username and invalid password
    And I click the login button
    Then I should see an error message

  Scenario: Unsuccessful login with invalid username and password
    Given I am on the login page
    When I enter invalid username and password
    And I click the login button
    Then I should see an error message