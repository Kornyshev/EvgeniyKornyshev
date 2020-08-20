Feature: User Table Page test
  In order to check content on User Table page
  As a logged user
  I want to check that content on User Table page displayed properly

  Scenario: Checking all content on User Table page
    Given I open JDI GitHub site on Main page
    And I login as user 'Roman Iovlev'
    When I click on 'Service' button in Header on the Main page
    And I click on 'User Table' button in Service dropdown on the Main page
    Then 'User Table' page should be opened
    And 6 Number Type Dropdowns should be displayed on Users Table on User Table page
    And 6 Usernames should be displayed on Users Table on User Table page
    And 6 Description texts under images should be displayed on Users Table on User Table page
    And 6 checkboxes should be displayed on Users Table on User Table page
    And User table should contain following values:
      | Number | User             | Description                      |
      | 1      | Roman            | Wolverine                        |
      | 2      | Sergey Ivan      | Spider Man                       |
      | 3      | Vladzimir        | Punisher                         |
      | 4      | Helen Bennett    | Captain America some description |
      | 5      | Yoshi Tannamuri  | Cyclope some description         |
      | 6      | Giovanni Rovelli | Hulk some description            |
    And droplist should contain values in column Type for user 'Roman'
      | Dropdown Values |
      | Admin           |
      | User            |
      | Manager         |