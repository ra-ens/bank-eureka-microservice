FROM openjdk:17-alpine
COPY ./target/*.jar ./app/discovery-service.jar
EXPOSE 8761
CMD ["java","-jar","./app/discovery-service.jar"]