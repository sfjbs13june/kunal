#Build

mvn clean install

# Run
```
docker-compose -f docker-compose-mongo.yml up -d

mvn spring-boot:run

docker-compose -f docker-compose-mongo.yml down

```
# training
## Create hospital
curl -X POST \
http://localhost:8083/hospital/save -H 'content-type: application/json' -d '{"hospitalname": "Hospital1","address": "Pune","id":"1"}'

## Get hospital data
curl -X GET http://localhost:8083/hospital/get

## update hospital address
curl -X PUT 'http://localhost:8083/hospital/update?id=1&address=Delhi

## Delete hospital data
curl -X DELETE http://localhost:8083/hospital/delete?"id"=1

## Create patient
curl -X POST http://localhost:8083/patient/save -H 'content-type: application/json' -d '{"patientname": "patient1","hospitalname": "hospital1","disease": "disease1","id": "1"}'

## Get patient data
curl -X GET http://localhost:8083/patient/get

## Update patient data
curl --location --request PUT 'http://localhost:8083/patient/update?pid=1&hospitalname=new'

## Delete patient data
curl -X DELETE http://localhost:8083/patient/delete?"id"=1

# Getting inside container
docker exec -it spring-mongo-app-mongo-1 bash
mongo
show dbs;
show tables;
db.hospital.find()
db.patient.find()