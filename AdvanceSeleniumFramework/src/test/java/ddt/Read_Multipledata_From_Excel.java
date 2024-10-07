package ddt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Read_Multipledata_From_Excel {

	public static void main(String[] args) throws Throwable {
		FileInputStream path = new FileInputStream("C:\\Users\\Guest2\\Downloads\\Book 4 (4).xlsx");
		Workbook book = WorkbookFactory.create(path);
		Sheet sheet = book.getSheet("sheet2");
//-----------------same---------------------------------
		
		int rownum = sheet.getLastRowNum();            //to know abt last iteration limit,we take last rownum()
		System.out.println(rownum);

	
	for (int i = 0; i < rownum; i++) {                  //iteration over row
		      Row row = sheet.getRow(i);
		
		for (int j = 0; j < row.getLastCellNum(); j++) {           //cell value remains same i.e is 0
			Cell cell = row.getCell(j);
		        String data = cell.getStringCellValue();          //now read data from cell
		System.out.println(data);
		
		}
	}
	
	}

}
