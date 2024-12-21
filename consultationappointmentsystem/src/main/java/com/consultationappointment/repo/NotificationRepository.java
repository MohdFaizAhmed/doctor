package com.consultationappointment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultationappointment.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
