FROM openjdk:17-alpine
COPY./target/*.jar ./app/gateway-service.jar
EXPOSE 9999
CMD ["java","-jar","./app/gateway-service.jar"]