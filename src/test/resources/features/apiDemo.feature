Feature: ApiTesting Demo

  Scenario: Test API
  Given New user is created via API
  When User navigates to page to update the created user
  And User types new personal data of choosed user
  Then User checks if data is correct
