@Login
Feature: Login page feature

@Smoke
Scenario: Login page title
Given user is on login page
When user gets the title of the login page
Then page title should be "Guru99 Bank Home Page"

@Smoke
Scenario: Forgot Password link
Given user is on login page
Then reset link should be displayed

@Regression 															
Scenario: Login with correct credentials
Given user is on login page
When user enters username "mngr502613"
When user enters password "UsymUsa"
And user clicks on Login button
Then user gets the title of the login page "Guru99 Bank Home Page"