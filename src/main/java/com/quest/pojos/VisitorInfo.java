/**
 * Project Name: zzh-common
 * File Name: VisitorInfo.java
 * Package Name: com.zzh.common.entity
 * Date: 2016年9月19日下午5:13:26 
 * Copyright (c) 2016, www.zhongzhihui.com All Rights Reserved. 
 */

package com.quest.pojos;

import java.util.Date;

/** 
 * @ClassName: VisitorInfo
 * @Description: 页面访问者信息记录（UV）
 * 
 * @author ganshimin@zhongzhihui.com
 * @date: 2016年9月19日 下午5:13:26
 */
public class VisitorInfo {
	/** 
	 * @Description:访问者id（所有用户唯一标识）
	 */  
	private String visitorId;
	/** 
	 * @Description:ip地址
	 */  
	private String ip;
	/**
	 * 客户端来源地址
	 */
	private String referer;
	/**
	 * 访问域名
	 */
	private String serverName;
	/**
	 * 访问资源地址
	 */
	private String uri;
	/**
	 * 访问时间
	 */
	private Date time;
	/**
	 * 客户端设备类型（1： PC端、2：移动端）
	 */
	private int terminalType;
	/** 
	 * @Description:url
	 */  
	private String url;
	/** 
	 * @Description:平台id
	 */  
	private long companyId;
	/** 
	 * @Description:平台系统（1.公共服务平台：public，2.云大学）
	 */  
	private String platform;
	
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getVisitorId() {
		return visitorId;
	}
	public void setVisitorId(String visitorId) {
		this.visitorId = visitorId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getReferer() {
		return referer;
	}
	public void setReferer(String referer) {
		this.referer = referer;
	}
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getTerminalType() {
		return terminalType;
	}
	public void setTerminalType(int terminalType) {
		this.terminalType = terminalType;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	
	
}
