package datadriven;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GePropertyFiles {

	public static void main(String[] args)
	{
		
		try {
			
			//Find Propety file location
			FileInputStream fi=new FileInputStream("TestData\\input1.properties");
			
			//Create object for property files
			Properties repository=new Properties();
			repository.load(fi);
			
			//Get elements
			String Firstname=repository.getProperty("firstname_textbox");
			String arr[]=Firstname.split(",");
			System.out.println(arr[0]);
			System.out.println(arr[1]);
			
			WebDriver driver=new FirefoxDriver();
			driver.get(repository.getProperty("facebook_url"));
			driver.manage().window().maximize();
			
			
			//Enter text into username
			driver.findElement(By.xpath(arr[0])).clear();
			driver.findElement(By.xpath(arr[0])).sendKeys(arr[1]);
			
			
			//Add result
			repository.setProperty("Result", "Testpass");
			
			
			//Create output file
			repository.store(new FileOutputStream("TestData\\Op.properties"), "Facebook_SigninUp_result");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
