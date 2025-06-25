# MeetingBackend

## Overview

MeetingBackend is a Java Spring Boot application for managing meetings. It provides RESTful APIs to create, read, update, and delete meeting records. The app uses Spring Data JPA for database operations and follows a layered architecture (Controller, Service, Repository).

## Features

- Create, read, update, and delete meetings
- RESTful API endpoints
- Data validation and exception handling
- Integration with a relational database (H2 by default, MySQL supported)

## Prerequisites

- Java 17 or higher
- Maven 3.8+
- (Optional) MySQL or another supported database
- By default, the app uses an H2 in-memory database.
  To use MySQL, update src/main/resources/application.properties:

## Getting Started

-API Endpoints.

The app will start on http://localhost:8080.


Method              Endpoint                    Description
GET                 /meetings                   List all meetings
GET                 /meetings/{id}              Get meeting by ID
POST                /meetings                   Create a new meeting
PUT                 /meetings/{id}              Update an existing meeting
DELETE              /meetings/{id}              Delete a meeting



### 1. Clone the Repository

```sh
git clone https://github.com/fokkah/MeetingBackend.git
cd MeetingBackend