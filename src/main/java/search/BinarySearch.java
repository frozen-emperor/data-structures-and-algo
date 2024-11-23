package search;

public class BinarySearch {

    static int x = 69;

    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 3, 29, 33, 45, 50, 58 };
        //            0  1  2  3  4   5   6   7   8
        System.out.println(arr.length);
        System.out.println(binarySearch(arr, 0, arr.length - 1));

    }

    static int binarySearch(int[] arr, int l, int u) {
        int m = (u + l) / 2;
        if (u < l) {
            return -1;
        }
        if (arr[m] == x) {
            return m;
        }
        else if (arr[m] > x) {
            return binarySearch(arr, l, m - 1);
        }
        else {
            return binarySearch(arr, m + 1, u);
        }
        // return -1;
    }
}
