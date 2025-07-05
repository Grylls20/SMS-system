# SMS-System

## Introduction
SMS-System is a Spring Boot application designed to send SMS and Email messages efficiently using RabbitMQ for message queuing. It provides a web interface and RESTful APIs for message delivery, supporting asynchronous processing and integration with MySQL and Redis.

## Project Description
This project enables users to send SMS and Email messages through a simple web UI or API. It leverages RabbitMQ for decoupled, scalable message processing, MySQL for persistent storage, and Redis for caching. The system is suitable for notification services, marketing, and transactional messaging.

## Features
- Send SMS and Email via a modern web interface
- Asynchronous message processing with RabbitMQ
- RESTful API endpoints for integration
- MySQL database for message and user data
- Redis caching for performance
- Log4j2 for logging
- Easy configuration and deployment

## Project Structure
```
/ (root)
├── src/
│   ├── main/
│   │   ├── java/com/meesho/smssystem/
│   │   │   ├── controller/         # REST controllers
│   │   │   ├── service/            # Business logic (RabbitMQ, Email, SMS)
│   │   │   ├── repository/         # Data access (MySQL, Redis)
│   │   │   ├── model/              # Entity classes
│   │   │   └── ...
│   │   └── resources/
│   │       ├── application-dev.properties
│   │       ├── static/
│   │       │   ├── index.html      # SMS UI
│   │       │   └── send.html       # SMS & Email UI
│   │       └── ...
│   └── test/                       # Unit and integration tests
├── pom.xml                         # Maven dependencies
├── README.md                       # Project documentation
└── ...
```

## Tech Stack Used
- Java 8+
- Spring Boot
- RabbitMQ
- MySQL
- Redis
- Log4j2
- Maven

## Implementation Overview
- **Messaging:** Uses RabbitMQ for queueing SMS and Email requests, ensuring reliable and scalable delivery.
- **Web/API:** Provides both a web UI (index.html, send.html) and REST endpoints for sending messages.
- **Persistence:** MySQL stores message and user data; Redis is used for caching and fast lookups.
- **Configuration:** All environment-specific settings are in `application-dev.properties`.
- **Logging:** Log4j2 is used for application logging.

