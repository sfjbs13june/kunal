package com.kunal.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/getHospitalDetails")
public class HospitalServiceController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/{hospitalname}")
    public String getPatients(@PathVariable("hospitalname") String hospitalname) {
        System.out.println("Getting Patient details for " + hospitalname);
        String requestUrl="http://patient-service/getPatientDetailsForHospital/"+hospitalname;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<String>(headers);

        ResponseEntity<String> response = restTemplate.exchange(requestUrl,
                HttpMethod.GET, httpEntity,  String.class);
        String patient=response.getBody();

        System.out.println("Response Received as " + patient);

        return "Hospital Name -  " + hospitalname + " \n Patient Details " + patient;
    }
}
