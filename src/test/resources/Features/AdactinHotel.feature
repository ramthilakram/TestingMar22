
Feature: Verify AdactinHotel login functionality

Scenario Outline: Verify login functionality for valid user name, password & book the hotel

Given User is on AdactinHotel login page and get the order number

When user enters "<user name>" and "<password>"

And user clicks the login button, book the hotel and get the order number

Then Error is displayed

Examples:
|user name|password|location|Hotels|Room Type|Number of Rooms|Check In Date|Check In Date|Adults per Room|Children per Room|
|Ramkumar22|F5V089|Sydney|Hotel Sunshine|Double|2 - Two|02/03/2022|04/03/2022|1 - One|1 - One|




