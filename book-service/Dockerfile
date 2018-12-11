FROM openjdk:8-jdk-alpine
MAINTAINER Rihab FEKI <rihab.feki.insat@gmail.com>
ADD target/book-service.jar book-service.jar.jar
ENTRYPOINT ["java", "-jar", "/book-service.jar.jar"]
EXPOSE 2230