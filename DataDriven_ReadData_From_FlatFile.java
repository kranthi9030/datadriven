package datadriven;

import java.io.BufferedReader;
import java.io.FileReader;

public class DataDriven_ReadData_From_FlatFile {

	public static void main(String[] args) 
	{
		
		try {
			
			//Target file location
			FileReader fr=new FileReader("TestData\\InputData.csv");
			
			//Read File Source
			BufferedReader reader=new BufferedReader(fr);
			
			//Read Header
			String Header=reader.readLine();
			
			//Read Nextline
			String TestCase_login=reader.readLine();
			
			//Split testcase
			String arr[]=TestCase_login.split(",");
			
			String appurl=arr[0];
			String Hsignin_btn=arr[1];
			String email_xpath=arr[2];
			
			System.out.println(appurl);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
