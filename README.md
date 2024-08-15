Spring Boot Application - Book Management API
---------------------------------------------

This is a Spring Boot application providing a simple API for managing books.

**Features:**

*   Lists all available books.

*   Adds a new book.


**Database:**

This initial implementation uses an embedded H2 database for simplicity. Data will be lost upon application restart. For production environments, consider using a persistent database like PostgreSQL. Spring Data JPA facilitates this transition.

**Security:**

An endpoint security framework is present but currently allows all non-authenticated access. To secure the endpoint, additional configuration and Spring role annotations on the controller are required.

**CORS:**

CORS (Cross-Origin Resource Sharing) configuration is included but allows all requests for demonstration purposes. Secure CORS requires additional configuration.

**Testing:**

Unit tests are provided for successful scenarios (sunny day use cases). With further development, these tests would be expanded to include exceptions and edge cases.

Integration tests leveraging test containers are recommended for infrastructure components like external databases.

### Getting Started

**Prerequisites:**

*   Java 11 or later

*   Maven 3 or later


**Build**

1.  Navigate to the project directory in your terminal.

2.  Run the following command to build the application:


Bash

`   mvn clean package   `

This will create a JAR file in the target directory. The jar is created with full dependences allowing for use as a standalone application.

**Run**

1.  Run the following command to start the application:


Bash

`   java -jar target/library-0.0.1-SNAPSHOT.jar   `

Consider SNAPSHOT version if a new version is created.

**API Endpoints:**

*   **List all books:** GET /api/books

*   **Add a new book:** POST /api/books (requires book information as JSON in the request body)


**Testing**

Unit tests are located in the src/test/java directory. You can run them using:

Bash

`   mvn test   `


### Recommendations for Improvement

**Versioning**

* The current maven configuration will build a SNAPSHOT version. A true versioned production jar may be created using the maven release plugin.
* However, in a contained environment it is the docker image of the container that is normally versioned.

**Containerisation**

* Docker containerisation allows for deployment of microservice containers, which provides many benefits including ease of scaling.

**Database Persistence:**

*   Consider switching to a persistent database like PostgreSQL for production environments. Spring Data JPA simplifies this transition.


**Endpoint Security:**

*   Implement endpoint security by configuring authentication and authorization using Spring Security. Apply appropriate Spring role annotations to controllers for access control.


**CORS Configuration:**

*   Configure CORS restrictions to only allow requests from authorized origins.


**Testing:**

*   Expand unit tests to cover exception handling and edge cases.

*   Introduce integration tests using test containers to test interactions with external databases.


**Additional Features:**

*   Implement functionalities like searching for books, deleting books, and updating book information.


This document provides a basic overview of building, running, and testing the application. As development progresses, consider implementing the suggested improvements for a more robust and secure application.