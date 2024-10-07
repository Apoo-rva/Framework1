package testngPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic_utility.Java_Utility;

public class CreateOrg {
@Test(dataProvider ="organization" )
	public void createOrganization(String OrgName,String phnNum,String email) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();

		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		
		driver.findElement(By.id("phone")).sendKeys(phnNum);
		
		driver.findElement(By.id("email1")).sendKeys(email);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click(); 
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}
@DataProvider
public Object[][] organization(){
	       Java_Utility jlib = new Java_Utility();
	       int ran = jlib.getRandomnum();
	 Object[][] objarr = new Object[3][3];
	 objarr[0][0]="AAA"+ran;
	 objarr[0][1]="9876545678";
	 objarr[0][2]="abc@gmail.com";
	 
	 objarr[1][0]="BBB"+ran;
	 objarr[1][1]="9876545678";
	 objarr[1][2]="abc@gmail.com";
	 
	 objarr[2][0]="ccc"+ran;
	 objarr[2][1]="9876545678";
	 objarr[2][2]="abc@gmail.com";
	 
	return objarr;
	
}

}
