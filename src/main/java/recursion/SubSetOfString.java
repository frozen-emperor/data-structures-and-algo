package recursion;

import java.util.HashSet;
import java.util.Set;

public class SubSetOfString {

	public static void main(String[] args) {
		String input = "abc";
		Set<String> result = new HashSet<String>();
		subSets(input, result, "");
		System.out.println(result);
	}
	
	private static void subSets(String str,Set<String> result,String subString) {
		if(str.isEmpty()) {
			result.add(subString);
			return;
		}
		
		subSets(str.substring(1), result,str.substring(0, 1)+subString);
		subSets(str.substring(1), result,subString);
	}

}
