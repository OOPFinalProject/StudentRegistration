# Student Registration System

## Description

The Student Registration System is a Java-based application that allows users to manage student records, courses, and course registrations. It provides functionalities to add students, add courses, register students for courses (individually or in bulk), and view registration information. The system uses an SQLite database for persistent storage and features a simple command-line interface.
It also has Logging feature which creates logs of registrations into a text file

## Installation

### Prerequisites

- Java 21 or newer (project uses Java 24 features)
- Maven (for dependency management and building)

### Steps

1. **Clone the repository:**
   ```bash
   git clone <repository-url>
   cd StudentRegistration
   ```

2. **Build the project and Initialize the Database:**
   ```bash
   mvn compile -Pinit-db
   ```

3. **Run the application:**
   ```bash
   mvn exec:java
   ```

## Usage

After running the application, follow the on-screen prompts to:

- Add new students and courses
- Register students for courses (individually or by year)
- View registered students and courses
- create logs
- read logs

The application stores data in an SQLite database file in the project directory.

## Collaborators

- **[Hamza Mohammed]** - Project Lead & Developer (overall, and minor fixes, )
- **[Abenezer Maru]** - Database (Create the Database and Initializer)
- **[Nahot Haile ]** - DAO Layer (Functions for Database Operation)
- **[Haile Abateneh]** - CLI layer 
- **[Nebiyu Samuel]** - CLI Layer


