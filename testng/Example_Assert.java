package testng;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Example_Assert 
{
  @Test
  public void tc001() 
  {
	  String Actvalue="selenium";
	  String Expvalue="webdriver";
	  Assert.assertEquals(Actvalue, Expvalue);
	  Reporter.log("match found",true);
  }
  
  
  @Test
  public void tc002() 
  {
	  String Actvalue="selenium";
	  String Expvalue="selenium";
	  Assert.assertEquals(Actvalue, Expvalue);
	  Reporter.log("match found",true);
  }
  
  
  
}
