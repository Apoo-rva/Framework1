package generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {

	
	public String getExceldata(String sheetno,int rowno,int cellno) throws Throwable {
		
		
		
		//step1:- path connection
 		FileInputStream fis1 = new FileInputStream("C:\\Users\\Guest2\\Downloads\\Book 4 (7).xlsx");

 		     //step2:- excel file in read mode
 			Workbook book = WorkbookFactory.create(fis1);
 			  
 			//step3:- get control on sheet
 			        org.apache.poi.ss.usermodel.Sheet sheet = book.getSheet(sheetno);
 			
 			//step4:- get control on row
 			Row row = sheet.getRow(rowno);   //organization name
 			
 			//step5:- get control on cell
 			org.apache.poi.ss.usermodel.Cell cell = row.getCell(cellno);
 			
 			//step6:-fetching the cell value
 			String Exceldata = cell.getStringCellValue(); 
		
		
		
		return Exceldata;
		
		
		
		
	}
	
public String getExceldataDataformatter(String sheetno,int rowno,int cellno) throws Throwable {
		
		
		
		//step1:- path connection
 		FileInputStream fis1 = new FileInputStream("C:\\Users\\Guest2\\Downloads\\Book 4 (7).xlsx");

 		     //step2:- excel file in read mode
 			Workbook book = WorkbookFactory.create(fis1);
 			  
 			//step3:- get control on sheet
 			        org.apache.poi.ss.usermodel.Sheet sheet = book.getSheet(sheetno);
 			
 			//step4:- get control on row
 			Row row = sheet.getRow(rowno);   //organization name
 			
 			//step5:- get control on cell
 			org.apache.poi.ss.usermodel.Cell cell = row.getCell(cellno);
 			
 			
 			DataFormatter format = new DataFormatter();
 			String Exceldata = format.formatCellValue(cell);
 			System.out.println(Exceldata);
 		
		
		
		return Exceldata;
		
		
		
		
	}
	
	
	
	
}
