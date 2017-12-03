package stack;

import java.util.Stack;

public class MinStack {
	Stack<Integer> stack = new Stack<Integer>();
	int min = Integer.MAX_VALUE;
	
	public void push(int x) {
		if(x <= min) {
			stack.push(min);
			min = x;
		}
		stack.push(x);
	}
	
	public void pop() {
		int peek = stack.pop();
		if (peek == min) {
			min = stack.pop();
		}
	}
	public int top() {
		return stack.peek();
	}
	
	public int getMin() {
		return min;
	}
	
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());

	}

}
