package dp.memoization;

import java.util.HashMap;
import java.util.Map;

public class NthStairProblem {

	public static void main(String[] args) {
		// only 1 or 2 steps allowed
		System.out.println(nthStairClimb(3));
		// System.out.println(nthStairClimb(100)); <- hangs till death
		System.out.println(nthStairClimbMemoized(100, new HashMap<Long, Long>()));
		System.out.println(nthStairClimbTabulated(100));//<-runs instantly
	}

	//tc:O(n*2) sc:O(n)
	private static int nthStairClimb(int n) {

		if (n == 0)
			return 1;
		if (n < 0)
			return 0;
		int ways = 0;
		for (int i = 1; i <= 2; i++) {

			ways += nthStairClimb(n - i);
		}
		return ways;
	}

	//tc:O(n) sc:O(n)
	private static long nthStairClimbMemoized(long n, Map<Long, Long> memo) {
		if (memo.containsKey(n))
			return memo.get(n).longValue();
		if (n == 0)
			return 1;
		if (n < 0)
			return 0;
		long ways = 0;
		for (int i = 1; i <= 2; i++) {
			ways += nthStairClimbMemoized(n - i, memo);
		}
		memo.put(n, ways);
		return ways;
	}

	//tc:O(n*2) sc:O(n)
	private static long nthStairClimbTabulated(int n) {
		long[] memo = new long[n + 1];
		memo[0] = 1;

		for (int i = 0; i < n + 1; i++) {
			for (int j = 1; j <= 2; j++) {
				if (i + j < memo.length) {
					memo[i + j] += memo[i];
				}
			}
		}
		return memo[n];
	}

}
