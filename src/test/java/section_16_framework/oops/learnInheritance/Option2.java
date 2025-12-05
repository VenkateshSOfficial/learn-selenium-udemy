package section_16_framework.oops.learnInheritance;

import org.testng.annotations.*;


public class Option2 extends Option1{
	@BeforeMethod
	public void beforeRun(){
		System.out.println("Run me first...!!!");
	}
	/*@Test
	public void run(){
		execute();
	}*/
	@AfterMethod
	public void afterRun(){
		System.out.println("Run me last...!!!!!!!!");
	}
}
