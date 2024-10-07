package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Vtiger_Loginpage { //class name same as that of application page

	//2nd create construtor to make access to objects
	       public  Vtiger_Loginpage( WebDriver driver){
	      PageFactory.initElements(driver, this);
	       }
	
	//1st identify all objects
	
	@FindBy(xpath = "//input[@name='user_name']")
	private WebElement userText;
	
	@FindBy(xpath = "//input[@name='user_password']")
	private WebElement pwdText;
	
	@FindBy(xpath = "//input[@id='submitButton']")
	private WebElement loginbutton;

	//3rs create getters 
	public WebElement getUserText() {
		return userText;
	}

	public WebElement getPwdText() {
		return pwdText;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}



//to further optimize code use business logic
//create 1 method
public void clickloginPage(String username,String password) {
	userText.sendKeys(username);
	pwdText.sendKeys(password);
	loginbutton.click();
}

}
