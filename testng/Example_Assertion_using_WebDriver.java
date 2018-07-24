package testng;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Example_Assertion_using_WebDriver 
{

	public WebDriver driver;
	
	@Test(priority=0, description="application launch method")
	public void tc001()
	{
		driver.get("http://outlook.com");
		//Get Runtime page title
		String Runtimetitle=driver.getTitle();
		Assert.assertEquals(Runtimetitle, "Outlook.com - Microsoft free personal email");
		Reporter.log("Application launch successfull , page title found  "+Runtimetitle);
	}
	
	
	
	@BeforeTest
	public void launchBrowser()
	{
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	
}
