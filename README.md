# Employee Management System

A RESTful Employee Management System built using **Java, Spring Boot, Spring Data JPA, Hibernate, and MySQL**.

## Features

- Create employee
- Get all employees
- Get employee by ID
- Update employee
- Delete employee
- DTO-based request/response
- Input validation
- Global exception handling

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Lombok
- Postman

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/v1/employees` | Create employee |
| GET | `/api/v1/employees` | Get all employees |
| GET | `/api/v1/employees/{id}` | Get employee by ID |
| PUT | `/api/v1/employees/{id}` | Update employee |
| DELETE | `/api/v1/employees/{id}` | Delete employee |

## Architecture

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
JPA / Hibernate
    ↓
MySQL

  







