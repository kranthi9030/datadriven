package datadriven;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POI_Read_Data_From_Multiple_Rows 
{

	public static void main(String[] args) 
	{
		
		try {
			
			//Target file location
			FileInputStream fi=new FileInputStream("TestData\\InputData.xlsx");
			
			//Read Workbook
			XSSFWorkbook book=new XSSFWorkbook(fi);
			
			//Using above workbook target sheet
			XSSFSheet sht_email_val=book.getSheet("Email_val");
			
			//Get Rowcount from above sheet
			int Lrnum=sht_email_val.getLastRowNum();
			
			
			//Iterate for number of row times
			for (int i = 6; i <= Lrnum; i++) 
			{
				String testcase=sht_email_val.getRow(i).getCell(0).getStringCellValue();
				System.out.println(testcase);
				
				String email=sht_email_val.getRow(i).getCell(3).getStringCellValue();
				System.out.println(email);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
