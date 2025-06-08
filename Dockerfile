FROM ubuntu:latest

EXPOSE 8080

LABEL authors="PD"

RUN apt-get update && \
    apt-get install -y openjdk-21-jdk && \
    rm -rf /var/lib/apt/lists/*

COPY target/*.jar /numorology.jar
ENTRYPOINT ["java", "-jar", "/numorology.jar"]
