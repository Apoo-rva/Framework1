package campaign;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import generic_utility.Base_Class;
import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import generic_utility.Webdriver_Utility;
import object_repository.CreateCamp;
import object_repository.Verification_utility;
import object_repository.Vtiger_Homepage;

public class create_camp_Regionaal_Regression extends Base_Class {

	@Test
		public  void create_camp_Regionaal_Regression() throws Throwable {
Webdriver_Utility wlib = new Webdriver_Utility();

		
		wlib.windowMaximize(driver);
		wlib.implicitWait(driver);

//-----create campaign

          Vtiger_Homepage home = new Vtiger_Homepage(driver);
            home.clickMoreLinks();
            home.clickCampLink();
          

         
 		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();

 		//---optimized code for random class
 		           Java_Utility data1 = new Java_Utility();
 		          int ranNum = data1.getRandomnum();
//---optimized excel code
 		
 		Excel_Utility elib = new Excel_Utility();
 		String campName= elib.getExceldata("Sheet1", 7, 0)+ranNum;
 		
 		   
 		CreateCamp camp = new CreateCamp(driver);
 		camp.clickLookupimg();
 		camp.sendText(campName);
 		camp.clickSave();
 		
	
	
 			//--------verification
 		    Thread.sleep(1000);
 		    Verification_utility verify = new Verification_utility(driver);
 		    verify.campaignVerification(driver, campName);
 
 		  //----------logout
 		   Thread.sleep(1000);
	
 	
	
	}
				
				
		@Test
		public  void create_Product() throws Throwable {
			WebDriver driver=new ChromeDriver();           //keeping reday for browser launch  
	         
            File_Utility flib = new File_Utility();
            String URL = flib.getKeyandValuePair("url");
            String UNAME = flib.getKeyandValuePair("username");
            String PWORD = flib.getKeyandValuePair("password");
//5th-pass url of application
driver.get(URL);

//6th-locating web elements and give values
driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UNAME);
driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PWORD);
driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
//------------------------------------------------------	
driver.findElement(By.linkText("Products")).click();
driver.findElement(By.xpath("//img[@title='Create Product...']")).click();

//java utility
                     Java_Utility jlib = new Java_Utility();
                     int ranNum = jlib.getRandomnum();



                     Excel_Utility elib = new Excel_Utility();
                     String proName=elib.getExceldata("Sheet1", 6, 0)+ranNum;


   driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(proName);

	
   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click(); 
	
 //--------verification
   Thread.sleep(2000);
   
   Verification_utility vlib = new Verification_utility(driver);
   vlib.productVerification(driver, proName);
   
	
 //----------logout
	
 	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
 	driver.findElement(By.linkText("Sign Out")).click();
	
	}

}


