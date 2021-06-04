#
# Build stage
#

#FROM maven:3.6.0-jdk-11-slim AS build
FROM 755242612616.dkr.ecr.us-west-2.amazonaws.com/maven:latest AS build
RUN mkdir -p /opt/poc-spring-app
COPY . /opt/poc-spring-app
RUN mvn -f /opt/poc-spring-app/pom.xml clean package -Dmaven.test.skip=true

#
# Package stage
#
# Linux with OpenJDK JRE
#FROM openjdk:11.0.8-jre-slim-buster
FROM 755242612616.dkr.ecr.us-west-2.amazonaws.com/ubuntu:latest
WORKDIR /opt/poc-spring-app
COPY --from=build /opt/poc-spring-app/target/poc-spring-app-1.0.jar target/poc-spring-app-1.0.jar
CMD java -Dserver.port=8080 -jar target/poc-spring-app-1.0.jar