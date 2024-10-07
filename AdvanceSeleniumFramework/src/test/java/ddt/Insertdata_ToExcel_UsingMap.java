package ddt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Insertdata_ToExcel_UsingMap {

	public static void main(String[] args) throws Throwable {
		FileInputStream path = new FileInputStream("C:\\Users\\Guest2\\Downloads\\Book 4 (4).xlsx");
		Workbook book = WorkbookFactory.create(path);
		Sheet sheet = book.getSheet("sheet1");
	
	//----------------------------------------------------------------------------------------------
	
	           LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
	            map.put("name", "Apoorva");
	           map.put("age", "25");
	
	int rowNum=10;
	for (Entry<String, String>m : map.entrySet()) { ////////to insert data
	          Row row = sheet.createRow(rowNum++);	
	row.createCell(10).setCellValue((String)m.getKey());
	
	row.createCell(11).setCellValue((String)m.getValue());
	
	}
	
	 FileOutputStream fos = new FileOutputStream("C:\\Users\\Guest2\\Downloads\\Book 4 (4).xlsx");
	   book.write(fos);
	   book.close();
	
	}

}
