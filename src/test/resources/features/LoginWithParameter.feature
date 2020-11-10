

Feature: Login with parameters

  @librarianParam
  Scenario: Login as librarian 18
    Given I am on the login page
    When I enter username "librarian18@library"
    And I enter password 'rKG2sP88'
    Then dashboard should be displayed
    And there should be 1777 users
   #number can be whatever you have there


@studentParam
  Scenario: Login as student 18
    Given I am on the login page
    When I enter username "student18@library"
    And I enter password 'nK83Q8Be'
    Then books should be displayed

   #number can be whatever you have there



  @librarianParam#2
  Scenario: Login as librarian same line
    Given I am on the login page
    When I login using "librarian18@library"and "rKG2sP88"
    Then dashboard should be displayed
    And there should be 1829 users
#number can be whatever you have there


