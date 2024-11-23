package array.sort;

public class MergeSort2 {

    static int iter = 1;

    public static void main(String[] args) {
        int[] arr = { 4, 1, 3, 8, 9, 6, 23, 4, 5, 60, 232, 3, -1, 5, 54 };
        //int[] arr = { 4, 1, 3, 8, 9, 6 };
        mergeSort(arr, 0, arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }

    private static void mergeSort(int[] arr, int start, int end) {

        //since the end cases will have 
        // e = 3 and 
        if (end - start <= 1) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid, end);
        System.out.print("start:" + start + " mid:" + mid + " end:" + end + "[");
        for (int i = start; i < end; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println("]");
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        //won't affect but just to use less time since below condition means
        // left array last el is less than right array first el
        // so no need to check left-right array
        if (arr[mid] > arr[mid - 1]) {
            return;
        }
        System.out.println("merge:");
        //        for (int i = start; i < mid; i++) {
        //            System.out.print(arr[i] + ",");
        //        }
        //        for (int i = mid; i < end; i++) {
        //            System.out.print(arr[i] + ",");
        //        }
        int i = start;
        int j = mid;
        int[] temp = new int[end - start];
        int tempArrIndex = 0;
        while (i < mid && j < end) {
            temp[tempArrIndex++] = arr[i] > arr[j] ? arr[j++] : arr[i++];
        }
        System.arraycopy(arr, i, arr, start + tempArrIndex, mid - i);
        System.arraycopy(temp, 0, arr, start, tempArrIndex);
    }

}
