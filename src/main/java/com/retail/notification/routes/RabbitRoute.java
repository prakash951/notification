package com.retail.notification.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class RabbitRoute extends RouteBuilder {
	
	@Value("${spring.rabbitmq.template.exchange}")
	private String exchangeName;
	
	@Value("${spring.rabbitmq.template.queue}")
	private String queueName;
	
	@Value("${spring.rabbitmq.template.routing-key}")
	private String routingKey;

	@Override
	public void configure() throws Exception {
		from("direct:notify").to("rabbitmq:"+exchangeName+"?connectionFactory=#rabbitSourceConnectionFactory&queue="+queueName+"&routingKey="+routingKey);
	}

}