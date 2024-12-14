package com.example.NotificationService.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.NotificationService.model.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, String> {
	@Query("select count(notificationid) from Notification")
    public Long findMaxNotificatioonId();
    List<Notification> findByUserId(Long userId);
}
