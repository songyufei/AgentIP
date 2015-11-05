package com.silence.agentip.crawler.model;

import java.io.Serializable;

/**
 * 从网页中获得的数据模型
 * @Package com.silence.agentip.crawler.model
 * @ClassName: AgentIp
 * @author SilencE<yaphets_t_t@163.com>
 * @date 2015年11月3日 下午7:48:07
 */
public class AgentIp implements Serializable{
	private static final long serialVersionUID = 4767134593211552711L;
	private String ipAddress;
	private String port;
	private String position;
	private String anonymous;
	private String type;
	private String validateDate;
	private String validateTime;
	
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getAnonymous() {
		return anonymous;
	}
	public void setAnonymous(String anonymous) {
		this.anonymous = anonymous;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValidateDate() {
		return validateDate;
	}
	public void setValidateDate(String validateDate) {
		this.validateDate = validateDate;
	}
	public String getValidateTime() {
		return validateTime;
	}
	public void setValidateTime(String validateTime) {
		this.validateTime = validateTime;
	}
	
}
