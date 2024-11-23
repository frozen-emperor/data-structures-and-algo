package utils;

public class PrintUtils {

	private static void printArrays(int[] arr1, int[] arr2) {
		if (arr1[0] > arr2[0]) {
			int[] temp = arr1;
			arr1 = arr2;
			arr2 = temp;
		}
		System.out.print("[");
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + ",");
		}
		System.out.print("]");
		System.out.println();
		System.out.print("[");
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + ",");
		}
		System.out.print("]");
	}

	public static void printArrays(int[] arr) {
		System.out.print("[");	
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i < arr.length - 1) {
				System.out.print(",");
			}
		}
		System.out.println("]");
	}
}
