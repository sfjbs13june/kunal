package com.kunal.app;

import com.kunal.app.controller.DoctorController;
import com.kunal.app.model.Appointment;
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
public class DoctorTestController {

    @InjectMocks
    private DoctorController doctorController;

    @Mock
    private AppointmentRepository appointmentRepository;

    @Mock
    private PrescriptionRepository prescriptionRepository;

    @Test
    public void getDoctorAppointmentTest() {
        Prescription prescription = new Prescription();
        prescription.setPrescriptionId("1");
        prescription.setAppointmentId("001");
        prescription.setDoctorName("doctor1");
        prescription.setPatientName("patient1");
        prescription.setDescription("fever");
        Appointment appointment = new Appointment();
        appointment.setAppointmentID("002");
        appointment.setDoctorName("doctor2");
        appointment.setPatientName("patient2");
        appointment.setDate("07-05-2000");
        appointment.setPrescription(prescription);
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(appointment);
        List<Appointment> result = (List<Appointment>) doctorController.getAppointment("doctor2");
        for (Appointment appointment1 : result) {
            assertEquals(appointment.getAppointmentID(), appointment1.getAppointmentID());
            assertEquals(appointment.getPatientName(), appointment1.getPatientName());
            assertEquals(appointment.getDoctorName(), appointment1.getDoctorName());
            assertEquals(appointment.getDate(), appointment1.getDate());
            assertEquals(appointment.getPrescription(), appointment1.getPrescription());
        }
    }

    @Test
    public void saveDoctorAppointmentTest() {
        Prescription prescription = new Prescription();
        prescription.setPrescriptionId("1");
        prescription.setAppointmentId("001");
        prescription.setDoctorName("doctor1");
        prescription.setPatientName("patient1");
        prescription.setDescription("fever");
        Appointment appointment = new Appointment();
        appointment.setAppointmentID("002");
        appointment.setDoctorName("doctor2");
        appointment.setPatientName("patient2");
        appointment.setDate("07-05-2000");
        appointment.setPrescription(prescription);
        when(appointmentRepository.save(appointment)).thenReturn(appointment);
        Appointment response = doctorController.saveAppointment(appointment);
        assertEquals(appointment,response);
    }
}
