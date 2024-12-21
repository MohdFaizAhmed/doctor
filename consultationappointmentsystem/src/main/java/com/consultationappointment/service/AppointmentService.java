package com.consultationappointment.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.consultationappointment.dto.AppointmentRequest;
import com.consultationappointment.dto.AppointmentResponse;
import com.consultationappointment.dto.CancelAppointmentRequest;
import com.consultationappointment.entity.Appointment;
import com.consultationappointment.repo.AppointmentRepository;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public AppointmentResponse bookAppointment(AppointmentRequest request) {
        Appointment appointment = new Appointment();
        appointment.setDoctorId(request.getDoctorId());
        appointment.setUserId(request.getUserId());
        appointment.setAppointmentTime(request.getAppointmentTime());
        appointment.setStatus("BOOKED");

        Appointment savedAppointment = appointmentRepository.save(appointment);

        return mapToResponse(savedAppointment);
    }

    public String cancelAppointment(CancelAppointmentRequest request) {
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(request.getAppointmentId());

        if (optionalAppointment.isEmpty()) {
            throw new RuntimeException("Appointment not found");
        }

        Appointment appointment = optionalAppointment.get();
        appointment.setStatus("CANCELLED");
        appointmentRepository.save(appointment);

        return "Appointment cancelled successfully";
    }

    private AppointmentResponse mapToResponse(Appointment appointment) {
        AppointmentResponse response = new AppointmentResponse();
        response.setId(appointment.getId());
        response.setDoctorId(appointment.getDoctorId());
        response.setUserId(appointment.getUserId());
        response.setAppointmentTime(appointment.getAppointmentTime());
        response.setStatus(appointment.getStatus());
        return response;
    }
}
