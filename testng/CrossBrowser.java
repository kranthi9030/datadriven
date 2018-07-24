package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowser 
{
	public WebDriver driver;
	
  @Test(priority=0)
  @Parameters("browser")
  public void launchBrowser(String brname) 
  {
	  switch (brname) 
	  {
	  
	  case "firefox":
		  driver=new FirefoxDriver();
		  break;
		
	  case "ie":
		  System.setProperty("webdriver.ie.driver", "browsers\\IEDriverServer.exe");
		  driver=new InternetExplorerDriver();
		  break;
		
		
	  case "chrome":
		  System.setProperty("webdriver.chrome.driver", "browsers\\chromedriver.exe");
		  driver=new ChromeDriver();
		  break;
	
	  default:
		  break;
	  }//switch
	  
  }//method
  
  
  @Test(priority=1)
  public void LaunchApp()
  {
	  driver.get("http://outlook.com");
	  String RuntimeTitle=driver.getTitle();
	  String ExpTitle="Outlook.com - Microsoft free personal email";
	  Assert.assertEquals(RuntimeTitle, ExpTitle);
	  Reporter.log("Application launched correct title presented  "+RuntimeTitle);
  }
  
  @Test(priority=2, dependsOnMethods={"LaunchApp"})
  public void Get_SignInPage() throws Exception
  {
	  Thread.sleep(4000);
	  driver.findElement(By.xpath("//div[@class='buttonLargeBlue']")).click();
	  String ExpTitle="Sign in to your Microsoft account";
	  Assert.assertEquals(driver.getTitle(), ExpTitle);
	  Reporter.log("Expected SignInpage Displayed title displayed   "+ExpTitle);
  }
  
  
  @Test(priority=3)
  public void Valid_EmailEntry() throws Exception
  {
	  Thread.sleep(5000);
	  driver.findElement(By.cssSelector("#i0116")).clear();
	  driver.findElement(By.cssSelector("#i0116")).sendKeys("sunilreddy.gajjala@outlook.com");
	  //Click Next button
	  driver.findElement(By.cssSelector("#idSIButton9")).click();
	  Thread.sleep(5000);
	 
	  
  }
  
  
  
  
  
}
