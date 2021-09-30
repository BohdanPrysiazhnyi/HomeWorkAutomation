Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly


  Scenario Outline: Check search results
    Given User open '<homePage>' page
    When User makes search by keyword '<searchWord>'
    And User makes choose first product
    And User click on add to cart button
    And User click on cart icon
    Then User checks that product is added to cart equals'<countOfItems>'

    Examples:
      | homePage                | searchWord | countOfItems |
      | https://www.amazon.com/ | samsung    | 1            |
      | https://www.amazon.com/ | iphone     | 1            |


  Scenario Outline: Check delete from cart
    Given User open '<homePage>' page
    When User makes search by keyword '<searchWord>'
    And User makes choose first product
    And User click on add to cart button
    And User click on cart icon
    When User delete item from cart
    Examples:
      | homePage                | searchWord | countOfItems |
      | https://www.amazon.com/ | samsung    | 1            |


  Scenario Outline: Check error messages on sign in page near "Re-Enter password " field when user leave
  "Re-enter password" field empty

    Given User open '<homePage>' page
    And User click on account list
    And User click on create new account
    And User fill out all mandatory fields'<userName>' '<emailOrPhoneNumber>' '<password>'
    And User click on continue button
    Then  User checks that error message '<error>' near re-enter password field is appeared



    Examples:
      | homePage                | userName | emailOrPhoneNumber | password | error                    |
      | https://www.amazon.com/ | Bogdan   | bodsdk@gmail.com   | 4541212  | Type your password again |


  Scenario Outline: Check error messages on sign in page near "Re-Enter password " field when the user entered
          a password that does not match with value in "Password" field
    Given User open '<homePage>' page
    And User click on account list
    And User click on create new account
    When User fill out all mandatory fields'<userName>' '<emailOrPhoneNumber>' '<password>' '<reEnter>'
    And User click on continue button
    Then  User check that error message '<error>' near re-enter field when does not matc passwords is appeared



    Examples:
      | homePage                | userName | emailOrPhoneNumber | password  | reEnter | error                |
      | https://www.amazon.com/ | Bogdan   | bosfcuk@gmail.com  | 546545623 | sdsa    | Passwords must match |

  Scenario Outline: Check that user is able to change language
    Given User open '<homePage>' page
    And User click on language icon
    When User choose language for changing
    And User click on save changes button
    Then User check that language is changed '<language>'

    Examples:
      | homePage                | language                        |
      | https://www.amazon.com/ | Ofertas del Día |

  Scenario Outline: : Sent request for getting articles

    Given Get Articles "<URL>" Request
    Then Response code is: "<status>"
    Examples:
      | URL           | status |
      | articles.json | 200    |
      |               | 404    |
      | wrong.json    | 404    |