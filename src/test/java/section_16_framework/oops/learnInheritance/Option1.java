package section_16_framework.oops.learnInheritance;

import org.testng.annotations.Test;


public class Option1 {

	@Test
	public void execute(){
		Option3 op3=new Option3(3);
		System.out.println("Hello iam from parent class..!!!");
		System.out.println("The increment val is : " + op3.increment());
		System.out.println("The decrement val is : " + op3.decrement());

	}
}
