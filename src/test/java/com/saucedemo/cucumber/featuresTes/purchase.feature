#Author: your.email@your.domain.com
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
#@tag
Feature:Feature: Search functionality
  As a user I want to purchase cheapest and costliest product from the sauce demo after sorting the products by High to Low filter.

  #Background:
  #I am on sauce demo page
    #Given I am on sauce demo page
  Scenario Outline: User navigates sauce demo page and complete the item purchase
    Given I login with credential "<username>" and "<password>"
    When I click on Login button
    And I filter the products by Price "high to low"
    And I select cheapest & costliest products and add to basket
    And I open shopping cart
    And I go to checkout
    And I enter details firstname "Gary", lastName "Barlow" and zipPostalCode "AB12 2JU"
    And I click on continue button
    And I click on finish button
    Then I should be able to see message 'Thank you for your order'
    
    Examples:
    |username|password|
    |standard_user|secret_sauce|
    

