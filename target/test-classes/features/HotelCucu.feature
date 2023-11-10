Feature: Register HotelWeb Account

  Scenario Outline: Register user on HotelWeb

    Given Page 'https://hotel-testlab.coderslab.pl/en/' opened in browser

    When Button SignIn clicked
    And Email filled and ENTER pushed
    And form filled with <FirstName>,<LastName>,<Password>

    And Button Register clicked

    Then Check if account created
    And Save screenshot
    And Close browser

    Examples:
      | FirstName | LastName | Password        |
      | Arek      | Krzyk    | erjuiwshjrfuiwj |
      | Janusz    | Kowalski | rwr3rsfse       |