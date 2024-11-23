package array.sort;

public class MergeSort {

	public static void main(String[] args) {
		// 0 1 2 3 4 5 6
		// int[] array = { 20, 35, -15, 7, 55, 1, -22 };
		for (int i = 0; i < getArrays().length; i++) {
			int[] array = getArrays()[i];
			mergeSort(array, 0, array.length);

			for (int j = 0; j < array.length; j++) {
				System.out.print(array[j] + ",");
			}
			System.out.println();
		}

	}

	public static int[][] getArrays() {
		int[][] arrays = { { 20, 35, -15, 7, 55, 1, -22 }, { 1, 2, 3, 4, 5, 6, 7, 8 }, { 55, 45, 35, 25, 15, 0, -15 },
				{ -1, 20, 90, 0, -56, -23 }, { 4, 1, 3, 9, 7 },
				{ 6334, 4098, 7968, 4523, 277, 6956, 4560, 2062, 5705, 5743, 879, 5626, 9961, 491, 2995, 741, 4827 } };
		return arrays;
	}

	// 0 - 7, 0 - 3, 0 - 1, 0 - 0
	public static void mergeSort(int[] array, int start, int end) {

		if (end - start < 2) {
			return;
		}
		int mid = (start + end) / 2;
		mergeSort(array, start, mid);
		mergeSort(array, mid, end);
		merge(array, start, mid, end);
	}

	private static void merge(int[] array, int start, int mid, int end) {
		if (array[mid] > array[mid - 1]) {
			return;
		}

		int temp[] = new int[end - start];
		int tempArrIndex = 0;
		int i = start;
		int j = mid;
		while (i < mid && j < end) {
			temp[tempArrIndex++] = array[i] < array[j] ? array[i++] : array[j++];
		}

		int length = (mid - i + 1) == array.length ? (mid - i) : (mid - i + 1);

		// uses for loop
//		tempArrIndex = copyRemainingFromLeftArray(array, i, temp, mid, tempArrIndex);
		// uses lib and copies directly to array itself
		copyRemainingFromLeftArray(array, i, start, mid, tempArrIndex);

		// copies the sorted values from temp to array
		System.arraycopy(temp, 0, array, start, tempArrIndex);

	}

	private static int copyRemainingFromLeftArray(int[] array, int i, int[] temp, int mid, int tempArrIndex) {
		for (int x = i; x < mid; x++) {
			temp[tempArrIndex++] = array[x];
		}
		return tempArrIndex;
	}

	private static void copyRemainingFromLeftArray(int[] array, int i, int start, int mid, int tempArrIndex) {
		System.arraycopy(array, i, array, start + tempArrIndex, mid - i);
	}

}
