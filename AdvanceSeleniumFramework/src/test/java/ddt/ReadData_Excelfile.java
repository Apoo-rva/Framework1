package ddt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData_Excelfile {

	public static void main(String[] args) throws Throwable {
		//1st--give path of excel
             FileInputStream path = new FileInputStream("C:\\Users\\Guest2\\Downloads\\Book 4 (3).xlsx");
		
		//2nd--keep excel in read mode
             Workbook book = WorkbookFactory.create(path);
		
             //3rd-get control of sheet
             Sheet sheet = book.getSheet("Sheet1");

	   //4th--get control on row
           Row row = sheet.getRow(1);
	
           //5th=get control on cell
           Cell cell = row.getCell(0);
	
	         //6th get value from cell
   //       String data = cell.getStringCellValue();----------------------for string values
   //                          double data = cell.getNumericCellValue();--for numeric values bt doesnt prints as it is so use data formatter
           
                    DataFormatter format = new DataFormatter();       //prints data as it is how its in excel
                     String data = format.formatCellValue(cell);
                    System.out.println(data);
	}

}
