# Base image with Java and Maven
FROM maven:3.6.0-jdk-11-slim AS builder

# Copy only the pom.xml file and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src /src
RUN mvn package -DskipTests

# Intermediate image for running MongoDB and building the Java application
FROM mongo:latest AS builder-mongo

# Copy the built JAR file from the builder stage
COPY --from=builder /target/transaction-routine-0.0.1.jar /app/transaction-routine.jar

# Set the working directory in the container
WORKDIR /app

# Expose the ports for the application and MongoDB
EXPOSE 8080
EXPOSE 27017

# Set the MongoDB connection string as an environment variable
ENV MONGODB_URI="mongodb+srv://crllmantovani:12345@cluster-pismo.qslygur.mongodb.net/pismo-transaction?retryWrites=true&w=majority"

# Set the Java home environment variable
ENV JAVA_HOME="/usr/lib/jvm/java-11-openjdk-amd64"

# Install the Java runtime
RUN apt-get update && apt-get install -y openjdk-11-jdk

# Start MongoDB and run the Java application
CMD mongod & sleep 5 && java -jar -Dspring.data.mongodb.uri=${MONGODB_URI} transaction-routine.jar
