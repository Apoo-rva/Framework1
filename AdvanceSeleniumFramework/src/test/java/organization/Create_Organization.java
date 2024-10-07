package organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.google.common.collect.Table.Cell;

public class Create_Organization {

	public static void main(String[] args) throws Throwable {

		FileInputStream path = new FileInputStream("./src/test/resources/Vtigerlogincredential.properties");
		
        //2nd--to start reading data ,create objfor properties class and load path
        Properties prop = new Properties();
	         prop.load(path);

	         //3rd--read data from prop file
	         
	         String BROWSER = prop.getProperty("browser");
	           String URL = prop.getProperty("url");
	            String UNAME = prop.getProperty("username");
	                String PWORD = prop.getProperty("password");
	            
//4th launching multiple browsers

	WebDriver driver;           //keeping reday for browser launch  
	         
if(BROWSER.equalsIgnoreCase("chrome")) {
driver=new ChromeDriver();
}
        
else if(BROWSER.equalsIgnoreCase("edge")) {
driver=new EdgeDriver();
}

else {
driver=new ChromeDriver(); //default 1 browser 
}

//5th-pass url of application
driver.get(URL);

//6th-locating web elements and give values
driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UNAME);
driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PWORD);
driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
//------------------------------------------------------	
driver.findElement(By.linkText("Organizations")).click();
driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();

Random ran = new Random();       //generates unique names everytime
int ranNum = ran.nextInt(1000);



//step1:- path connection
FileInputStream fis1 = new FileInputStream("C:\\Users\\Guest2\\Downloads\\Book 4 (7).xlsx");

       //step2:- excel file in read mode
	Workbook book = WorkbookFactory.create(fis1);
	  
	//step3:- get control on sheet
	        org.apache.poi.ss.usermodel.Sheet sheet = book.getSheet("Sheet1");
	
	//step4:- get control on row
	Row row = sheet.getRow(5);   //organization name
	
	//step5:- get control on cell
	org.apache.poi.ss.usermodel.Cell cell = row.getCell(0);
	
	//step6:-fetching the cell value
	String OrgName = cell.getStringCellValue()+ranNum;

	
	driver.findElement(By.name("accountname")).sendKeys(OrgName);
		
	Row row1 = sheet.getRow(5);   //phone number
	
	//step5:- get control on cell
	org.apache.poi.ss.usermodel.Cell cell1 = row1.getCell(1);
	
	
	//step6:-fetching the cell value
	DataFormatter format = new DataFormatter();
	String phnNum = format.formatCellValue(cell1);
	
	driver.findElement(By.id("phone")).sendKeys(phnNum);
	
	
    Row row2 = sheet.getRow(5);   //emailid
	
	//step5:- get control on cell
    org.apache.poi.ss.usermodel.Cell cell2 = row2.getCell(2);
	
	
	//step6:-fetching the cell value
	
	String email = format.formatCellValue(cell2);  
	driver.findElement(By.id("email1")).sendKeys(email);
	

	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();   //save organization

//----------------------verification---------
	Thread.sleep(2000);
	String actualdata = driver.findElement(By.id("mouseArea_Organization Name")).getText();
	
	if(actualdata.contains(OrgName) ) {
	
	System.out.println("organization is created");
	}
	else {
		System.out.println("organization is not created");	
	}
	
	//----------logout
	
	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	driver.findElement(By.linkText("Sign Out")).click();
	
	
	
	
	
	}
}
