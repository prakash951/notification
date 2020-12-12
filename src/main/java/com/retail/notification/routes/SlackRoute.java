package com.retail.notification.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SlackRoute extends RouteBuilder {
	
	@Value("${slack.channel}")
	private String channel;
	
	@Value("${camel.component.slack.webhook-url}")
	private String webHookUrl;

	@Override
	public void configure() throws Exception {
		from("direct:slack").to("slack:#"+channel+"?webhookUrl="+webHookUrl);
	}

}
