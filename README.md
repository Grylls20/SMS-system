# SMS System

This is a powerful and scalable SMS management system built with Spring Boot. It provides a robust platform for sending, receiving, and managing SMS messages, with features like contact management, blacklisting, and detailed message logging.

## System Architecture

The SMS System is built on a microservices-based architecture, designed for scalability and resilience. The core components are:

- **Spring Boot Application:** The heart of the system, handling all business logic, API requests, and coordination between the other services.
- **MySQL Database:** The primary data store for contacts, message logs, and other essential data.
- **RaabitMQ:** Used for caching frequently accessed data and managing blacklisted numbers for fast lookups.
- **Apache Kafka:** A distributed streaming platform that enables asynchronous communication and decouples the sending of SMS messages from the main application flow.
- **Elasticsearch:** A powerful search and analytics engine used for full-text search on SMS messages.
- **Twilio:** Integrated for sending and receiving SMS messages.

All services are containerized using Docker and orchestrated with Docker Compose, making it easy to set up and run the entire system with a single command.

## Tech Stack Used

- Java 8+
- Spring Boot
- Apache Kafka
- MySQL
- RabbitMQ
- Elasticsearch
- Twilio
- Log4j2
- Maven
- Docker

## Installation & Setup

Follow these steps to set up and run the SMS System locally:

### Prerequisites

- [Docker](https://docs.docker.com/get-docker/)
- [Docker Compose](https://docs.docker.com/compose/install/)
- [Java 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
- [Maven](https://maven.apache.org/install.html)

### 1. Clone the Repository

```bash
git clone https://github.com/Grylls20/SMS-system.git
cd SMS-system
```

### 2. Configure Environment Variables

Create a `.env` file by copying the `sample.env` file:

```bash
cp sample.env .env
```

Update the `.env` file with your specific configurations for the database, RabbitMQ, Kafka, Elasticsearch, and Twilio credentials.

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

This will start the Spring Boot application, MySQL, RabbitMQ, Kafka, and Elasticsearch in detached mode. The application will be accessible at `http://localhost:8080`.

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