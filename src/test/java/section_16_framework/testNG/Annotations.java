package section_16_framework.testNG;

import org.testng.annotations.Test;


public class Annotations {
	@Test(groups = {"smoke"})
	public void execute(){
		System.out.println("Hello world!!");
	}
}
