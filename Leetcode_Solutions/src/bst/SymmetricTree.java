package bst;

import java.util.Stack;

/**
 * 
 * @author basila
 * 
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *  1
   / \
  2   2
 / \ / \
3  4 4  3

returns true
 *
 */

public class SymmetricTree {
	//recursive solution
	public boolean isSymmetric(TreeNode root) {
		if (root == null) return true;
		return isSymmetricHelper(root.left, root.right);
	}

	private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
		if(left == null && right == null) return true;
		if(left == null || right == null) return false;
		
		if(left.val == right.val) {
			return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
		} else
			return false;
	}
	
	//iterative solution
	public boolean isSymmetricIterative(TreeNode root) {
		if(root == null) return true;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root.left);
		stack.push(root.right);
		
		while(!stack.isEmpty()) {
			TreeNode n1 = stack.pop(), n2 = stack.pop();
			if(n1 == null && n2 == null) continue;
			if(n1 == null || n2 == null || n1.val != n2.val) return false;
	        stack.push(n1.left);
	        stack.push(n2.right);
	        stack.push(n1.right);
	        stack.push(n2.left);
		}
		return true;
	}

}
