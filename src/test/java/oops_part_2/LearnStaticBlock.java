package oops_part_2;

public class LearnStaticBlock {
	static int a=10;
	static int b;

	// will run only once when the class is loaded for the first time
	static{
		System.out.println("Hello iam a static block !....");
		b=a*5;
	}
	public static void main(String[] args) {
		LearnStaticBlock staticBlock=new LearnStaticBlock();
		LearnStaticBlock staticBlock2=new LearnStaticBlock();

		System.out.println("The value of a : " + staticBlock.a);
		System.out.println("The value of b : " + staticBlock.b);

		System.out.println("The value of a : " + staticBlock2.a*5);
		System.out.println("The value of b : " + staticBlock2.b*5);

		System.out.println("The value of a : " + staticBlock.a*10);
		System.out.println("The value of b : " + staticBlock.b*10);
	}
}
