package section_16_framework.testNG;

import org.testng.annotations.*;


public class SuiteScope {
	@BeforeSuite
	public void pre(){
		System.out.println("I am suite pre....!!");
	}
	@Test(enabled = false)
	public void exect(){
		System.out.println("heeeelllllo");
	}
	@AfterSuite
	public void post(){
		System.out.println("I am suite post...!!");
	}
}
