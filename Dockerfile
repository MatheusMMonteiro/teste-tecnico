# Build stage
FROM maven:3.6.0-jdk-11-slim AS build
WORKDIR /build
COPY pom.xml .
COPY src ./src
RUN mvn clean package

# Package stage
FROM tomcat:9.0.56-jdk11-openjdk-slim
COPY --from=build /build/target/tech-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/API.war
EXPOSE 8080
CMD ["catalina.sh", "run"]
