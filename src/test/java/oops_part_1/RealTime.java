package oops_part_1;



public class RealTime {
	public static void main(String[] args) {
		Student student=new Student();
		Student student1=new Student(54,"Kaushik",99.5f);
		Student student2=new Student(45,"Rahul",78.98f);

		System.out.println("NAME : " + student.name +
				           " , ROLL-NO : " + student.rollNo +
				           " , MARKS : " + student.marks);
		student.greetings();
		System.out.println("***********************************");

		System.out.println("NAME : " + student1.name +
				" , ROLL-NO : " + student1.rollNo +
				" , MARKS : " + student1.marks);
		student.greetings();
		System.out.println("***********************************");

		System.out.println("NAME : " + student2.name +
				" , ROLL-NO : " + student2.rollNo +
				" , MARKS : " + student2.marks);
		student.greetings();
	}
}
