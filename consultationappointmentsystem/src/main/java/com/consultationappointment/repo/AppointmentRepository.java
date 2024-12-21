package com.consultationappointment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultationappointment.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
