package com.consultationappointment.dto;

import lombok.Data;

@Data
public class DoctorSearchRequest {
    private String specialization;
    private String location;
}
