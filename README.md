# SpringBoot-Rest-H2

Dependencies:

-> Spring Boot

-> Spring Data

-> H2 in-memory database

-> Spring AOP

-> Spring Web

-> Lombok

Rest URLs:

1. List of Company Stock Data
-> GET http://localhost:8080/stock

2. Save/ Update Company Stock Data
-> PUT http://localhost:8080/stock

3. Delete Company Stock Data
-> DELETE http://localhost:8080/stock/{id}

4. All Stock data by Company Code
-> GET http://localhost:8080/stock/{companyCode}

5. List of Company Codes
-> GET http://localhost:8080/stock/companyCodes

Bad URLs

1. List of Company Stock Data is empty
-> throws Resource not found exception

2. If Company code does not exists
- throws Bad Request Exception.

Used three simple, common response codes indicating (1) success, (2) failure due to client-side problem, (3) failure due to server-side problem:

200 - OK

400 - Bad Request

500 - Internal Server Error




