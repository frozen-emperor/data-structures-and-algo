package utils;

public class MyArrayUtils {
	public static int[][] getArrays() {
		int[][] arrays = { { 20, 35, -15, 7, 55, 1, -22 }, { 1, 2, 3, 4, 5, 6, 7, 8 }, { 55, 45, 35, 25, 15, 0, -15 },
				{ -1, 20, 90, 0, -56, -23 }, { 4, 1, 3, 9, 7 },
				{ 6334, 4098, 7968, 4523, 277, 6956, 4560, 2062, 5705, 5743, 879, 5626, 9961, 491, 2995, 741, 4827 } };
		return arrays;
	}

	//used for counting sort
	public static int[][] getPositiveArrays() {
		int[][] arrays = { { 20, 35, 15, 7, 55, 1, 22 }, { 1, 2, 3, 4, 5, 6, 7, 8 }, { 55, 45, 35, 25, 15, 1, 15 },
				{ 4, 1, 3, 9, 7 }, { 2, 5, 9, 8, 2, 8, 7, 10, 4, 3 } };
		return arrays;
	}

}
