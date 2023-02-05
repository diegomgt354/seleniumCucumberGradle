@Google
Feature: Test Google search functionality

  # Rule: Piesa fundamental del Feachure file

  Background: open Google
    Given I am on the Google search page

  @Search
  Scenario Outline: As a user I enter a search criteria in Google
    When I enter a search <criteria>
    And click on the search button
    Then the results match the criteria
    Examples:
    | criteria |
    | Python   |

  @validateIsDisplay
  Scenario: validate search is display
    Then search is display

    
