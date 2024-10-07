package ddt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Insert_Data_to_Excel {

	public static void main(String[] args) throws Throwable {
     
		FileInputStream path = new FileInputStream("C:\\Users\\Guest2\\Downloads\\Book 4 (3).xlsx");
		Workbook book = WorkbookFactory.create(path);
		Sheet sheet = book.getSheet("sheet1");
		
		Row row = sheet.createRow(6);//select rownum
		Cell cell = row.createCell(6);//select column num
	 cell.setCellValue("ADV SELENIUM");//add data
		
	 FileOutputStream fos = new FileOutputStream("C:\\Users\\Guest2\\Downloads\\Book 4 (3).xlsx"); //keep excel in write mode
	       book.write(fos); ////keep in write mode
	       book.close();   //close sheet
	}

}
