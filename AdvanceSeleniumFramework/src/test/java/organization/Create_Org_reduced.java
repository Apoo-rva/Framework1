package organization;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import generic_utility.Webdriver_Utility;
import object_repository.Create_Organization;
import object_repository.Verification_utility;
import object_repository.Vtiger_Homepage;
import object_repository.Vtiger_Loginpage;

public class Create_Org_reduced {

	public static void main(String[] args) throws Throwable {
		 WebDriver driver=new ChromeDriver();
		 
		 Webdriver_Utility wlib = new Webdriver_Utility();
		 Java_Utility jlib = new Java_Utility();
		 Excel_Utility elib = new Excel_Utility();
		 File_Utility flib = new File_Utility();
	     Vtiger_Homepage home = new Vtiger_Homepage(driver);
		 Vtiger_Loginpage login = new Vtiger_Loginpage(driver);
		 Create_Organization org = new Create_Organization(driver);
		Verification_utility verify = new Verification_utility(driver);
		
		
		 String BROWSER=flib.getKeyandValuePair("browser");
		 String URL=flib.getKeyandValuePair("url");
		 String UNAME=flib.getKeyandValuePair("username");
		 String PWORD=flib.getKeyandValuePair("password");


 //keeping reday for browser launch 
		 driver.get(URL);
	login.clickloginPage(UNAME, PWORD);         

//------------------------------------------------------	
	
	home.clickOrganizationLink();
	Thread.sleep(1000);
	org.getOrglookupimg().click();

   int ranNum = jlib.getRandomnum();


    
    String OrgName =  elib.getExceldata("Sheet1", 5, 0)+ranNum;
    org.sendOrgname(OrgName);

	
	
	String phnNum = elib.getExceldataDataformatter("Sheet1", 5, 1);
	org.sendphnum(phnNum);

	

	String email = elib.getExceldataDataformatter("Sheet1", 5, 2);
	org.sendmailid(email);

	
	
	Thread.sleep(1000);
	org.clickSave();


//----------------------verification---------
	Thread.sleep(2000);
	verify.OrganizationVerification(driver, OrgName);
	
	
	//----------logout
	 home.Clicksignout1();
	 home.Clicksignout2();

	}
}
