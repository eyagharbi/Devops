# Use a base image with OpenJDK 11 on Ubuntu
FROM openjdk:11

# Set an author label
LABEL authors="Haifa"

# Expose the port your application will listen on
EXPOSE 8089


#adds the Spring Boot application JAR file to the image
ADD target/achat-devops-1.0.jar achat-devops-1.0.jar


# Define the entry point to run your application
ENTRYPOINT ["java", "-jar", "/app/achat-devops-1.0.jar"]
