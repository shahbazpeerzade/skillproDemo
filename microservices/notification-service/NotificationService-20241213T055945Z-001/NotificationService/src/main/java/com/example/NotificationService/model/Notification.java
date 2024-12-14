package com.example.NotificationService.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Notification {

	@Id
    private String notificationid;

    @Column(nullable = false)
    private Long userId; // ID of the user to whom the notification is sent

    @Column(nullable = false)
    private String message; // Notification message content

    @Column(nullable = false)
    private String channel; // e.g., EMAIL, SMS, PUSH, etc.

    @Column(nullable = false)
    private String deliveryMethod; // e.g., IN_APP, EXTERNAL

    @Column(nullable = false)
    private String status; // e.g., UNREAD, READ

    @Column(nullable = false, updatable = false)
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
		return "Notification [notificationid=" + notificationid + ", userId=" + userId + ", message=" + message
				+ ", channel=" + channel + ", deliveryMethod=" + deliveryMethod + ", status=" + status + ", createdAt="
				+ createdAt + ", readAt=" + readAt + "]";
	}

	public Notification(String notificationid, Long userId, String message, String channel, String deliveryMethod,
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

	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	public Notification(NotificationDTO notificationDTO) {
		super();
		this.notificationid =notificationDTO.getNotificationid();
		this.userId = notificationDTO.getUserId();
		this.message = notificationDTO.getMessage();
		this.channel = notificationDTO.getChannel();
		this.deliveryMethod = notificationDTO.getDeliveryMethod();
		this.status = notificationDTO.getStatus();
		this.createdAt = notificationDTO.getCreatedAt();
		this.readAt = notificationDTO.getReadAt();
	}
}
