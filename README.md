# My Web Application

A simple Spring Boot web application deployed to Azure Container Registry.

## Features
- RESTful API endpoints
- Health check endpoint
- Containerized with Docker
- Automated CI/CD with GitHub Actions

## Endpoints
- `GET /` - Welcome message
- `GET /health` - Health check
- `GET /info` - Application information

## Local Development

### Prerequisites
- JDK 17
- Maven 3.9+

### Run Locally
```bash
mvn spring-boot:run
```

Access the application at: http://localhost:8080

### Build JAR
```bash
mvn clean package
java -jar target/web-application-1.0.0.jar
```

### Build Docker Image
```bash
docker build -t web-app:local .
docker run -p 8080:8080 web-app:local
```

## Azure Deployment
This application automatically builds and pushes to Azure Container Registry on every push to main branch.

**Registry:** crbtttestwus2002.azurecr.io
**Image:** web-app:latest