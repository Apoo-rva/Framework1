package campaign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import generic_utility.Base_Class;
import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import generic_utility.Webdriver_Utility;
import object_repository.CreateCamp;
import object_repository.Verification_utility;
import object_repository.Vtiger_Homepage;
import object_repository.Vtiger_Loginpage;

public class Create_Campaign_Baseclass_Test extends Base_Class {
@Test
	public void Create_Campaign_Baseclass_Test()throws Throwable 
	{  


		
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
	         home.Clicksignout1();
	         home.Clicksignout2();
 	
	
	}
}
