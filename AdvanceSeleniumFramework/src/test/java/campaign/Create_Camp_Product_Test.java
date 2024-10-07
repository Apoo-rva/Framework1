package campaign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import generic_utility.Webdriver_Utility;
import object_repository.CreateCamp;
import object_repository.Product_Create_Page;
import object_repository.Verification_utility;
import object_repository.Vtiger_Homepage;
import object_repository.Vtiger_Loginpage;

public class Create_Camp_Product_Test {

	@Test
	public void Create_camp_product_codeopti() throws Throwable   {
	    WebDriver driver=new ChromeDriver();           //keeping reday for browser launch  
		File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility();
	    Excel_Utility elib = new Excel_Utility();
	    Webdriver_Utility wlib = new Webdriver_Utility();
		Vtiger_Loginpage login = new Vtiger_Loginpage(driver);
		Vtiger_Homepage home = new Vtiger_Homepage(driver);
		Product_Create_Page pro = new Product_Create_Page(driver);
		
		 String BROWSER	=flib.getKeyandValuePair("browser");
		 String URL=	flib.getKeyandValuePair("url");
		 String UNAME=flib.getKeyandValuePair("username");
		 String PWORD= flib.getKeyandValuePair("password");
		
	            
//4th launching multiple browsers

//5th-pass url of application
driver.get(URL);

//6th-locating web elements and give values
login.clickloginPage(UNAME, PWORD);

//here campaign module is dependent on product so create product modu 1st		

home.clickProductsLink();
pro.clickproductimg();
 int ranNum = jlib.getRandomnum();
 
   String proName=elib.getExceldata("Sheet1", 6, 0)+ranNum;

    pro.sendProductName(proName);
    pro.clickSave();

//-----create campaign


 home.clickMoreLinks();
 WebElement element = driver.findElement(By.xpath("//a[text()='More']"));
wlib.mouseoverAction(driver,element);
home.clickCampLink();

       CreateCamp camp = new CreateCamp(driver);
       camp.clickLookupimg();
 
 		String campName=elib.getExceldata("Sheet1", 7, 0)+ranNum;
 		
 
       camp.sendText(campName);
 	//		driver.findElement(By.name("campaignname")).sendKeys(campName);
 		
//--------adding product

       camp.clickaddProduct();

//switching window
       
wlib.windowSwitching(driver,"Products&action");

Product_Create_Page product = new Product_Create_Page(driver);
product.productSearch(proName);
product.clickOnSearchBar();

// driver.findElement(By.xpath("//a[text()='Iphone61']")).click();   dont give this

Thread.sleep(2000);
// dynamic xapth
product.ClickaddProuct(driver, proName);

//switch back to main window
Thread.sleep(1000);
wlib.windowSwitching(driver,"Campaigns&record");
camp.clickSave();
 
//-----------verification
Thread.sleep(2000);

Verification_utility vlib = new Verification_utility(driver);
vlib.campaignVerification(driver, campName);

//----------logout

home.Clicksignout1();
home.Clicksignout2();


	}
}
