FROM eclipse-temurin:17-jre-focal
WORKDIR /opt/app
COPY /target/spring-github-actions-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java","-jar","/opt/app/spring-github-actions-0.0.1-SNAPSHOT.jar"]