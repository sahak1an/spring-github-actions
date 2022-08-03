FROM registry.access.redhat.com/ubi8/openjdk-17:1.14-3
WORKDIR /opt/app
COPY /target/spring-github-actions-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java","-jar","/opt/app/spring-github-actions-0.0.1-SNAPSHOT.jar"]