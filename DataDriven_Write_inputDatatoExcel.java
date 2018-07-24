package datadriven;

import java.io.FileInputStream;
import java.io.FileOutputStream;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven_Write_inputDatatoExcel {

	public static void main(String[] args)
	{
		
		
		try {
			
			//Target file location
			FileInputStream fi=new FileInputStream("TestData\\InputData.xlsx");
			
			//Using above file open workbook
			XSSFWorkbook book=new XSSFWorkbook(fi);
			
			//Target sheet using above workbook refferal
			XSSFSheet sht_config=book.getSheet("config");
			
			sht_config.getRow(1).createCell(3).setCellValue("TestPass");
			
			
			book.write(new FileOutputStream("TestData\\Op.xlsx"));
			book.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
