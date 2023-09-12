package com.kunal.app.controller;

import com.kunal.app.model.Hospital;
import com.kunal.app.repository.HopsitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/hospital")
public class HospitalController {
    @Autowired
    HopsitalRepository hopsitalRepository;

    @PostMapping("/save")
    public @ResponseBody
    String createHospital(@RequestBody final Hospital hospital){
        hopsitalRepository.save(hospital);
        return "saved";
    }

    @GetMapping("/get")
    public @ResponseBody
    Iterable<Hospital> getAll() {
        return hopsitalRepository.findAll();
    }

    @DeleteMapping("/delete")
    public @ResponseBody
    String store(@RequestParam("id") final int id) {
        hopsitalRepository.deleteById(id);
        return "deleted";
    }
}
