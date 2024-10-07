package object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_Create_Page {
	
 public Product_Create_Page(WebDriver driver) {
	 PageFactory.initElements( driver,this);
	
 }
 
 @FindBy(xpath="//img[@title='Create Product...']")
 private WebElement productLookupimg;
 
 
 @FindBy(xpath="//input[@name='productname']")
 private WebElement  productTextfield;
 
 @FindBy(xpath="//input[@id='search_txt']")
 private WebElement productSearch;
 
 @FindBy(xpath="//input[@class='crmbutton small create']")
 private WebElement searchBar;
 
 @FindBy(xpath = "//input[@title='Save [Alt+S]']")
 private WebElement savebutton;


 


//business logic
 
public void clickproductimg() {
	productLookupimg.click();
}

public void sendProductName(String productname) {
	productTextfield.sendKeys(productname);
}
public void productSearch(String proName) {
	productSearch.sendKeys(proName);
}
public void clickOnSearchBar() {
	searchBar.click();
}

public void ClickaddProuct(WebDriver driver,String proName ) {
	driver.findElement(By.xpath("//a[text()='" + proName + "']")).click();
}
public void clickSave() {
	savebutton.click();
}
}
