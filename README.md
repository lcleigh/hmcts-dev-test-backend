# HMCTS Dev Test Backend

This project is a Spring Boot backend for the HMCTS dev test by [Laura Leigh](https://github.com/lcleigh).

It uses PostgreSQL as the database and Gradle for build and dependency management.

## Prerequisites

Before running the project locally, ensure you have the following installed:
- Java 21 JDK
- Gradle 8.x (optional; Gradle wrapper is included)
- PostgreSQL

You can also use [TablePlus](https://tableplus.com/) (or similar) to connect to the task-manager database, view tables, and run queries through a graphical interface.

## 1. Clone the Repository

```console
git clone git@github.com:lcleigh/hmcts-dev-test-backend.git
cd hmcts-dev-test-backend
```

## 2. Set up the Database

1. Start PostgreSQL locally

via Homebrew:

```console
brew services start postgresql
```

2. Create a new database

```console
CREATE DATABASE task_manager;
```

## 3. Build and Run the Backend

You can use the Gradle wrapper included in the repo:
```console
./gradlew bootRun
```
The backend will start on http://localhost:4000.

## 4. Run Tests
```console
./gradlew test
```


## Notes

- Make sure PostgreSQL is running before starting the backend.
- If you change the database name or credentials, update application.yml accordingly.
- ddl-auto: update ensures tables are created automatically on startup.
