package org.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Locators 
{
	
	
	public static By getlocator(String pname, String pvalue)
	{
		By by=null;
		
		switch (pname) {
		case "id":
			by=By.id(pvalue);
			break;
			
		case "name":
			by=By.name(pvalue);
			break;
			
		case "classname":
			by=By.className(pvalue);
			break;
			
		case "xpath":
			by=By.xpath(pvalue);
			break;
			
		case "css":
			by=By.cssSelector(pvalue);
			break;
			
		case "linktext":
			by=By.linkText(pvalue);
			break;
			
		case "partiallinktext":
			by=By.partialLinkText(pvalue);
			break;
			
		case "tagname":
			by=By.tagName(pvalue);
			break;

		default:
			break;
		}
		
		return by;
		
		
	}//method
	
	
	public static void main(String args[])
	{
		WebDriver driver=new FirefoxDriver();
		driver.get("http://facebook.com");
		
		driver.findElement(getlocator("id", "u_0_1")).clear();
		driver.findElement(getlocator("id", "u_0_1")).sendKeys("input");
		
		
		
	}

}
