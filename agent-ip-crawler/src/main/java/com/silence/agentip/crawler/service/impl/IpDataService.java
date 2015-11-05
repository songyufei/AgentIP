package com.silence.agentip.crawler.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silence.agentip.crawler.service.IIpDataService;
import com.silence.agentip.dao.domain.IpDataDomain;
import com.silence.agentip.dao.mapper.IpDataDomainMapper;

@Service
public class IpDataService implements IIpDataService{
	@Autowired
	private IpDataDomainMapper ipDataDomainMapper;
	
	public Integer addOneIpData(IpDataDomain ipDataDomain){
		return ipDataDomainMapper.insertSelective(ipDataDomain);
	}
}
