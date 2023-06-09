# E-Voting App

The E-Voting App is a secure and efficient platform for conducting electronic voting. It provides a convenient way for voters to cast their votes remotely and securely, while ensuring the integrity of the voting process.

## Table of Contents
- [Introduction](#introduction)
- [Technologies Used](#technologies-used)
- [Features](#features)
- [Usage](#usage)

## Introduction
The E-Voting App is a Java-based application that facilitates the electronic voting process. It enables voters to cast their votes securely.

## Technologies Used
- Java
- Spring Boot
- MongoDB
- Postman (For API testing and documentation)
- Layered Architecture

## Features
- Register Voter: Allows the registration of eligible voters, ensuring their inclusion in the electoral roll.
- Register Party: Enables the registration of political parties, allowing them to participate in the election.
- Cast Votes: Users can securely cast their votes through the application, ensuring their participation in the electoral process.
- Age Verification: Implements a validation mechanism to ensure that only eligible voters above 18 years old can register and cast their votes.
- View Result: Provides a feature to view real-time election results, allowing users to stay informed about the progress of the voting process.

## Usage
### Voter Registration API

- Endpoint: `/voter/register`
- Method: POST

#### Request

```json
{
  "firstName": "Aliyah",
  "lastName": "Renike",
  "emailAddress": "aliyahrenike@gmail.com",
  "password": "1234",
  "age": 19
}
```

#### Response

```json
{
    "voterId": "648275cdfa5ed918943b0df7",
    "name": "Aliyah Renike",
    "message": "Voter registered successfully"
}
```
### Voter Login API
- Endpoint: `/voter/login`
- Method: POST

#### Request

```json
{
  "emailAddress": "aliyahrenike@gmail.com",
  "password": "1234"
}
```

#### Response

```json
{
  "id": "64827d2aaa3e626159f1f1ed",
  "message": "Voter successfully logged in"
}
```
