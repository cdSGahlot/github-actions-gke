FROM openjdk:8-jdk-alpine
EXPOSE 8081
ADD target/registration-login-update-service.jar registration-login-update-service.jar
ENTRYPOINT  ["java", "-jar", "/registration-login-update-service.jar"]