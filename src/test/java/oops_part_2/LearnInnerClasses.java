package oops_part_2;

public class LearnInnerClasses {
	static class InnerOne{
		String name;

		public InnerOne(String name){
			this.name=name;
		}
	}

	public static void main(String[] args) {
		InnerOne innerOne=new InnerOne("Kaushik");
		InnerOne innerTwo=new InnerOne("Venkatesh");
		System.out.println(innerTwo.name);
	}
}
