@wip
Feature: Login and Navigation functionality

  Background:
    Given User is on the Nextbase CRM login page

    Scenario: Login as a Student
      When User enters "helpdesk31@cybertekschool.com" and "UserUser" and login
      Then User should see "CRM" displayed

      Scenario: My Meeting Verification
        When User clicks on "Time and Reports"
        And User navigates on "Meetings and Briefings"
        Then User should see "My meetings"
