package testngPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Hard_assert_Examp {
@Test
	public void m1() {
		int act = 10;
		int exp = 20;
		Assert.assertEquals(act, exp);  //if assert fails then it stops execution from that line
		System.out.println("assert passed");
	}

@Test
public void m2() {
	int act = 10;
	int exp = 10;
	Assert.assertEquals(act, exp);  
	System.out.println("assert passed");
}

@Test
public void m3() {
	int act = 10;
	int exp = 20;
	Assert.assertEquals(act, exp, "assert fail"); //if assert failed this line is printed else next line
	System.out.println("assert passed");
}

@Test
public void m4() {
	int act = 10;
	int exp = 10;
	Assert.assertEquals(act, exp, "assert fail"); 
	System.out.println("assert passed");//if assert passed this line is printed4
}
@Test
public void m5() {
	int act = 10;
	int exp = 10;
	Assert.assertNotEquals(act, exp, "assert fail");
	System.out.println("assert passed");//if assert passed this line is printed4
}

@Test
public void m6() {
	 String act = "hello";
	
	Assert.assertTrue(act.contains("e"), "fail");
	System.out.println("assert passed");//if assert passed this line is printed
}

}
