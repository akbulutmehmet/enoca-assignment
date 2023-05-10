FROM openjdk:11
WORKDIR /app
COPY target/enoca-assignment-1.0.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]