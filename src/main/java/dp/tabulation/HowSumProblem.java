package dp.tabulation;

import java.util.ArrayList;
import java.util.List;

public class HowSumProblem {

	public static void main(String[] args) {
		for (Integer i : howSum(7, new int[] { 5, 2, 3 })) {
			System.out.print(i + ",");
		}
	}

	private static Integer[] howSum(int m, int[] arr) {
		Integer[][] howSum = new Integer[m + 1][];
		howSum[0] = new Integer[0];

		for (int i = 0; i < howSum.length; i++) {
			if (howSum[i] != null) {
				for (int num : arr) {
					if (num + i < howSum.length) {
						List<Integer> result = new ArrayList<Integer>();
						result.add(num);
						for (Integer k : howSum[i])
							result.add(k);

						Integer[] resultArr = new Integer[result.size()];
						for (int k = 0; k < resultArr.length; k++) {
							resultArr[k] = result.get(k);
						}

						howSum[num + i] = resultArr;
					}
				}
			}
		}
		return howSum[m];
	}

}
