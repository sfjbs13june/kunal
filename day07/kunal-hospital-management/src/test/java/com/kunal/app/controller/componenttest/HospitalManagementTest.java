package com.kunal.app.controller.componenttest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.kunal.app.controller.HospitalController;
import com.kunal.app.controller.PatientController;
import com.kunal.app.model.Hospital;
import com.kunal.app.model.Patient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest({HospitalController.class, PatientController.class})
@ActiveProfiles(value = "test")
public class HospitalManagementTest {
    @Autowired
    private MockMvc mockMvc;

    @Value("${hospital.create.url}")
    String create_url;
    @Value("${hospital.read.url}")
    String read_url;
    @Value("${hospital.update.url}")
    String update_url;
    @Value("${hospital.delete.url}")
    String delete_url;
    @Value("${patient.create.url}")
    String createp_url;
    @Value("${patient.read.url}")
    String readp_url;
    @Value("${patient.update.url}")
    String updatep_url;
    @Value("${patient.delete.url}")
    String deletep_url;

    @Test
    public void test_savehospital() throws Exception {
        Hospital hospital = new Hospital("hospital1","pune",1);
        ResultActions resultActions=mockMvc.perform(post(create_url).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(hospital)).accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string=resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Hospital result = g.fromJson(result_string, Hospital.class);
        assertEquals("hospital1",result.getHospitalname());
        assertEquals("pune",result.getAddress());
        assertEquals(1,result.getId());
    }

    @Test
    public void test_gethospital() throws Exception {
        Hospital hospital = new Hospital("hospital1","pune",1);
        ResultActions resultActions_create=mockMvc.perform(post(create_url).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(hospital)).accept(MediaType.APPLICATION_JSON));
        resultActions_create.andExpect(status().isOk());
        ResultActions resultActions=mockMvc.perform(get(read_url).param("hospitalname","hospital1").accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string=resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Hospital result = g.fromJson(result_string, Hospital.class);
        assertEquals("hospital1",result.getHospitalname());
        assertEquals("pune",result.getAddress());
        assertEquals(1,result.getId());
    }

    @Test
    public void test_updatehospital() throws Exception {
        Hospital hospital = new Hospital("hospital1","pune",1);
        ResultActions resultActions_create=mockMvc.perform(post(create_url).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(hospital)).accept(MediaType.APPLICATION_JSON));
        resultActions_create.andExpect(status().isOk());
        ResultActions resultActions=mockMvc.perform(put(update_url)
                .param("hospitalname","hospital1")
                .param("address","mumbai")
                .accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string=resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Hospital result = g.fromJson(result_string, Hospital.class);
        assertEquals("hospital1",result.getHospitalname());
        assertEquals("mumbai",result.getAddress());
        assertEquals(1,result.getId());
    }

    @Test
    public void test_deletehospital() throws Exception {
        Hospital hospital = new Hospital("hospital1","pune",1);
        ResultActions resultActions_create=mockMvc.perform(post(create_url).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(hospital)).accept(MediaType.APPLICATION_JSON));
        resultActions_create.andExpect(status().isOk());
        ResultActions resultActions=mockMvc.perform(delete(delete_url).param("hospitalname", "hospital1").contentType(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string=resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Hospital result = g.fromJson(result_string, Hospital.class);
        assertNull(result);

    }

    @Test
    public void test_savepatient() throws Exception {
        Patient patient = new Patient("patient1",1,"hospital1","disease1");
        ResultActions resultActions=mockMvc.perform(post(createp_url).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(patient)).accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string=resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Patient result = g.fromJson(result_string, Patient.class);
        assertEquals("patient1",result.getPatientname());
        assertEquals(1,result.getId());
        assertEquals("hospital1",result.getHospitalname());
        assertEquals("disease1",result.getDisease());
    }

    @Test
    public void test_getpatient() throws Exception {
        Patient patient = new Patient("patient1",1,"hospital1","disease1");
        ResultActions resultActions_create=mockMvc.perform(post(createp_url).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(patient)).accept(MediaType.APPLICATION_JSON));
        resultActions_create.andExpect(status().isOk());
        ResultActions resultActions=mockMvc.perform(get(readp_url).param("patientname","patient1").accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string=resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Patient result = g.fromJson(result_string, Patient.class);
        assertEquals("patient1",result.getPatientname());
        assertEquals(1,result.getId());
        assertEquals("hospital1",result.getHospitalname());
        assertEquals("disease1",result.getDisease());
    }

    @Test
    public void test_updatepatient() throws Exception {
        Patient patient = new Patient("patient1",1,"hospital1","disease1");
        ResultActions resultActions_create=mockMvc.perform(post(createp_url).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(patient)).accept(MediaType.APPLICATION_JSON));
        resultActions_create.andExpect(status().isOk());
        ResultActions resultActions=mockMvc.perform(put(updatep_url)
                .param("patientname","patient1")
                .param("hospitalname","newHospital")
                .accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string=resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Patient result = g.fromJson(result_string, Patient.class);
        assertEquals("patient1",result.getPatientname());
        assertEquals(1,result.getId());
        assertEquals("newHospital",result.getHospitalname());
        assertEquals("disease1",result.getDisease());
    }

    @Test
    public void test_deletepatient() throws Exception {
        Patient patient = new Patient("patient1",1,"hospital1","disease1");
        ResultActions resultActions_create=mockMvc.perform(post(createp_url).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(patient)).accept(MediaType.APPLICATION_JSON));
        resultActions_create.andExpect(status().isOk());
        ResultActions resultActions=mockMvc.perform(delete(deletep_url).param("patientname", "patient1").contentType(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string=resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Patient result = g.fromJson(result_string, Patient.class);
        assertNull(result);

    }

    private String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
