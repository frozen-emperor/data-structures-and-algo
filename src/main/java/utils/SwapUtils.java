package utils;

public class SwapUtils {
	public static void swapArrayElements(int[] arr, int i, int j, boolean lessThenCheck) {
		int temp;
		if (lessThenCheck && arr[i] > arr[j]) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}else {
			
		}
	}
}
