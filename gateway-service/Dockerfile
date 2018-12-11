FROM openjdk:8-jdk-alpine
MAINTAINER Rihab FEKI <rihab.feki.insat@gmail.com>
ADD target/gateway-service.jar gateway-service.jar
ENTRYPOINT ["java", "-jar", "/gateway-service.jar"]
EXPOSE 8765