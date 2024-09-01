Feature: Add 2 products to cart

  Scenario: Successfully add 2 products to cart
    Given I am logged in as a standard user
    When I add the first product to the cart
    And I add the second product to the cart
    Then the cart should display "2" items
    And the cart should contain the first product
    And the cart should contain the second product