# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the host machine into the container
COPY target/job-scheduler.jar /app/app.jar

# Set the command to run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
