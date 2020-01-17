# game-transaction

This is a Spring Boot application what can be started by the following command:

mvn spring-boot:run

Available services:

POST http://localhost:9000/gametransaction/store-transaction

GET http://localhost:9000/gametransaction/all-transactions

GET http://localhost:9000/gametransaction/transaction/{transactionId}

(port 9000 can be changed in application.properties file by changing server.port property to new integer value)
