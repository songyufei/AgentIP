package com.silence.agentip.crawler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.silence.agentip.crawler.handler.AbstractIpCrawlerHandler;

public class Application {
	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext(new String[] { "classpath:spring/agentip-crawler-spring.xml" });
		AbstractIpCrawlerHandler ipCrawlerHandler = (AbstractIpCrawlerHandler) context.getBean("ipCrawlerHandler");
		try {
			ipCrawlerHandler.setThreads(20);
			for(int i=1;i<2;i++){
				ipCrawlerHandler.addSeed("http://www.xicidaili.com/nn/"+i);
			}
			//crawler.addRegex("http://www.xicidaili.com/nn/[1-9]+");
			//crawler.setTopN(1);
			ipCrawlerHandler.start(1);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("爬取失败: "+e.getMessage());
		} finally{
			logger.info("爬虫执行完毕");
		}
	}

}
