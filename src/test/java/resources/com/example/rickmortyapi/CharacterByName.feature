Feature: Character Search By Name

  Scenario Outline: Search by full name
    Given the user enters "<characterName>" in the search field
    When the user presses the search button
    Then the system displays details for "<characterName>"
      And the details include name, status, location, image, and episodes
    Examples:
      | characterName   |
      | Rick Sanchez    |
      | Morty Smith     |

  Scenario Outline: Search by partial name
    Given the user enters "<partialName>" in the search field
    When the user presses the search button
    Then the system displays a list of characters that include "<partialName>" in their name
      And each character in the list shows name, status, location, image, and episodes
    Examples:
      | partialName |
      | Rick        |
      | Morty       |

  Scenario Outline: Search with no exact match
    Given the user enters "<approxName>" in the search field
    When the user presses the search button
    Then the system offers suggestions close to "<exactName>"
    Examples:
      | approxName      | exactName     |
      | Rack Sanchez    | Rick Sanchez  |

