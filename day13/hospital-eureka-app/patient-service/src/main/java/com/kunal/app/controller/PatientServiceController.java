package com.kunal.app.controller;

import com.kunal.app.dto.Patient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PatientServiceController {
    private static Map<String, List<Patient>> hospitalDB = new HashMap<String, List<Patient>>();

    static {
        hospitalDB = new HashMap<String, List<Patient>>();

        List<Patient> lst = new ArrayList<Patient>();
        Patient patient = new Patient("1", "Patient1","Disease1");
        lst.add(patient);
        patient = new Patient("2", "Patient2","Disease2");
        lst.add(patient);

        hospitalDB.put("Hospital1", lst);

        lst = new ArrayList<Patient>();
        patient = new Patient("3", "Patient3","Disease3");
        lst.add(patient);
        patient = new Patient("4", "Patient4","Disease4");
        lst.add(patient);

        hospitalDB.put("Hospital2", lst);

    }

    @RequestMapping(value = "/getPatientDetailsForHospital/{hospitalname}", method = RequestMethod.GET)
    public List<Patient> getPatients(@PathVariable String hospitalname) {
        System.out.println("Getting Patient details for " + hospitalname);

        List<Patient> patientList = hospitalDB.get(hospitalname);
        if (patientList == null) {
            patientList = new ArrayList<Patient>();
            Patient patient = new Patient("Not Found", "N/A","N/A");
            patientList.add(patient);
        }
        return patientList;
    }

}
