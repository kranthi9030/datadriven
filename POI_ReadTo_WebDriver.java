package datadriven;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class POI_ReadTo_WebDriver {

	public static void main(String[] args) 
	{
		
		try {
			
			//target file location
			FileInputStream fi=new FileInputStream("TestData\\InputData.xlsx");
			//Open workbook
			XSSFWorkbook book=new XSSFWorkbook(fi);
			//using above workbook target sheet
			XSSFSheet sht_login=book.getSheet("login_valid");
			
			//Get CellData
			String Appurl=sht_login.getRow(6).getCell(0).getStringCellValue();
			String Hsignin_button=sht_login.getRow(6).getCell(1).getStringCellValue();
			String Email_EB=sht_login.getRow(6).getCell(2).getStringCellValue();
			String Email=sht_login.getRow(6).getCell(3).getStringCellValue();
			String NextBtn=sht_login.getRow(6).getCell(4).getStringCellValue();
			String pwd_EB=sht_login.getRow(6).getCell(5).getStringCellValue();
			String Pwd=sht_login.getRow(6).getCell(6).getStringCellValue();
			String SignIn_btn=sht_login.getRow(6).getCell(7).getStringCellValue();
			
			
			WebDriver driver=new FirefoxDriver();
			driver.get(Appurl);
			driver.manage().window().maximize();
			
			//Click Signin button to get login page
			driver.findElement(By.xpath(Hsignin_button)).click();
			
			//Enter Username
			driver.findElement(By.xpath(Email_EB)).sendKeys(Email);
			driver.findElement(By.xpath(NextBtn)).click();
			Thread.sleep(5000);
			
			//Enter password
			driver.findElement(By.xpath(pwd_EB)).sendKeys(Pwd);
			driver.findElement(By.xpath(SignIn_btn)).click();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
