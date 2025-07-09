# SMS & Email Notification System

A comprehensive notification system built with Spring Boot that provides robust SMS and Email messaging capabilities. This system offers a unified platform for managing all your communication needs with features like contact management, blacklisting, and detailed message logging.

## ✨ Features

### SMS Features
- Send and receive SMS messages
- Schedule SMS messages for future delivery
- Contact management with groups and tags
- Phone number blacklisting
- Message templates and personalization
- Delivery status tracking
- Detailed message logging and analytics

### Email Features
- Send rich HTML and plain text emails
- Email templates with dynamic content
- Bulk email sending
- Email scheduling
- Attachment support
- Delivery status tracking
- Email analytics and reporting

## 🏗️ System Architecture

The system is built on a microservices-based architecture, designed for scalability and resilience. The core components are:

- **Spring Boot Application:** The heart of the system, handling all business logic, API requests, and service coordination.
- **MySQL Database:** The primary data store for contacts, message logs, and system data.
- **RabbitMQ:** Message broker for handling asynchronous tasks and event-driven communication.
- **Apache Kafka:** Distributed streaming platform for high-throughput message processing.
- **Elasticsearch:** Powerful search and analytics engine for full-text search and log analysis.
- **Twilio:** Integrated for sending and receiving SMS messages.
- **Spring Mail:** Integrated with SMTP servers for sending emails.
- **Redis:** Caching layer for improved performance.

All services are containerized using Docker and orchestrated with Docker Compose, making it easy to set up and run the entire system with a single command.

## 🛠️ Tech Stack

- **Backend:**
  - Java 17+
  - Spring Boot 3.x
  - Spring Data JPA
  - Spring Security
  - Spring WebFlux (for reactive endpoints)
  - Spring Mail

- **Messaging & Streaming:**
  - Apache Kafka
  - RabbitMQ
  - WebSocket

- **Database & Search:**
  - MySQL 8.0
  - Elasticsearch 8.x
  - Redis

- **Cloud & Services:**
  - Twilio (SMS)
  - Amazon SES / SendGrid (Email)
  - Docker & Docker Compose
  - Kubernetes (optional)

- **Monitoring & Logging:**
  - Prometheus
  - Grafana
  - ELK Stack (Elasticsearch, Logstash, Kibana)
  - Micrometer
- Docker

## 🚀 Getting Started

### Prerequisites

- [Docker](https://docs.docker.com/get-docker/) (v20.10.0+)
- [Docker Compose](https://docs.docker.com/compose/install/) (v2.0.0+)
- [Java 17](https://adoptium.net/)
- [Maven](https://maven.apache.org/install.html) (3.8.0+)
- [Node.js](https://nodejs.org/) (v16+) - For frontend development (optional)

### Quick Start

1. **Clone the repository**
   ```bash
   git clone https://github.com/Grylls20/SMS-system.git
   cd SMS-system
   ```

2. **Setup Environment**
   ```bash
   cp sample.env .env
   # Update the .env file with your configurations
   ```

3. **Build and Run with Docker**
   ```bash
   # Build the application
   mvn clean package -DskipTests
   
   # Start all services
   docker-compose up -d
   ```

4. **Access the Application**
   - API Documentation: `http://localhost:8080/swagger-ui.html`
   - Admin Dashboard: `http://localhost:3000` (if frontend is enabled)
   - Kibana: `http://localhost:5601`
   - Grafana: `http://localhost:3001`

## 📚 Project Structure

```
src/
├── main/
│   ├── java/com/meesho/smssystem/
│   │   ├── config/          # Configuration classes
│   │   ├── controller/      # REST controllers
│   │   ├── dto/             # Data Transfer Objects
│   │   ├── exception/       # Exception handling
│   │   ├── model/           # Entity classes
│   │   ├── repository/      # Data access layer
│   │   ├── service/         # Business logic
│   │   │   ├── impl/        # Service implementations
│   │   │   ├── EmailService.java
│   │   │   └── SMSService.java
│   │   ├── util/            # Utility classes
│   │   └── SmsSystemApplication.java
│   └── resources/
│       ├── static/          # Static resources
│       ├── templates/       # Email templates
│       └── application.yml  # Application configuration
└── test/                    # Test files
```

## 📡 API Documentation

### SMS Endpoints
- `POST /api/v1/sms/send` - Send an SMS message
- `GET /api/v1/sms/{id}` - Get SMS details by ID
- `GET /api/v1/sms` - Search SMS messages with filters
- `POST /api/v1/sms/bulk` - Send bulk SMS
- `GET /api/v1/sms/status/{messageId}` - Check SMS delivery status

### Email Endpoints
- `POST /api/v1/emails/send` - Send an email
- `POST /api/v1/emails/template` - Send email using template
- `POST /api/v1/emails/bulk` - Send bulk emails
- `GET /api/v1/emails/{id}` - Get email details by ID
- `GET /api/v1/emails` - Search emails with filters

### Contact Management
- `GET /api/v1/contacts` - List all contacts
- `POST /api/v1/contacts` - Add new contact
- `GET /api/v1/contacts/{id}` - Get contact details
- `PUT /api/v1/contacts/{id}` - Update contact
- `DELETE /api/v1/contacts/{id}` - Delete contact

### Templates
- `GET /api/v1/templates` - List all templates
- `POST /api/v1/templates` - Create new template
- `PUT /api/v1/templates/{id}` - Update template
- `DELETE /api/v1/templates/{id}` - Delete template

## 🔒 Security

The system implements JWT-based authentication and includes:
- Role-based access control (RBAC)
- Rate limiting
- Request validation
- CORS configuration
- CSRF protection
- Secure password hashing

## 📈 Monitoring & Logging

- **Prometheus** - Metrics collection
- **Grafana** - Visualization and dashboards
- **ELK Stack** - Centralized logging
- **Health Checks** - `/actuator/health`
- **Metrics** - `/actuator/metrics`

## 🧪 Testing

Run tests using:
```bash
mvn test
```

Test coverage includes:
- Unit tests
- Integration tests
- API tests
- Performance tests

## 🚀 Deployment

### Production Deployment
1. Update production configurations in `application-prod.yml`
2. Build Docker images:
   ```bash
   docker-compose -f docker-compose.prod.yml build
   ```
3. Deploy:
   ```bash
   docker-compose -f docker-compose.prod.yml up -d
   ```

### Kubernetes (Optional)
```bash
kubectl apply -f k8s/
```

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- Built with ❤️ using Spring Boot
- Thanks to all contributors who have helped shape this project

---

<p align="center">
  Made with ❤️ by Your Team Name
</p>

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