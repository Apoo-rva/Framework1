package testngPractice;

import org.testng.annotations.Test;

public class SampleTest {

	@Test(priority = 2,invocationCount = 2)
	public void m1() {
		System.out.println("contact created");
	}


	@Test(enabled = false)                    //will skip execution of this method
	//@Test(dependsOnMethods ="m1" )          //if m1 fails then m2 will skip execution
	public void m2() {
		System.out.println("contact modified");
	}

	@Test(priority = 0,invocationCount = 2 )
	public void m3() {
		System.out.println("contact deleted");
	}
//----if we write annotations on class so all methods gets triggered-----
}
