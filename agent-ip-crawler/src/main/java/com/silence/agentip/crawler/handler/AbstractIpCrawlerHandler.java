package com.silence.agentip.crawler.handler;

import javax.annotation.Resource;

import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.hfut.dmic.webcollector.crawler.BreadthCrawler;
import cn.edu.hfut.dmic.webcollector.model.Links;
import cn.edu.hfut.dmic.webcollector.model.Page;

import com.silence.agentip.crawler.common.Constant;
import com.silence.agentip.crawler.common.DateUtil;
import com.silence.agentip.crawler.model.AgentIp;
import com.silence.agentip.dao.domain.IpDataDomain;
import com.silence.agentip.dao.mapper.IpDataDomainMapper;

/**
 * 爬IP抽象类
 * 
 * @Package com.silence.agentip.crawler.handler
 * @ClassName: AbstractIpCrawlerHandler
 * @author SilencE<yaphets_t_t@163.com>
 * @date 2015年11月3日 下午7:36:15
 */
public class AbstractIpCrawlerHandler extends BreadthCrawler implements CrawlerInterface<AgentIp> {
	private static final Logger logger = LoggerFactory.getLogger(AbstractIpCrawlerHandler.class); 
	@Resource
	private IpDataDomainMapper ipDataDomainMapper;
	
	public AbstractIpCrawlerHandler(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
	}

	@Override
	public Integer saveDataToDb(AgentIp t) {
		IpDataDomain ipDataDomain = new IpDataDomain();
		ipDataDomain.setSource(Constant.AGENT_IP_XICIDAILI);
		ipDataDomain.setType(Constant.AGENT_IP_TYPE_DOMESTIC);
		ipDataDomain.setIp(t.getIpAddress().trim());
		ipDataDomain.setPort(t.getPort().trim());
		ipDataDomain.setPosition(t.getPosition().trim());
		ipDataDomain.setIpType(t.getType());
		ipDataDomain.setValidateTime(DateUtil.spellDateStr(t.getValidateDate(), t.getValidateTime()));
		int cnt = ipDataDomainMapper.insertSelective(ipDataDomain);
		logger.debug("入库记录 IP {} 成功数 {}",ipDataDomain.getIp(),cnt);
		return cnt;
	}

	@Override
	public void visit(Page page, Links nextLinks) {
		Elements trElements = page.getDoc().select("tr");
		logger.debug("准备爬取URL {} 行数 {}",page.getUrl(),trElements.size());
		AgentIp agentIp = null;
		for (int i = 1; i < trElements.size(); i++) {
			logger.debug("原始记录 {}",trElements.get(i).text());
			String[] resultArray = trElements.get(i).text().split(" ");
			logger.debug("列数 {}",resultArray.length);
			agentIp = new AgentIp();
			agentIp.setIpAddress(resultArray[0]);
			agentIp.setPort(resultArray[1]);
			agentIp.setPosition(resultArray[2]);
			agentIp.setAnonymous(resultArray[3]);
			agentIp.setType(resultArray[4]);
			agentIp.setValidateDate(resultArray[5]);
			agentIp.setValidateTime(resultArray[6]);
			this.saveDataToDb(agentIp);
		}
	}

}
