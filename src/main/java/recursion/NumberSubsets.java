package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberSubsets {

	public static void main(String[] args) {
		System.out.println(subsets(new int[]{1,2,3}));
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> numList = new ArrayList<>();
		for (int i : nums)
			numList.add(i);

		subsets(numList, result, new ArrayList<>());
		return result;
	}

	static void subsets(List<Integer> nums, List<List<Integer>> result, List<Integer> subResult) {
		if (nums.isEmpty()) {
			result.add(subResult);
			return;
		}
		int x = nums.get(0);
		List<Integer> newNums = new ArrayList<Integer>(nums);
		newNums.remove(0);
		subsets(newNums, result, new ArrayList<>(subResult));
		subResult.add(x);
		subsets(newNums, result, subResult);
	}
	
	
}
