Feature: Search and place order
  @Buy
  Scenario: Search for iteam and validate result
    Given User is on landing page
    When user search for "Shirt"
    Then "Shirt" results are display
  @second
  Scenario: search second item then move to checkout page
    Given User is on landing page
    When user search for "Dress"
    Then "Dress" results are display on page
    And user select brand and dress
    And User proceeded to ckeckout page for perchess
#    Then Verify select "Dress" item is display on ckechout page
