package recursion;

public class KthSymbolInGrammarV2 {

	public static void main(String[] args) {
//		System.out.println(findKthBit(3, 7));
		System.out.println(findKthBit(4, 11));
	}

	public static char findKthBit(int n, int k) {
		if (n == 1)
			return '0';

		int len = (int) Math.pow(2, n) - 1;
		int mid = (int)(len / 2) +1;

		if (k == mid)
			return '1';
		else if (k < mid)
			return findKthBit(n - 1, k);
		else
			return findKthBit(n - 1, (mid -(k - mid))) == '0' ? '1' : '0';
	}
}
