package com.silence.agentip.crawler.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.silence.agentip.crawler.handler.AbstractIpCrawlerHandler;
import com.silence.agentip.crawler.service.impl.IpDataService;
/**
 * 
 * @Package com.silence.agentip.crawler.control
 * @ClassName: AgentIpCrawler
 * @author SilencE<yaphets_t_t@163.com>
 * @date 2015年11月3日 下午8:04:34
 */
public class AgentIpCrawler {
	private static final Logger logger = LoggerFactory.getLogger(AgentIpCrawler.class);
	@Autowired
	private IpDataService ipDataService;
	
	public static void main(String[] args) {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:spring/agentip-crawler-spring.xml","classpath:spring/agentip-db-config.xml"});
			AbstractIpCrawlerHandler ipCrawlerHandler = new AbstractIpCrawlerHandler("/Users/SilencE/Developer/crawler",false);
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
