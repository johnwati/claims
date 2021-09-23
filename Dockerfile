# FROM openjdk
FROM openjdk:8-jdk-alpine
MAINTAINER WAKE TECHNOLOGIES LTD <alberto.isaboke@wake.co.ke>
ADD target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8310