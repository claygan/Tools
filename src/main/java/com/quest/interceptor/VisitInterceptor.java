package com.quest.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.quest.commons.constants.GlobalDefine;
import com.quest.commons.cookie.CookieUtil;
import com.quest.commons.utils.JsonUtil;
import com.quest.commons.utils.UAUtils;
import com.quest.pojos.VisitorInfo;

public class VisitInterceptor extends HandlerInterceptorAdapter{

private Logger logger = LoggerFactory.getLogger("visitLogger");

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//过滤爬虫
		if(UAUtils.isRobot(request)){
			return true;
		}
		String requestType = request.getHeader("X-Requested-With"); 
		//异步请求不拦截
		if(!StringUtils.isNotBlank(requestType)){
			//首次登录没有vid，则新建一个vid
			String vid = CookieUtil.getVisitorId(request);
			if(vid == null){
				vid = CookieUtil.setVisitorId(request);
			}
			VisitorInfo visitorInfo = new VisitorInfo();
			visitorInfo.setVisitorId(vid);
			visitorInfo.setIp(getIpAddr(request));
			visitorInfo.setReferer(request.getHeader("referer"));
			visitorInfo.setServerName(request.getServerName());
			visitorInfo.setUri(request.getRequestURI());
			String completeUrl = "http://" + request.getServerName() //服务器地址  
                    + request.getContextPath();      //项目名称  
			//防止web.xml配置导致servletPath为空的情况
			String servletPath = request.getServletPath();
			String pathInfo = request.getPathInfo();
			if (StringUtils.length(pathInfo) > 0) {
				servletPath += servletPath + pathInfo;
			}
			completeUrl += servletPath;
			//带参数请求
			if(StringUtils.isNotBlank(request.getQueryString())){
				completeUrl += "?" + (request.getQueryString());
			}
			visitorInfo.setUrl(completeUrl);
			visitorInfo.setTime(new Date());
			if(UAUtils.isH5(request)){
				visitorInfo.setTerminalType(GlobalDefine.LogConstants.MOBILE);
			}else{
				visitorInfo.setTerminalType(GlobalDefine.LogConstants.PC);
			}
			logger.info(JsonUtil.getJsonStr(visitorInfo, "yyyy-MM-dd HH:mm:ss"));
		}
		return true;
	}


	private String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
