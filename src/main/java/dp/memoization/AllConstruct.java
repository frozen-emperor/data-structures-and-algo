package dp.memoization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllConstruct {

	public static void main(String[] args) {
		String target = "abcdef";
		String[] wordBank = { "ab", "abc", "cd", "def", "abcd" };
		System.out.println(allConstruct(target, wordBank)); // 1

		System.out.println(allConstruct("skateboard", new String[] { "bo", "rd", "ate", "t", "ska", "sk", "boar" }));// 0
		System.out.println(allConstruct("enterapotentpot", new String[] { "a", "p", "ent", "enter", "ot", "o", "t" }));// 4

//		System.out.println(allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
//				new String[] { "e", "ee", "eee", "eeee", "eeeee", "eeeeee", "eeeeeee" }));// <- hangs till death
		
		System.out.println(allConstructDP("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
		new String[] { "e", "ee", "eee", "eeee", "eeeee", "eeeeee", "eeeeeee" },new HashMap<String, List<List<String>>>()));// <- I'm pro coder
	}
	
	private static List<List<String>> allConstructDP(String target, String[] wordBank,Map<String,List<List<String>>> memo) {
		
		if(memo.containsKey(target)) {
			return memo.get(target);
		}
		// O(1)
		if (target.isEmpty()) {
			List<String> subResult = new ArrayList<String>();
			List<List<String>> result = new ArrayList<List<String>>();
			result.add(subResult);

			return result;
		}

		List<List<String>> result = new ArrayList<List<String>>();
		for (String str : wordBank) {
			if (startsWith(target, str)) {
				String newTarget = getNewTarget(target, str);
				List<List<String>> subResult = allConstructDP(newTarget, wordBank,memo);			
				for (List<String> arr : subResult) {
					arr.add(str);
				} 
				
				result.addAll(subResult);
			}
		}
		memo.put(target,result);
		return result;
	}

	private static List<List<String>> allConstruct(String target, String[] wordBank) {
		// O(1)
		if (target.isEmpty()) {
			List<String> subResult = new ArrayList<String>();
			List<List<String>> result = new ArrayList<List<String>>();
			result.add(subResult);

			return result;
		}

		List<List<String>> result = new ArrayList<List<String>>();
		for (String str : wordBank) {
			if (startsWith(target, str)) {
				String newTarget = getNewTarget(target, str);
				List<List<String>> subResult = allConstruct(newTarget, wordBank);
				for (List<String> arr : subResult) {
					arr.add(str);
				}
				result.addAll(subResult);
			}
		}

		return result;
	}

	// O(n) n bein lenght og input
	private static String getNewTarget(String input, String prefix) {
		int start = prefix.length();
		char[] inputCharArray = input.toCharArray();
		char[] newTargetCharArray = new char[inputCharArray.length - start];

		int k = 0;
		for (int i = start; i < inputCharArray.length; i++) {
			newTargetCharArray[k++] = inputCharArray[i];
		}
		return String.valueOf(newTargetCharArray);
	}

	// O(n) n being the lenght of input
	private static boolean startsWith(String input, String prefix) {
		if (input == "") {
			return prefix == "";
		}
		if (prefix == "")
			return true;
		else if (prefix.length() > input.length())
			return false;

		char[] inputCharArray = input.toCharArray();
		char[] prefixCharArray = prefix.toCharArray();

		for (int i = 0; i < prefixCharArray.length; i++) {
			if (inputCharArray[i] != prefixCharArray[i]) {
				return false;
			}
		}
		return true;
	}

}
