FROM eclipse-temurin:17-jre-focal
WORKDIR /opt/app
COPY /target/spring-github-actions-0.0.1-SNAPSHOT.jar .
RUN apt-get update && \
    apt-get -y --no-install-recommends install curl \
        ca-certificates && \
    curl https://raw.githubusercontent.com/gadiener/docker-images-size-benchmark/master/main.go -o main.go && \
    apt-get purge -y curl \
        ca-certificates && \
    apt-get autoremove -y && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/* \
EXPOSE 8080
ENTRYPOINT ["java","-jar","/opt/app/spring-github-actions-0.0.1-SNAPSHOT.jar"]