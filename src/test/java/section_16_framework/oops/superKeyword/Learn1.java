package section_16_framework.oops.superKeyword;

import org.testng.annotations.Test;


public class Learn1 {
	@Test
	public void exe(){
		Learn2 l2=new Learn2(5);
//		System.out.println("The increment val : " + l2.increment());
//		System.out.println("The decrement val : " + l2.decrement());
		System.out.println("The Multiply val : " + l2.multiplyByFour());
		System.out.println("The multiply of three is " + l2.multiplyByThree());
	}
}
