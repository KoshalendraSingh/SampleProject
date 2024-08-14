Feature: User Sign Up

  Scenario: Successful Sign Up
    Given the user is on the Create Account page
    When the user enters "John" in the "first name" field
    And the user enters "Doe" in the "last name" field
    And the user enters "john.doe@example.com" in the "email" field
    And the user enters "Password123!" in the "password" field
    And the user enters "Password123!" in the "confirm password" field
    And the user scrolls to the Create an Account button
    And the user clicks the Create an Account button
    Then the user account should be created successfully

  Scenario: Unsuccessful Sign Up with already registered email
    Given the user is on the Create Account page
    When the user enters "Jane" in the "first name" field
    And the user enters "Doe" in the "last name" field
    And the user enters "john.doe@example.com" in the "email" field
    And the user enters "Password123!" in the "password" field
    And the user enters "Password123!" in the "confirm password" field
    And the user scrolls to the Create an Account button
    And the user clicks the Create an Account button
    Then the user should see an error message for the already registered email

  Scenario: Unsuccessful Sign Up with mismatched passwords
    Given the user is on the Create Account page
    When the user enters "John" in the "first name" field
    And the user enters "Doe" in the "last name" field
    And the user enters "john.doe@example.com" in the "email" field
    And the user enters "Password123!" in the "password" field
    And the user enters "Password456!" in the "confirm password" field
    And the user scrolls to the Create an Account button
    And the user clicks the Create an Account button
    Then the user should see an error message for mismatched passwords

  Scenario: Unsuccessful Sign Up with missing mandatory fields
    Given the user is on the Create Account page
    When the user leaves the "first name" field empty
    And the user leaves the "last name" field empty
    And the user enters "john.doe@example.com" in the "email" field
    And the user enters "Password123!" in the "password" field
    And the user enters "Password123!" in the "confirm password" field
    And the user scrolls to the Create an Account button
    And the user clicks the Create an Account button
    Then the user should see error messages for the missing mandatory fields