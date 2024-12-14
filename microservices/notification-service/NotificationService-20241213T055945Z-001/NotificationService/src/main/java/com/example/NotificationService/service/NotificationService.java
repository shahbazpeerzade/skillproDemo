package com.example.NotificationService.service;

import java.util.List;

import com.example.NotificationService.model.Notification;
import com.example.NotificationService.model.NotificationDTO;

public interface NotificationService {

	public void save(NotificationDTO notificationDTO);
	public List<NotificationDTO> findAll();
	public void deleteById(String notificationID);
	public NotificationDTO findById(String notificationID);
	public String generateNotificationId();
	List<NotificationDTO> findNotificationsByUserId(Long userId);

}
