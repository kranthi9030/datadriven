package datadriven;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Datadriven_FrameWork {

	public static void main(String[] args) 
	{
		
		try {
			
			//Target file location
			FileInputStream fi=new FileInputStream("TestData\\InputData.xlsx");
			
			//GetWorkbook from above location
			XSSFWorkbook book=new XSSFWorkbook(fi);
			
			//Target Sheet
			XSSFSheet sht_email=book.getSheet("Email_val");
			
			
			//Launch Browser window
			WebDriver driver=new FirefoxDriver();
			driver.manage().window().maximize();
			
			String email = null;
			//Iterate for number of row times
			for (int i = 6; i <= sht_email.getLastRowNum(); i++) 
			{
				
				XSSFCell Email=sht_email.getRow(i).getCell(3);
				//Convert numeric value to text
				if(Email.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				     email = NumberToTextConverter.toText(Email.getNumericCellValue());
				}
				else if(Email.getCellType() ==  Cell.CELL_TYPE_STRING)
				{
					 email=Email.getStringCellValue();
				}
				
				
				String Testcase=sht_email.getRow(i).getCell(0).getStringCellValue();
				String HsignIn_btn=sht_email.getRow(6).getCell(1).getStringCellValue();
				String Email_EB=sht_email.getRow(6).getCell(2).getStringCellValue();
				String Nxt_btn=sht_email.getRow(6).getCell(4).getStringCellValue();
				String Exe_status=sht_email.getRow(i).getCell(6).getStringCellValue();
				String ExP_result=sht_email.getRow(i).getCell(5).getStringCellValue();
				String stype=sht_email.getRow(i).getCell(7).getStringCellValue();
				
				
				//Execute only selected testcase
				if(Exe_status.equals("y"))
				{
					driver.get("http://outlook.com");
					//Enter Data to Fields
					driver.findElement(By.xpath(HsignIn_btn)).click();
					
					//Enter username
					driver.findElement(By.xpath(Email_EB)).clear();
					driver.findElement(By.xpath(Email_EB)).sendKeys(email);
					
					//click Next button
					driver.findElement(By.xpath(Nxt_btn)).click();
					Thread.sleep(7000);
					
					
					//Get output scenario type
					if(stype.equals("text"))
					{
						//Capture page visibletext
						String pagevisibleText=driver.findElement(By.tagName("body")).getText();
						if(pagevisibleText.contains(ExP_result))
						{
							sht_email.getRow(i).createCell(9).setCellValue("Testpass");
						}
						else
						{
							sht_email.getRow(i).createCell(9).setCellValue("Testfail");
						}
						
					}
					
					
					if(stype.equals("object"))
					{
						if(driver.findElement(By.id(ExP_result)).isDisplayed())
						{
							sht_email.getRow(i).createCell(9).setCellValue("Testpass");
						}
						else
						{
							sht_email.getRow(i).createCell(9).setCellValue("TestFail");
						}
					}
					
					
				}
			}//for
			
			book.write(new FileOutputStream("TestData\\Foutput.xlsx"));
			book.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
