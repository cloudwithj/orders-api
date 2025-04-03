FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY target/orders-api-1.0-SNAPSHOT.jar orders-api.jar
ENTRYPOINT ["java", "-jar", "/app/orders-api.jar"]