package generic_utility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Webdriver_Utility {
/**
 * this method is used for maximizing windows
 * @param driver
 */
	public WebDriver driver;
	public void windowMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	   
	}

	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	
	public void alert_popup(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void mouseoverAction(WebDriver driver,WebElement element) {
		
        Actions act = new Actions(driver);
       act.moveToElement(element).perform();
	}


	public void windowSwitching(WebDriver driver,String titlewin) {
		Set<String> allwin = driver.getWindowHandles();
		Iterator<String> it = allwin.iterator();   //standard way of handling windows

		while(it.hasNext()) {    //enters loop if there is next window
		  String win = it.next();      //switches to nxt wind
		  driver.switchTo().window(win);
		  
		 String title = driver.getTitle();
		 
		 if(title.contains(titlewin)) {
		  break;
		 }
		}
	}



}


