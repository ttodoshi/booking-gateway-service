FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn package

FROM openjdk:21-jdk-slim

WORKDIR /app
COPY --from=build /app/target/booking-gateway-service-0.0.1-SNAPSHOT.jar /app

EXPOSE 8443

CMD ["java", "-jar", "booking-gateway-service-0.0.1-SNAPSHOT.jar"]
