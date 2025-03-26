ARG REGISTRY=""
FROM openjdk:17-jdk-slim


ENV PROJECT_NAME=inventory-service
ENV PROJECT_VERSION=0.0.1-SNAPSHOT

COPY build/libs/${PROJECT_NAME}-${PROJECT_VERSION}.jar inventory.jar

EXPOSE 8081

ENTRYPOINT ["sh","-c","java -jar /inventory.jar --server.port=8081"]