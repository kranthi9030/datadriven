package testng;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class InputData 
{
  @Test(dataProvider = "dp")
  public void login(String uid,String pwd) 
  {
	  System.out.println(uid);
	  System.out.println(pwd);
  }

  @DataProvider
  public Object[][] dp() 
  {
    return new Object[][] {
      new Object[] { "user1","pwd1" },
      new Object[] { "user2","pwd2" },
      new Object[] { "user3","pwd3" },
    };
  }
}
