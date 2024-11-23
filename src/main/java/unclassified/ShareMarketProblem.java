package unclassified;

public class ShareMarketProblem {

	public static void main(String[] args) {
		int[] arr = { 80, 10, 40, 5, 60, 2 };

		// find the maxima
		int maximaPrice = 0;
		int maximaIndex = 0;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > maximaPrice) {
				maximaPrice = arr[i];
				maximaIndex = i;
			}
		}

		int minimaIndex = 0;
		int minimaPrice = maximaPrice;
		for (int i = maximaIndex; i > 0; i++) {
			
		}

		System.out.println(maximaPrice);

	}

}
