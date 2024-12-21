package com.consultationappointment.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AppointmentResponse {
    private Long id;
    private Long doctorId;
    private Long userId;
    private LocalDateTime appointmentTime;
    private String status;
}
