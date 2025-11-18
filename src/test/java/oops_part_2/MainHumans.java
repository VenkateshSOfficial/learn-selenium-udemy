package oops_part_2;

public class MainHumans {
	public static void main(String[] args) {
		Humans Anish=new Humans("Anish",25,10000,true);
		Humans Ravi=new Humans("Ravi",34,40000,false);
		Humans Rahul=new Humans("Rahul",32,50000,false);

		System.out.println(Anish.name);
		System.out.println(Humans.population);
	}
}
