package com.selenium.utils;
import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDataUtils {

	private Workbook workbook;
	private Sheet sheet;
	
	public ExcelDataUtils(String filepath, String sheetname) throws IOException
	{
		FileInputStream fis = new FileInputStream(filepath);
		workbook = WorkbookFactory.create(fis);
		sheet = workbook.getSheet(sheetname);
		fis.close();
	}
	
	public String getCellData(int rowNum, int colNum)
	{
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(colNum);
		
		return cell.toString();
		
	}
	
	public int getRowCount()
	{
		return sheet.getPhysicalNumberOfRows();
	}
	
	public int getCellCount()
	{
		return sheet.getRow(0).getPhysicalNumberOfCells();
	}
	
	
}
