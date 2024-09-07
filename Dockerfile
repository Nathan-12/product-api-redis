# Get image maven
FROM maven:3.9.8-eclipse-temurin-17

# Maintaner data
LABEL maintainer="Nathan Lima <nathanlima.b@gmail.com>"

# Set the working directory to /app
WORKDIR /app

# Copy the source code to the container
COPY . .

# Build the application with Maven
RUN mvn package

# Expose default Spring Boot port
EXPOSE 8080

# Run the jar file
CMD ["java", "-jar", "target/product-api-redis-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=prod"]