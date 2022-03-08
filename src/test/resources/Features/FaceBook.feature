Feature: Verify Facebook login functionality

Scenario: Verify login functionality for valid username and invalid password

Given User is on Facebook login page
When  user enters valid username and password
   |user name      | password  |
   |user1          | test123   |
   |user2          | test456   |
   |user3          | test789   |
   |user4          | test567   |
And user clicks the login button
Then  Error is displayed


