FROM openjdk:17-jdk-slim
MAINTAINER com.nikiforov.bank
COPY build/libs/bank-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
#docker build -t bank .