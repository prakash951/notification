package com.retail.notification.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


@Component
public class RabbitRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:notify").to("rabbitmq:test?connectionFactory=#rabbitSourceConnectionFactory&queue=test&routingKey=test");
	}

}