Feature: Trello Board Creation

  @Sanity
  Scenario Outline: User creates a new Trello Board

    Given user opens Trello page
    When user login with user and password
    Then user clicks create board and enters board name as <boardname>
    Then user deletes the board



    Examples:
      | boardname |
      | A New Board  via UI |


  @Sanity
  Scenario: User creates a new Trello Board via api

    Given user creates board via api
    When user creates a new list via api
    Then user deletes the board via api

