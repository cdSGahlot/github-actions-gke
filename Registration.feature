
Feature: Registration

  Scenario: Registration is successful
  	Given I visit /register endpoint
    When I enter userdetails
    Then I get "Successfully registered"
    
   Scenario: Registration is unsuccessful
  	Given I visit /register endpoint
    When I enter userdetails with existing PAN "BYAKY6650L"
    Then I get "ERROR: user with entered PAN BYAKY6650L already exists"

   Scenario: Registration is unsuccessful
  	Given I visit /register endpoint
    When I enter userdetails with existing Bank Id 551
    Then I get "ERROR: user with Bank id 551 already exists"
