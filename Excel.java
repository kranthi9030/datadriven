package datadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel 
{

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook book;
	public static XSSFSheet sht;
	public static String filepath="TestData\\";
	
	public static void GetWorkbook(String filename,String shtname)
	{
		try {
			
			fi=new FileInputStream(filepath+filename);
			book=new XSSFWorkbook(fi);
			//Target Sheet
			sht=book.getSheet(shtname);
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	
	/*
	 * Method Get Cell Data
	 */
	public static String GetCellData(int Row, int Col)
	{
		XSSFRow row=sht.getRow(Row);
		XSSFCell cell=row.getCell(Col);
		String Cellvalue=cell.getStringCellValue();
		return Cellvalue;
	}
	
	/*
	 * Method Get Cell Data
	 */
	public static void SetCellData(int Row, int Col,String Result)
	{
		XSSFRow row=sht.getRow(Row);
		XSSFCell cell=row.createCell(Col);
		cell.setCellValue(Result);
		
	}
	
	/*
	 * Create Excel output file
	 */
	
	public static void createExcel_output(String Ofile)
	{
		try {
			book.write(new FileOutputStream(filepath+Ofile));
			book.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
