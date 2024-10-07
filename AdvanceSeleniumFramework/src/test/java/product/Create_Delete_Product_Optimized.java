package product;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import generic_utility.Webdriver_Utility;
import object_repository.Product_Create_Page;
import object_repository.Product_Delete_Page;
import object_repository.Vtiger_Homepage;
import object_repository.Vtiger_Loginpage;

public class Create_Delete_Product_Optimized {
@Test
	public void create_Delete_Product_Optimized() throws Throwable {
		WebDriver driver=new ChromeDriver();

		 File_Utility flib = new File_Utility();
		 Vtiger_Loginpage login = new Vtiger_Loginpage(driver);
         Vtiger_Homepage home = new Vtiger_Homepage(driver);
         Product_Create_Page pro = new Product_Create_Page(driver);
          Product_Delete_Page delete = new Product_Delete_Page(driver);
         
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
		
	
//-----------------------------------------------------------	
	//navigating the product table
	delete.clickProductField();
//driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='Product Name']/../preceding-sibling::td//input[@type='checkbox']")).click();

	//Dynamic Xpath
	delete.checkBoxselect(driver,proName);
	Thread.sleep(1000);
	delete.clickDelete();

Thread.sleep(1000);
Webdriver_Utility wlib = new Webdriver_Utility();
wlib.alert_popup(driver);

delete.validateProductDeleted(driver, proName);


Thread.sleep(1000);
home.Clicksignout1();
Thread.sleep(1000);
home.Clicksignout2();

}
	}


