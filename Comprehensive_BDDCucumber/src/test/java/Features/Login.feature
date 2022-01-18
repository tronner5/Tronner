#Author: jacksparrow5297@gmail.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Login into Application 


Scenario Outline: Sign with false details
Given Initialize the browser with chrome
And Navigate to Site from excel File
And Click on SignIn Icon and Sign In popUp Comes
When User enters wrong <user name> and <password> and try to Signs in
Then Verify the error message is printing
And Close browsers

Examples:
|user name			|password	|
|test99@gmail.com   |123456		|
|test1234@gmail.com |123456		|




Scenario: OutStation car booking TestCase
Given Initialize the browser 
Then Read the Site From excel and navigate
When Select the Round Trip checkBox
Then User enters From City <fromCity> 
Then User enters To City Details <toCity> 
Then User select the time for travel and click to summit button
And Display the title of the selected car and select the summit button
And Close browserss

Examples:
|fromCity		    |toCity	    |
|Delhi              |Mumbai		|




Scenario: LocalCarBooking car booking TestCase 
Given Initialize the browser and navigate to site
When Select the Local box
Then User enters City <City> and User selects the date
Then user select the time of travel and summit the details
Then Change the hr and km details and Check the car Name
And Navigate to next page and checks the title 
And Close all browsers

Examples:
|City		    |
|Ahm            |




Scenario: Airport car booking TestCase
Given Initialize the browser and opens site
When Select the Airport box
Then User enters CityName from ExcelSheet and User selects trip type
Then User enters pickup location from ExcelSheet and User selects pickup time and summit 
Then Navigate to next page gets car name and validate and summit 
And Navigate to next page and fill the name <name> email <email> number <number>
Then Unchecked the whatsapp notification check box and summit
Then Prints the details of the ride in console
And Close all browsers1

Examples:
|name		    |email		              |number		   |
|Tronner		|Tronner1234@gmail.com	  |1234567890      |
|Arjun Singh	|aj123224@gmail.com	      |8365938727      |





Scenario: Feature IN TestCase
Given Initialize the browser and navigate to savaari site
When Select the One option from featured Section
Then Navigate to next page and print the title and Validate the heading
And Close all browsers2




Scenario: AboutUs details TestCase
Given Initialize the browser , navigate to the site
When Select the About Us Option 
Then Navigate to next page and print all the details
Then validate the CEO name 
And Close all browsers3





Scenario: Service One Way Cab TestCase
Given Initialize the browser , Open site
When Click on One way Cab option under service 
Then Navigate to next window and select a journey 
Then Navigate to next window and validate the journey selected right
And Close all browsers4


Scenario: Contact us details validate TestCase
Given Initialize the browser , Open the site
When Click Contact us under GET IN TOUCH 
Then Navigate to next window and get the mail id 
Then Print the Phone number and full address 
And Close all browsers5




Scenario: Social Blogger Icon Validate TestCase
Given initialize the browser and Open the site
When Click on the Blogger icon 
Then Navigate to next window and click on travel guide
Then Print the article heading in console
And Close all browsers6



Scenario: Car Rental in City from bottom TestCase
Given initialize the chrome Open the site
When Click on the city in the bottom car rental bar
Then Navigate to next window and check the correct city is selected
Then Click on travel guide and print the pune details in console
And Close all browsers7
