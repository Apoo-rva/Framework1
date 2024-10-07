package campaign;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Create_Campaign_Product_Logout {

	
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
		
	//here campaign module is dependent on product so create product modu 1st		
			
			
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
			
			
			
			
			
			//-----create campaign

			WebElement element = driver.findElement(By.xpath("//a[text()='More']"));
			          Actions act = new Actions(driver);
			         act.moveToElement(element).perform();

			         driver.findElement(By.linkText("Campaigns")).click();
			 		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();

			 		Random ran1 = new Random();
			 		int ranNum1 = ran.nextInt(1000);

			 		
			 		//step1:- path connection
			 		FileInputStream fis = new FileInputStream("C:\\Users\\Guest2\\Downloads\\Book 4 (7).xlsx");

			 		     //step2:- excel file in read mode
			 			 Workbook book1 = WorkbookFactory.create(fis);
			 			  
			 			//step3:- get control on sheet
			 			        org.apache.poi.ss.usermodel.Sheet sheet1 = book1.getSheet("Sheet1");
			 			
			 			//step4:- get control on row
			 			Row row1 = sheet1.getRow(7);   //organization name
			 			
			 			//step5:- get control on cell
			 			org.apache.poi.ss.usermodel.Cell cell1 = row1.getCell(0);
			 			
			 			//step6:-fetching the cell value
			 			String campName = cell1.getStringCellValue()+ranNum;   //concatinating proname with random variable

			 			driver.findElement(By.name("campaignname")).sendKeys(campName);
			 		
	//--------adding product
		
	driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		
	//switching window
	
	   Set<String> allwin = driver.getWindowHandles();
	      Iterator<String> it = allwin.iterator();   //standard way of handling windows
		
	      while(it.hasNext()) {    //enters loop if there is next window
	    	  String win = it.next();      //switches to nxt wind
	    	  driver.switchTo().window(win);
	    	  
	    	 String title = driver.getTitle();
	    	 
	    	 if(title.contains("Products&action")) {
	    	  break;
	    	 }
	      }
	     driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(proName);
	     driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
	     
	  // driver.findElement(By.xpath("//a[text()='Iphone61']")).click();   dont give this

			Thread.sleep(2000);
			// dynamic xapth
			driver.findElement(By.xpath("//a[text()='" + proName + "']")).click();  //concatinate with exceldata
	
		//switch back to main window
		          Set<String> all1 = driver.getWindowHandles();
		         Iterator<String> it1 = all1.iterator();
		
		while(it1.hasNext()) {
			String win1 = it1.next();
		 driver.switchTo().window(win1);
	          String tit1 = driver.getTitle();
		if(tit1.contains("Campaigns&record")) {
		break;
		}
		}

		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click(); 
		//-----------verification
		  Thread.sleep(2000);
		   String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
			
		    if(actData.contains(campName) ) {
		    	
		    	System.out.println("campaign is created");
		    	}
		    	else {
		    		System.out.println("campaign is not created");	
		    	}
		
		 //----------logout
			
		  	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		  	driver.findElement(By.linkText("Sign Out")).click();
}
}