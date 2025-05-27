FROM gradle:8.0-jdk17 AS build
WORKDIR /app
COPY --chown=gradle:gradle . .
RUN chmod +x ./gradlew && ./gradlew build --no-daemon

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
