package practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot {

	public static void main(String[] args) throws Throwable {
     WebDriver driver= new ChromeDriver();
     driver.manage().window().maximize();
     driver.get("https://www.flipkart.com");
     
             TakesScreenshot ss = (TakesScreenshot)driver;
     
		    File src = ss.getScreenshotAs(OutputType.FILE);
	         File des = new File("./screenshotnew.png");
	         FileUtils.copyFile(src, des);
	}

}
