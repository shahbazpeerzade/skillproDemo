package com.example.NotificationService.dao;

import java.util.List;


import com.example.NotificationService.model.Notification;

public interface NotificationDao {
	public void save(Notification notification);
	public List<Notification> findAll();
	public Notification findById(String notificationId);
	public void delete(String notificationId);
	

}
