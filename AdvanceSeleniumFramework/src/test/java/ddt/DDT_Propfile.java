package ddt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;

public class DDT_Propfile {

	public static void main(String[] args) throws Throwable {

		//1st--establish conn btw script and properties file
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
	}

}
