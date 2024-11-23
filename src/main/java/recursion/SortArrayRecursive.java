package recursion;

public class SortArrayRecursive {

	public static void main(String[] args) {
		int[] arr = { 2, 5, 4, 3, 6, 7, 9, 1, 8 };
		sortArr(arr, arr.length - 1);
		for (int i : arr) {
			System.out.print(i + ",");
		}

//		int[] temp = {2,4,5,3};
//		insertInArray(temp, temp[3], 3, new int[4], 0);
//		for(int t:temp) {
//			System.out.print(t+",");
//		}

	}

	static void sortArr(int[] arr, int end) {
		if (end == 0) {
			return;
		}

		sortArr(arr, end - 1);
		insertInArray(arr, arr[end], end, new int[end + 1], 0);
		// [2,4,5..3]
		// pop 4 5 out insert 3 recursively
		// end = 3 val = 3
	}

	static void insertInArray(int[] arr, int val, int end, int[] temp, int tempIndex) {
		if (end < 0) {
			temp[tempIndex++] = val;
			return;
		}
		if (val < arr[end]) {
			temp[tempIndex++] = arr[end];
		} else if(val==arr[end]){
			
		}else {
			temp[tempIndex++] = val;
			return;
		}

		insertInArray(arr, val, end - 1, temp, tempIndex);
		if (tempIndex > -1) {
			if (tempIndex == temp.length) {
				tempIndex--;
			}
			arr[end] = temp[tempIndex];

			tempIndex--;

		}
	}

}
