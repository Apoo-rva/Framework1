package ddt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Insert_Multipledata_To_Excel {

		public static void main(String[] args) throws Throwable {
		     
			FileInputStream path = new FileInputStream("C:\\Users\\Guest2\\Downloads\\Book 4 (4).xlsx");
			Workbook book = WorkbookFactory.create(path);
			Sheet sheet = book.getSheet("sheet2");
	//-----------------------------same----------------------------------------------	
	      WebDriver driver=new ChromeDriver();
		  driver.get("https://www.flipkart.com");
		  List<WebElement> links = driver.findElements(By.xpath("//a"));
	
		   for (int i = 0; i < links.size(); i++) {
			
                       Row row = sheet.createRow(i);	//row values changes	
		             Cell cell = row.createCell(0);
		           cell.setCellValue(links.get(i).getAttribute("href"));  //links containing href will be printed
		   
	
		   }
		
		   FileOutputStream fos = new FileOutputStream("C:\\Users\\Guest2\\Downloads\\Book 4 (4).xlsx");
		   book.write(fos);
		   book.close();
		}

}
