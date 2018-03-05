@scoring_system @add_user
Feature: Tests for JavaGuru website: Android page and registration form

  Scenario Outline: As an end user I am able to register using registration form
    Given User is on the 'http://qaguru.lv:8080/qa2/' page
    When User opens 'Add user' registration form
    Then User fills registration form with data
      | Name      | <name>      |
      | Surname   | <surname>   |
      | Phone     | <phone>     |
      | E-mail    | <email>     |
      | Gender    | <gender>    |
      | person ID | <person_ID> |
    Examples:
      | name   | surname | phone    | email           | gender | person_ID    |
      | John   | Kramer  | 77777777 | jksaw@mailo.com | Male   | 131366-13666 |
      | Sandra | Bullock | 25252525 | speed@mailo.com | Female | 252566-25255 |