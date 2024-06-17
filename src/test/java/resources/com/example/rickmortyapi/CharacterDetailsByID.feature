@Character @Details @Regression @Smoke
Feature: Character Details By ID

  Scenario Outline: Get details by ID
    Given the user has the ID "<characterId>"
    When the user requests details for the character
    Then the system displays details for the character with ID "<characterId>"
      And the details include name, status, species, gender, origin, location, image, and episodes

    Examples:
      | characterId |
      | 1           |
      | 2           |