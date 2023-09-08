package com.kunal.app.controller;

import com.kunal.app.model.Hospital;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HospitalController {
    Map<String, Hospital> hospitalMap= new HashMap<String,Hospital>();

    @PostMapping("save/hospital")
    public Hospital createHospital(@RequestBody Hospital hospital){
        hospitalMap.put(hospital.getHospitalname(),hospital);
        return hospital;
    }

    @GetMapping("get/hospital")
    public Hospital gethospital(@RequestParam("hospitalname") String hospitalname){
        return hospitalMap.get(hospitalname);
    }

    @PutMapping("update/hospital")
    public Hospital updatehospital(@RequestParam("hospitalname") String hospitalname,@RequestParam("address") String address){
        Hospital hospital= hospitalMap.get(hospitalname);
        hospital.setAddress(address);
        hospitalMap.put(hospitalname,hospital);
        return hospital;
    }

    @DeleteMapping("delete/hospital")
    public void deletehospital(@RequestParam("hospitalname") String hospitalname){
        hospitalMap.remove(hospitalname);
    }
}
