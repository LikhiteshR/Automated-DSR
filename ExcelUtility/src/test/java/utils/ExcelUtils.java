package utils;

import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.Test;


public class ExcelUtils  {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	 public static void ExcelUtils1(String excelPath,String sheetName) 
	{
		try
		{
		 workbook=new XSSFWorkbook(excelPath);
		 sheet=workbook.getSheet(sheetName);
	}
		catch(Exception exp)
		{
		  System.out.println(exp.getCause());
		  System.out.println(exp.getMessage());
		  exp.printStackTrace();
		}
	}
	

	public static  Object getCellData(int rowNum,int colNum) throws IOException
	{
		DataFormatter formatter=new DataFormatter();
		Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
//        System.out.println(value);
//        if(value.equals("1")) {
//        	System.out.println("flag");
//        }
		return value;
		
	}
	public static int getRowCount()
	{

		int rowCount= sheet.getPhysicalNumberOfRows();
		
		return rowCount;
	}
}
