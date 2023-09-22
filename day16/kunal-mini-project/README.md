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

## getting prescrition data

    curl --location --request GET 'http://localhost:8081/prescription/viewprescription?patientName=patient5' \
    --header 'Authorization: Basic ZG9jdG9yMTpwYXNzd29yZA==' \
    --header 'Cookie: JSESSIONID=96F4C5735C0264AA0881E426F096DE75'

## posting prescription data
    curl --location --request POST 'http://localhost:8081/prescription/viewprescription?patientName=patient5' \
    --header 'Authorization: Basic ZG9jdG9yMTpwYXNzd29yZA==' \
    --header 'Content-Type: application/json' \
    --header 'Cookie: JSESSIONID=96F4C5735C0264AA0881E426F096DE75' \
    --data-raw '{
      "prescriptionId": "5",
      "appointmentId": "005",
      "description": "fever",
      "patientName": "patient5",
      "doctorName": "doctor5"
    }'

## Save Patient
    curl --location --request POST 'http://localhost:8081/patient/save' \
    --header 'Authorization: Basic cGF0aWVudDE6cGFzc3dvcmQ=' \
    --header 'Content-Type: application/json' \
    --header 'Cookie: JSESSIONID=96F4C5735C0264AA0881E426F096DE75' \
    --data-raw '{
      "appointmentID": "1",
      "patientName": "p1",
      "doctorName": "d1",
      "date": "20-07-2022",
      "prescription": {
        "prescriptionId": "04",
        "appointmentId": "4",
        "description": "fever",
        "patientName": "pat2",
        "doctorName": "doc2"
      }
    }'

## get Patient appointment
    curl --location --request GET 'http://localhost:8081/patient/myappointments?patientName=pat1' \
    --header 'Authorization: Basic cGF0aWVudDE6cGFzc3dvcmQ=' \
    --header 'Cookie: JSESSIONID=96F4C5735C0264AA0881E426F096DE75'

## Post doctor details
    curl --location --request POST 'http://localhost:8081/doctor/save' \
    --header 'Authorization: Basic ZG9jdG9yMTpwYXNzd29yZA==' \
    --header 'Content-Type: application/json' \
    --header 'Cookie: JSESSIONID=96F4C5735C0264AA0881E426F096DE75' \
    --data-raw '{
      "appointmentID": "1",
      "patientName": "p1",
      "doctorName": "d1",
      "date": "20-07-2022",
      "prescription": {
        "prescriptionId": "04",
        "appointmentId": "4",
        "description": "fever",
        "patientName": "pat2",
        "doctorName": "doc2"
      }
    }'
## Get doctor details:
    curl --location --request GET 'http://localhost:8081/doctor/doctorappointment?doctorName=d1' \
    --header 'Authorization: Basic ZG9jdG9yMTpwYXNzd29yZA==' \
    --header 'Cookie: JSESSIONID=96F4C5735C0264AA0881E426F096DE75'
 
## Enter mongo Container   
    docker exec -it <container-id> /bin/bash
    mongo
    show dbs;
    db.hospital.find()
    db.patient.find()

## Swagger UI
    http://localhost:8081/swagger-ui/index.html