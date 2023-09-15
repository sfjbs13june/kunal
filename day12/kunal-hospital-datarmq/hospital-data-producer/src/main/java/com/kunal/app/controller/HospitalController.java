package com.kunal.app.controller;


import com.kunal.app.model.Hospital;
import com.kunal.app.service.RabbitMQHospitalSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hrabbitmq")
public class HospitalController {
    @Autowired
    RabbitMQHospitalSender rabbitMQHospitalSender;

    @GetMapping(value = "/hdataproducer")
    public String hproducer(@RequestParam("hospitalname") String hospitalname, @RequestParam("hid") String hid, @RequestParam("address") String address) {

        Hospital hospital=new Hospital();
        hospital.setHospitalname(hospitalname);
        hospital.setHid(hid);
        hospital.setAddress(address);
        rabbitMQHospitalSender.hsend(hospital);

        return "Hospital data sent Successfully";
    }

    @PostMapping(value = "/hospital")
    public String postHospital(@RequestBody Hospital hospital) {

        rabbitMQHospitalSender.hsend(hospital);

        return "Hospital data sent Successfully";
    }
}
