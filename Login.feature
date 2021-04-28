
Feature: Login 

  Scenario: Login is successful
  	Given I visit /login endpoint
    When I enter userid 101 and password "password"
    Then I should get "Logged in successfully"

  Scenario: Login is unsuccessful because incorrect password
  	Given I visit /login endpoint
    When I enter userid 101 and password "abcxyz"
    Then I should get "ERROR: Incorrect Password"
    
   Scenario: Login is unsuccessful because user not found
  	Given I visit /login endpoint
    When I enter userid 121 and password "password"
    Then I should get "ERROR: Not found user with Bank id 121"

