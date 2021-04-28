FROM openjdk:8-jdk-alpine
EXPOSE 8081
ARG JAR_FILE=target/RegistrationLoginService-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} RegApp.jar
ENTRYPOINT exec java -jar /RegApp.jar