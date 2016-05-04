Feature: Flight details page responsive design

  Scenario Outline: Flight Option validation on OJ page for screen type <screen type>
    Given I am on the OJ home page
    And I am navigating to responsive page by selecting Hand_off_1 button
    And I am viewing using <screen type>
    When I click expand view system shows flight expand view
    When I click hide option system displays flight summery view
    When I click back option system displays oj home page
    And I navigate back to OJ page and select second option
    When I click expand view system shows flight expand view
    When I click hide option system displays flight summery view
    Examples:
      | screen type |
      | Desktop     |
      | Tablet      |
      | Mobile      |