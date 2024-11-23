package dp.tabulation;

public class FibTabulation {

	public static void main(String[] args) {
		// 1 1 2 3 5 8 13 21 ....
		System.out.println(fibTabulated(1));
		System.out.println(fibTabulated(2));
		System.out.println(fibTabulated(5));
		System.out.println(fibTabulated(10));
		 System.out.println(fibTabulated(50)); //<- doesn't hangs up 
	}

	//O(n)
	private static long fibTabulated(int n) {
		long[] arr = new long[n + 1];
		arr[1] = 1;
		for (int i = 0; i < n; i++) {
			arr[i + 1] += arr[i];
			if (i < n - 1) {
				arr[i + 2] += arr[i];
			}
		}
		return arr[n];
	}

}
