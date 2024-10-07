package practice;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import net.bytebuddy.asm.Advice.Enter;

public class TakeScreenshot {

	public static void main(String[] args) throws Throwable {
		 WebDriver driver= new ChromeDriver();
	     driver.manage().window().maximize();
	     
	     driver.get("https://www.youtube.com");
	     
	
	driver.findElement(By.xpath("//input[@id='search']")).sendKeys("selenium java");
	driver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();

	Thread.sleep(2000);
      driver.findElement(By.xpath("//div[@id='thumbnail-container']")).click();
	
	Thread.sleep(2000);
	TakesScreenshot ss = (TakesScreenshot)driver;
    
     File src = ss.getScreenshotAs(OutputType.FILE);
     File des = new File("./screenshot1.png");
     FileUtils.copyFile(src, des);
	
	}

}
