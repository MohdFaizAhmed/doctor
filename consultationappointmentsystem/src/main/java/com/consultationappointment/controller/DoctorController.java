package com.consultationappointment.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.consultationappointment.dto.DoctorResponse;
import com.consultationappointment.service.DoctorService;

@RestController
@RequestMapping("/api/doctors")
@CrossOrigin("*")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<DoctorResponse>> searchDoctors(
            @RequestParam(required = false) String specialization,
            @RequestParam(required = false) String location) {
        List<DoctorResponse> doctors = doctorService.searchDoctors(specialization, location);
        return ResponseEntity.ok(doctors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorResponse> getDoctorById(@PathVariable Long id) {
        DoctorResponse doctor = doctorService.getDoctorById(id);
        return ResponseEntity.ok(doctor);
    }
}
