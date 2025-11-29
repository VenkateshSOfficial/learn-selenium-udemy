package section_16_framework.testNG;

import org.testng.annotations.*;


public class ScopeClass {
	@BeforeClass
	public void preOrder(){
		System.out.println("I come first");
	}
	@Test
	public void exe(){
		System.out.println("come on");
	}
	@AfterClass
	public void postOrder(){
		System.out.println("i come last");
	}
}
