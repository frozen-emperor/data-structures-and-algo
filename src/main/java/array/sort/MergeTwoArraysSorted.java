package array.sort;

public class MergeTwoArraysSorted {

    public static void main(String[] args) {
        int[] arr1 = { 2, 4, 6, 8, 10 };
        int[] arr2 = { 3, 5, 7, 9 };
        // mergeWithExtraSpace(arr2, arr1);
        mergeWithoutExtraSpace(arr1, arr2);
        printArrays(arr1, arr2);
    }

    public static void mergeWithoutExtraSpace(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] > arr2[j]) {
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
                j++;
                sortSortedArray(arr2, j);
            }
            else {
                i++;
            }
        }
    }

    private static void sortSortedArray(int[] arr2, int j) {
        while (j < arr2.length - 1 && arr2[j] > arr2[j + 1]) {
            int temp = arr2[j];
            arr2[j] = arr2[j + 1];
            arr2[j + 1] = temp;
            j++;
        }
    }

    public static void mergeWithExtraSpace(int[] arr1, int[] arr2) {
        int[] temp = new int[arr1.length + arr2.length];
        int tempIndex = 0;
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            temp[tempIndex++] = arr1[i] < arr2[j] ? arr1[i++] : arr2[j++];
        }

        while (i < arr1.length) {
            temp[tempIndex++] = arr1[i++];
        }

        while (j < arr2.length) {
            temp[tempIndex++] = arr2[j++];
        }

        System.arraycopy(temp, 0, arr1, 0, arr1.length);
        System.arraycopy(temp, arr1.length, arr2, 0, arr2.length);
    }

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

}
