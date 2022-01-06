@ChangeQuantity @AllTest
Feature: This feature will verify the change in the quantity of the items in the cart funcationality.

  Background: User is on the product page and has items in the cart
    Given User launchs the Swiggy application
    And User landed at Product page
    And User has items in the cart

  @AddQuanitytoExisitngitems
  Scenario: User able to add quanity to the item in the cart
    When User click on + symbol to add a quanity 
    Then User should be able to notice the Shopping Cart icon badge changed
    And User should be able examine the item in Shopping cart


  @RemoveQuanitytoExisitngitems
  Scenario: Uuser is able to remove item from the cart
    When User click on - symbol to remove items form the cart
    Then User should be able to notice the Shopping Cart icon badge changed
    And User should be able examine the item in Shopping cart