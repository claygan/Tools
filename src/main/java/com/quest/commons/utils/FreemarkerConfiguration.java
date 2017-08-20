package com.quest.commons.utils;

import freemarker.template.Configuration;

import java.io.File;
import java.io.IOException;

/**
 * freemark配置
 * 
 * @ClassName: FreemarkerConfiguration
 * @Description: freemark配置
 */
public class FreemarkerConfiguration {

	private static Configuration config = null;

	/**
	 * 获取 FreemarkerConfiguration
	 * 
	 * @Title: getConfiguation
	 */
	public static synchronized Configuration getConfiguation() {
		if (config == null) {
			setConfiguation();
		}
		return config;
	}

	/**
	 * 设置 配置
	 * 
	 * @Title: setConfiguation
	 */
	private static void setConfiguation() {
		config = new Configuration();
		String path = ResourceLoader.getPath("");
		System.out.println("path=" + path);
		try {
			config.setDirectoryForTemplateLoading(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
