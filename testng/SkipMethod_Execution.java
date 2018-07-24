package testng;

import org.testng.annotations.Test;

public class SkipMethod_Execution 
{
	
  @Test(priority=0)
  public void tc001() 
  {
	  
  }
  
  @Test(priority=1,enabled=false)
  public void tc002() 
  {
	  
  }
  
  
  //@Test(priority=2)
  public void tc003() 
  {
	  
  }
}
