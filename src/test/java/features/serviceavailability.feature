@serviceavailability @AllTest
Feature: This feature will verify if swiggy services are available at certain pin codes

  @PositiveTest 
  Scenario Outline: Verify swiggy services are available at a certain pin code
    Given User launchs the Swiggy application
    When User enters Pin code info '<Pincode>' and clicks the FindFood button
    Then User should be landed on the Products Page
    Examples: 
      | Pincode| 
      | 110025 |
	  
	@PositiveTest 
    Scenario Outline: Verify swiggy services are available at a certain area name
    Given User launchs the Swiggy application
    When User enters area/location name '<locationname>' and clicks the FindFood button
    Then User should be landed on the Products Page
    Examples: 
      | locationname| 
      | New Delhi, Delhi 110025, India |  
	  
	
  @NegativeTest
    Scenario Outline: Verify swiggy services are available at a certain pin code which is not servicable yet
    Given User launchs the Swiggy application
    When User enters Pin code info '<Pincode>' and clicks the FindFood button
    Then User should be landed on the Products Page
	 Examples: 
      | Pincode | 
      | 190001 |
	  
	@NegativeTest
    Scenario Outline: Verify swiggy services are available at a certain pin code which is not servicable yet
    Given User launchs the Swiggy application
    When User enters area/location name '<locationname>' and clicks the FindFood button
    Then User should be landed on the Products Page
    Examples: 
      | locationname| 
      | Srinagar, kashmir |  
