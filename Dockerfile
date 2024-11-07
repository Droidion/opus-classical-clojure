# Build stage
FROM clojure:temurin-23-lein AS builder

# Set working directory
WORKDIR /app

# Copy project files
COPY project.clj /app/
COPY src /app/src

# Build uberjar
RUN lein uberjar

# Runtime stage
FROM eclipse-temurin:23-jre-alpine

WORKDIR /app

# Copy the uberjar from builder stage
COPY --from=builder /app/target/uberjar/*-standalone.jar /app/app.jar

# Run the application
CMD ["java", "-jar", "/app/app.jar"]