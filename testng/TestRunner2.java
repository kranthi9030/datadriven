package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestRunner2 
{
	@Test
	  public void tc004() 
	  {
		  Reporter.log("tc004 method executed",true);
	  }
	  
	  @Test
	  public void tc005() 
	  {
		  Reporter.log("tc005 method executed",true);
	  }
	  
	  @Test
	  public void tc006() 
	  {
		  Reporter.log("tc006 method executed",true);
	  }
}
