FROM openjdk:17-alpine
COPY ./target/*.jar ./app/customer-service.jar
EXPOSE 8081
CMD ["java","-jar","./app/customer-service.jar"]