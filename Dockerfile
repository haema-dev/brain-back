# Start with a base image containing Java runtime (JDK 17)
FROM openjdk:17-jdk-alpine

# The application's jar file
ARG JAR_FILE=build/libs/*.jar

# Add the application's jar to the container
COPY ${JAR_FILE} brain-back.jar

# Make port 8081 available to the world outside this container
EXPOSE 8081

# Run the jar file
ENTRYPOINT ["java","-jar","/brain-back.jar"]