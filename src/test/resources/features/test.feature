@smoke
Feature: Login and Navigation functionality

  Background:
    Given User is on the Nextbase CRM login page
    When User enters "helpdesk31@cybertekschool.com" and "UserUser" and login

  Scenario: Login as a Student
    Then User should see "CRM" displayed

  Scenario: My Meeting Verification
    When User clicks on "Time and Reports"
    And User navigates on "Meetings and Briefings"
    Then User should see "My meetings"
