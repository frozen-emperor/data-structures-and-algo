package dp.memoization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountSortedVowelSubstrings {

	public static void main(String[] args) {
		System.out.println(getAllSortedVowelSubstrings(1, "", Arrays.asList("a", "e", "i", "o", "u"),new HashMap<String, List<String>>()));
		System.out.println(getAllSortedVowelSubstrings(2, "", Arrays.asList("a", "e", "i", "o", "u"),new HashMap<String, List<String>>()));
		System.out.println(getAllSortedVowelSubstrings(3, "", Arrays.asList("a", "e", "i", "o", "u"),new HashMap<String, List<String>>()));
		System.out.println(getAllSortedVowelSubstrings(15, "", Arrays.asList("a", "e", "i", "o", "u"),new HashMap<String, List<String>>()));
	}

	private static List<String> getAllSortedVowelSubstrings(int n, String temp, List<String> vowels,Map<String,List<String>> memo) {
		if(memo.containsKey(temp)) {
			return memo.get(temp);
		}
		List<String> newVowels = new ArrayList<String>();
		for (String vowel : vowels) {
			if (temp.length() < 1 || vowel.charAt(0) >= temp.charAt(temp.length()-1)) {
				newVowels.add(vowel);
			}
		}
		
		if (n == 1) {
			List<String> newSubstrings = new ArrayList<String>();
			for (String vowel : newVowels) {
				newSubstrings.add(temp + vowel);
			}
			memo.put(temp, newSubstrings);
			return newSubstrings;
		}

		List<String> result = new ArrayList<String>();
		
		for (String vowel : newVowels) {
			result.addAll(getAllSortedVowelSubstrings(n - 1, temp+vowel, newVowels,memo));
		}
		memo.put(temp, result);
		return result;
	}

}
