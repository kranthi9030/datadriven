package org.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import datadriven.Excel;
import reusable_Class_parameter.Repository;


public class Driver {

	public static void main(String[] args) 
	{
		
		//GetWorkbook
		Excel.GetWorkbook("KWD.xlsx", "Sheet2");
		
		
		WebDriver driver=new FirefoxDriver();
		driver.get("http://facebook.com");
		driver.manage().window().maximize();
		
		WebDriverWait wait=new WebDriverWait(driver, 100);
		
		//Iterator number of row times
		for (int i = 6; i <= Excel.sht.getLastRowNum(); i++) 
		{
			//ReadData
			String Locator=Excel.GetCellData(i, 1);
			String locatorvalue=Excel.GetCellData(i, 2);
			String keyword=Excel.GetCellData(i, 3);
			String inputdata=Excel.GetCellData(i, 4);
			
			
			switch (keyword) 
			{
			case "Text_Entry":
				WebElement Editbox=driver.findElement(Locators.getlocator(Locator, locatorvalue));
				Editbox.clear();
				Editbox.sendKeys(inputdata);
				break;
				
			case "Select_Dropdown_option":
				Select Dropdown=new Select(driver.findElement(Locators.getlocator(Locator, locatorvalue)));
				Dropdown.selectByVisibleText(inputdata);
				break;
				
			case "Click_Element":
				driver.findElement(Locators.getlocator(Locator, locatorvalue)).click();
				break;

			case "Wait_For_Element":
				wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.getlocator(Locator, locatorvalue)));
				break;
				
			case "IsTextVisisble":
				boolean flag=Repository.istext_visible(driver, inputdata);
				if(flag)
					Excel.SetCellData(i, 5, "text visible");
				else
					Excel.SetCellData(i, 5, "text not visible");
				break;
				
			default:
				break;
			}
			
		}
		
		
		Excel.createExcel_output("FrameWork_Op.xlsx");
	}

}
