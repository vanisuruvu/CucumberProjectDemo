Feature: Login

Background: The User opens login Page
 Given User Launches Chrome Browser
 When user opens facebook  portal link "https://www.facebook.com/"
 Then User should see the  page title "Facebook - log in or sign up"

Scenario Outline: Validating the Login functionality
    When User enters Username as "<username>" and Password as "<password>" 
    Then User clicks on Login button with expected status as "<status>"
    Then User should see the Facebook Home page on successful login status "<status>"
    
 Examples:
    | username | password   | status      |
    |          |            | Both Fail   |
    | Valid    |            | Missing Password  |    
    | Valid    | Valid      | Pass        |