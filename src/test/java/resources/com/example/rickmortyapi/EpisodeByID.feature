Feature: Get Episode by ID

  Scenario Outline: Get details of an episode by ID
    Given the user knows the episode ID "<id>"
    When the user requests details for the episode
    Then the system displays details for the episode with ID "<id>"
    And the details include name, air date, and characters

    Examples:
      | id  |
      | 1   |
      | 2   |
      | 10  |
