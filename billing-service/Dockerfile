FROM openjdk:17-alpine
COPY ./target/*.jar ./app/billing-service.jar
EXPOSE 8080
CMD ["java","-jar","./app/billing-service.jar"]