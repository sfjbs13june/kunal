## Build the app

``` 
mvn clean install
```

## Run the app

``` 
docker-compose -f docker-compose-mongo.yml up -d
mvn spring-boot:run

```
## Creating docker image

```
mvn install dockerfile:build

```
## running docker compose

``` 
docker-compose up -d

```


## Post

``` 
customer:
curl --request POST 'http://localhost:8083/customer/create' --header 'Content-Type: application/json' --data-raw '{"name": "Rama","custId": "1re206","address": "Bangalore"}'

student:
 curl --request POST 'http://localhost:8083/student/create' --header 'Content-Type: application/json' --data-raw '{"name": "Student1","id": "1","roll": "001"}'
```

## Get 

``` 
customer:
curl -X GET http://localhost:8083/customer/read 

student:
curl -X GET http://localhost:8083/student/read

get student by name:
curl -X GET http://localhost:8083/student/read/Student1?"name"="Student1"
```

## Put

``` 
curl -X PUT 'http://localhost:8083/customer/update?custId=1re07&name=Rama' 
```

## Delete

```
curl -X DELETE 'http://localhost:8083/customer/delete?name=Rama' 
```




## Show data

```
docker exec -it spring-mongo-app-mongo-1 bash

mongo

show dbs

show tables

db.customer.find()

```

## Stop docker container
    docker-compose -f docker-compose-mongo.yml down

## Dockerization

### Maven 
Here i am using maven spotify plugin to create the docker image for this application.
Use the below command to create the docker image.
For creating please use your repository to create the image which will be easy to push image in your docker hub.
update in your pom.xml.
<docker.image.prefix> <your repo name> </docker.image.prefix>

```bash
$ mvn install dockerfile:build
```

### Push docker images

```bash
docker login

$ docker push <repository-name>/<app-name>

```

