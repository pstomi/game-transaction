Feature: Game Transaction

Scenario: Store Transaction

Given There is no transaction stored
When I create game transaction where 100 of monetary amount spent by user1 user for product1 product
When I check transactions
Then I have 2 game transaction