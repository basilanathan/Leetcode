package stack;

import java.util.Stack;

public class RemoveKDigits {
	
	public String removeKdigits(String num, int k) {
		int length = num.length();
		
		//base case
		if(k == length) return "0";
		
		Stack<Character> stack = new Stack<>();
		int i = 0;
		
		while(i < num.length()) {
			while(k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
				stack.pop();
				k--;
			}
			stack.push(num.charAt(i));
			i++;
		}
		//corner case 1111
		while(k > 0) {
			stack.pop();
			k--;
		}
		
		//construct the number from the stack
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		while(sb.length() > 1 && sb.charAt(sb.length()-1) == '0')
            sb.deleteCharAt(sb.length()-1);

		return sb.reverse().toString();
		
	}

}
