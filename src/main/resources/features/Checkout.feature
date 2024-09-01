Feature: Checkout

  Scenario: Successfully complete checkout
    Given I have 2 products in the cart
    And I am on the checkout page
    When I enter my first name, last name, and postal code
    And I click the continue button
    And I click the finish button
    Then I should see the confirmation message "Thank you for your order!"

  Scenario: Unsuccessful checkout due to missing postal code
    Given I have 2 products in the cart
    And I am on the checkout page
    When I enter my first name and last name but leave the postal code blank
    And I click the continue button
    Then I should see an error message indicating that the postal code is required