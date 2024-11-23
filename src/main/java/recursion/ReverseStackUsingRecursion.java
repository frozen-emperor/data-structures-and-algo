package recursion;

import java.util.Stack;

public class ReverseStackUsingRecursion {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 1; i < 6; i++) {
			stack.push(i);
		}
		
		System.out.println(stack);
		reverseStack(stack);
		System.out.println(stack);
	}

	static void reverseStack(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		int ele = stack.pop();
		reverseStack(stack);
		insertIntoStackAtEnd(stack, ele);
	}

	static void insertIntoStackAtEnd(Stack<Integer> stack, int ele) {
		if (stack.isEmpty()) {
			stack.push(ele);
			return;
		}

		int temp = stack.pop();
		insertIntoStackAtEnd(stack, ele);
		stack.push(temp);
	}

}
