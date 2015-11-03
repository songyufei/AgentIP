package com.silence.agentip.crawler;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.silence.agentip.crawler.service.IpDataService;
import com.silence.agentip.dao.domain.IpDataDomain;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/agentip-crawler-spring.xml" })
public class ServiceTest extends TestCase {
	@Autowired
	private IpDataService ipDataService;

	@Test
	public void addOneIpDataTest() {
		System.out.println(ipDataService);
		IpDataDomain ipDataDomain = new IpDataDomain();
		ipDataDomain.setIp("192.168.1.1");
		Integer cnt = ipDataService.addOneIpData(ipDataDomain);
		System.out.println("插入记录 " + cnt + " 条");
	}
}
