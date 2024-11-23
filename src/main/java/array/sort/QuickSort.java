package array.sort;

import utils.PrintUtils;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 7, 2, 1, 6, 8, 5, 3, 4,1 };
		quickSort(arr, 0, arr.length-1);
		PrintUtils.printArrays(arr);
	}

	public static void quickSort(int[] arr, int start, int end) {
		if (start < end) {
			int pIndex = partition(arr, start, end);
			quickSort(arr, start, pIndex - 1);
			quickSort(arr, pIndex + 1, end);
		}
	}

	public static int partition(int[] arr, int start, int end) {
		int pivot = end;
		int pIndex = start;
		for(int i=start;i<end;i++) {
			if(arr[i]<=arr[pivot]) {
				swap(arr,i,pIndex++);				
			}
		}
		swap(arr,pIndex,pivot);
		return pIndex;
	}

	private static void swap(int[] arr, int i, int pivot) {
		int temp = arr[i];
		arr[i] = arr[pivot];
		arr[pivot] = temp;
	}

}
