package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCamp {

	
	public CreateCamp(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath = "//img[@alt='Create Campaign...']")
private WebElement campLookupimg;
	
    @FindBy(name = "campaignname")
    private WebElement campText;
    
    @FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
    private WebElement	addProduct;	

@FindBy(xpath = "//input[@title='Save [Alt+S]']")
private WebElement savebutton;

public WebElement getCampLookupimg() {
	return campLookupimg;
}

public WebElement getCampText() {
	return campText;
}

public WebElement getSavebutton() {
	return savebutton;
}

//business logic
public void clickLookupimg() {
	campLookupimg.click();
}
public void sendText(String name) {
	campText.sendKeys(name);


}

public void clickaddProduct() {
	addProduct.click();
}
public void clickSave() {
	savebutton.click();
}
}
