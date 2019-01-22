package com.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel {
	
	
	public static Object[][] readExcel()
	{
		Object[][] obj=null;
		File file=new File("src/test/resources/Book1.xlsx");
		try {
			InputStream stream=new FileInputStream(file);
			XSSFWorkbook workbook=new XSSFWorkbook(stream);
			XSSFSheet sheet=workbook.getSheet("Sheet1");
			System.out.println("Starting row count:"+sheet.getFirstRowNum());
			System.out.println("No of rows: "+sheet.getLastRowNum());
			
			System.out.println("No of active cells :"+sheet.getRow(0).getPhysicalNumberOfCells());
			obj=new Object[sheet.getLastRowNum()][];
			
			for(int i=1;i<=sheet.getLastRowNum();i++)
			{
				obj[i-1]=new Object[2];
				
				for(int j=0;j<sheet.getRow(i).getPhysicalNumberOfCells();j++)
				{
					obj[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
				}
			}
			workbook.close();
			stream.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

}
