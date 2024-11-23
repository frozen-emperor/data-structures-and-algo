package dp.memoization;

import java.util.HashMap;
import java.util.Map;

public class GridTraveller {

	public static void main(String[] args) {
		// note only moving down and bottom is possible
		System.out.println(gridTraveler(0, 1)); // 0
		System.out.println(gridTraveler(1, 0));// 0
		System.out.println(gridTraveler(1, 1));// 1
		System.out.println(gridTraveler(2, 2));// 2
		System.out.println(gridTraveler(3, 3));// 6
		// System.out.println(gridTraveler(18, 18)); literally hangs

		System.out.println(gridTraveler(18, 18, new HashMap<String, Long>())); //2333606220

	}

	private static int gridTraveler(int m, int n) {
		if (m == 1 && n == 1)
			return 1;
		if (m == 0 || n == 0)
			return 0;

		return gridTraveler(m - 1, n) + gridTraveler(m, n - 1);
	}

	private static long gridTraveler(int m, int n, Map<String, Long> memoizedRoutes) {
		String pos = m + "," + n;
		String revPos = n + "," + m;
		// since (2,3) and (3,2) both grids have same number of possible paths
		if (memoizedRoutes.get(pos) != null) {
			return memoizedRoutes.get(pos);
		} else if (memoizedRoutes.get(revPos) != null) {
			return memoizedRoutes.get(revPos);
		}

		if (m == 1 && n == 1)
			return 1;
		if (m == 0 || n == 0)
			return 0;

		long numberOfPaths = gridTraveler(m - 1, n, memoizedRoutes) + gridTraveler(m, n - 1, memoizedRoutes);
		memoizedRoutes.put(pos, numberOfPaths);
		return numberOfPaths;
	}

}
