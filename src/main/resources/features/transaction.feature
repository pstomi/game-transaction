Feature: Game Transaction

Scenario: Store multiple Transaction

Given There is no transaction stored
When I create game transaction where 100 of monetary amount spent by user1 user for product1 product
When I check transactions
Then I have 1 game transaction
When I create game transaction where 100 of monetary amount spent by user2 user for product2 product
When I create game transaction where 100 of monetary amount spent by user2 user for product2 product
When I check transactions
Then I have 3 game transaction