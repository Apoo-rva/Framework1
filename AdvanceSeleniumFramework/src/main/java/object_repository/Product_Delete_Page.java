package object_repository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_Delete_Page {
 
	public  Product_Delete_Page(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}

@FindBy(xpath = "//a[text()='Products']")
private WebElement productLink;           //to get product list page

@FindBy(xpath="//input[@value='Delete']")
private WebElement  deleteButton;

//business logic

public void clickProductField() {
	productLink.click();
}

public void checkBoxselect(WebDriver driver,String proName) {
	driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='" + proName +"']/../preceding-sibling::td//input[@type='checkbox']")).click();

}	


public void clickDelete() {
	deleteButton.click();
}
public void validateProductDeleted(WebDriver driver,String proName) {
	List<WebElement> productList = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));

	boolean flag=false;
	for(WebElement prdName1:productList)
	{
	String actData = prdName1.getText();
	if(actData.contains(proName))
	{
	flag=true;
	break;
	}
	}
	if(flag)
	{
	System.out.println("product data is deleted");
	}
	else
	{
	System.out.println("product data not deleted");
	}
}

}
