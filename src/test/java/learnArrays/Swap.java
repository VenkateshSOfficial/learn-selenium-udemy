package learnArrays;

import java.util.Arrays;


public class Swap {
	public static void main(String[] args) {
		String name="java";
		char[] charArray = name.toCharArray();
		System.out.println("Before swapping : " + Arrays.toString(charArray));
		int start=0;
		int end=name.length()-1;

		char temp =charArray[start];
		charArray[start]=charArray[end];
		charArray[end]=temp;

		System.out.println("After swapping : " + Arrays.toString(charArray));

	}
}
