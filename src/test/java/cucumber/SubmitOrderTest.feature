@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file

	Background:
	Given I landed on Ecommers Page
	



  @Regration
  Scenario Outline: Positive Test of Submiting Order
    Given Logged in with username <name> and password <password>
    When I add product <productName> to cart
    And Checkout <productName> and submit the order
    Then "Thankyou for the order." message is displayed on confirmationPage

    Examples: 
    | name  										| password 			| productName |
    | kakdepavan050@gmail.com   | Pavan2!((^  	| ZARA COAT 3 |
      
