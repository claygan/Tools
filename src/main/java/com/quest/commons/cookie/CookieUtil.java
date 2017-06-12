/**
 * Project Name: zzh-cloud-admin
 * File Name: CookieUtil.java
 * Package Name: com.zzh.cloud.web.admin.security
 * Date: 2015-8-23下午11:14:22 
 * Copyright (c) 2015, www.zhongzhihui.com All Rights Reserved. 
 */

package com.quest.commons.cookie;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;

/**
 * ClassName: CookieUtil Description: TODO(用一句话描述这个类)
 * 
 * @author jupiter@zhongzhihui.com
 * @date: 2015-8-23 下午11:14:22
 */
public class CookieUtil {
	public static final String COOKIE_LIVE_TOKEN = "liveToken";
	
	static final String[] AUTHORITIES = new String[0];

	public static void writeCookie(HttpServletRequest request, UserDO userDO, int expire) {
		if (request == null || userDO == null) {
			throw new IllegalArgumentException();
		}

		CookieModule jar = (CookieModule) request.getAttribute(CookieModule.COOKIE);

		if (jar == null) {
			throw new NullPointerException();
		}

		jar.remove(CookieConstants.MANAGER_ID_COOKIE);

		jar.set(CookieConstants.MANAGER_ID_COOKIE, String.valueOf(userDO.getUserId()), expire);
		try {
			jar.set(CookieConstants.MANAGER_UNAME_COOKIE, URLEncoder.encode(userDO.getUsername(), "UTF-8"), expire);
		} catch (UnsupportedEncodingException e) {
		}
		jar.set(CookieConstants.MANAGER_PWD_COOKIE, userDO.getPassword(), expire);
	}

	public static void clearCookie(HttpServletRequest request) {
		CookieModule jar = (CookieModule) request.getAttribute(CookieModule.COOKIE);
		if (jar != null) {
			jar.remove(CookieConstants.MANAGER_ID_COOKIE);
			jar.remove(CookieConstants.MANAGER_UNAME_COOKIE);
			jar.remove(CookieConstants.MANAGER_PWD_COOKIE);
		}
	}

	public static Long getUserId(HttpServletRequest request) {
		if (request == null) {
			throw new IllegalArgumentException();
		}
		CookieModule jar = (CookieModule) request.getAttribute(CookieModule.COOKIE);

		if (jar == null) {
			return null;
		}
		String idStr = jar.get(CookieConstants.MANAGER_ID_COOKIE);
		if (StringUtils.isNumeric(idStr)) {
			return Long.valueOf(idStr);
		}
		return null;
	}

	public static String getUserName(HttpServletRequest request) {
		if (request == null) {
			throw new IllegalArgumentException();
		}
		CookieModule jar = (CookieModule) request.getAttribute(CookieModule.COOKIE);

		if (jar == null) {
			return null;
		}

		try {
			String uname = jar.get(CookieConstants.MANAGER_UNAME_COOKIE);
			if (uname == null) {
				return uname;
			}
			return URLDecoder.decode(uname, "UTF-8");
		} catch (UnsupportedEncodingException e) {
		}
		return null;
	}

	public static String getUserPassword(HttpServletRequest request) {
		if (request == null) {
			throw new IllegalArgumentException();
		}
		CookieModule jar = (CookieModule) request.getAttribute(CookieModule.COOKIE);

		if (jar == null) {
			return null;
		}

		try {
			String upassword = jar.get(CookieConstants.MANAGER_PWD_COOKIE);
			if (upassword == null) {
				return upassword;
			}
			return URLDecoder.decode(upassword, "UTF-8");
		} catch (UnsupportedEncodingException e) {
		}
		return null;
	}

	public static boolean isLogin(HttpServletRequest request) {
		Long userId = getUserId(request);
		String userName = getUserName(request);
		String userPassword = getUserPassword(request);
		if (userId != null && userName != null && userPassword != null) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @Title: getCurrentUserDO
	 * @Description: 获取当前用户
	 * @author 简道
	 * @param request
	 * @return UserDO 返回类型
	 * @throws
	 */
	public static UserDO getCurrentUser(HttpServletRequest request) {
		if (!isLogin(request)) {
			return null;
		}

		Long userId = getUserId(request);
		String userName = getUserName(request);
		String userPassword = getUserPassword(request);

		UserDO userDO = new UserDO();
		//
		userDO.setUserId(userId);
		userDO.setUsername(userName);
		userDO.setPassword(userPassword);

		return userDO;
	}
	public static void writeCookie(HttpServletRequest request, String key, String value, int expire) {

		Assert.notNull(request, "write cookie error. http request cannot be null!");

		CookieModule jar = (CookieModule) request.getAttribute(CookieModule.COOKIE);
		if (jar == null) {
			throw new NullPointerException();
		}
		jar.remove(key);
		jar.set(key, value, expire);
	}

	public static void clearCookie(HttpServletRequest request, String key) {
		CookieModule jar = (CookieModule) request.getAttribute(CookieModule.COOKIE);
		if (jar != null) {
			jar.remove(key);
		}
	}
	public static String getLiveToken(HttpServletRequest request){
		if (request == null) {
			throw new IllegalArgumentException();
		}
		CookieModule jar = (CookieModule) request.getAttribute(CookieModule.COOKIE);
		if (jar == null) {
			return null;
		}
		String liveToken = jar.get(COOKIE_LIVE_TOKEN);
		return liveToken;
	}
	/** 
	 * @Title: setVisitorId
	 * @Description: 定义一个新的访问者id
	 * @author ganshimin@zhongzhihui.com
	 * @param request  
	 */  
	public static String setVisitorId(HttpServletRequest request){
		if (request == null ) {
			throw new IllegalArgumentException();
		}

		CookieModule jar = (CookieModule) request.getAttribute(CookieModule.COOKIE);

		if (jar == null) {
			throw new NullPointerException();
		}

		jar.remove(CookieConstants.VISITOR_ID_COOKIE);
		//随机生成一个UUID作为访问者id
		try {
			String uid = UUID.randomUUID()+"";
			//定义vi的生存周期
			int expiry = 3600 * 24 * 365 * 10; 
			jar.set(CookieConstants.VISITOR_ID_COOKIE, uid, expiry);
			return uid;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/** 
	 * @Title: getVisitorId
	 * @Description: 获取访问者id
	 * @author ganshimin@zhongzhihui.com
	 * @param request
	 * @return  
	 */  
	public static String getVisitorId(HttpServletRequest request){
		if (request == null) {
			throw new IllegalArgumentException();
		}
		CookieModule jar = (CookieModule) request.getAttribute(CookieModule.COOKIE);

		if (jar == null) {
			return null;
		}
		return jar.get(CookieConstants.VISITOR_ID_COOKIE);
	}
}
