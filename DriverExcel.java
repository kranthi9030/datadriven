package datadriven;

public class DriverExcel {

	public static void main(String[] args) 
	{
		
		
		Excel.GetWorkbook("InputData.xlsx", "Email_val");
		for (int i = 6; i <= Excel.sht.getLastRowNum(); i++) 
		{
			String testcase=Excel.GetCellData(i, 0);
			System.out.println(testcase);
			
			Excel.SetCellData(i, 9, "Testpass");
		}
		
		Excel.createExcel_output("Output.xlsx");

	}

}
