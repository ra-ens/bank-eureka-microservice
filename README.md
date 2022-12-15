# Bank eureka microservice

This is a project that demonstrates the use of Eureka Server for service discovery in a microservice architecture. The project consists of a bank management system based on Eureka Server and a microservices that registers themselfs with the Eureka Server.  

The app consists of three microservices:

- Customer Service: Provides API endpoints for managing customer data, such as creating new customers, updating customer information, and retrieving customer details.
- Billing Service: Provides API endpoints for managing customer billing information, such as adding new charges, paying bills, and retrieving billing statements.
- Discovery Service: Provides service discovery functionality for the Customer Service and Billing Service using Spring Cloud's DiscoveryClient.

## Requirements

- Java 8+
- Maven
- Docker and Docker-compose (optional)

## Running the app using docker and docker-compose

To start the system using docker-compose, run the following commands in the terminal:
```sh
$ docker-compose up
```

## Running the app manually

1. Start the Eureka Server by running the following command in the terminal:

```sh
$ cd discovery-service
$ mvn spring-boot:run
```

This will start the Eureka Server on port `8761`. You can verify that the server is running by visiting `http://localhost:8761` in your web browser. This should show the Eureka Server dashboard, which should be empty at this point since no microservices have registered with the server yet.

2. In a new terminal, start the Discovery Service by running the following command:

```sh
$ cd discovery-service
$ mvn spring-boot:run
```

This will start the Discovery Service on port `9999`. You can verify that the service is running by visiting `http://localhost:9999/actuator/health` in your web browser. This should show a JSON response with the status of the service.

3. In another new terminal, start the Customer Service by running the following command:

```sh
$ cd customer-service
$ mvn spring-boot:run
```

This will start the Customer Service on port `8081`. You can verify that the service is running by visiting `http://localhost:8081/actuator/health` in your web browser. This should show a JSON response with the status of the service.

4. In another new terminal, start the Billing Service by running the following command:

```sh
$ cd billing-service
$ mvn spring-boot:run
```

This will start the Billing Service on port `8080`. You can verify that the service is running by visiting `http://localhost:8080/actuator/health` in your web browser. This should show a JSON response with the status of the service.

5. You can now go back to the Eureka Server dashboard at `http://localhost:8761` and verify that the Customer Service, Billing Service, and Discovery Service have registered themselves with the server. The dashboard should show the services in the list of available services.
