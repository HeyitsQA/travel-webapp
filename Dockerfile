#
# Build stage
#
FROM gradle:9-jdk25 AS build
WORKDIR /home/gradle/project
COPY --chown=gradle:gradle . .
RUN gradle build --no-daemon

LABEL org.name="QuynhAnhHieuMinh"
#
# Package stage
#
FROM eclipse-temurin:25-jdk-jammy
COPY --from=build /home/gradle/project/build/libs/web-app-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]