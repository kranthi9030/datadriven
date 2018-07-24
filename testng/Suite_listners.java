package testng;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Suite_listners 
{
 
  @BeforeSuite
  public void beforeSuite() 
  {
	  System.out.println("Run Started");
  }

  @AfterSuite
  public void afterSuite() 
  {
	  System.out.println("Run Completed");
  }

}
