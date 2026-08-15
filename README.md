# Employee Management System

A RESTful Employee Management System built using **Java, Spring Boot, Spring Data JPA, Hibernate, and MySQL**.

## Features

- Create employee
- Get all employees
- Get employee by ID
- Update employee
- Delete employee
- Pagination and sorting
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

## Pagination & Sorting

```text
GET /api/v1/employees?page=0&size=10
GET /api/v1/employees?page=0&size=10&sort=firstName,asc
GET /api/v1/employees?page=0&size=10&sort=salary,desc
```

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
```

## Author
Ahmad Shaikh