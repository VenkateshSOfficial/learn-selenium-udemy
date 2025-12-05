package section_16_framework.testNG;

import org.testng.annotations.*;


public class PracticeImplementListeners {
	@BeforeTest
	public void preRequisite(){
		System.out.println("before start");
	}
	@Test
	public void execute(){
		System.out.println("Executing data");
	}
	@AfterTest
	public void tearDown(){
		System.out.println("tear down closing");
	}
}
