# Spring-Boot-REST-API.

![image](https://github.com/user-attachments/assets/f5a3a3a6-ac88-4379-8a56-0e8f2c8bde6a)

Below is a structured documentation outline for your Spring Boot project with PostgreSQL integration and Docker setup. It can serve as a README or comprehensive project guide.

---

# **Spring Boot Web Application with PostgreSQL Integration**

### **Table of Contents**
1. [Introduction](#introduction)  
2. [Features](#features)  
3. [Technologies Used](#technologies-used)  
4. [Project Structure](#project-structure)  
5. [Configuration](#configuration)  
   - Application Configuration (`application.yml`)
   - Docker Setup (`docker-compose.yml`)  
6. [Setup Instructions](#setup-instructions)  
7. [Running the Application](#running-the-application)  
8. [Building and Testing](#building-and-testing)  
9. [Troubleshooting](#troubleshooting)  

---

## **1. Introduction**
This is a Spring Boot-based web application using PostgreSQL as the database. It is designed to demonstrate:
- RESTful API development.
- Integration with Docker for seamless database management.
- Using Spring JPA for database interactions.

The project can serve as a boilerplate for scalable web applications.

---

## **2. Features**
- CRUD operations with PostgreSQL.
- Dockerized database setup.
- REST APIs for easy integration with front-end or external systems.
- Automatic schema generation using Hibernate.
- Centralized configurations via `application.yml`.

---

## **3. Technologies Used**
- **Backend Framework**: Spring Boot 3.4.0
- **Database**: PostgreSQL
- **Dependency Management**: Maven
- **Containerization**: Docker with Docker Compose
- **JPA Provider**: Hibernate
- **Java Version**: 17+

---

## **4. Project Structure**
```
SPRING-BOOT-WEB-1
├── src
│   ├── main
│   │   ├── java
│   │   │   └── org.myBoot1
│   │   │       ├── controller        # REST controllers
│   │   │       ├── model             # Entity classes
│   │   │       ├── repository        # JPA repositories
│   │   │       └── service           # Service layer
│   │   └── resources
│   │       ├── application.yml       # Application configuration
│   │       └── static                # Static assets (if needed)
│   │       └── templates             # Thymeleaf templates (if applicable)
├── docker-compose.yml                # Docker Compose configuration
├── pom.xml                           # Maven configuration
└── README.md                         # Project documentation
```

---

## **5. Configuration**

### **Application Configuration (`application.yml`)**
The `application.yml` file contains the Spring Boot configurations:

```yaml
server:
  port: 3030

spring:
  datasource:
    url: jdbc:postgresql://localhost:5332/hospital
    username: prince
    password: matongo
  jpa:
    hibernate:
      ddl-auto: create-drop
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect
        format_sql: true
    show-sql: true
  main:
    web-application-type: servlet
```

### **Docker Setup (`docker-compose.yml`)**
This file defines the PostgreSQL container for the database:

```yaml
services:
  db:
    container_name: postgres
    image: postgres
    environment:
      POSTGRES_USER: prince
      POSTGRES_PASSWORD: matongo
      PGDATA: /data/postgres
    volumes:
      - db:/data/postgres
    ports:
      - "5332:5432"
    networks:
      - db
    restart: unless-stopped

networks:
  db:
    driver: bridge

volumes:
  db:
```

---

## **6. Setup Instructions**

### **Prerequisites**
1. **Java**: Ensure Java 17+ is installed.  
2. **Maven**: Make sure Maven is installed and configured.  
3. **Docker**: Install Docker and Docker Compose.  

### **Steps**
1. Clone the project:
   ```bash
   git clone https://github.com/your-repo-name.git
   cd SPRING-BOOT-WEB-1
   ```

2. Build the Maven project:
   ```bash
   mvn clean install
   ```

3. Start the database container:
   ```bash
   docker-compose up -d
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

---

## **7. Running the Application**
1. Access the application on **`http://localhost:3030`**.  
2. Interact with APIs (e.g., `/api/entities`) using Postman or Curl.

---

## **8. Building and Testing**

### **Build JAR**
Package the application:
```bash
mvn package
```

### **Run Tests**
Execute the test cases:
```bash
mvn test
```

---

## **9. Troubleshooting**
1. **Docker Container Not Starting**:
   - Ensure no other services are using port `5332`:
     ```bash
     sudo netstat -tuln | grep 5332
     ```
   - If a conflict exists, modify the `docker-compose.yml` port mapping.

2. **Database Connection Issues**:
   - Verify the `POSTGRES_USER` and `POSTGRES_PASSWORD` match between `application.yml` and `docker-compose.yml`.

3. **Application Crashing**:
   - Check logs for detailed errors:
     ```bash
     docker logs postgres
     mvn spring-boot:run
     ```

