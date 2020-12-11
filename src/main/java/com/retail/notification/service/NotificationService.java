package com.retail.notification.service;

import org.apache.camel.CamelExecutionException;
import org.apache.camel.Handler;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.retail.notification.entity.Notification;

@Service
public class NotificationService {

	@Produce(value = "direct:notify")
	private ProducerTemplate producer;

	@Produce(value = "direct:slack")
	private ProducerTemplate slackProducer;

	@Produce(value = "direct:mail")
	private ProducerTemplate mailProducer;

	@Autowired
	private ObjectMapper mapper;

	@Handler
	public void sendNotification(Notification notification) {
		

		try {
			producer.sendBody(notification);
			slackProducer.sendBody(mapper.writeValueAsString(notification));
			mailProducer.sendBody(mapper.writeValueAsString(notification));
		} catch (CamelExecutionException | JsonProcessingException e) {
			e.printStackTrace();
		}
	}

}
