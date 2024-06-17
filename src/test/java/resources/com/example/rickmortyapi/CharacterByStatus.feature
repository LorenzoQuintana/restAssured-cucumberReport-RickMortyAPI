@Character @Filter @Status @Regression @Smoke
Feature: Filter Characters by Status

  Scenario Outline: Filter characters by status
    Given the user filters characters by status "<status>"
    When the user presses the search button for status
    Then the system displays a list of characters with status "<status>"

    Examples:
      | status  |
      | alive   |
      | dead    |
      | unknown |

