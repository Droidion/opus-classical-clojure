# Build stage
FROM clojure:temurin-23-tools-deps AS builder

# Set working directory
WORKDIR /app

# Copy project files
COPY deps.edn build.clj /app/
COPY src /app/src
COPY resources/public /app/resources/public
COPY resources/* /app/resources

# Build uberjar
RUN clj -T:build uber

# Runtime stage
FROM eclipse-temurin:23-jre-alpine

WORKDIR /app

# Copy the uberjar from builder stage
COPY --from=builder /app/target/*-standalone.jar /app/app.jar

EXPOSE 3000

# Run the application
CMD ["java", \
    # Memory settings
    "-XX:MaxRAMPercentage=75.0", \
    # GC settings
    "-XX:+UseG1GC", \
    "-XX:+UseStringDeduplication", \
    # Container awareness
    "-XX:+UseContainerSupport", \
    # Faster startup
    "-XX:TieredStopAtLevel=1", \
    "-Duser.timezone=UTC", \
    "-jar", "/app/app.jar"]