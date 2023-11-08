Feature: Account Management

  Background:
    Given I am logged in to my Parabank account

  Scenario: View account details
    When I click on the Accounts link
    And I select an account
    Then I should see the account details



  Scenario Outline: Transfer funds between accounts
    When I click on the Transfer Funds link
    And I transfer <money> between two of my accounts
    Then the transfer should be successful
    And the account balances should be updated
    Examples:
      | money |
      | 100   |
      | 20    |
      | 200   |




#
#  Scenario: View transaction history
#    When I click on the "Transaction History" link
#    And I select an account
#    Then I should see the transaction history for that account
#
#  Scenario: Open a new account
#    When I click on the "Open New Account" link
#    And I select an account type
#    Then a new account should be created
#
#  Scenario: Close an account
#    When I click on the "Close Account" link
#    And I select an account to close
#    Then the account should be closed
#
#  Scenario: Request a loan
#    When I click on the "Request Loan" link
#    And I submit a loan request
#    Then the loan request should be processed
