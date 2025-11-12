package learnArrays;

import java.util.Arrays;


public class MultidimentionArray {
	public static void main(String[] args) {
		int[][] arr={
				{1,2,3},  // individual array
				{4,5,6},  // individual array
				{7,8,9}   // individual array
		};
//		System.out.println(arr[1][2]);

		for(int row=0;row<arr.length;row++){
			for(int col=0;col<arr[row].length;col++){
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}

		for(int i=0;i<arr.length;i++){
			System.out.println(Arrays.toString(arr[i]));
		}
	}
}
