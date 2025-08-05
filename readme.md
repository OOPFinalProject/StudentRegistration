# Student Registration System

A Java-based command-line application for managing students, courses, and their registrations using an SQLite database. The system allows users to register students (individually or in bulk), view course enrollments, and manage logs for tracking operations.

## Features

- Add, view, and manage students and courses
- Register students to courses individually or by academic year
- Persistent SQLite database integration
- Logging system to track registration activities
- Command-line interface for simple, fast operation

## Installation

### Prerequisites

- Java 21+ (Uses features up to Java 24)
- Maven (for dependency management and running)

### Setup Steps

1. Clone the repository
   ```bash
   git clone https://github.com/OOPFinalProject/StudentRegistration.git
   cd StudentRegistration
````

2. Build the project and initialize the database

   ```bash
   mvn compile -Pinit-db
   ```

3. Run the application

   ```bash
   mvn exec:java
   ```

## Usage

After running the application, follow the interactive CLI to:

* Add students and courses
* Register students for courses (individually/by year)
* View registration data
* Create and read logs

All data is saved in a local SQLite database file within the project directory.

## Project Structure

```
StudentRegistration/
│
├── src/
│   ├── main/
│   │   ├── java/         → Application source code
│   │   └── resources/    → SQL initialization scripts
│
├── logs/                 → Stores generated registration logs
├── pom.xml               → Maven config file
└── README.md             → Project documentation
```

## Contributors

| Name                                                   | Role                                               |
| ------------------------------------------------------ | -------------------------------------------------- |
| [Hamza Mohammed](https://github.com/Hamiiz)            | Project Lead & Developer (architecture, bug fixes) |
| [Abenezer Maru](https://github.com/azensso)            | Database Setup & Initialization                    |
| [Nahot Haile](https://github.com/Nahot4)               | DAO Layer (Database access methods)                |
| [Haile Abateneh](https://github.com/halazab)           | UI Layer Development                               |
| [Nebiyu Samuel](https://github.com/charismatic-design) | UI Layer Development                               |
git add
