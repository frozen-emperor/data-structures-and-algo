package dp.memoization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChangeProblem {

	static int count = 0;

	public static void main(String[] args) {

		int N = 4;
		int[] S = { 1, 2, 3 };
		System.out.println(coinChange(N, S));
		System.out.println(coinChangeCount(N, S));

		int[] dp = new int[N + 1];

		Arrays.fill(dp, 0);
		System.out.println(coinChange(S, N, dp));
	}

	// bruteforce
	private static List<List<Integer>> coinChange(int N, int[] S) {

		if (N == 0) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			result.add(new ArrayList<Integer>());
			return result;
		}
		if (N < 0)
			return null;

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i : S) {
			int newN = N - i;
			List<List<Integer>> subResult = coinChange(newN, S);

			if (subResult != null) {
				for (List<Integer> list : subResult) {
					list.add(i);
				}
				result.addAll(subResult);
			}
		}

		return result;
	}

	// bruteforce
	private static int coinChangeCount(int N, int[] S) {

		if (N == 0) {
			return 1;
		}
		if (N < 0)
			return -1;

		int result = 0;
		for (int i : S) {
			int newN = N - i;
			int val = coinChangeCount(newN, S);

			if (val >= 0) {
				result += val;
			}
		}

		return result;
	}

	private static int coinChange(int[] coins, int amount, int[] dp) {
		if (amount < 0) {
			return -1;
		}
		if (amount == 0) {
			return 0;
		}

		if (dp[amount] != 0) {
			return dp[amount];
		}

		int minimum = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i++) {
			int val = coinChange(coins, amount - coins[i], dp);

			if (val >= 0 && val < minimum) {
				minimum = val + 1;
			}
		}
		dp[amount] = (minimum == Integer.MAX_VALUE) ? -1 : minimum;
		return dp[amount];
	}
}
