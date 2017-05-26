package com.quest.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quest.commons.utils.ExcelUtil;
import com.quest.commons.utils.ExportUtil;

@Controller
@RequestMapping("/export")
public class ExportController {
	@Resource(name="config")
	Properties config;
	
	@RequestMapping("/index")
	public String toIndex(){
		return "/export/index";
	}
	
	@RequestMapping("/excel")
	public void exportExcel(HttpServletRequest request,HttpServletResponse response, Model model){
		
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
}
