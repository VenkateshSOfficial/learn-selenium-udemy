package section_16_framework.oops.superKeyword;

public class Learn2 extends Learn3{
	int a;
	public Learn2(int a){
		super(a);
		this.a=a;
	}
	public int increment(){
		a++;
		return a;
	}
	public int decrement(){
		a--;
		return a;
	}
}
