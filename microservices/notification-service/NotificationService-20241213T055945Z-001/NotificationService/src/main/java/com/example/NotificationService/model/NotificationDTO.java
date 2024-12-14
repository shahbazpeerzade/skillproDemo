package com.example.NotificationService.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;

public class NotificationDTO {
	private String notificationid;

    
    private Long userId;

    
    private String message; // Notification message content

    
    private String channel; // e.g., EMAIL, SMS, PUSH, etc.

    
    private String deliveryMethod; // e.g., IN_APP, EXTERNAL

    
    private String status; // e.g., UNREAD, READ

    
    private LocalDateTime createdAt; // Timestamp when the notification was created

    private LocalDateTime readAt;

	public String getNotificationid() {
		return notificationid;
	}

	public void setNotificationid(String notificationid) {
		this.notificationid = notificationid;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getDeliveryMethod() {
		return deliveryMethod;
	}

	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getReadAt() {
		return readAt;
	}

	public void setReadAt(LocalDateTime readAt) {
		this.readAt = readAt;
	}

	@Override
	public String toString() {
		return "NotificationDTO [notificationid=" + notificationid + ", userId=" + userId + ", message=" + message
				+ ", channel=" + channel + ", deliveryMethod=" + deliveryMethod + ", status=" + status + ", createdAt="
				+ createdAt + ", readAt=" + readAt + "]";
	}

	public NotificationDTO(String notificationid, Long userId, String message, String channel, String deliveryMethod,
			String status, LocalDateTime createdAt, LocalDateTime readAt) {
		super();
		this.notificationid = notificationid;
		this.userId = userId;
		this.message = message;
		this.channel = channel;
		this.deliveryMethod = deliveryMethod;
		this.status = status;
		this.createdAt = createdAt;
		this.readAt = readAt;
	}

	public NotificationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	public NotificationDTO(Notification notification) {
		super();
		this.notificationid = notification.getNotificationid();
		this.userId = notification.getUserId();
		this.message = notification.getMessage();
		this.channel = notification.getChannel();
		this.deliveryMethod = notification.getDeliveryMethod();
		this.status = notification.getStatus();
		this.createdAt = notification.getCreatedAt();
		this.readAt = notification.getReadAt();
	}


}
