package oops_part_2;

public class Humans {
	String name;
	int age;
	int salary;
	boolean maritalStatus;
	static long population;

	public Humans(String name,int age,int salary,boolean maritalStatus){
		this.name=name;
		this.age=age;
		this.salary=salary;
		this.maritalStatus=maritalStatus;
		Humans.population=population+1;
	}
}
