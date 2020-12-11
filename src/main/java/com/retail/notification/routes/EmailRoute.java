package com.retail.notification.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class EmailRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("direct:mail").doTry().setHeader("subject", simple("JavaInUse Invitation111"))
				.setHeader("to", simple("prakash.barri@gmail.com,sheetal951@gmail.com"))
				.to("smtps://smtp.gmail.com:465?username=rinkub4u21@gmail.com&password=NOKIA@123456q");
	}
}
