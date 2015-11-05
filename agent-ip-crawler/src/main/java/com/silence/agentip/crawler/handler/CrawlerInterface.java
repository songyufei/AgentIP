package com.silence.agentip.crawler.handler;

/**
 * 定义顶层爬取接口
 * @Package com.silence.agentip.crawler.handler
 * @ClassName: AgentIpCrawlerInterface
 * @author SilencE<yaphets_t_t@163.com>
 * @date 2015年11月3日 下午7:31:27
 */
public interface CrawlerInterface<T>{
	/**
	 * 将数据存入数据库
	 * @param t
	 * @return
	 */
	public Integer saveDataToDb(T t);
}
