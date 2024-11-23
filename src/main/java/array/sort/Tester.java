package array.sort;

public class Tester {

	public static void main(String[] args) {
		// 0 1 2 3 4 5 6
		// int[] array = { 20, 35, -15, 7, 55, 1, -22 };
		for (int i = 0; i < getArrays().length; i++) {
			int[] array = getArrays()[i];
			mergeSort(array, 0, array.length - 1);

			for (int j = 0; j < array.length; j++) {
				System.out.print(array[j] + ",");
			}
			System.out.println();
		}

	}

	public static int[][] getArrays() {
		int[][] arrays = { { 4, 1, 3, 9, 7 ,8},// { 4, 1, 3, 9, 7, }
				// { 6334, 4098, 7968, 4523, 277, 6956, 4560, 2062, 5705, 5743, 879, 5626, 9961,
				// 491, 2995, 741, 4827 }
		};
		return arrays;
	}

	static void merge(int arr[], int l, int m, int r) {
		if (m < 1) {
			return;

		} else {
			if (arr[m] > arr[m - 1] && arr.length % 2 == 0) {
				return;
			}
		}

		int[] temp = new int[r - l];
		
		int i = l;
		if(l==arr.length-2) {
			m = m+1 ;
		}
		int j = m;
		int tempArrIndex = 0;			
		while (i < m && j < r + 1) {
			temp[tempArrIndex++] = (arr[i] < arr[j]) ? arr[i++] : arr[j++];
		}
		System.arraycopy(arr, i, arr, l + tempArrIndex, m - i);
		System.arraycopy(temp, 0, arr, l, tempArrIndex);
	}

	static void mergeSort(int arr[], int l, int r) {
		// r++;
		if (r - l < 1) {
			return;
		}
		int mid = (r + l) / 2;

		mergeSort(arr, l, mid);
		mergeSort(arr, mid + 1, r);
		merge(arr, l, mid, r);
	}

//   static void mergeSort(int arr[], int l, int r)
//   {
//     split(arr,0,arr.length);
//   }
}
