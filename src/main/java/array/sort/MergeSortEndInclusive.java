package array.sort;

public class MergeSortEndInclusive {

    static int iter = 1;

    public static void main(String[] args) {
        int[] arr = { 4, 1, 3, 8, 7, 6 };
        //int[] arr = { 4, 1, 3, 8, 9, 6 };
        mergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }

    private static void mergeSort(int[] arr, int start, int end) {

        //since the end cases will have 
        // e = 3 and 
        if (end > start) {

            // if(end)
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            System.out.print("start:" + start + " mid:" + mid + " end:" + end + "[");
            for (int i = start; i < end; i++) {
                System.out.print(arr[i] + ",");
            }
            System.out.println("]");
            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        System.out.println("merge:");
        //        for (int i = start; i < mid; i++) {
        //            System.out.print(arr[i] + ",");
        //        }
        //        for (int i = mid; i < end; i++) {
        //            System.out.print(arr[i] + ",");
        //        }
        if (mid != end && arr[mid] < arr[mid + 1]) {
            return;
        }
        int i = start;
        int j = mid + 1;
        int[] temp = new int[end - start];
        int tempArrIndex = 0;
        while (i < mid && j < end) {
            temp[tempArrIndex++] = arr[i] > arr[j] ? arr[j++] : arr[i++];
        }
        System.arraycopy(arr, i, arr, start + tempArrIndex, mid - i);
        System.arraycopy(temp, 0, arr, start, tempArrIndex);
    }

}
