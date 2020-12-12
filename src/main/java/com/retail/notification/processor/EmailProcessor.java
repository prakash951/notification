package com.retail.notification.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.retail.notification.entity.Notification;

@Component
public class EmailProcessor implements Processor {

	@Autowired
	private ObjectMapper mapper;

	public void process(Exchange exchange) throws Exception {
		Notification notification = exchange.getIn().getBody(Notification.class);
		String subject = notification.getSubject();
		String to = notification.getTo();

		exchange.getIn().setHeader("subject", subject);
		exchange.getIn().setHeader("to", to);
		exchange.getIn().setBody(mapper.writeValueAsString(notification));
	}

}
