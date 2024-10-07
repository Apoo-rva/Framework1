package product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import generic_utility.Webdriver_Utility;
import object_repository.Product_Create_Page;
import object_repository.Product_Delete_Page;
import object_repository.Verification_utility;
import object_repository.Vtiger_Homepage;
import object_repository.Vtiger_Loginpage;

public class Create_Delete_product_Test {

	@Test
	public  void Create_Product_Optimization_using_utility() throws Throwable {

	            
//4th launching multiple browsers

	         WebDriver driver=new ChromeDriver();           //keeping reday for browser launch  
	         
             File_Utility flib = new File_Utility();
             Vtiger_Loginpage login = new Vtiger_Loginpage(driver);
             Vtiger_Homepage home = new Vtiger_Homepage(driver);
             Product_Create_Page pro = new Product_Create_Page(driver);
             
             
             String URL = flib.getKeyandValuePair("url");
             String UNAME = flib.getKeyandValuePair("username");
             String PWORD = flib.getKeyandValuePair("password");
//5th-pass url of application
driver.get(URL);

//6th-locating web elements and give values
login.clickloginPage(UNAME, PWORD);
		
//------------------------------------------------------
home.clickProductsLink();
pro.clickproductimg();

//java utility
                      Java_Utility jlib = new Java_Utility();
                      int ranNum = jlib.getRandomnum();



                      Excel_Utility elib = new Excel_Utility();
                      String proName=elib.getExceldata("Sheet1", 6, 0)+ranNum;

    pro.sendProductName(proName);
    pro.clickSave();

  //--------verification
    Thread.sleep(2000);
    
    Verification_utility vlib = new Verification_utility(driver);
    vlib.productVerification(driver, proName);
    
	
  //----------logout
    home.Clicksignout1();
    home.Clicksignout2();
	
	}
}
