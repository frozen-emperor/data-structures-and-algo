package dp.memoization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestSumProblem {

	public static void main(String[] args) {
		int[] arr = new int[] { 8, 2, 4, 9, 1 };
//		for (int i : bestSum(7, 7, arr, new int[arr.length + 1])) {
//			System.out.print(i + ",");
//		}
//		System.out.println();
		
//
//		arr = new int[] { 2, 3, 5 };
//		for (int i : bestSum(8, 8, arr, new int[arr.length + 1])) {
//			System.out.print(i + ","); // <- hangs up
//		}

		//takes 1 sec
		Map<Integer, List<Integer>> howSumMapDP = new HashMap<>();
		List<Integer> result = bestSumDP(300, new int[] { 5, 10 }, howSumMapDP);
		result = result == null ? Collections.emptyList() : result;
		for (int i : result) {
			System.out.print(i + ",");
		}
		System.out.println();

		//takes 5 sec
		arr = new int[] { 10, 14 };
		for (int i : bestSum(300, 300, arr, new int[arr.length + 1])) {
			System.out.print(i + ","); // <- hangs up
		}
		
	}

	private static int[] bestSum(int realsum, int sum, int[] arr, int[] bestSum) {
		if (sum == 0)
			return new int[] {};
		if (sum < 0)
			return null;

		bestSum = null;
		for (int i : arr) {
			int rem = sum - i;
			int[] result = bestSum(realsum, rem, arr, bestSum);

			if (result != null) {
				// below op could take max time equals to sum if there are all ones
				// so Time complexity will be O(n^m*m) n is basically the number of numbers in
				// arr
				// and m is the sum
				// space will be still O(m) since min number is 1 so whole array of 1 will make
				// m space
				int[] newResult = new int[result.length + 1];
				int j;
				for (j = 0; j < result.length; j++) {
					newResult[j] = result[j];
				}
				newResult[j] = i;

				bestSum = bestSum == null || newResult.length < bestSum.length ? newResult : bestSum;

			}
		}

		return bestSum;
	}

	// O(n*m^2) O(m^2)
	private static List<Integer> bestSumDP(int sum, int[] arr, Map<Integer, List<Integer>> howSumMap) {
		if (howSumMap.containsKey(sum)) {
			return howSumMap.get(sum);
		}
		if (sum == 0)
			return Collections.emptyList();
		if (sum < 0)
			return null;

		List<Integer> bestSum = null;
		for (int i : arr) {
			int rem = sum - i;
			List<Integer> result = bestSumDP(rem, arr, howSumMap);
			
			if (result != null) {
				
				howSumMap.put(rem, result);
				List<Integer> newResult = new ArrayList<Integer>();
				newResult.add(i);
				newResult.addAll(result);
				bestSum = bestSum == null || newResult.size() < bestSum.size() ? newResult : bestSum;

			}

		}
		
		return bestSum;
	}

}
