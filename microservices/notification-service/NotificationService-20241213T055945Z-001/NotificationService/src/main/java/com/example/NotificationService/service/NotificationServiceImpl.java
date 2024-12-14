package com.example.NotificationService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.NotificationService.dao.NotificationDao;
import com.example.NotificationService.dao.NotificationRepository;
import com.example.NotificationService.model.Notification;
import com.example.NotificationService.model.NotificationDTO;
@Service
public class NotificationServiceImpl implements NotificationService {
	
	@Autowired
	NotificationDao notificationDao;
	@Autowired
	NotificationRepository notificationRepository;

	@Override
	public void save(NotificationDTO notificationDTO) {
		Notification notification =new Notification(notificationDTO);
		notificationDao.save(notification);

	}

	@Override
	public List<NotificationDTO> findAll() {
		
		
		List<NotificationDTO> notificationList = new ArrayList<>();
		for(Notification notification: notificationDao.findAll()) {
			NotificationDTO notificationDTO = new NotificationDTO(notification);
			notificationList.add(notificationDTO);
			}
		return notificationList;
	}

	@Override
	public void deleteById(String notificationID) {
		notificationDao.delete(notificationID);

	}

	@Override
	public NotificationDTO findById(String notificationID) {
		return new NotificationDTO(notificationDao.findById(notificationID));
	}

	@Override
	public String generateNotificationId() {
		Long val=notificationRepository.findMaxNotificatioonId();
	 	if(val==null)
			val=1001L;
		else
			val=(val+1)+240001;
		String s="N"+String.valueOf(val);
		return s;
	}
	
	
	@Override
	public List<NotificationDTO> findNotificationsByUserId(Long userId) {
	    // Fetch notifications by userId from the repository
	    List<Notification> notifications = notificationRepository.findByUserId(userId);

	    // Convert Notification entities to NotificationDTO objects
	    List<NotificationDTO> notificationDTOs = new ArrayList<>();
	    for (Notification notification : notifications) {
	        notificationDTOs.add(new NotificationDTO(notification));
	    }
	    return notificationDTOs;
	}

	

}
