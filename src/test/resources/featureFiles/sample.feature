Feature: Sample Test Feature

  Scenario: Test Google Search Functionality
    Given User opens home page
    When  User searches "Phone Booth"
    Then  User validates the search result as "Phone Booth"