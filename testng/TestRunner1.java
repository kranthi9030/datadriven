package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestRunner1 
{
  @Test
  public void tc001() 
  {
	  Reporter.log("tc001 method executed",true);
  }
  
  @Test
  public void tc002() 
  {
	  Reporter.log("tc002 method executed",true);
  }
  
  @Test
  public void tc003() 
  {
	  Reporter.log("tc003 method executed",true);
  }
}
