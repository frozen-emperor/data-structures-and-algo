package dp.memoization;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {

	public static void main(String[] args) {
		// 1 1 2 3 5 8 13 21 ....
		// the normal call of fibonacci
		System.out.println(fib(1));
		System.out.println(fib(2));
		System.out.println(fib(5));
		System.out.println(fib(10));
		// System.out.println(fib(50)); <- literally hangs up

		// we are using below maps to store the fibs calculated at each stage to
		// decrease
		// time complexity from O(2^n) to O(n)
		Map<Long, Long> memoiazedFibs = new HashMap<>();
		System.out.println(fib(50L, memoiazedFibs));
	}

	private static int fib(int n) {
		if (n <= 2)
			return 1;
		return fib(n - 1) + fib(n - 2);
	}

	private static long fib(long n, Map<Long, Long> memoiazedFibs) {
		if (memoiazedFibs.get(n) != null)
			return memoiazedFibs.get(n).longValue();
		if (n <= 2)
			return 1;

		long calculatedFib = fib(n - 1, memoiazedFibs) + fib(n - 2, memoiazedFibs);
		memoiazedFibs.put(n, calculatedFib);
		return calculatedFib;
	}

}
