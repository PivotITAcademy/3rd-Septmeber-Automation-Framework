package com.naveenautomation.tests;

import java.io.IOException;

import com.naveenautomation.Utils.ExcelUtils;

public class TestClass {

	public static void main(String[] args) throws IOException {
		String filePath = "./Test Data\\LoginDetails.xlsx";

		int rowCount = ExcelUtils.getRowCount(filePath, "Sheet1");
		int colCount = ExcelUtils.getColumnCount(filePath, "Sheet1", rowCount);
		System.out.println("row and colum count " + rowCount + " " + colCount);
		String[][] loginData= new String[rowCount][colCount];
	}

}
