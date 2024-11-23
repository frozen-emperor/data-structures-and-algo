package dp.memoization;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct {

	public static void main(String[] args) {
		String target = "abcdef";
		String[] wordBank = { "ab", "abc", "cd", "def", "abcd" };
		System.out.println(canConstruct(target, wordBank));

		System.out.println(canConstruct("skateboard", new String[] { "bo", "rd", "ate", "t", "ska", "sk", "boar" }));
		System.out.println(canConstruct("enterapotentpot", new String[] { "a", "p", "ent", "enter", "ot", "o", "t" }));
//		System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
//				new String[] { "e", "ee", "eee", "eeee", "eeeee", "eeeeee", "eeeeeee" })); <- hangs till death
		
		System.out.println(canConstructDP("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
				new String[] { "e", "ee", "eee", "eeee", "eeeee", "eeeeee", "eeeeeee" },new HashMap<String, Boolean>()));//<- runs instantly 

	}

	private static boolean canConstruct(String target, String[] wordBank) {
		// O(1)
		if (target.isEmpty())
			return true;

		for (String str : wordBank) {
			if (startsWith(target, str)) {
				String newTarget = getNewTarget(target, str);
				if (canConstruct(newTarget, wordBank)) {
					return true;
				}
			}
		}

		return false;
	}
	
	private static boolean canConstructDP(String target, String[] wordBank,Map<String,Boolean> canConstructMemo) {
		if(canConstructMemo.containsKey(target)) {
			return canConstructMemo.get(target).booleanValue();
		}
		// O(1)
		if (target.isEmpty())
			return true;

		for (String str : wordBank) {
			if (startsWith(target, str)) {
				String newTarget = getNewTarget(target, str);
				if (canConstructDP(newTarget, wordBank,canConstructMemo)) {
					canConstructMemo.put(target, true);
					return true;
				}
			}
		}
		canConstructMemo.put(target, false);
		return false;
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
