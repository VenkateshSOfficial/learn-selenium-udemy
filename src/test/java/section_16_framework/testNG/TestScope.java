package section_16_framework.testNG;

import org.testng.annotations.*;


public class TestScope {
	@BeforeTest
	public void preRequisite(){
		System.out.println("execute start");
	}
	@Test(groups = {"smoke"})
	public void execute(){
		System.out.println("Hello world!!!");
	}
	@AfterTest
	public void tearDown(){
		System.out.println("execute end");
	}
}
