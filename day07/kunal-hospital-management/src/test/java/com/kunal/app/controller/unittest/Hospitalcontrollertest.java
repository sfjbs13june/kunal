package com.kunal.app.controller.unittest;

import com.kunal.app.controller.HospitalController;
import com.kunal.app.model.Hospital;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class Hospitalcontrollertest {
    @InjectMocks
    private HospitalController hospitalController=new HospitalController();

    @Test
    public void test_createhospital(){
        Hospital hospital=new Hospital("Hospital1","Pune",1);
        Hospital result=hospitalController.createHospital(hospital);
        assertEquals(hospital.getHospitalname(),result.getHospitalname());
        assertEquals(hospital.getAddress(),result.getAddress());
        assertEquals(hospital.getId(),result.getId());
    }

    @Test
    public void test_gethospital(){
        Hospital hospital=new Hospital("Hospital1","Pune",1);
        hospitalController.createHospital(hospital);
        Hospital result=hospitalController.gethospital("Hospital1");
        assertEquals("Hospital1",result.getHospitalname());
        assertEquals("Pune",result.getAddress());
        assertEquals(1,result.getId());
    }

    @Test
    public void test_updatehospital(){
        Hospital hospital=new Hospital("Hospital1","Pune",1);
        hospitalController.createHospital(hospital);
        Hospital result=hospitalController.updatehospital("Hospital1","Mumbai");
        assertEquals("Hospital1",result.getHospitalname());
        assertEquals("Mumbai",result.getAddress());
        assertEquals(1,result.getId());
    }

    @Test
    public void test_deletehospital(){
        Hospital hospital=new Hospital();
        hospital.setHospitalname("Hospital1");
        hospital.setAddress("Pune");
        hospital.setId(1);
        hospitalController.createHospital(hospital);
        hospitalController.deletehospital("Hospital1");
        Hospital result=hospitalController.gethospital("Hospital1");
        assertNull(result);
    }

}
