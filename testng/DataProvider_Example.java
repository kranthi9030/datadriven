package testng;

import org.testng.annotations.DataProvider;

public class DataProvider_Example 
{
	
	@DataProvider
	public static String[][] login_Data()
	{
		String data[][]=new String[3][2];
		
		data[0][0]="qadarshan@gmail.com";
		data[0][1]="hello12345";
		
		data[1][0]="sunilreddy.gajjala@outlook.com";
		data[1][1]="mupepo1234";
		
		data[2][0]="sunilreddy";
		data[2][1]="680806sunil";
		
		return data;
	}

}
