package array.sort;

import utils.PrintUtils;

/***
 * The array is divided into 2 parts (sorted : right) && (unsorted : left) loop
 * on the array until last sorted index is > 1 and check for the
 * greatest/smallest elem in unsorted part and then replace it against last
 * sorted i if greatest/smallest
 * 
 * Selection Sort select the next most fit element and adds it to sorted side one by one
 * 
 * @author shsingh
 */
public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = { 20, 1, 35, -15, 0, 2 };
		selectionSortAscend(arr);
		System.out.println("arr sorted ascending:");
		PrintUtils.printArrays(arr);
		selectionSortDescend(arr);
		//print arrays
		System.out.println("arr sorted descending:");
		PrintUtils.printArrays(arr);
	}

	private static void selectionSortAscend(int[] arr) {
		int lastSortedIndex = arr.length - 1;
		int largestIndex = 0;
		int temp;

		while (lastSortedIndex > 1) {
			for (int i = 0; i < lastSortedIndex; i++) {
				if (arr[i] > arr[largestIndex]) {
					largestIndex = i;
				}
			}
			if (arr[largestIndex] > arr[lastSortedIndex]) {
				temp = arr[largestIndex];
				arr[largestIndex] = arr[lastSortedIndex];
				arr[lastSortedIndex] = temp;
			}
			lastSortedIndex--;
		}
	}

	private static void selectionSortDescend(int[] arr) {
		int lastSortedIndex = arr.length - 1;
		int largestIndex = 0;
		int temp;

		while (lastSortedIndex > 0) {
			largestIndex=0;
			for (int i = 0; i < lastSortedIndex; i++) {
				if (arr[i] < arr[largestIndex]) {
					largestIndex = i;
				}
			}
			if (arr[largestIndex] < arr[lastSortedIndex]) {
				temp = arr[largestIndex];
				arr[largestIndex] = arr[lastSortedIndex];
				arr[lastSortedIndex] = temp;
			}
			lastSortedIndex--;
		}
	}
}
