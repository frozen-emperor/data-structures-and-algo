package dp.memoization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HowSumProblem {

	public static void main(String[] args) {
		for (int i : howSum(7, new int[] { 9, 5, 4, 2, 7 })) {
			System.out.print(i + ",");
		}

//		for(int i:howSum(300, new int[] { 7,14}, howSumMap)) {
//			System.out.print(i+","); <- hangs up
//		}
		System.out.println();

		Map<Integer, List<Integer>> howSumMapDP = new HashMap<>();
		List<Integer> result = howSumDP(300, new int[] { 7, 14 }, howSumMapDP);
		result = result == null ? Collections.emptyList() : result;
		for (int i : result) {
			System.out.print(i + ",");
		}

	}

	private static int[] howSum(int sum, int[] arr) {
		if (sum == 0)
			return new int[] {};
		if (sum < 0)
			return null;
		for (int i : arr) {
			int rem = sum - i;
			int[] result = howSum(rem, arr);
			if (result != null) {
				//below op could take max time equals to sum if there are all ones
				//so Time complexity will be O(n^m*m) n is basically the number of numbers in arr
				//and m is the sum 
				//space will be still O(m) since min number is 1 so whole array of 1 will make m space
				int[] newResult = new int[result.length + 1];
				int j;
				for (j = 0; j < result.length; j++) {
					newResult[j] = result[j];
				}
				newResult[j] = i;
				return newResult;
			}
		}
		return null;
	}

	//O(n*m^2) O(m^2)
	private static List<Integer> howSumDP(int sum, int[] arr, Map<Integer, List<Integer>> howSumMap) {
		//below map cache pre computed results
		if (howSumMap.containsKey(sum)) {
			return howSumMap.get(sum);
		}
		if (sum == 0)
			return Collections.emptyList();
		if (sum < 0)
			return null;
		for (int i : arr) {
			int rem = sum - i;

			List<Integer> result = howSumDP(rem, arr, howSumMap);
			if (result != null) {
				howSumMap.put(rem, result);
				
				List<Integer> newResult = new ArrayList<Integer>();
				newResult.add(i);
				newResult.addAll(result);
				return newResult;
			}
		}
		howSumMap.put(sum, null);
		return null;
	}

}
