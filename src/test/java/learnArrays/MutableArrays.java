package learnArrays;

import java.util.Arrays;


public class MutableArrays {
	public static void main(String[] args) {
		int[] nums={12,23,34,41,56,69};
		System.out.println("Actual val : " + Arrays.toString(nums));
		changeVal(nums,3,100);
		System.out.println("Changed array val : " + Arrays.toString(nums));
	}
	public static void changeVal(int[] arr,int index,int val){
		arr[index]=val;
	}
}
