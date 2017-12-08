package stack;

import java.util.Stack;

/**
 * 
 * @author basila
 * 
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with 
 * the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, 
 * where h is the height of the tree.
 *
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BSTIterator {
	private Stack<TreeNode> stack;
	public BSTIterator(TreeNode root) {
		stack = new Stack<>();
		
		TreeNode current = root;
		while(current != null) {
			stack.push(current);
			if (current.left != null) {
				current = current.left;
			} else
				break;
		}
	}
	
	//return weather we have a next smallest value
	public boolean hasNext() {
		return !stack.isEmpty();
	}
	
	//return the smallest number
	public int next() {
		TreeNode node = stack.pop();
		TreeNode current = node;
		// traversal right branch
		if(current.right != null){
			current = current.right;
			while(current != null){
				stack.push(current);
				if(current.left != null)
					current = current.left;
				else
					break;
			}
		}
		return node.val;
	}

}
