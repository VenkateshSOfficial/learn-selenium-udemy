package learnArrays;

public class Arraysbasics {
	public static void main(String[] args) {
		/*
		1 : Array is sequential collection of homogeneous elements with similar datatype.
		2 : Array is always fixed in size.
		3 : Collection of multiple datatype is strictly not allowed.
		4 : Size increase is not possible
		===================================================================================
		int[] rollNo => Array declaration
		rollNo=new int[5] => Array initialization (Object is being created in the heap memory)

		Array objects stored in the heap memory are not continuous.
		Dynamic memory allocation of the elements in the heap area.
		heap area == dynamic memory allocation
		*/
		int[] rollNos=new int[5];
		//      OR
		int[] rollNo={10,23,45,46,76};
		rollNos[0]=123;
		rollNos[1]=234;
		rollNos[2]=897;

		System.out.println(rollNos[2]);
		System.out.println(rollNo[3]);

		for(int i=0;i<rollNo.length;i++){
			System.out.println(rollNo[i]);
		}
		for (int i : rollNo) {
			System.out.print(i + " ");
		}

	}
}
