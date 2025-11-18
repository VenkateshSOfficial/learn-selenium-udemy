package oops_part_3;

public class Execute {
	public static void main(String[] args) {
		BoxWeight box = new BoxWeight(23, 12, 3, 190);
		System.out.println("Length: " + box.length);
		System.out.println("Width: " + box.width);
		System.out.println("Height: " + box.height);
		System.out.println("Weight: " + box.weight);
	}
}