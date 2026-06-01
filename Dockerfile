#
# Build stage
#
FROM gradle:8.13-jdk21 AS build
WORKDIR /home/gradle/project
COPY --chown=gradle:gradle . .
RUN gradle build --no-daemon -x test

#
# Package stage
#
FROM eclipse-temurin:21-jdk-jammy
LABEL org.name="QuynhAnhHieuMinh"
COPY --from=build /home/gradle/project/build/libs/web-app-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]