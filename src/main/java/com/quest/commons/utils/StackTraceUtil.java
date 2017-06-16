package com.quest.commons.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @Title: StackTraceUtil.java
 * @Package com.ws.platform.core.module.wscms.util
 * @Description: TODO(添加描述)
 * @author luog
 * @date 2012-11-3 下午11:25:58
 * @version V1.0
 */
public class StackTraceUtil {
	/**
	 * 取出exception中的信息
	 * 
	 * @param exception
	 * @return
	 */
	public static String getStackTrace(Throwable exception) {
		StringWriter sw = null;
		PrintWriter pw = null;
		try {
			sw = new StringWriter();
			pw = new PrintWriter(sw);
			exception.printStackTrace(pw);
			return sw.toString();
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}
}
