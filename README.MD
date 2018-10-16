## Spring Data DynamoDB Sample POC

This project was built to play around with Spring Data with DynamoDB support. 

It uses this https://github.com/derjust/spring-data-dynamodb

**Note**: I realize that a typical AWS configuration is not as simple as the one in this project. This was simply just to get a feel for the tooling.

### Requirements
- Java 8

### Running DynamoDB Locally
I prefer Docker..

```
docker run -p 8000:8000 amazon/dynamodb-local
```