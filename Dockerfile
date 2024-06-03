# Use a base image with Java 17
FROM openjdk:17-jdk-slim

# Set the working directory in the Docker container
WORKDIR /app

# Copy the JAR file into the Docker image
COPY target/manager-1.0-SNAPSHOT.jar /app/

# Command to run the application
CMD ["java", "-jar", "manager-1.0-SNAPSHOT.jar"]

# Expose the port the application runs on
EXPOSE 8080
