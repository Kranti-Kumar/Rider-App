# Stage 1: Build the application (using a Maven image)
FROM maven:3.9-eclipse-temurin-21-alpine AS builder
WORKDIR /app
# Copy pom.xml and source code
COPY pom.xml .
COPY . .

# Build the project, generating the JAR in /app/target/
# The JAR name is uberApp-0.0.1-SNAPSHOT.jar based on your pom.xml artifactId
RUN mvn clean package -DskipTests

# Stage 2: Create the final, lean runtime image
# Use the same base JRE image as before
FROM public.ecr.aws/docker/library/eclipse-temurin:21-jre-alpine

# Define the JAR file name
ARG JAR_FILE=uberApp-0.0.1-SNAPSHOT.jar

# Copy the built JAR from the 'builder' stage into the final image
COPY --from=builder /app/target/${JAR_FILE} app.jar

# Expose the application port (default for Spring Boot)
EXPOSE 8080

# Run the JAR file, passing the production profile
ENTRYPOINT ["java", "-jar", "/app.jar", "--spring.profiles.active=prod"]