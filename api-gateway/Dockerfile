# Use Eclipse Temurin Java 17 JDK (works on Intel & Apple Silicon)
FROM eclipse-temurin:17-jdk

# Set working directory inside container
WORKDIR /app

# Copy the JAR file from target folder to container
COPY target/*.jar app.jar

# Expose port for this service (change if needed)
EXPOSE 8080

# Run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
