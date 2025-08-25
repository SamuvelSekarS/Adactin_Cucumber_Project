Feature: Adactin Automation

@smoke
Scenario: Login Functionality
	Given User launch the browser and URL
	When User enter the username as "shyamblaze"     
	And User enter the password as "I4Q104"
	And User click on the submit button
  Then User verifies the new page contains expected URL "https://adactinhotelapp.com/SearchHotel.php"
  And User verifies new page contains expected text
  And User verifies Logout button is displayed on the page
 
 @Regression 
Scenario: Search page functionality
	When  User select the location
	And  User select the hotel
	And User select the room type
	And User select the number of rooms
	And User enter the check in date
	And User enter the check out date
	And User select the adult count
	And User select the children count
	And User click on the search button
	 
Scenario: Select Hotel Functionality
	When User click the hotel information
	And  User click on the continue button
	
Scenario: Booking Hotel Functionality
	When User enter the first name
	And User enter the last name
	And User enter the billing address
	And User enter the credit card number
	And User select the credit card type
	And User select the expiry date
	And User enter CVV number
	And  User click on the book now button
	
Scenario: Booking confirmation Functionality
	When User click on my Itinerary button
	
Scenario: Booked itinerary Functionality
	When User click on my Itinerary button
	And User enter the order Id and click on go button
	And User click the logout button
	And User terminates the browser
	
	
	
	
	
	
	


