# Base image with Java and Maven
FROM maven:3.6.0-jdk-11-slim AS builder

# copy only the pom.xml file and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src /src
RUN mvn package -DskipTests

# Final image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the builder stage
COPY --from=builder target/transaction-routine-0.0.1-jar-with-dependencies.jar transaction-routine.jar

# Expose the port on which the application will listen
EXPOSE 8080

# Set the command to run the application
CMD ["java", "-jar", "transaction-routine-0.0.1.jar"]
