Feature: saucedemo homework
  As a user I want to be able login and make an success purchase of any product

  Scenario: Success Purchase
    Given I have navigate to login page
    When I login with 'standard_user' and 'secret_sauce'
    Then I am successfully logged in
    When I put into cart a Sauce Labs Onesie
    Then I go to shopping cart
    And I check that 'Sauce Labs Onesie' is successfully added
    Then I press the Checkout button
    When I fill fields with 'Laura', 'Valtere' and 'LV1084'
    Then I press the Continue button
    And I check that the added items are successfully added
    When I press the Finish button
    Then I check that 'CHECKOUT: COMPLETE!' successfully
    And I press the Back Home button


Scenario: The examination of Checkout Page
  Given I have navigate to login page
  When I login with 'standard_user' and 'secret_sauce'
  Then I am successfully logged in
  Then I go to shopping cart
  Then I press the Checkout button
  When I do not fill any of the field and I press the Continue button
  Then I see the error message 'Error: First Name is required'
  When I fill in the First Name field with 'Laura'
  Then I press the Continue button
  Then I see the error message 'Error: Last Name is required'
  When I fill in the Last Name field with 'Valtere'
  Then I press the Continue button
  Then I see the error message 'Error: Postal Code is required'