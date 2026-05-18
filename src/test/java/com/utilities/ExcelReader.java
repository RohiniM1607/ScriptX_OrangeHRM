package com.utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	XSSFWorkbook workbook;

	XSSFSheet sheet;

	public ExcelReader(String filePath) {

		try {

			FileInputStream file = new FileInputStream(filePath);

			workbook = new XSSFWorkbook(file);
		}

		catch (Exception e) {

			e.printStackTrace();
		}
	}

	public String getData(String sheetName, int rowNum, int cellNum) {

		sheet = workbook.getSheet(sheetName);

		return sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
	}
}