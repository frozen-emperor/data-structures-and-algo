package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NextGreaterElementToRight {

	public static void main(String[] args) {
		int[] arr = { 5, 4, 1, 3, 2, 6 };

		Stack<Integer> stack = new Stack<>();
		List<Integer> result = new ArrayList<Integer>();

		for (int i = arr.length - 1; i > -1; i--) {
			if (stack.isEmpty()) {
				result.add(-1);
			} else if (!stack.isEmpty() && stack.peek() > arr[i]) {
				result.add(stack.peek());

			} else if (!stack.isEmpty() && stack.peek() <= arr[i]) {
				while (!stack.isEmpty() && stack.peek() <= arr[i]) {
					stack.pop();
				}
				if (stack.isEmpty()) {
					result.add(-1);
				} else {
					result.add(stack.peek());
				}
			}

			stack.push(arr[i]);
		}
		Collections.reverse(result);
		System.out.println(result);
		System.out.println("kela");
	}

}
