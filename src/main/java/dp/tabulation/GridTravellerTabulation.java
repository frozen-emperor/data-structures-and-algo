package dp.tabulation;

public class GridTravellerTabulation {

	public static void main(String[] args) {
		// note only moving down and bottom is possible
		System.out.println(gridTraveler(0, 1)); // 0
		System.out.println(gridTraveler(1, 0));// 0
		System.out.println(gridTraveler(1, 1));// 1
		System.out.println(gridTraveler(2, 2));// 2
		System.out.println(gridTraveler(3, 3));// 6
		System.out.println(gridTraveler(18, 18)); // 2333606220
	}

	private static long gridTraveler(int m, int n) {
		if (m < 1 || n < 1)
			return 0;
		if (m == 1 && n == 1)
			return 1;

		long[][] arr = new long[m + 1][n + 1];
		arr[1][1] = 1; // laying the base case
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i < m)
					arr[i + 1][j] += arr[i][j]; // bottom move
				if (j < n)
					arr[i][j + 1] += arr[i][j];// right move
			}
		}
		return arr[m][n];
	}

}
