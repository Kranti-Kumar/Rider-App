# Use a lightweight base image with Java 21 (Corretto 21 is suggested in buildspec.yml)
FROM public.ecr.aws/docker/library/eclipse-temurin:21-jre-alpine

# Define the build argument for the JAR file name
# Note: Spring Boot Maven plugin creates JAR with artifactId as prefix
ARG JAR_FILE=target/uberApp-0.0.1-SNAPSHOT.jar

# Add the application JAR to the container
COPY ${JAR_FILE} app.jar

# Expose the application port (default for Spring Boot)
EXPOSE 8080

# Run the JAR file, passing the production profile
ENTRYPOINT ["java", "-jar", "/app.jar", "--spring.profiles.active=prod"]