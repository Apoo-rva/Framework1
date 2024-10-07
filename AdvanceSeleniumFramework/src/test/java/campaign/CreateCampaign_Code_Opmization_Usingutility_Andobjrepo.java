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

import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import generic_utility.Webdriver_Utility;
import object_repository.CreateCamp;
import object_repository.Verification_utility;
import object_repository.Vtiger_Homepage;
import object_repository.Vtiger_Loginpage;
//
public class CreateCampaign_Code_Opmization_Usingutility_Andobjrepo {
	
     @Test
	public void   CreateCampaign_Code_Opmization_Usingutility() throws Throwable {
		//1st pull
		WebDriver driver=new ChromeDriver();

		 Webdriver_Utility wlib = new Webdriver_Utility();
		 File_Utility file = new File_Utility();
		  Java_Utility data1 = new Java_Utility();
		 Vtiger_Loginpage login = new Vtiger_Loginpage(driver);
		 Vtiger_Homepage home = new Vtiger_Homepage(driver);
			CreateCamp camp = new CreateCamp(driver);
		 Excel_Utility elib = new Excel_Utility();
		 Verification_utility verify = new Verification_utility(driver);
		
		wlib.windowMaximize(driver);
		wlib.implicitWait(driver);
//--code optimization using fileutility class---

		   String URL = file.getKeyandValuePair("url");
		   String UNAME = file.getKeyandValuePair("username");
		   String PWORD = file.getKeyandValuePair("password");
		
//5th-pass url of application
driver.get(URL);


//optimizing code using getters----------approach1 using constructors
 /*       Vtiger_Loginpage login = new Vtiger_Loginpage(driver);
        login.getUserText().sendKeys(UNAME);
        login.getPwdText().sendKeys(PWORD);
        login.getLoginbutton().click();   */

//optimizing code using business logic--approach2

login.clickloginPage(UNAME, PWORD);		

//-----create campaign
          home.clickMoreLinks();
            home.clickCampLink();
          

         
 //		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();

 		//---optimized code for random class
 		          int ranNum = data1.getRandomnum();
//---optimized excel code
 		String campName= elib.getExceldata("Sheet1", 7, 0)+ranNum;
 		
 		   
 	
 		camp.clickLookupimg();
 		camp.sendText(campName);
 		camp.clickSave();
 		
 		//--------verification
 		    Thread.sleep(1000);		    
 		    verify.campaignVerification(driver, campName);
		  //----------logout
 		   Thread.sleep(1000);
 		    home.Clicksignout1();
 		    home.Clicksignout2();
 			
	}
	}


