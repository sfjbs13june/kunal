#Build

mvn clean install

# Run
```
docker-compose -f docker-compose-mysql.yml up -d

mvn spring-boot:run

docker-compose -f docker-compose-mysql.yml down

```
# training
## Create hospital
curl -X POST \
http://localhost:8080/hospital/save -H 'content-type: application/json' -d '{"hospitalname": "Hospital1","address": "Pune"}'

## Get hospital data
curl -X GET http://localhost:8080/hospital/get

## Delete hospital data
curl -X DELETE http://localhost:8080/hospital/delete?"id"=1

## Create patient
curl -X POST http://localhost:8080/patient/save -H 'content-type: application/json' -d '{"patientname": "patient1","hospitalname": "hospital1","disease": "disease1"}'

## Get patient data
curl -X GET http://localhost:8080/patient/get

## Delete patient data
curl -X DELETE http://localhost:8080/patient/delete?"id"=2

# Getting inside container
docker exec -it <container-id> /bin/bash
mysql -u user -p
show databases;
use db;
show tables;
select * from <table name>;