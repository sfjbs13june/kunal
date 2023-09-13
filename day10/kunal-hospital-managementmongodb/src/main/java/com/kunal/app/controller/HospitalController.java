package com.kunal.app.controller;

import com.kunal.app.model.Hospital;
import com.kunal.app.repository.HopsitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/hospital")
public class HospitalController {
    @Autowired
    HopsitalRepository hopsitalRepository;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public @ResponseBody
    String createHospital(@RequestBody final Hospital hospital){
        hopsitalRepository.save(hospital);
        return "saved";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public @ResponseBody
    List<Hospital> getAll() {
        return hopsitalRepository.findAll();
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void modifyByID(@RequestParam int id, @RequestParam String address) {
        Hospital hospital = hopsitalRepository.findById(id);
        hospital.setAddress(address);
        hopsitalRepository.save(hospital);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public @ResponseBody
    String store(@RequestParam int id)  {
        hopsitalRepository.deleteById(id);
        return "deleted";
    }
}
