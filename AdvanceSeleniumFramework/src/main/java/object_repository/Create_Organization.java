package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Organization {
public  Create_Organization(WebDriver driver) {
	PageFactory.initElements( driver,this);
}


@FindBy(xpath="//img[@alt='Create Organization...']")
  private WebElement orglookupimg;

@FindBy(name = "accountname")
private WebElement orgname;

@FindBy(id="phone")
private WebElement phnum;

@FindBy(id = "email1")
private WebElement mailid;

@FindBy(xpath = "//input[@title='Save [Alt+S]']")
private WebElement savebutton;


public WebElement getOrglookupimg() {
	return orglookupimg;
}

public WebElement getOrgname() {
	return orgname;
}

public WebElement getPhnum() {
	return phnum;
}

public WebElement getMailid() {
	return mailid;
	
}
public WebElement getSavebutton() {
	return savebutton;
}


//business logic
public void clickorgnlookupimg() {
	orglookupimg.click();
}
public void sendOrgname(String organame) {
	orgname.sendKeys(organame);
}
public void sendphnum(String phnumer) {
	phnum.sendKeys(phnumer);
}
public void sendmailid(String email) {
	mailid.sendKeys(email);
}
public void clickSave() {
	savebutton.click();
}
}