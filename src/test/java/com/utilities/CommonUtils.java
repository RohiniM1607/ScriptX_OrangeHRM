package com.utilities;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CommonUtils {

    private static Workbook workbook;
    private static Sheet sheet;

    public static void loadExcel(String sheetName) {
        try {
            FileInputStream fis = new FileInputStream(
                "src/test/resources/testdata/OrangeHRM_TestData.xlsx");
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getCellData(int rowNum, String columnName) {
        Row headerRow = sheet.getRow(0);
        int colIndex = -1;
        for (Cell cell : headerRow) {
            if (cell.getStringCellValue().equalsIgnoreCase(columnName)) {
                colIndex = cell.getColumnIndex();
                break;
            }
        }
        if (colIndex == -1) return "";
        Row dataRow = sheet.getRow(rowNum);
        if (dataRow == null) return "";
        Cell cell = dataRow.getCell(colIndex);
        if (cell == null) return "";
        cell.setCellType(CellType.STRING);
        return cell.getStringCellValue().trim();
    }
}