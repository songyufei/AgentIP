package com.silence.agentip.crawler.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silence.agentip.crawler.handler.AbstractIpCrawlerHandler;
import com.silence.agentip.crawler.service.IIpDataService;
import com.silence.agentip.dao.mapper.IpDataDomainMapper;

@Service
public class IpDataService implements IIpDataService{
	private static final Logger logger = LoggerFactory.getLogger(IIpDataService.class);
	@Autowired
	private IpDataDomainMapper ipDataDomainMapper;

	@Override
	public void crawlerAgentIp() {
		try {
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
