package dp.memoization;

import java.util.HashMap;
import java.util.Map;

public class IsSubSequenceProblem {

	public static void main(String[] args) {
		String s = "abc", t = "ahbgdc";
		System.out.println(isSubSequence(s, t));

		s = "axc";
		System.out.println(isSubSequence(s, t));

		s = "acb";
		System.out.println(isSubSequence(s, t));
		
		s = "aaaaa";
		t = "bbaaa";
		System.out.println(isSubSequenceDp(s, t,new HashMap<String, Boolean>()));

//		s = "rjufvjafbxnbgriwgokdgqdqewn";
//		t = "mjmqqjrmzkvhxlyruonekhhofpzzslupzojfuoztvzmmqvmlhgqxehojf"
//				+ "owtrinbatjujaxekbcydldglkbxsqbbnrkhfdnpfbuaktupfftiljwpgglkjqunv"
//				+ "ithzlzpgikixqeuimmtbiskemplcvljqgvlzvnqxgedxqnznddkiujwhdefziydtquoudzxs"
//				+ "tpjjitmiimbjfgfjikkjycwgnpdxpeppsturjwkgnifinccvqzwlbmgpdaodzptyrjjkbqmgdrft"
//				+ "fbwgimsmjpknuqtijrsnwvtytqqvookinzmkkkrkgwafohflvuedssukjgipgmypakhlckvizmqvycv"
//				+ "bxhlljzejcaijqnfgobuhuiahtmxfzoplmmjfxtggwwxliplntkfuxjcnzcqsaagahbbneugiocexcfps"
//				+ "zzomumfqpaiydssmihdoewahoswhlnpctjmkyufsvjlrflfiktndubnymenlmpyrhjxfdcq";
//		System.out.println(isSubSequence(s, t)); // takes few seconds
		
		s = "rjufvjafbxnbgriwgokdgqdqewn";
		t = "mjmqqjrmzkvhxlyruonekhhofpzzslupzojfuoztvzmmqvmlhgqxehojf"
				+ "owtrinbatjujaxekbcydldglkbxsqbbnrkhfdnpfbuaktupfftiljwpgglkjqunv"
				+ "ithzlzpgikixqeuimmtbiskemplcvljqgvlzvnqxgedxqnznddkiujwhdefziydtquoudzxs"
				+ "tpjjitmiimbjfgfjikkjycwgnpdxpeppsturjwkgnifinccvqzwlbmgpdaodzptyrjjkbqmgdrft"
				+ "fbwgimsmjpknuqtijrsnwvtytqqvookinzmkkkrkgwafohflvuedssukjgipgmypakhlckvizmqvycv"
				+ "bxhlljzejcaijqnfgobuhuiahtmxfzoplmmjfxtggwwxliplntkfuxjcnzcqsaagahbbneugiocexcfps"
				+ "zzomumfqpaiydssmihdoewahoswhlnpctjmkyufsvjlrflfiktndubnymenlmpyrhjxfdcq";
		System.out.println(isSubSequenceDp(s, t,new HashMap<String, Boolean>())); // takes few seconds
	}

	private static boolean isSubSequence(String s, String t) {
		if (s.isEmpty()) {
			return true;
		}
		char[] arr = t.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			// substring will also consume m time
			if (s.charAt(0) == arr[i] && isSubSequence(s.substring(1), t.substring(i))) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean isSubSequenceDp(String s, String t,Map<String,Boolean> memo) {
		
		if (s.isEmpty()) {
			return true;
		}
		if(t.isEmpty()) {
			memo.put(s, false);
			return false;
		}
		if(memo.containsKey(s)) {
			return memo.get(s);
		}
		
		char[] arr = t.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			// substring will also consume m time
			if (s.charAt(0) == arr[i] && isSubSequenceDp(s.substring(1), t.substring(i+1),memo)) {
				memo.put(s, true);
				return true;
			}
		}
		memo.put(s, false);
		return false;
	}

}
