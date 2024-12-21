package com.consultationappointment.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultationappointment.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findBySpecializationContainingIgnoreCaseAndLocationContainingIgnoreCase(String specialization, String location);
}
