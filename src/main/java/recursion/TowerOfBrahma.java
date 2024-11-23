package recursion;

import java.util.Stack;

public class TowerOfBrahma {

	public static void main(String[] args) {
		Integer count = 0;
		solve(3, 1, 2, 3, count);
		System.out.println(count);
//		Stack<Integer> s = new Stack<Integer>();
//		for (int i = 3; i > 0; i++) {
//			s.push(i);
//		}
//		Stack<Integer> h = new Stack<Integer>();
//		Stack<Integer> d = new Stack<Integer>();
//		solveWithStack(s, d, h, count);
//		System.out.println(d);

	}

	static void solveWithStack(Stack<Integer> s, Stack<Integer> d, Stack<Integer> h, Integer count) {
		if (s.size() == 1) {
			int lastPlate = s.pop();
			d.push(lastPlate);
			count++;
			return;
		}

		Stack<Integer> temp = new Stack<Integer>();
		temp.addAll(s);
		int lastItem = temp.get(temp.size() - 1);
		temp.remove(temp.size() - 1);
		
		solveWithStack(temp,h,d,count);
		
		solveWithStack(h, d, s, count);
	}

	static void solve(int n, int s, int d, int h, Integer count) {
		if (n == 1) {
			System.out.println(count+".moving biggest plate from s to d");
			count++;
			return;
		}

		solve(n - 1, s, h, d, count);

		System.out.println(count+".moving " + (n - 1) + "discs from h to d");
		count++;
		System.out.println(count+".move nth plate from s->d");
		count++;
		
		System.out.println(count+".then move "+(n-1)+" plates from h -> d");
		solve(n - 1, h, d, s, count);
		count++;
	}

}
