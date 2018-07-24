package datadriven;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DataDriven_UsingPropertyFiles 
{

	public static void main(String[] args) 
	{
		
		try {
			
			//Find Propety file location
			FileInputStream fi=new FileInputStream("TestData\\input.properties");
			
			//Create object for property files
			Properties repository=new Properties();
			repository.load(fi);
			
			//Get property value using property keyname
			String url=repository.getProperty("hotmail_url");
			System.out.println(url);
			
			WebDriver driver=new FirefoxDriver();
			driver.get(url);
			driver.manage().window().maximize();
			
			
			//Get elements
			String Xpath_email=repository.getProperty("email_xpath");
			String input_email=repository.getProperty("email");
			
			driver.findElement(By.xpath(Xpath_email)).clear();
			driver.findElement(By.xpath(Xpath_email)).sendKeys(input_email);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
