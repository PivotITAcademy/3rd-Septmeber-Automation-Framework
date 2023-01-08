package com.naveenautomation.Utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static FileInputStream fi;

	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getRowCount(String xFile, String sheetName) throws IOException {

		int rowCount = 0;
		// Fetch the file
		fi = new FileInputStream(xFile);
		// Initialize the Work Book
		wb = new XSSFWorkbook(fi);
		// Get the sheet from Work book
		ws = wb.getSheet(sheetName);
		// Get the last row.
		rowCount = ws.getLastRowNum();

		wb.close();
		fi.close();

		return rowCount;

	}

	public static int getColumnCount(String xFile, String sheetName, int rowNo) throws IOException {

		int colCount = 0;
		// Fetch the file
		fi = new FileInputStream(xFile);
		// Initialize the Work Book
		wb = new XSSFWorkbook(fi);
		// Get the last row.
		ws = wb.getSheet(sheetName);

		row = ws.getRow(rowNo);
		colCount = row.getLastCellNum();
		wb.close();
		fi.close();
		return colCount;

	}

	public static String getCellValue(String xFile, String sheetName, int rowNo, int colCount) throws IOException {

		String data = "";
		fi = new FileInputStream(xFile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetName);
		row = ws.getRow(rowNo);
		cell = row.getCell(colCount);
		data = new DataFormatter().formatCellValue(cell);

		return data;

	}

}
