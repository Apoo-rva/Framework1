package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Vtiger_Homepage {

	//2nd create constructor
	public Vtiger_Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

		//1st identify all objects
		@FindBy(linkText = "Organizations")
		private WebElement  orgLink;
	
		@FindBy(linkText = "Products")
		private WebElement prodLink;
		
		@FindBy(xpath = "//a[text()='More']")
		private WebElement moreLink;
		
		@FindBy(linkText =  "Campaigns")
		private WebElement campLink;
		
		
		
		@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
		private WebElement signOut1;

		@FindBy(linkText = "Sign Out")
		private WebElement signOut2;
		
		//generate getters 
		public WebElement getOrgLink() {
			return orgLink;
		}

		public WebElement getProdLink() {
			return prodLink;
		}

		public WebElement getMoreLink() {
			return moreLink;
		}
		public WebElement getCampLink() {
			return campLink;
		}


		public WebElement getSignOut1() {
			return signOut1;
		}

		public WebElement getSignOut2() {
			return signOut2;
		}
		
	
		
		//business logic
	public void clickOrganizationLink() {
		orgLink.click();
	}	
	public void clickProductsLink() {
		prodLink.click();
	}
	
	public void clickMoreLinks() {
		moreLink.click();
	}
	public void clickCampLink() {
		campLink.click();
	}
	
	public void Clicksignout1() {
		signOut1.click();
	}
	public void Clicksignout2() {
		signOut2.click();	
	}
	
}
