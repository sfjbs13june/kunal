package com.kunal.app.controller.unittest;


import com.kunal.app.controller.PatientController;
import com.kunal.app.model.Patient;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class PatientcontrollerTest {
    @InjectMocks
    private PatientController patientController=new PatientController();

    @Test
    public void test_createpatient(){
        Patient patient=new Patient("Patient1",1,"Hospital1","disease1");
        Patient result=patientController.createPatient(patient);
        assertEquals(patient.getPatientname(),result.getPatientname());
        assertEquals(patient.getId(),result.getId());
        assertEquals(patient.getHospitalname(),result.getHospitalname());
        assertEquals(patient.getDisease(),result.getDisease());
    }

    @Test
    public void test_getpatient(){
        Patient patient=new Patient("Patient1",1,"Hospital1","disease1");
        patientController.createPatient(patient);
        Patient result=patientController.getpatient("Patient1");
        assertEquals("Patient1",result.getPatientname());
        assertEquals(1,result.getId());
        assertEquals("Hospital1",result.getHospitalname());
        assertEquals("disease1",result.getDisease());
    }

    @Test
    public void test_updatepatient(){
        Patient patient=new Patient("Patient1",1,"Hospital1","disease1");
        patientController.createPatient(patient);
        Patient result=patientController.updatepatient("Patient1","Hospital2");
        assertEquals("Patient1",result.getPatientname());
        assertEquals(1,result.getId());
        assertEquals("Hospital2",result.getHospitalname());
        assertEquals("disease1",result.getDisease());
    }

    @Test
    public void test_deletepatient(){
        Patient patient=new Patient();
        patient.setPatientname("Patient1");
        patient.setId(1);
        patient.setHospitalname("Hospital1");
        patient.setDisease("disease1");
        patientController.createPatient(patient);
        patientController.deletepatient("Patient1");
        Patient result=patientController.getpatient("Patient1");
        assertNull(result);
    }
}
