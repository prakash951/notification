package com.retail.notification.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SlackRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:slack").to("slack:#academic-project?webhookUrl=https://hooks.slack.com/services/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");
	}

}
