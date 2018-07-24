package datadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageobject.InputData;

public class POI_Read_Data_XLSX {

	public static void main(String[] args) 
	{
		
	
			try {
				
				//Target file location
				FileInputStream fi=new FileInputStream("TestData\\InputData.xlsx");
				
				//Read Workbook
				XSSFWorkbook book=new XSSFWorkbook(fi);
				
				//Using above workbook target sheet
				XSSFSheet sht_config=book.getSheet("config");
				
				//Using above sheet target row number
				XSSFRow row=sht_config.getRow(1);
				
				//Using above row find cell
				XSSFCell CellAddress=row.getCell(0);
				
				//Read Data from above cell
				String CellData=CellAddress.getStringCellValue();
				System.out.println(CellData);
				
				//launch Webdriver 
				WebDriver driver=new FirefoxDriver();
				driver.get(CellData);
				
				
				//Read browser name
				String browsername=sht_config.getRow(1).getCell(1).getStringCellValue();
				System.out.println(browsername);
				//Read browser version
				double version=sht_config.getRow(1).getCell(2).getNumericCellValue();
				System.out.println(version);
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			
		
	}

}
