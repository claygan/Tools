package com.quest.commons.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.CharEncoding;
import org.apache.poi.ss.usermodel.Workbook;

public class ExportUtil {
	
	public static final String CONTENT_TYPE = "application/x-msdownload";
	
	public static void processExport(HttpServletRequest request ,HttpServletResponse response, Workbook workbook, String fileName){
		response.setContentType(CONTENT_TYPE);
		response.setCharacterEncoding(CharEncoding.UTF_8);
		response.setHeader("Content-Disposition", "attachment;filename=" + encodeChineseDownloadFileName(request, fileName));
		//
		OutputStream out = null;
		try {
			out = response.getOutputStream();
			workbook.write(out);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(out != null)
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	
	public static String encodeChineseDownloadFileName(HttpServletRequest request, String fileName) {
		String agent = request.getHeader("USER-AGENT");
		try {
			if (null != agent && -1 != agent.indexOf("MSIE")) {
				fileName = URLEncoder.encode(fileName, "utf-8");
			} else {
				fileName = new String(fileName.getBytes("utf-8"), "ISO-8859-1");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return fileName;
	}
	
	
}
