package com.retail.notification.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.retail.notification.processor.EmailProcessor;

@Component
public class EmailRoute extends RouteBuilder {

	@Value("${smtp.url}")
	private String smtpAdresss;

	@Value("${smtp.from}")
	private String userName;

	@Value("${smtp.password}")
	private String password;
	
	@Autowired
	private EmailProcessor myEmailProcessor;

	@Override
	public void configure() throws Exception {

		from("direct:mail").process(myEmailProcessor)
				.to(smtpAdresss + "?username=" + userName + "&password=" + password);
	}
}
