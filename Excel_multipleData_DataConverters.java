package datadriven;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Excel_multipleData_DataConverters
	{

	
		public static void main(String[] args) 
		{
			
			try {
				
				//Target File location
				FileInputStream fi=new FileInputStream("TestData\\InputData.xlsx");
				
				//Create object for workbook
				XSSFWorkbook book=new XSSFWorkbook(fi);
				
				//Get sheet count on excel
				int shtcount=book.getNumberOfSheets();
				
				
				//Get Sheet using above workbook
				XSSFSheet sht_config=book.getSheetAt(2);
				
				
				
				
				//Get Row count
				int rnum=sht_config.getLastRowNum();
				System.err.println(rnum);
				
				for (int i = 6; i <= rnum; i++)
				{
					
					XSSFCell Celladd=sht_config.getRow(i).getCell(3);
					
					String email;
					
					
					//Convert numeric value to text
					if(Celladd.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						
					     email = NumberToTextConverter.toText(Celladd.getNumericCellValue());
					     System.out.println(email);
					    
					}
					else if(Celladd.getCellType() ==  Cell.CELL_TYPE_STRING)
					{
						 email=Celladd.getStringCellValue();
						 System.out.println(email);
					}
					else if(Celladd.getCellType() == Cell.CELL_TYPE_BOOLEAN)
					{
						 boolean flag=Celladd.getBooleanCellValue();
						 System.out.println(flag);
					}
					
					
					
				
					
				 }
				
				
				
				
				//Conver double to integer
				double val=123.99;
				int x=(int) val;
				System.out.println(x);
				System.out.println(val);
				
				
				//convert String to integer
				String name="9030";
				int num=Integer.parseInt(name);
				System.out.println(num);
				
				
				
				
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}

	}

}
