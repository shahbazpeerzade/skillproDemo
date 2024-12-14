package com.example.NotificationService.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.NotificationService.dao.NotificationRepository;
import com.example.NotificationService.model.NotificationDTO;
import com.example.NotificationService.service.NotificationService;

@RestController
public class NotifiactionController {
	@Autowired
	NotificationService notificationService;
	
	@GetMapping(value="/notification",produces=MediaType.APPLICATION_JSON_VALUE)
	 public List<NotificationDTO> showAll(){
			
			return notificationService.findAll();
		}
	
	@PostMapping(value="/notification",consumes=MediaType.APPLICATION_JSON_VALUE)
    public String createNotification(@RequestBody NotificationDTO notificationDTO) {
        notificationDTO.setNotificationid(notificationService.generateNotificationId());
		notificationDTO.setCreatedAt(LocalDateTime.now());
        notificationDTO.setStatus("UNREAD");
       notificationService.save(notificationDTO);
       return "notification posted";
    }
	
	
	
	@PutMapping(value="/notification/{notificationId}",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String edit(@PathVariable String notificationId,@RequestBody NotificationDTO notificationDTO) {
		NotificationDTO Editnotification=notificationService.findById(notificationId);
		
		notificationService.save(Editnotification);
		return "notifiactionEdited ";
	}
	
	
	 @DeleteMapping(value="notification/{notificationId}",consumes=MediaType.APPLICATION_JSON_VALUE)
	    public void deleteNotification(@PathVariable String id) {
	        notificationService.deleteById(id);
	    }
	 
	 
	 @GetMapping(value = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<List<NotificationDTO>> getNotificationsByUserId(@PathVariable Long userId) {
	        // Fetch notifications using the userId
	        List<NotificationDTO> notifications = notificationService.findNotificationsByUserId(userId);

	        // Return the response
	        return ResponseEntity.ok(notifications);
	    }
}
