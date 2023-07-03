Feature: Manager Page Features

Background: 
	Given User has already logged into an Application
	|username|password|
	|mngr502613|UsymUsa|
	
Scenario: Manager Page Title
	Given User is on Manager Page
	When User gets the title of the page
	Then Page title should be "Guru99 Bank Home Page"

Scenario: Manager Section Counts
Given User is on Manager Page
When User gets the title of the page
Then Then Page title should be "Guru99 Bank Home Page"
|Manager|
|New Customer|
|Edit Customer|
|Delete Customer|
|New Account|
|Edit Account|
|Delete Account|
|Deposit|
|Withdrawal|
|Fund Transfer|
|Change Password|
|Balance Enquiry|
|Mini Statement|
|Customised Statement|
|Log out|
And Manager Section Counts is 15