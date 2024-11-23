package recursion;

public class KthSymbolInGrammar {

	public static void main(String[] args) {
		System.out.println(solve(1, 1)); // 0
		System.out.println(solve(2, 1)); // 0
		System.out.println(solve(2, 2)); // 1
		System.out.println(solve(4, 3)); // 1
	}

	static int solve(int N, int K) {
		if (N <= 1 && K <= 1)
			return 0;

		int mid = (int) Math.pow(2, N - 1); // O(n)
		if (K <= mid)
			return solve(N - 1, K);
		else
			return solve(N - 1, K - mid) == 0 ? 1 : 0;
	}

}
