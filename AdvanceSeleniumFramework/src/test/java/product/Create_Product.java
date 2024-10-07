package product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Create_Product {

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
driver.findElement(By.linkText("Products")).click();
driver.findElement(By.xpath("//img[@title='Create Product...']")).click();


Random ran = new Random();       //generates unique names everytime
int ranNum = ran.nextInt(1000);


//step1:- path connection
FileInputStream fis1 = new FileInputStream("C:\\Users\\Guest2\\Downloads\\Book 4 (7).xlsx");

     //step2:- excel file in read mode
	Workbook book = WorkbookFactory.create(fis1);
	  
	//step3:- get control on sheet
	        org.apache.poi.ss.usermodel.Sheet sheet = book.getSheet("Sheet1");
	
	//step4:- get control on row
	Row row = sheet.getRow(6);   //organization name
	
	//step5:- get control on cell
	org.apache.poi.ss.usermodel.Cell cell = row.getCell(0);
	
	//step6:-fetching the cell value
	String proName = cell.getStringCellValue()+ranNum;   //concatinating proname with random variable


    driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(proName);

	
    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click(); 
	
  //--------verification
    Thread.sleep(2000);
    String actualdata = driver.findElement(By.xpath("//td[@id='mouseArea_Product Name']")).getText();
	
    if(actualdata.contains(proName) ) {
    	
    	System.out.println("product is created");
    	}
    	else {
    		System.out.println("product is not created");	
    	}
	
  //----------logout
	
  	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
  	driver.findElement(By.linkText("Sign Out")).click();
	
	}

}
