package com.kunal.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/getHospitalDetails/{hospitalname}", method = RequestMethod.GET)
    public String getStudents(@PathVariable String hospitalname) {
        System.out.println("Getting Hospital details for " + hospitalname);
        String response = restTemplate.exchange("http://hospital-service/getHospitalDetails/{hospitalname}",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
                }, hospitalname).getBody();

        System.out.println("Response Received as " + response);

        return "Hospital Name -  " + hospitalname + " \n Patient Details " + response;
    }


}
