Build application
mvn clean install

Run Application
mvn spring-boot:run

Create docker image
mvn install dockerfile:build

Run docker image
docker run -p 8080:8080 kunal7/docker-kinfo-app:0.0.1-SNAPSHOT