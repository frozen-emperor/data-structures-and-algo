package array;

import java.util.Arrays;

public class MergeInPlace {
    public static void main(String[] args) {
        // case where nothing left on second array
        int[] nums1 = {1,2,3,0,0,0}, nums2 = {2,5,6};
        int m = 3, n = 3;
        merge(nums1, m, nums2, n);

        // case where something left on second array
        nums1 = new int[]{2, 2, 3, 0, 0, 0};
        nums2 = new int[]{1, 5, 6};
        m = 3;
        n = 3;
        merge(nums1, m, nums2, n);
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length - 1;
        while(m > 0 && n > 0) {
            if(nums2[ n - 1] >= nums1[ m - 1]){
                nums1[i] = nums2[n -1];
                n--;
            }else{
                nums1[i] = nums1[m-1];
                m--;
            }
            i--;
        }

        while(n > 0){
            nums1[i] = nums2[n -1];
            n--;
            i--;
        }

        System.out.println(Arrays.toString(nums1));
    }
}
