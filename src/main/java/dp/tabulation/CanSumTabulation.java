package dp.tabulation;

public class CanSumTabulation {

	public static void main(String[] args) {
		System.out.println(canSum(7, new int[] { 5, 4, 3, 7 }));//true
		System.out.println(canSum(7, new int[] { 2, 4 }));
		System.out.println(canSum(7, new int[] { 5, 4, 3 }));//true

		 System.out.println(canSum(300, new int[] { 7, 14 })); //<-not hangs till death

	}

	private static boolean canSum(int m, int[] arr) {
		boolean[] canSum = new boolean[m + 1];
		int n = arr.length;

		// base case
		canSum[0] = true;
		for (int i = 0; i < m + 1; i++) {
			if (canSum[i] == true) {
				for (int num : arr) {
					if (num+i < m + 1) {
						canSum[num+i] = canSum[i];
					}
				}
			}
		}
		System.out.print("[");
		for (boolean b : canSum) {
			System.out.print(b + ",");
		}
		System.out.println("]");
		return canSum[m];
	}

}
