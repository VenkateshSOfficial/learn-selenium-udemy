package learnArrays;

import java.util.ArrayList;


public class BasicsArrayList {
	public static void main(String[] args) {
		// basic declaration
		ArrayList<Integer> vals=new ArrayList<>(5);
		vals.add(67);
		vals.add(45);
		vals.add(102);
		vals.add(345);
		vals.add(3456);

		vals.set(2,10000);
		System.out.println(vals);

		for(int i=0;i< vals.size();i++){
			System.out.println(vals.get(i));
		}
	}
}
