package com.example.NotificationService.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NotificationService.model.Notification;
@Service
public class NotificationDaoImpl implements NotificationDao {

	
	
	@Autowired
	NotificationRepository notificationRepository;
	@Override
	public void save(Notification notification) {
			notificationRepository.save(notification);

	}

	@Override
	public List<Notification> findAll() {
		return notificationRepository.findAll();
	}

	@Override
	public Notification findById(String notificationId) {
		
		return notificationRepository.getById(notificationId);
	}

	@Override
	public void delete(String notificationId) {
		notificationRepository.deleteById(notificationId);

	}
	
}
