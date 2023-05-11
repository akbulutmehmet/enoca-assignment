FROM openjdk:11-jdk-slim
WORKDIR /app
COPY  enoca-assignment-1.0.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]