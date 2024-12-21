package com.consultationappointment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consultationappointment.dto.AppointmentRequest;
import com.consultationappointment.dto.AppointmentResponse;
import com.consultationappointment.dto.CancelAppointmentRequest;
import com.consultationappointment.service.AppointmentService;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/book")
    public ResponseEntity<AppointmentResponse> bookAppointment(@RequestBody AppointmentRequest request) {
        AppointmentResponse response = appointmentService.bookAppointment(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/cancel")
    public ResponseEntity<String> cancelAppointment(@RequestBody CancelAppointmentRequest request) {
        String message = appointmentService.cancelAppointment(request);
        return ResponseEntity.ok(message);
    }
}
