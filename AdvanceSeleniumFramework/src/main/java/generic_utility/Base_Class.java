package generic_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import object_repository.Vtiger_Homepage;
import object_repository.Vtiger_Loginpage;

public class Base_Class {
	public static WebDriver driver;  //made driver as static for invoking Listner

	@BeforeSuite
	public void bS() {
		System.out.println("connect to database");
	}

	@BeforeTest
	public void bT() {
		System.out.println("parallel execution");

	}

	@Parameters(value="BROWSER")////while using crossbrowser execution readding browser value from xml
	@BeforeClass
	public void bC(String BROWSER) throws Throwable {

		File_Utility flib = new File_Utility();
//		String BROWSER = flib.getKeyandValuePair("browser");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}

		else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		else {
			driver = new ChromeDriver(); // default 1 browser
		}
		System.out.println("launch browser");
	}

//	@Parameters({"URL","UNAME","PWORD"})  using xml file
	@BeforeMethod
//	public void bM(String BROWSER,String UNAME,String PWORD) throws Throwable {
		public void bM() throws Throwable {
		File_Utility file = new File_Utility();
		String URL = file.getKeyandValuePair("url");
		String UNAME = file.getKeyandValuePair("username");
		String PWORD = file.getKeyandValuePair("password");

		// 5th-pass url of application
		driver.get(URL);

		// optimizing code using business logic--approach2
		Vtiger_Loginpage login = new Vtiger_Loginpage(driver);
		login.clickloginPage(UNAME, PWORD);

		System.out.println("login into application");
	}

	@AfterMethod
	public void aM() throws Throwable {
		Thread.sleep(1000);
		Vtiger_Homepage home = new Vtiger_Homepage(driver);
		home.Clicksignout1();
		home.Clicksignout2();;

		System.out.println("logout from application");

	}

	@AfterClass
	public void aC() {
		driver.quit();
		System.out.println("close browser");

	}

	@AfterTest
	public void aT() {
		System.out.println("parallel execution");

	}

	@AfterSuite
	public void aS() {
		System.out.println("close database connection");
	}
}
