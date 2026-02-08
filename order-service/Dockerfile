# Use lightweight Java 17 JDK image
FROM eclipse-temurin:17-jdk

# Set working directory inside container
WORKDIR /app

# Copy JAR file from target folder to container
COPY target/*.jar app.jar

# Expose port for this service (change if needed)
EXPOSE 8081

# Run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
