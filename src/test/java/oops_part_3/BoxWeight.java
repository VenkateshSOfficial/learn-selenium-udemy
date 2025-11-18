package oops_part_3;

public class BoxWeight extends Box{
	long weight;
	BoxWeight(long length,long width, long height,long weight){
		super(length,width,height);
		this.weight=weight;
	}
}
