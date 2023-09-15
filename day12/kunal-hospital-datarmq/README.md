curl --location --request GET 'http://localhost:8080/hrabbitmq/hdataproducer?hospitalname=hospital1&hid=id1&address=pune'

# Build

    mvn clean install

# Run
    docker-compose -f docker-compose-rabbitmq.yml up -d
    hospital-data-consumer> mvn spring-boot:run

# Test
    send hospital data:
        curl --location --request GET 'http://localhost:8080/hrabbitmq/hdataproducer?hospitalname=hospital1&hid=id1&address=pune'
    send patient data:
    curl --location --request GET 'http://localhost:8080/prabbitmq/pdataproducer?patientname=patient1&pid=id1&hospitalname=hospital1&disease=disease1'
    
    patient-data-consumer> mvn spring-boot:run

# Show data on browser::

    http://localhost:15672/

    user-name:guest
    password:guest


## Stop Container

    docker-compose -f docker-compose-rabbitmq.yml down