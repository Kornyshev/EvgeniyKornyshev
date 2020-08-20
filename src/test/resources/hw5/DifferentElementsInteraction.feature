Feature: Interaction with UI elements on Different Elements page
  In order to check interactions with UI elements
  As a logged user
  I want to check that Log area reacts on interaction with elements

  Scenario: Checking proper behavior of elements
    Given I open JDI GitHub site on Main page
    And I login as user 'Roman Iovlev'
    When I click on 'Service' button in Header on the Main page
    And I click on 'Different Elements' button in Service dropdown on the Main page
    And I click 'Water' checkbox in Checkbox block on the Different Elements page
    And I click 'Wind' checkbox in Checkbox block on the Different Elements page
    And I click on 'Selen' radio button on the Different Elements page
    And I select 'Yellow' color in dropdown on the Different Elements page
    Then user name should be equal to 'Roman Iovlev'
    And 1 log row has 'Colors: value changed to Yellow' text in log section
    And 2 log row has 'metal: value changed to Selen' text in log section
    And 3 log row has 'Wind: condition changed to true' text in log section
    And 4 log row has 'Water: condition changed to true' text in log section