package com.silence.agentip.crawler;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.silence.agentip.crawler.service.IIpDataService;

public class Application {

	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext(new String[] {"classpath:spring/agentip-crawler-spring.xml"});
		IIpDataService ipDataService = (IIpDataService)context.getBean("ipDataService");
		System.out.println(ipDataService);
	}

}
