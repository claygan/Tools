package com.quest.commons.utils;

import java.io.File;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	/**
	 * 
	 * @Title: parseExcel
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @return List<List<Object>>
	 * @param workbook
	 * @param startRow
	 * @return
	 */
	public static List<List<Object>> parseExcel(Workbook workbook, int startRow) {
		List<List<Object>> data = null;
		data = new ArrayList<List<Object>>();
		Sheet sheet = workbook.getSheetAt(0);
		for (int i = startRow; i <= sheet.getLastRowNum(); i++) {
			List<Object> item = new ArrayList<Object>();
			Row row = sheet.getRow(i);
			boolean emptyRow = true;
			for (int j = 0; j < row.getLastCellNum(); j++) {
				Cell cell = row.getCell(j);
				if (cell == null) {
					item.add("");
				} else {
					String value = getStringCellValue(cell);
					if (value != null && !"".equals(value.trim())) {
						emptyRow = false;
					}
					item.add(value);
				}
			}
			if (!emptyRow) {
				data.add(item);
			}
		}

		return data;
	}

	/**
	 * @Title: parseExcel
	 * @Description: 解析Excel文件
	 * @return List<List<Object>>
	 * @param startRowIndex
	 * @param is
	 * @return
	 */
	public static List<List<Object>> parseExcel(int startRowIndex, InputStream is) {
		List<List<Object>> data = null;
		try {
			data = new ArrayList<List<Object>>();
			Workbook workbook = WorkbookFactory.create(is);
			Sheet sheet = workbook.getSheetAt(0);
			for (int i = startRowIndex; i <= sheet.getLastRowNum(); i++) {
				List<Object> item = new ArrayList<Object>();
				Row row = sheet.getRow(i);
				boolean emptyRow = true;
				if(row != null){
					for (int j = 0; j < row.getLastCellNum(); j++) {
						Cell cell = row.getCell(j);
						if (cell == null) {
							item.add("");
						} else {
							String value = getStringCellValue(cell);
							if (value != null && !"".equals(value.trim())) {
								emptyRow = false;
							}
							item.add(value);
						}
					}
				}
				if (!emptyRow) {
					data.add(item);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * @Title: getStringCellValue
	 * @Description: 获得Excel单元格内容的字符串形式
	 * @return String
	 * @param cell
	 * @return
	 */
	public static String getStringCellValue(Cell cell) {
		// 获得单元格的类型
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			// 根据不同的类型获得单元格的值
			return cell.getStringCellValue();
		case Cell.CELL_TYPE_NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				return dateFormat.format(cell.getDateCellValue());
			} else {
				DecimalFormat decimalFormat = new DecimalFormat("#.00");
				return decimalFormat.format(cell.getNumericCellValue()).replaceAll("\\.00", "");
			}
		case Cell.CELL_TYPE_BOOLEAN:
			return Boolean.toString(cell.getBooleanCellValue());
		case Cell.CELL_TYPE_BLANK:
			return "";
		case Cell.CELL_TYPE_FORMULA:
			return cell.getCellFormula();
		case Cell.CELL_TYPE_ERROR:
			return Byte.toString(cell.getErrorCellValue());
		default:
			return null;
		}
	}

	/**
	 * @Title: buildExcel
	 * @Description: 构建Excel文件
	 * @return Workbook
	 * @param template
	 * @param heads
	 * @param data
	 * @param startRow
	 * @return
	 */
	public static Workbook buildExcel(String template, List<String> heads, List<List<Object>> data, int startRow) {
		Workbook workbook = null;
		try {
			workbook = WorkbookFactory.create(new File(template));
			Sheet sheet = workbook.getSheetAt(0);
			CellStyle cellStyle = sheet.getRow(startRow).getCell(0).getCellStyle();
			Row row = sheet.createRow(startRow);
			for (int i = 0; i < heads.size(); i++) {
				Cell cell = row.createCell(i);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(heads.get(i));
			}
			if (data == null || data.size() <= 0) {
				return new HSSFWorkbook();
			} else {
				List<Object> objects = data.get(0);
				Map<Integer, CellStyle> styleMap = new HashMap<Integer, CellStyle>();
				Map<Integer, Integer> typeMap = new HashMap<Integer, Integer>();
				for (int i = 0; i < objects.size(); i++) {
					Cell styleCell = sheet.getRow(startRow + 1).getCell(i);
					if (styleCell != null) {
						CellStyle style = styleCell.getCellStyle();
						styleMap.put(i, style);
						typeMap.put(i, styleCell.getCellType());
					}
				}
				for (int i = 0; i < data.size(); i++) {
					int seq = i + startRow + 1;
					row = sheet.createRow(seq);
					for (int j = 0; j < data.get(i).size(); j++) {
						Cell cell = row.createCell(j);
						// 插入样式
						CellStyle style = styleMap.get(j);
						cell.setCellStyle(style);
						cell.setCellType(typeMap.get(j));
						//
						if (data.get(i).get(j) == null) {
							cell.setCellValue("");
						} else {
							cell.setCellValue(data.get(i).get(j).toString());
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return workbook;
	}

	/**
	 * @Title: buildExcel
	 * @Description: 构建Excel文件
	 * @return Workbook
	 * @param template
	 * @param heads
	 * @param data
	 * @return
	 */
	public static Workbook buildExcel(String template, List<String> heads, List<List<Object>> data) {
		Workbook workbook = null;
		try {
			workbook = WorkbookFactory.create(new File(template));
			Sheet sheet = workbook.getSheetAt(0);
			CellStyle cellStyle = sheet.getRow(0).getCell(0).getCellStyle();
			Row row = sheet.createRow(0);
			for (int i = 0; i < heads.size(); i++) {
				Cell cell = row.createCell(i);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(heads.get(i));
			}
			int[] cwMax = new int[heads.size()];
			for (int i = 0; i < data.size(); i++) {
				row = sheet.createRow(i + 1);
				for (int j = 0; j < data.get(i).size(); j++) {
					Cell cell = row.createCell(j);
					Object value = data.get(i).get(j);
					if (value == null) {
						cell.setCellValue("");
					} else {
						if(value instanceof Integer || value instanceof Long || value instanceof Double){
							cell.setCellValue(NumberUtils.toDouble(value.toString(), 0));
						}else{
							cell.setCellValue(value.toString());
						}
						if (cwMax[j] < value.toString().getBytes().length) {
							cwMax[j] = value.toString().getBytes().length;
						}
					}
				}
			}
			// 根据每列最长数据或标题设置Excel列宽度
			for (int i = 0; i < heads.size(); i++) {
				sheet.autoSizeColumn(i, true);
				if (cwMax[i] < heads.get(i).getBytes().length){
					cwMax[i] = heads.get(i).getBytes().length;
				}
				sheet.setColumnWidth(i, cwMax[i] * 1 * 256);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return workbook;
	}

}
