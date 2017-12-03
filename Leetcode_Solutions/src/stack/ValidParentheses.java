package stack;

import java.util.Stack;

/**
 * 
 * @author basila
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" 
 * are all valid but "(]" and "([)]" are not.
 *
 */

public class ValidParentheses {
    public boolean isValid(String s) {
        if(s.length() % 2 == 1) //check if odd
            return false;
        
        Stack<Character> stack = new Stack<Character>();
        for(char c : s.toCharArray()) { //read each charachter in the string
            if(c == '(')
                stack.push(')');
            else if(c == '{')
                stack.push('}');
            else if(c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
    
    //second solution
    
   /* boolean isValid(String s) {
    	  if ((s.length() & 1) == 1) return false;
    	  else {
    	    Deque<Character> p = new ArrayDeque<>(s.length());
    	    for (int i = 0; i < s.length(); i++)
    	      switch (s.charAt(i)) {
    	        case '(': p.push(')'); break;
    	        case '{': p.push('}'); break;
    	        case '[': p.push(']'); break;
    	        case ')': case '}': case ']': if (p.isEmpty() || p.pop() != s.charAt(i)) return false;
    	      }
    	    return p.isEmpty();
    	  }
    	} */
    
	public static void main(String[] args) {
		ValidParentheses test = new ValidParentheses();
		System.out.println(test.isValid("(, {, [, ], }, )"));
	}
}
