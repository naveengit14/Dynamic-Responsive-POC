Feature: Flight Option Validation Feature

  @Search
  Scenario Outline: Flight Option Validation
    Given I am on the home page
    And I am choosing <screen type>
    When I perform expand Flight Option display Expanded view
    When I perform hide Flight Option display flight summery view

    Examples:
    | screen type |
    | Desktop     |
    | Tablet      |
    | Mobile      |