package dp.memoization;

import java.util.HashMap;
import java.util.Map;

public class StockMarketMaxProfitProblem {

	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		System.out.println(maxProfit(prices));

		prices = new int[] { 7, 6, 4, 3, 1 };
		System.out.println(maxProfit(prices));

		prices = new int[] { 7, 1, 5, 3, 6, 4, 7, 1, 5, 3, 6, 4, 7, 1, 5, 3, 6, 4, 7, 1, 5, 3, 6, 4, 7, 1, 5, 3, 6, 4,
				7, 1, 5, 3, 6, 4, 7, 1, 5, 3, 6, 4, 7, 1, 5, 3, 6, 4, 7, 1, 5, 3, 6, 4, 7, 1, 5, 3, 6, 4, 7, 1, 5, 3, 6,
				4, 7, 1, 5, 3, 6, 4,7, 1, 5, 3, 6, 4, 7, 1, 5, 3, 6, 4, 7, 1, 5, 3, 6, 4, 7, 1, 5, 3, 6, 4, 7, 1, 5, 3, 6, 4,
				7, 1, 5, 3, 6, 4, 7, 1, 5, 3, 6, 4, 7, 1, 5, 3, 6, 4, 7, 1, 5, 3, 6, 4, 7, 1, 5, 3, 6, 4, 7, 1, 5, 3, 6,
				4, 7, 1, 5, 3, 6, 4, 7, 1, 5, 3, 6, 4, 7, 1, 5, 3, 6, 4, 7, 1, 5, 3, 6, 4, 7, 1, 5, 3, 6, 4, 7, 1, 5, 3, 6, 4,
				7, 1, 5, 3, 6, 4, 7, 1, 5, 3, 6, 4, 7, 1, 5, 3, 6, 4, 7, 1, 5, 3, 6, 4, 7, 1, 5, 3, 6, 4, 7, 1, 5, 3, 6,
				4, 7, 1, 5, 3, 6, 4, 7, 1, 5, 3, 6, 4, 7, 1, 5, 3, 6, 4, 7, 1, 5, 3, 6, 4, 7, 1, 5, 3, 6, 4, 7, 1, 5, 3, 6, 4,
				7, 1, 5, 3, 6, 4, 7, 1, 5, 3, 6, 4, 7, 1, 5, 3, 6, 4, 7, 1, 5, 3, 6, 4, 7, 1, 5, 3, 6, 4, 7, 1, 5, 3, 6,
				4, 7, 1, 5, 3, 6, 4 };
		System.out.println(maxProfit(prices));
		

	}

	private static int maxProfit(int[] prices) {
		int maxProfit = 0;
		Map<String, Integer> profitMap = new HashMap<>();

		for (int i = 0; i < prices.length - 1; i++) {
			int tempProfit = Integer.MIN_VALUE;
			int sellIndex = i;
			for (int j = i + 1; j < prices.length; j++) {
				if (prices[j] - prices[i] > tempProfit) {
					tempProfit = prices[j] - prices[i];
					sellIndex = j;
				}
			}
			profitMap.put(i + "," + sellIndex, tempProfit);
			maxProfit = tempProfit > maxProfit ? tempProfit : maxProfit;
		}

		return maxProfit;
	}

	public int maxProfitDp(int[] prices) {
		Map<Integer, Integer> memo = new HashMap<>();
		int maxProfit = 0;
		Map<String, Integer> profitMap = new HashMap<>();

		for (int i = 0; i < prices.length - 1; i++) {
			int tempProfit = Integer.MIN_VALUE;
			int sellIndex = i;
			if (memo.containsKey(prices[i])) {
				tempProfit = memo.get(prices[i]);
				maxProfit = tempProfit > maxProfit ? tempProfit : maxProfit;
				continue;
			}
			for (int j = i + 1; j < prices.length; j++) {
				if (prices[j] - prices[i] > tempProfit) {
					tempProfit = prices[j] - prices[i];
					sellIndex = j;
				}
			}
			profitMap.put(i + "," + sellIndex, tempProfit);
			memo.put(prices[i], tempProfit);
			maxProfit = tempProfit > maxProfit ? tempProfit : maxProfit;
		}

		return maxProfit;
	}

}
