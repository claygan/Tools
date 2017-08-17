package com.quest.web.controllers;

import java.io.*;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quest.commons.utils.HtmlToPdf;
import com.quest.commons.utils.PdfUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quest.commons.utils.ExcelUtil;
import com.quest.commons.utils.ExportUtil;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

@Controller
@RequestMapping("/export")
public class ExportController extends BaseController{
	@Resource(name="config")
	Properties config;
	
	@RequestMapping("/index")
	public String toIndex(){
		return "/export/index";
	}
	
	@RequestMapping("/excel")
	public void exportExcel(){

		String fileName = config.getProperty("export.excel.name");
		String excelTemp = config.getProperty("export.template");
		List<String> heads = new ArrayList<String>();
		heads.add("name");
		List<Object> rows1 = new ArrayList<Object>();
		rows1.add("库里");
		List<Object> rows2 = new ArrayList<Object>();
		rows2.add("欧文");
		List<List<Object>> columns = new ArrayList<List<Object>>();
		columns.add(rows1);
		columns.add(rows2);
		//执行
		Workbook workbook = ExcelUtil.buildExcel(excelTemp, heads, columns);
		
		ExportUtil.processExport(request, response, workbook, fileName);
	}
	@RequestMapping("/pdfHtml")
	public String toPdfHtml(){
		return "/export/pdf";
	}

	@RequestMapping("/pdf")
	public void exportPdf(){
		File pdfFile = null;
		PrintWriter out = null;
		InputStream is = null;
		ServletOutputStream os = null;
		try {

			String pdfTemp = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()
					+"/export/pdfHtml";
			String path = new File("/").getAbsolutePath();
			// 生成pdf路径
			String pdfName = PdfUtil.generateUUID() + ".pdf";
			String outputFile = path + pdfName;

			//内容
			Map retMsg = new HashMap();
			retMsg.put("name", "库里");
			retMsg.put("age", "29");
			retMsg.put("position","得分后卫");
			// 生成pdf
			boolean f = PdfUtil.generatePdf(pdfTemp, outputFile);

			if (f) {
				// 生成下载文件名
				String fileName = "页面信息";
				String fn = new String(fileName.getBytes("gbk"), "iso8859-1");

				// 文件下载响应设置
				response.setContentType("application/force-download");
				response.addHeader("Content-Disposition", "attachment;fileName="+ fn + ".pdf");
				os = response.getOutputStream();

				pdfFile = new File(outputFile);
				is = new FileInputStream(pdfFile);

				int ch = 0;
				while((ch = is.read()) != -1) {
					os.write(ch);
				}
			} else {
				throw new IOException();
			}
		} catch (IOException e) {
			try {
				out = response.getWriter();
				out.println("<script>alert(\"下载失败！\");\r\n window.close();</script>");
			} catch (IOException ee) {
				ee.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) is.close();
				if (os != null) os.close();
				if (pdfFile != null) pdfFile.delete();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
