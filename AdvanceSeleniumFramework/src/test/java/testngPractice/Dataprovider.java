package testngPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider {
                       //method name
	@Test(dataProvider="dataprovider")
	public void bookTicket(String src,String dest,int ppl) {
		System.out.println("book tickets from" +src+ "to" +dest+"for"+ppl);
	}

@DataProvider
   public Object[][] dataprovider(){
	            Object[][] objarr = new Object[2][3];
	   
	            objarr[0][0]="Banagalore";
	            objarr[0][1]="Hubli";
	            objarr[0][2]=2;
	   
	            objarr[1][0]="Banagalore";
	            objarr[1][1]="goa";
	            objarr[1][2]=5;
	   
	            
	            return objarr;
			   
	   
   }


}
