package testng;

import org.testng.annotations.Test;

public class Test_DataProvider 
{
	
	@Test(dataProvider="login_Data",dataProviderClass=DataProvider_Example.class)
	public void Verify_login(String uid, String pwd)
	{
		System.out.println(uid);
		System.out.println(pwd);
	}

}
