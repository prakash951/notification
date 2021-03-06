package com.retail.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.retail.notification.entity.Notification;
import com.retail.notification.service.NotificationService;

@RestController
public class NotificationController {

	@Autowired
	NotificationService myNotificationService;

	@PostMapping("/notify")
	public ResponseEntity<String> notifyUser(@RequestBody Notification notification) {
		myNotificationService.sendNotification(notification);
		return ResponseEntity.ok("{\"message\":\"Notified all the channels\"}");
	}

}
