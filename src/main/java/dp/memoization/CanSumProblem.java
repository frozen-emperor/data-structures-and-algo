package dp.memoization;

import java.util.HashMap;
import java.util.Map;

public class CanSumProblem {

	public static void main(String[] args) {
		System.out.println(canSum(7, new int[] { 5, 4, 3, 7 }));
		System.out.println(canSum(7, new int[] { 2, 4 }));
		// System.out.println(canSum(14,new int[] {5,4,3,7}));

		// System.out.println(canSum(300, new int[] { 7, 14 })); <-hangs till death

		Map<Integer, Boolean> canSumMap = new HashMap<>();
		System.out.println(canSum(300, new int[] { 7, 14 }, canSumMap));// <-runs instantly

	}

	private static boolean canSum(int sum, int[] arr) {
		if (sum == 0)
			return true;
		if (sum < 0)
			return false;
		for (int i : arr) {
			int rem = sum - i;
			if (canSum(rem, arr)) {
				return true;
			}
		}

		return false;
	}

	private static boolean canSum(int sum, int[] arr, Map<Integer, Boolean> canSumMap) {
		if (canSumMap.get(sum) != null) {
			return canSumMap.get(sum).booleanValue();
		}
		if (sum == 0)
			return true;
		if (sum < 0)
			return false;
		for (int i : arr) {
			int rem = sum - i;

			if (canSum(rem, arr, canSumMap)) {
				canSumMap.put(rem, true);
				return true;
			}
		}
		canSumMap.put(sum, false);
		return false;
	}

}
