Feature:To verify login functionality

  @first
  Scenario: Verify User logs in successfully when enters valid Credentials
    Given User launch Carters Homepage
    When User clicks on My Account
    And Clicks on Sign In CTA
    Then Email & Password field is displayed
    And Enters valid Credentials
    Then User should be logged in successfully


  Scenario: Verify login functionality with Invalid Credentials
    Given User launch Carters Homepage
    When User clicks on My Account
    And Clicks on Sign In CTA
#    Then Email & Password field is displayed
    And Enter Invalid credentials
    Then Validation message should be displayed
