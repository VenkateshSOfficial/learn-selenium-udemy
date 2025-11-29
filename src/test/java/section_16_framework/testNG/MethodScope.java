package section_16_framework.testNG;

import org.testng.annotations.*;


public class MethodScope {
	@BeforeMethod
	public void before(){
		System.out.println("i come before");
	}
	@Test
	public void t1(){
		System.out.println("This is t1...");
	}
	@Test
	public void t2(){
		System.out.println("This is t2...");
	}
	@AfterMethod
	public void after(){
		System.out.println("i come after");
	}
}
