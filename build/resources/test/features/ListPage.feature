@ListPage
Feature: Test GList Page

  @Lista
  Scenario Outline: Search in list
    Given I am on the List search page
    When I search the <text>
    Then I can find the <textSearch> in the list
    Examples:
    |     text      |  textSearch         |
    | Washington    |Spokane, Washington  |
    | Texas         |El Paso, Texas       |
    | Florida       |Fort Pierce, Florida |

