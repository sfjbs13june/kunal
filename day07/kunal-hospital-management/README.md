### Build Application
    mvn clean install

### Run the application
    mvn spring-boot:run

### Create hospital profile
    curl --location --request POST 'http://localhost:8080/save/hospital' \
    --header 'Content-Type: application/json' \
    --data-raw '{
    "hospitalname":"hospital1",
    "address":"Pune",
    "id":1
    }'

### read hospital details
    curl --location --request GET 'http://localhost:8080/get/hospital?hospitalname=hospital1'

### update hospital address
    curl --location --request PUT 'http://localhost:8080/update/hospital?hospitalname=hospital1&address=Delhi'

### delete hospital details
    curl --location --request DELETE 'http://localhost:8080/delete/hospital?hospitalname=hospital1'

-----------------------------------------------------------------------------------------------------------------------------

### Create patient profile
    curl --location --request POST 'http://localhost:8080/save/patient' \
    --header 'Content-Type: application/json' \
    --data-raw '{
    "patientname":"patient1",
    "id":1,
    "hospitalname":"hospital1",
    "disease":"Disease1"
    }

### read patient details
    curl --location --request GET 'http://localhost:8080/get/patient?patientname=patient1'

### update patient hospital name
    curl --location --request PUT 'http://localhost:8080/update/patient?patientname=patient1&hospitalname=new'

### delete patient details
    curl --location --request DELETE 'http://localhost:8080/delete/patient?patientname=patient1'