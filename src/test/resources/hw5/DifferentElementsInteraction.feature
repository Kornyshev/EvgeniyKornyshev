Feature: Interaction with UI elements on Different Elements page
  In order to check interactions with UI elements
  As a logged user
  I want to check that Log area reacts on interaction with elements

  Scenario: Checking proper behavior of elements
    Given I open JDI GitHub site on Main page
    And I login as user 'Roman Iovlev'
    And I click on 'Service' button in Header on the Main page
    And I click on 'Different Elements' button in Service dropdown on the Main page
    When I check 'Water' checkbox in Checkbox block on the Different Elements page
    And I check 'Wind' checkbox in Checkbox block on the Different Elements page
    And I click on 'Selen' radio button on the Different Elements page
    And I select 'Yellow' color in dropdown on the Different Elements page
    Then user name should be equal to 'Roman Iovlev'
    And Log area should contains logs about 'Water' checkbox checking
    And Log area should contains logs about 'Wind' checkbox checking
    And Log area should contains logs about 'Selen' radio selecting
    And Log area should contains logs about 'Yellow' color selecting