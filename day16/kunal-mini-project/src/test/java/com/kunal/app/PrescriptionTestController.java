package com.kunal.app;

import com.kunal.app.controller.DoctorController;
import com.kunal.app.controller.PatientController;
import com.kunal.app.controller.PrescriptionController;
import com.kunal.app.model.Prescription;
import com.kunal.app.repository.AppointmentRepository;
import com.kunal.app.repository.PrescriptionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PrescriptionTestController {

    @InjectMocks
    private PrescriptionController prescriptionController;

    @Mock
    private PrescriptionRepository prescriptionRepository;

    @Test
    public void viewPrescriptionTest() {
        Prescription prescription = new Prescription();
        prescription.setPrescriptionId("007");
        prescription.setAppointmentId("7");
        prescription.setPatientName("patient7");
        prescription.setDoctorName("doctor7");
        prescription.setDescription("fever");
        List<Prescription> list = new ArrayList<>();
        list.add(prescription);
        List<Prescription> response = (List<Prescription>) prescriptionController.getprescription("patient7");
        for (Prescription pr: response) {
            assertEquals(prescription.getPrescriptionId(),pr.getPrescriptionId());
            assertEquals(prescription.getAppointmentId(),pr.getAppointmentId());
            assertEquals(prescription.getPatientName(),pr.getPatientName());
            assertEquals(prescription.getDoctorName(),pr.getDoctorName());
            assertEquals(prescription.getDescription(),pr.getDescription());
        }
    }

    @Test
    public void savePrescription() {
        Prescription prescription = new Prescription();
        prescription.setPrescriptionId("007");
        prescription.setAppointmentId("7");
        prescription.setPatientName("patient7");
        prescription.setDoctorName("doctor7");
        prescription.setDescription("fever");
        when(prescriptionRepository.save(prescription)).thenReturn(prescription);
        Prescription response = prescriptionController.saveprescription(prescription);
        assertEquals(prescription,response);
    }
}
