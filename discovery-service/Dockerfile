FROM openjdk:8-jdk-alpine
MAINTAINER Rihab FEKI <rihab.feki.insat@gmail.com>
ADD target/discovery-service.jar discovery-service.jar
ENTRYPOINT ["java", "-jar", "/discovery-service.jar"]
EXPOSE 8761