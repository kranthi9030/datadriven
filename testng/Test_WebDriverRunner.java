package testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Test_WebDriverRunner 
{
	public WebDriver driver;
	
  @Test
  public void launh_browser() 
  {
	  driver=new FirefoxDriver();
	  Reporter.log("Automation browser window lanched");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	  Reporter.log("timeout specified");
  }
}
