package oops_part_1;

public class Student {
	int rollNo;
	String name;
	float marks;

	/* above variables declared inside the class but outside any method or any block
	*  is called instance variables
	* */

	/* example of constructor overloading */

	public Student(){
		this.rollNo=12;
		this.name="Venkatesh Swaminathan";
		this.marks=75.0f;
	}

	public Student(int rollNo,String name,float marks){
		this.rollNo=rollNo;
		this.name=name;
		this.marks=marks;
	}

	public void greetings(){
		System.out.println("hello ! how are you " + name);
	}
	public void changeName(String newName){
		name=newName;
	}

	/* Class is a template or blue-print
	*  Objects are instances of the class
	* */
}
