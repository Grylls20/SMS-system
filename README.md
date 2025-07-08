# SMS System

This is a powerful and scalable SMS management system built with Spring Boot. It provides a robust platform for sending, receiving, and managing SMS messages, with features like contact management, blacklisting, and detailed message logging.

## System Architecture

The SMS System is built on a microservices-based architecture, designed for scalability and resilience. The core components are:

- **Spring Boot Application:** The heart of the system, handling all business logic, API requests, and coordination between the other services.
- **MySQL Database:** The primary data store for contacts, message logs, and other essential data.
- **Redis:** Used for caching frequently accessed data and managing blacklisted numbers for fast lookups.
- **Apache Kafka:** A distributed streaming platform that enables asynchronous communication and decouples the sending of SMS messages from the main application flow.
- **Elasticsearch:** A powerful search and analytics engine used for full-text search on SMS messages.
- **Twilio:** Integrated for sending and receiving SMS messages.

All services are containerized using Docker and orchestrated with Docker Compose, making it easy to set up and run the entire system with a single command.

## Installation & Setup

Follow these steps to set up and run the SMS System locally:

### Prerequisites

- [Docker](https://docs.docker.com/get-docker/)
- [Docker Compose](https://docs.docker.com/compose/install/)
- [Java 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
- [Maven](https://maven.apache.org/install.html)

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/SMS-system.git
cd SMS-system
```

### 2. Configure Environment Variables

Create a `.env` file by copying the `sample.env` file:

```bash
cp sample.env .env
```

Update the `.env` file with your specific configurations for the database, Redis, Kafka, Elasticsearch, and Twilio credentials.

### 3. Build the Application

Compile the project and build the JAR file using Maven:

```bash
mvn clean install
```

### 4. Run with Docker Compose

Start all the services using Docker Compose:

```bash
docker-compose up -d
```

This will start the Spring Boot application, MySQL, Redis, Kafka, and Elasticsearch in detached mode. The application will be accessible at `http://localhost:8080`.

## API Endpoints

The following are the main API endpoints available in the SMS System:

### SMS Management

- `POST /v1/sms/send`: Send an SMS message.
- `POST /v1/sms`: Retrieve an SMS message by its ID.
- `POST /v1/sms/get-by-text`: Search for SMS messages containing specific text.
- `POST /v1/sms/get-between`: Get all SMS messages for a phone number within a specified date range.

### Contact Management

- `GET /v1/contacts`: Get a list of all contacts.
- `POST /v1/contacts`: Add a new contact.
- `DELETE /v1/contacts/{id}`: Delete a contact by its ID.

### Blacklist Management

- `GET /v1/blacklist`: Get all blacklisted phone numbers.
- `POST /v1/blacklist`: Add one or more phone numbers to the blacklist.
- `DELETE /v1/blacklist/{phoneNumber}`: Remove a phone number from the blacklist.

### Message Logs

- `GET /v1/messages`: Get a list of all message logs.


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