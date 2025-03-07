# Spring Boot MVC with Postgres, Docker, and Test Integration 🚀

## Project Overview 📝
This project showcases a **simple Spring Boot application** that follows the **MVC (Model-View-Controller) pattern**, integrates with a **Postgres database**, and demonstrates **unit tests with Diffblue**, as well as **container-based integration testing**. It also demonstrates the use of **Docker** to containerize the application.

The purpose of this project is to provide a straightforward example of how to:
- Build and deploy a Spring Boot app with **Hibernate** and a **Postgres database**.
- Integrate **unit tests** using Diffblue and **integration tests** using **Testcontainers**.
- Containerize the application with **Docker** for easy deployment.

## Features ⚙️
- Spring Boot application following the **MVC pattern**.
- Integration with **Postgres** for data storage.
- **Hibernate ORM** for database interactions.
- **Docker** support for containerization.
- **JUnit Jupiter** for unit testing.
- **Testcontainers** for integration tests with real services.
- Simple API endpoints to **register** and **fetch members**.

## Technologies Used 🔧
- **Spring Framework** (Spring Boot, Spring MVC)
- **Java** version 21
- **PostgreSQL** database
- **Tomcat** server (default embedded in Spring Boot)
- **JUnit Jupiter** for testing
- **Testcontainers** for integration testing with real databases and services
- **Hibernate ORM** for database interaction
- **Docker** for containerization
- **Diffblue** for automated unit test generation

## Setup and Installation 🛠️

### Prerequisites 📦
- Make sure you have **Docker** installed on your machine. If you don’t have it, you can download and install it from the [official Docker website](https://www.docker.com/products/docker-desktop).

### Steps to Set Up Locally 🖥️
1. **Clone the repository:**
   ```bash
   git clone <repository-url>
   cd <project-directory>

2. Start the application dependencies using Docker Compose.Make sure Docker is running and execute the following command to bring up the services (Postgres, etc.):
    ```bash
    docker-compose up

3. Build and run the Spring Boot application: After the containers are up, build the Spring Boot application and run the jar file:
    ```bash
    ./mvnw clean package
    java -jar target/your-project-name.jar

4. Access the application:Once the application is running, open your browser and go to:
http://localhost:8080

Usage Instructions 🧑‍💻

The application runs locally on localhost:8080. You can interact with it via the following API endpoints:

The application runs locally on localhost:8080. You can interact with it via the following API endpoints:

Register a new member:

## Endpoint: POST /api/kitchensink/register
- Description: Register a new member in the system.
- Body: Pass member details as JSON (e.g., {"name": "John Doe", "email": "Jone@test.com", "phoneNumber":"1999666333"}).
Fetch all members:

## Endpoint: GET /api/kitchensink/members
Description: Fetch a list of all registered members.

## Testing and CI/CD 🧪
- Unit Tests: The project includes unit tests powered by JUnit Jupiter and Diffblue for automated test generation.
- Integration Tests: Testcontainers is used to spin up real services (like Postgres) for integration testing.
Run all tests with:
    ```bash
    ./mvnw test
  
## Docker Integration 🐳
This project uses Docker for easy deployment and containerization. You can use the following commands to manage the Docker containers:

- Start the containers (Postgres, etc.):
    ```bash
    docker-compose up
  
- Stop the containers:
    ```bash
    docker-compose down

Enjoy building with Spring Boot and Docker! 😊
