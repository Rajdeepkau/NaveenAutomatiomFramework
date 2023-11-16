package com.naveenautomation.utils;

import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.naveenautomation.base.TestBase;

public class ExcelUtils extends TestBase {
	// To read a file//
	public static FileInputStream fi;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow rows;
	public static XSSFCell cell;

	public static int getRowCount(String fileName, String sheetName) throws Exception {
		int rowCount;
		fi = new FileInputStream(fileName);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		rowCount = sheet.getLastRowNum();
		workbook.close();
		fi.close();
          return rowCount;
	}
	
	public static int getCellCount(String fileName,String sheetName,int rowCount) throws Exception {
		int cellCount;
		fi = new FileInputStream(fileName);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		rows=sheet.getRow(rowCount);
		cellCount=rows.getLastCellNum();
		workbook.close();
		fi.close();
		return cellCount;
		
	}
	 public static String getCellData(String fileName, String sheetName,int rowCount,int cellCount  ) throws Exception {
		 String data=null;
		 fi = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(fi);
			sheet = workbook.getSheet(sheetName);
			rows=sheet.getRow(rowCount);
			cell=rows.getCell(cellCount-1);
			data=cell.getStringCellValue();
			workbook.close();
			fi.close();
			return data;
		 
	 }

}
