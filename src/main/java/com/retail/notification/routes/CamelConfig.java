package com.retail.notification.routes;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamelConfig {

	@Autowired
	private CachingConnectionFactory rabbitConnectionFactory;

	@Bean
	com.rabbitmq.client.ConnectionFactory rabbitSourceConnectionFactory() {
		return rabbitConnectionFactory.getRabbitConnectionFactory();
	}
}