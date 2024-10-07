package object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Verification_utility {
	public Verification_utility(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
   
	@FindBy(xpath="//span[@id='dtlview_Campaign Name']")
	private WebElement  camptextfield;
	
	@FindBy(xpath="//td[@id='mouseArea_Product Name']")
	private WebElement  protextfield;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement  orgtextfield;

	
	//business logic
	public void campaignVerification(WebDriver driver,String cname) {
		String actData = camptextfield.getText();
			
		    if(actData.contains(cname) ) {
		    	
		    	System.out.println("campaign is created");
		    	}
		    	else {
		    		System.out.println("campaign is not created");	
		    	}
	}


	public void productVerification(WebDriver driver,String pname) {
		 String actualdata = protextfield.getText();
			
		    if(actualdata.contains(pname) ) {
		    	
		    	System.out.println("product is created");
		    	}
		    	else {
		    		System.out.println("product is not created");	
		    	}
	
	}


	public void OrganizationVerification(WebDriver driver,String OrgName) {
		String actualdata = orgtextfield.getText();
		
		if(actualdata.contains(OrgName) ) {
		
		System.out.println("organization is created");
		}
		else {
			System.out.println("organization is not created");	
		}
	}






}
