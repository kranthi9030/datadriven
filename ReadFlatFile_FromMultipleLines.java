package datadriven;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadFlatFile_FromMultipleLines 
{

	public static void main(String[] args) 
	{
		try {
			
			//Target file location
			FileReader fr=new FileReader("TestData\\MobileOperators.csv");
			
			//Read File Source
			BufferedReader reader=new BufferedReader(fr);
			
			//Read Header
			String Header=reader.readLine();
			
			String rline;
			while((rline=reader.readLine())!=null)
			{
				String arr[]=rline.split(",");
				String mobilenum=arr[0];
				String operatorname=arr[1];
				
				System.out.println(mobilenum);
				System.out.println(operatorname);
				
				System.out.println("\n");
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
